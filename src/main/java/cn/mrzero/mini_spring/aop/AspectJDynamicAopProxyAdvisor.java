package cn.mrzero.mini_spring.aop;

import org.aopalliance.aop.Advice;
/*
 * 实现PointcutAdvisor接口，组合AspectJExpressionPointcut对象
 * 从而实现通知与切点的整合
 */
public class AspectJDynamicAopProxyAdvisor implements PointcutAdvisor{

	private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
	
	private Advice advice;
	
	@Override
	public Advice getAdvice() {
		return this.advice;
	}

	@Override
	public Pointcut getPointcut() {
		return this.pointcut;
	}

	public void setExpression(String expression) {
		this.pointcut.setExpression(expression);
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

}
