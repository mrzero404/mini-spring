package cn.mrzero.mini_spring.factory;

import cn.mrzero.mini_spring.BeanDefinition;

public interface BeanFactory {
	
	Object getBean(String name);
	
	void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception; 
}
