package cn.mrzero.mini_spring.beans.xml;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import cn.mrzero.mini_spring.beans.BeanDefinition;
import cn.mrzero.mini_spring.beans.io.ResourceLoader;
import cn.mrzero.mini_spring.beans.xml.XmlBeanDefinitionReader;


public class XmlBeanDefinitionReaderTest {
	@Test
	public void test() throws Exception {
		XmlBeanDefinitionReader xr = new XmlBeanDefinitionReader(new ResourceLoader());
		xr.loadBeanDefinitions("ioc.xml");
		Map<String,BeanDefinition> registry = xr.getRegistry();
		Assert.assertTrue(registry.size() > 0);
	}

}
