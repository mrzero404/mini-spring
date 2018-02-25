package cn.mrzero.mini_spring.annotation;

import java.lang.reflect.Field;

import cn.mrzero.mini_spring.HelloWorldServiceImpl;
import cn.mrzero.mini_spring.context.AbstractApplicationContext;
import cn.mrzero.mini_spring.context.ClassPathXmlApplicationContext;

public class FruitInfoUtil {
	public static Object getFruitInfo(Class<?> clazz) throws Exception {
		Object bean = clazz.newInstance();
		String strFruitName = "水果名称:";
		String strFruitColor = "水果颜色:";
		String strFruitProvider = "水果供应商:";
		
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			if(field.isAnnotationPresent(FruitName.class)) {
				FruitName fruitName = (FruitName)field.getAnnotation(FruitName.class);
				strFruitName = strFruitName + fruitName.value();
				System.out.println(strFruitName);
			}
			else if(field.isAnnotationPresent(FruitColor.class)) {
				FruitColor fruitColor = (FruitColor)field.getAnnotation(FruitColor.class);
				strFruitColor = strFruitColor + fruitColor.fruitColor();
				System.out.println(strFruitColor);
			}
			else if(field.isAnnotationPresent(FruitProvider.class)) {
				FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
				
				strFruitProvider = "供应商编号：" + fruitProvider.id() +"，供应商名称：" + fruitProvider.name() + "，供应商地址：" + fruitProvider.address();
				System.out.println(strFruitProvider);
			}
			else if(field.isAnnotationPresent(Autowried.class)) {
				AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
				HelloWorldServiceImpl helloWorldService = (HelloWorldServiceImpl) applicationContext.getBean("helloWorldService");
				field.setAccessible(true);
				helloWorldService.helloWorld();
				System.out.println(field.getName());
				field.set(bean, helloWorldService);
			}
		}
		return bean;
	}
}
