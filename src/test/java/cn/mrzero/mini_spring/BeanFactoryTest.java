package cn.mrzero.mini_spring;


import java.util.Map;

import org.junit.Test;

import cn.mrzero.mini_spring.factory.AutowireCapableBeanFactory;
import cn.mrzero.mini_spring.factory.BeanFactory;
import cn.mrzero.mini_spring.io.ResourceLoader;
import cn.mrzero.mini_spring.xml.XmlBeanDefinitionReader;

public class BeanFactoryTest {
	
	
	@Test
	public void test() throws Exception {
		//1.读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader  = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("ioc.xml");
		
		//2.初始化BeanFactory与注册BeanDefinition
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		for(Map.Entry<String, BeanDefinition> beanDenifitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()){
			beanFactory.registerBeanDefinition(beanDenifitionEntry.getKey(), beanDenifitionEntry.getValue());
		}
		//3.获取bean
		HelloWorldService helloWorldService =(HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
	
}
