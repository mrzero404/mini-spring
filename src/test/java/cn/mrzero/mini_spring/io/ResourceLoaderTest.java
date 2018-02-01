package cn.mrzero.mini_spring.io;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;


public class ResourceLoaderTest {
	
	@Test
	public void test() throws Exception{
		ResourceLoader resourceLoader = new ResourceLoader();
		Resource resource = resourceLoader.getResource("ioc.xml");
		InputStream inputStream = resource.getInputStream();
		Assert.assertNotNull(inputStream);
		
	}
	
}
