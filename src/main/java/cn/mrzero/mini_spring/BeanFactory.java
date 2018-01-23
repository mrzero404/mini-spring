package cn.mrzero.mini_spring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//本质上就是一个map，只不过用方法把put与get封装起来
//看起来都像javabean的模样，只不过把基本类型（int、String等）替换成map
//思考类的复用
public class BeanFactory {
	//为什么要用ConcurrentHashMap而不用HashMap？因为ConcurrentHashMap是线程安全的
	private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,BeanDefinition>();
	
	public void registerBeanDefinition(String name,BeanDefinition beanDefinition) {
		beanDefinitionMap.put(name, beanDefinition);
	}
	
	public Object getBean(String name){
		return beanDefinitionMap.get(name).getBean();
	}
}
