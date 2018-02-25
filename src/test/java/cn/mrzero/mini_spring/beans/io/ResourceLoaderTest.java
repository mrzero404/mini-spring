package cn.mrzero.mini_spring.beans.io;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import cn.mrzero.mini_spring.beans.io.Resource;
import cn.mrzero.mini_spring.beans.io.ResourceLoader;


public class ResourceLoaderTest {
	
	@Test
	public void test() throws Exception{
		ResourceLoader resourceLoader = new ResourceLoader();
		Resource resource = resourceLoader.getResource("ioc.xml");
		InputStream inputStream = resource.getInputStream();
		Assert.assertNotNull(inputStream);
		
	}
	
}
