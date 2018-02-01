package cn.mrzero.mini_spring.io;

import java.io.InputStream;

public interface Resource {
	
	public InputStream getInputStream() throws Exception; 
}
