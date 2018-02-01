package cn.mrzero.mini_spring.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlResource implements Resource {
	
	private final URL url;
	
	public UrlResource(URL url) {
		this.url = url;
	}
	
	public InputStream getInputStream() throws Exception {
		//抽象类 URLConnection 是所有类的超类，它代表应用程序和 URL 之间的通信链接。
    	//此类的实例可用于读取和写入此 URL 引用的资源。URLConnection 基于Http协议。通常，创建一个到 URL 的连接需要几个步骤：
    	//1. 通过在 URL 上调用 openConnection 方法创建连接对象。 
    	//2. 处理设置参数和一般请求属性。 
    	//3. 使用 connect 方法建立到远程对象的实际连接。 
    	//4. 远程对象变为可用。远程对象的头字段和内容变为可访问。
		URLConnection urlConnection = url.openConnection();
		urlConnection.connect();
		return urlConnection.getInputStream();
	}

}
