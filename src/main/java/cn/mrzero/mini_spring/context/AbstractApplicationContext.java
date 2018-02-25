package cn.mrzero.mini_spring.context;

import cn.mrzero.mini_spring.beans.BeanDefinition;
import cn.mrzero.mini_spring.beans.factory.AbstractBeanFactory;

public abstract class AbstractApplicationContext implements ApplicationContext {
	
	protected AbstractBeanFactory beanFactory;
	
	public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}
	
	public Object getBean(String name) throws Exception {
		return beanFactory.getBean(name);
	}

	public void refresh() throws Exception {
	}
}
