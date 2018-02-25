package cn.mrzero.mini_spring.beans.io;

import java.net.URL;

public class ResourceLoader {
	
	public Resource getResource(String location) throws Exception{
		URL resource = this.getClass().getClassLoader().getResource(location);
		return new UrlResource(resource);
	}
}
