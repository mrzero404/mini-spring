package cn.mrzero.mini_spring.beans;

public interface BeanDefinitionReader {
	
	void loadBeanDefinitions(String location) throws Exception;
}
