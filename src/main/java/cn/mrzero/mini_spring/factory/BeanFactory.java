package cn.mrzero.mini_spring.factory;

import cn.mrzero.mini_spring.BeanDefinition;

public interface BeanFactory {
	
	Object getBean(String name) throws Exception;
	
	void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception; 
}
