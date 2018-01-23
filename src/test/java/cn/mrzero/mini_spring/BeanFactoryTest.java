package cn.mrzero.mini_spring;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class BeanFactoryTest {
	
	String message = "Hello World";
	BeanFactory beanFactory = new BeanFactory();
	HelloWorldService helloWorldService = new HelloWorldService();//需要自己创建对象
	BeanDefinition beanDefinition = new BeanDefinition(helloWorldService);
	
	@Test
	public void test() {
		beanFactory.registerBeanDefinition("HelloWorldService", beanDefinition);//把bean注册到map中
		HelloWorldService helloWorldService =(HelloWorldService) beanFactory.getBean("HelloWorldService");//把bean从map中拿出来
		assertEquals(message, helloWorldService.sayHello());
	}
}
