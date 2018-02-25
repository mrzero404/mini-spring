package cn.mrzero.mini_spring;

import cn.mrzero.mini_spring.annotation.FruitInfoUtil;

public class FruitRun {

	public static void main(String[] args) throws Exception {
		Apple apple = (Apple)FruitInfoUtil.getFruitInfo(Apple.class);
		apple.sayHello();
	}
}
