package cn.mrzero.mini_spring.beans.factory;

import cn.mrzero.mini_spring.beans.BeanDefinition;

public interface BeanFactory {
	
	Object getBean(String name) throws Exception;
	
}
