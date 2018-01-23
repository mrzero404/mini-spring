package cn.mrzero.mini_spring;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class BeanFactoryTest {
	
	String message = "Hello World";
	BeanFactory beanFactory = new BeanFactory();
	HelloWorldService helloWorldService = new HelloWorldService();
	BeanDefinition beanDefinition = new BeanDefinition(helloWorldService);
	
	@Test
	public void test() {
		beanFactory.registerBeanDefinition("HelloWorldService", beanDefinition);
		HelloWorldService helloWorldService =(HelloWorldService) beanFactory.getBean("HelloWorldService");
		assertEquals(message, helloWorldService.sayHello());
	}
}
