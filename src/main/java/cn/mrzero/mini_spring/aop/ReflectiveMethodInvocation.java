package cn.mrzero.mini_spring.aop;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;

public class ReflectiveMethodInvocation implements MethodInvocation {
	
	private Object target;

	private Method method;
	
	private Object[] args;
	
	public ReflectiveMethodInvocation(Object object, Method method, Object[] args) {
		this.target = object;
		this.method = method;
		this.args = args;
	}

	public Object[] getArguments() {
		return args;
	}

	public Object proceed() throws Throwable {
		return method.invoke(target, args);
	}

	public Object getThis() {
		return target;
	}

	public AccessibleObject getStaticPart() {
		return method;
	}

	public Method getMethod() {
		return method;
	}

}
