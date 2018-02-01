package cn.mrzero.mini_spring;

public interface BeanDefinitionReader {
	
	void loadBeanDefinitions(String location) throws Exception;
}
