package cn.mrzero.mini_spring.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 水果颜色注解
 * @author mrzero
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
	
	public enum Color{BULE, RED, GREEN};
	
	Color fruitColor() default Color.GREEN;
	
}