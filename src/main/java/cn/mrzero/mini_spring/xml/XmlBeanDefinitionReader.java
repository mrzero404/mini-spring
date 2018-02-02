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
import cn.mrzero.mini_spring.BeanReference;
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
				String name = propertyEle.getAttribute("name");
				String value = propertyEle.getAttribute("value");
				/*获取到的Node有下面两种情况
				 *<property name="text" value="Hello World!"></property>
		         *<property name="outputService" ref="outputService"></property> ref为类名
				 * 下面对这两种情况作出处理
				 * 第一种：用PropertyValue的Object存放String
				 * 第二种：用PropertyValue的Object存放BeanReference类
				 */
				if(value != null && value.length()>0) {
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
				} else {
					String ref = propertyEle.getAttribute("ref");
					if(ref == null || ref.length() == 0) {
						throw new IllegalArgumentException("Configuration problem: <property> element for property '"
								+ name + "' must specify a ref or value");
					}
					BeanReference beanReference = new BeanReference(ref);
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
				}
			}
		}
	}
}