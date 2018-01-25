package cn.mrzero.mini_spring;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import cn.mrzero.mini_spring.factory.AutowireCapableBeanFactory;
import cn.mrzero.mini_spring.factory.BeanFactory;

public class BeanFactoryTest {
	
	
	@Test
	public void test() {
		//1.初始化beanfactory
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		
		//2.注入bean
		BeanDefinition beanDefinition = new BeanDefinition();
		//beanClassName拿到字符串————cn.mrzero.mini_spring.HelloWorldService
		//beanClass拿到Class类（类型信息）
		beanDefinition.setBeanClassName("cn.mrzero.mini_spring.HelloWorldService");
		beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
		
		//3.获取bean
		HelloWorldService helloWorldService =(HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.sayHello();
	}
	
}
