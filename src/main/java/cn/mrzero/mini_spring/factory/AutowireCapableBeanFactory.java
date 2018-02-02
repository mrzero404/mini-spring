package cn.mrzero.mini_spring.factory;

import java.lang.reflect.Field;

import cn.mrzero.mini_spring.BeanDefinition;
import cn.mrzero.mini_spring.BeanReference;
import cn.mrzero.mini_spring.PropertyValue;

public class AutowireCapableBeanFactory extends AbstractBeanFactory{

	@Override
	protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
		//根据beanDefinition中保存的Class对象创建出bean（本例为HelloWorldService）
		Object bean = createBeanInstance(beanDefinition);
		//先把主骨架放入车间
		beanDefinition.setBean(bean);
		//把propertyValues放在List中一个个propertyValue拿出来赋值到上面刚创建出来bean中的成员变量
		applyPropertyValues(bean, beanDefinition);
		return bean;
	}
	
	
	protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
		return beanDefinition.getBeanClass().newInstance();
	}


	protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
		//把propertyValues放在List中的propertyValue拿出来赋值到bean中的成员变量
		//拿出装字段（PropertyValue）的propertyValuesList
		//目前的PropertyValue中的Object有两种类型，String与BeanReference
		//如果是String就直接赋值，如果是BeanReference
		for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
			//根据变量名propertyValue.name获得字段（本例为HelloWorldService的text）
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
			//设置字段可访问，即暴力反射 
			declaredField.setAccessible(true);
			//把propertyValue.value赋值给bean中对应的变量
			Object value = propertyValue.getValue();
			if(value instanceof BeanReference) {
				BeanReference beanReference = (BeanReference) value;
				value = getBean(beanReference.getName());
			}
			declaredField.set(bean, value);
		}
	}

}
