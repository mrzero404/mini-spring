package cn.mrzero.mini_spring.aop;

import org.junit.Assert;
import org.junit.Test;

import cn.mrzero.mini_spring.HelloWorldService;
import cn.mrzero.mini_spring.HelloWorldServiceImpl;

/*
 * 
 */
public class AspectJExpressionPointcutTest {
	
	@Test
	public void testClassFilter() {
		//把匹配表达式设置到AspectJExpressionPointcut
		String expression = "execution(* cn.mrzero.mini_spring.*.*(..))";
		AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
		aspectJExpressionPointcut.setExpression(expression);
		//getClassFilter()返回的是this，相当于调用自身的方法matches(传入Class对象)
		boolean marcher = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
		Assert.assertTrue(marcher);
	}
	
	@Test
	public void testMethodInterceptor() throws Exception, Exception {
		//把匹配表达式设置到AspectJExpressionPointcut
        String expression = "execution(* cn.mrzero.mini_spring.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        //getClassFilter()返回的是this，相当于调用自身的方法matches(传入Method对象与Class对象)
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloWorldServiceImpl.class.getDeclaredMethod("helloWorld"),HelloWorldServiceImpl.class);
        Assert.assertTrue(matches);
	}
}
