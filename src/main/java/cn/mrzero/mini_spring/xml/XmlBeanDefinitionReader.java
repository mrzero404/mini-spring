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
import cn.mrzero.mini_spring.io.ResourceLoader;
/*
 * 用解析xml文件得到的值来初始化BeanDefinition
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{

	public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
		super(resourceLoader);
	}

	public void loadBeanDefinitions(String location) throws Exception {
		InputStream inputStream = this.getResourceLoader().getResource(location).getInputStream();
		doLoadBeanDefinitions(inputStream);
	}

	protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
		DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = dFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(inputStream);
		registerBeanDefinitions(doc);
		inputStream.close();
	}

	private void registerBeanDefinitions(Document doc) {
		Element root = doc.getDocumentElement();
		parseBeanDenifition(root);
	}

	protected void parseBeanDenifition(Element root) {
		NodeList nodes = root.getChildNodes();
		for(int i=0; i<nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if(node instanceof Element){
				Element ele = (Element) node;
				processBeanDefinition(ele);
			}
		}
	
	}

	protected void processBeanDefinition(Element ele) {
		String name = ele.getAttribute("name");
		String className = ele.getAttribute("class");
		BeanDefinition beanDefinition = new BeanDefinition();
		processProperty(ele, beanDefinition);
		beanDefinition.setBeanClassName(className);
		this.getRegistry().put(name, beanDefinition);
	}

	private void processProperty(Element ele, BeanDefinition beanDefinition) {
		NodeList list = ele.getChildNodes();
		for(int i=0; i<list.getLength(); i++) {
			Node node = list.item(i);
			if(node instanceof Element) {
				Element propertyEle = (Element) node;
				String proname = propertyEle.getAttribute("name");
				String provalue = propertyEle.getAttribute("value");
				PropertyValue pv = new PropertyValue(proname, provalue);
				beanDefinition.getPropertyValues().addPropertyValue(pv);
			}
		}
	}
}