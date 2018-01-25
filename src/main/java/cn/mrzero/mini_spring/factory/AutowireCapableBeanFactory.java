package cn.mrzero.mini_spring.factory;

import java.lang.reflect.Field;

import cn.mrzero.mini_spring.BeanDefinition;
import cn.mrzero.mini_spring.PropertyValue;

public class AutowireCapableBeanFactory extends AbstractBeanFactory{

	@Override
	protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
		//根据beanDefinition中保存的Class对象创建出bean
		Object bean = createBeanInstance(beanDefinition);
		//把propertyValues放在List中一个个propertyValue拿出来赋值到bean中的成员变量
		applyPropertyValues(bean, beanDefinition);
		return bean;
	}
	
	
	protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
		return beanDefinition.getBeanClass().newInstance();
	}


	protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
		//把propertyValues放在List中的propertyValue拿出来赋值到bean中的成员变量
		for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
			//根据变量名propertyValue.name获得字段
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
			//设置字段可访问，即暴力反射 
			declaredField.setAccessible(true);
			//把propertyValue.value赋值给bean中对应的变量
			declaredField.set(bean, propertyValue.getValue());
		}
	}

}
