package cn.mrzero.mini_spring;


import java.util.Map;

import org.junit.Test;

import cn.mrzero.mini_spring.beans.BeanDefinition;
import cn.mrzero.mini_spring.beans.factory.AbstractBeanFactory;
import cn.mrzero.mini_spring.beans.factory.AutowireCapableBeanFactory;
import cn.mrzero.mini_spring.beans.factory.BeanFactory;
import cn.mrzero.mini_spring.beans.io.ResourceLoader;
import cn.mrzero.mini_spring.beans.xml.XmlBeanDefinitionReader;

public class BeanFactoryTest {
	
	
	@Test
	public void test() throws Exception {
		//1.读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader  = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("ioc.xml");
		
		//2.初始化BeanFactory与注册BeanDefinition
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		for(Map.Entry<String, BeanDefinition> beanDenifitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()){
			beanFactory.registerBeanDefinition(beanDenifitionEntry.getKey(), beanDenifitionEntry.getValue());
		}
		//3.获取bean
		HelloWorldServiceImpl helloWorldService =(HelloWorldServiceImpl) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
	
	@Test
	public void testPreInstantiate() throws Exception {
		// 1.读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("ioc.xml");

		// 2.初始化BeanFactory并注册bean
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}

        // 3.初始化bean
        beanFactory.preInstantiateSingletons();

		// 4.获取bean
		HelloWorldServiceImpl helloWorldService = (HelloWorldServiceImpl) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
	
}
