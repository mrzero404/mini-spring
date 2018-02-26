package cn.mrzero.mini_spring.aop;

public interface Pointcut {

	ClassFilter getClassFilter();
	
	MethodMatcher getMethodMatcher();

}
