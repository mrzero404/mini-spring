package cn.mrzero.mini_spring.context;

import org.junit.Test;

import cn.mrzero.mini_spring.HelloWorldService;
import context.AbstractApplicationContext;
import context.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
	@Test
	public void test() throws Exception{
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
		HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
}
