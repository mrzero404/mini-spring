package cn.mrzero.mini_spring.aop;

public interface ClassFilter {

	boolean matches(Class targetClass);
}
