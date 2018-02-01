package cn.mrzero.mini_spring.xml;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import cn.mrzero.mini_spring.BeanDefinition;
import cn.mrzero.mini_spring.io.ResourceLoader;


public class XmlBeanDefinitionReaderTest {
	@Test
	public void test() throws Exception {
		XmlBeanDefinitionReader xr = new XmlBeanDefinitionReader(new ResourceLoader());
		xr.loadBeanDefinitions("ioc.xml");
		Map<String,BeanDefinition> registry = xr.getRegistry();
		Assert.assertTrue(registry.size() > 0);
	}

}
