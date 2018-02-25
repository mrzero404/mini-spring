package cn.mrzero.mini_spring.aop;

import org.junit.Test;

import cn.mrzero.mini_spring.HelloWorldService;
import cn.mrzero.mini_spring.HelloWorldServiceImpl;
import cn.mrzero.mini_spring.context.ApplicationContext;
import cn.mrzero.mini_spring.context.ClassPathXmlApplicationContext;

public class JdkDynamicAopProxyTest {
	
	@Test
	public void test() throws Exception{
		// --------- helloWorldService without AOP
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
		HelloWorldService helloWorldService = (HelloWorldService)applicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();
		
		// --------- helloWorldService with AOP
		//1.设置被代理对象(Joinpoint)
		AdvicedSupport advicedSupport = new AdvicedSupport();
		TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldService.class);
		advicedSupport.setTargetSource(targetSource);
		
		//2.
		TimerInterceptor timerInterceptor = new TimerInterceptor();
		advicedSupport.setMethodInterceptor(timerInterceptor);
		
		//3.
		JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advicedSupport);
		HelloWorldService helloWorldServiceProxy = (HelloWorldService)jdkDynamicAopProxy.getProxy();
		
		//4.
		helloWorldServiceProxy.helloWorld();
	}
}
