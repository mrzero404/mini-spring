package cn.mrzero.mini_spring.context;

import org.junit.Test;

import cn.mrzero.mini_spring.HelloWorldServiceImpl;
import cn.mrzero.mini_spring.context.AbstractApplicationContext;
import cn.mrzero.mini_spring.context.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
	@Test
	public void test() throws Exception{
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
		HelloWorldServiceImpl helloWorldService = (HelloWorldServiceImpl) applicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
}
