package cn.mrzero.mini_spring.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.mrzero.mini_spring.AbstractBeanDefinitionReader;
import cn.mrzero.mini_spring.BeanDefinition;
import cn.mrzero.mini_spring.PropertyValue;
import cn.mrzero.mini_spring.PropertyValues;
import cn.mrzero.mini_spring.io.ResourceLoader;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{

	public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
		super(resourceLoader);
	}

	public void loadBeanDefinitions(String location) throws Exception {
		InputStream inputStream = this.getResourceLoader().getResource(location).getInputStream();
		DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dFactory.newDocumentBuilder();
		Document document = builder.parse(inputStream);
		Element element = document.getDocumentElement();
		NodeList nodes = element.getChildNodes();
		
		for(int i=0; i<nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if(node instanceof Element){
				Element el = (Element) node;
				String name = el.getAttribute("name");
				String clazz = el.getAttribute("class");
				BeanDefinition beanDefinition = new BeanDefinition();
				beanDefinition.setBeanClassName(clazz);
				NodeList list = el.getChildNodes();
				for(int j=0; j<list.getLength(); j++) {
					Node nd = list.item(j);
					if(nd instanceof Element) {
						Element ele = (Element) nd;
						String proname = ele.getAttribute("name");
						String provalue = ele.getAttribute("value");
						PropertyValue pv = new PropertyValue(proname, provalue);
						beanDefinition.getPropertyValues().addPropertyValue(pv);
						this.getRegistry().put(name, beanDefinition);
					}
				}
			}
			
		}
		
	}
	
}
