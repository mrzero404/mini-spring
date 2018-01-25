package cn.mrzero.mini_spring;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import cn.mrzero.mini_spring.factory.AutowireCapableBeanFactory;
import cn.mrzero.mini_spring.factory.BeanFactory;

public class BeanFactoryTest {
	
	
	@Test
	public void test() throws Exception {
		//1.初始化beanfactory
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		
		//2.定义bean
		BeanDefinition beanDefinition = new BeanDefinition();
		//beanClassName拿到字符串————cn.mrzero.mini_spring.HelloWorldService
		//beanClass拿到Class类（类型信息）
		beanDefinition.setBeanClassName("cn.mrzero.mini_spring.HelloWorldService");
		
		//3.设置bean的属性
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("text", "Hello World"));
		beanDefinition.setPropertyValues(propertyValues);
		
		//4.生成bean
		beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
		
		//3.获取bean
		HelloWorldService helloWorldService =(HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
	
}
