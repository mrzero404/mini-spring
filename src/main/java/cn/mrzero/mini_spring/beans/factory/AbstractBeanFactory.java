package cn.mrzero.mini_spring.beans.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.mrzero.mini_spring.beans.BeanDefinition;

public abstract class AbstractBeanFactory implements BeanFactory{
	
	private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,BeanDefinition>();
	
	private List<String> beanDefinitionNames = new ArrayList<String>();

	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
		//把带有说明书的车间赋予名字加入清单
		beanDefinitionMap.put(name, beanDefinition);
		beanDefinitionNames.add(name);
	}
	
	public Object getBean(String name) throws Exception {
		BeanDefinition beanDefinition = beanDefinitionMap.get(name);
		if(beanDefinition == null) {
			throw new IllegalArgumentException("No bean named " + name + " is defined"); 
		}
		Object bean = beanDefinition.getBean();
		//用拿到的Class类（HelloWorldService.class）创建出Object对象，再放到beanDefinition中的成员变量bean
		//BeanDefinition就像是一个车间，JVM就是工人
		//拿出产品图纸（Class-主骨架，PropertyValues-这幅主骨架的特点说明）制作出成品放到成品框中（BeanDefinition中的Bean字段）
		if(bean == null) {
			bean = doCreateBean(beanDefinition);
		}
		//bean是BeanDefinition的成员变量，所以get(name)拿到的是BeanDefinition对象，需要用getBean()方法才能拿到Bean
		return bean;
	}
	
	public void preInstantiateSingletons() throws Exception {
		for (Iterator<String> it = this.beanDefinitionNames.iterator(); it.hasNext();) {
			String beanName = (String) it.next();
			getBean(beanName);
		}
	}
	
	/*
	 *由子类去实现bean的初始化
	 */
	protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

}
