package cn.mrzero.mini_spring;
//用一个类来装一个类，为啥要这样做？
public class BeanDefinition {
	private Object bean;
	
	public BeanDefinition(Object bean) {
		this.bean = bean;
	}
	
	public Object getBean() {
		return bean;
	}
}
