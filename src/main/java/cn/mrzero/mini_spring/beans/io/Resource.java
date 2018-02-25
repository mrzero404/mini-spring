package cn.mrzero.mini_spring.beans.io;

import java.io.InputStream;

public interface Resource {
	
	public InputStream getInputStream() throws Exception; 
}
