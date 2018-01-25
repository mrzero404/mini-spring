package cn.mrzero.mini_spring.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.mrzero.mini_spring.BeanDefinition;

public abstract class AbstractBeanFactory implements BeanFactory{
	
	private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,BeanDefinition>();

	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
		//用拿到的Class类创建出Object对象，再放到beanDefinition中的成员变量bean
		Object object = doCreateBean(beanDefinition);
		beanDefinition.setBean(object);
		beanDefinitionMap.put(name, beanDefinition);
	}
	
	public Object getBean(String name) {
		//bean是BeanDefinition的成员变量，所以get(name)拿到的是BeanDefinition对象，需要用getBean()方法才能拿到Bean
		return beanDefinitionMap.get(name).getBean();
	}
	/*
	 *由子类去实现bean的初始化
	 */
	protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
