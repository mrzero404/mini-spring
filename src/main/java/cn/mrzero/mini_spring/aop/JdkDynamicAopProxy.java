package cn.mrzero.mini_spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.aopalliance.intercept.MethodInterceptor;
/*
 * JDK动态代理，是实现AOP的核心
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler{
	
	private AdvicedSupport adviced;
	
	public JdkDynamicAopProxy(AdvicedSupport advice) {
		this.adviced = advice;
	}
	
	public Object getProxy() {
		//第三个参数需要传入实现InvocationHandler的类，从而让invoke与Proxy挂钩，这里为this
		return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{adviced.getTargetSource().getTargetClass()}, this);
	}
	
	public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
		MethodInterceptor methodInterceptor = adviced.getMethodInterceptor();
		return methodInterceptor.invoke(new ReflectiveMethodInvocation(adviced.getTargetSource().getTarget(), method, args));
	}




}
