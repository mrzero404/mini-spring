package cn.mrzero.mini_spring.aop;

import org.aopalliance.intercept.MethodInterceptor;

public class AdvicedSupport {
	
	private TargetSource targetSource;
	
	private MethodInterceptor methodInterceptor;

	public TargetSource getTargetSource() {
		return targetSource;
	}

	public void setTargetSource(TargetSource targetSource) {
		this.targetSource = targetSource;
	}

	public MethodInterceptor getMethodInterceptor() {
		return methodInterceptor;
	}

	public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
		this.methodInterceptor = methodInterceptor;
	}
	
	
	
}
