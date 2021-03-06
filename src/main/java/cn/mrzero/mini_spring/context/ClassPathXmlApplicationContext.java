package cn.mrzero.mini_spring.context;

import java.util.Map;
import java.util.Map.Entry;

import cn.mrzero.mini_spring.beans.BeanDefinition;
import cn.mrzero.mini_spring.beans.factory.AbstractBeanFactory;
import cn.mrzero.mini_spring.beans.factory.AutowireCapableBeanFactory;
import cn.mrzero.mini_spring.beans.io.ResourceLoader;
import cn.mrzero.mini_spring.beans.xml.XmlBeanDefinitionReader;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
	
	private String configLocation;

	public ClassPathXmlApplicationContext(String configLocation) throws Exception {
		this(configLocation, new AutowireCapableBeanFactory());
	}

	public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
		super(beanFactory);
		this.configLocation = configLocation;
		//读取、解析、注册一气呵成
		refresh();
	}

	@Override
	public void refresh() throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
		for(Map.Entry<String, BeanDefinition> beanDefinition : xmlBeanDefinitionReader.getRegistry().entrySet()){
			beanFactory.registerBeanDefinition(beanDefinition.getKey(), beanDefinition.getValue());
		}
		
	}
	
	
}
