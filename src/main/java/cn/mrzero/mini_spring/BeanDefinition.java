package cn.mrzero.mini_spring;

public class BeanDefinition {
	private Object bean;
	
	public BeanDefinition(Object bean) {
		this.bean = bean;
	}
	
	public Object getBean() {
		return bean;
	}
}
