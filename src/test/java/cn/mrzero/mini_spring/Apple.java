package cn.mrzero.mini_spring;

import cn.mrzero.mini_spring.annotation.Autowried;
import cn.mrzero.mini_spring.annotation.FruitColor;
import cn.mrzero.mini_spring.annotation.FruitColor.Color;
import cn.mrzero.mini_spring.annotation.FruitName;
import cn.mrzero.mini_spring.annotation.FruitProvider;

public class Apple {
	
	@FruitName("Apple")
	private String appleName;
	
	@FruitColor(fruitColor=Color.RED)
	private String appleColor;
	
	@FruitProvider(id=1, name="红富士集团", address="富士山下")
	private String appleProvider;
	
	@Autowried
	private HelloWorldServiceImpl helloWorldService123;

	public void sayHello() {
		helloWorldService123.helloWorld();
	}
	public String getAppleName() {
		return appleName;
	}

	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}

	public String getAppleColor() {
		return appleColor;
	}

	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}

	public String getAppleProvider() {
		return appleProvider;
	}

	public void setAppleProvider(String appleProvider) {
		this.appleProvider = appleProvider;
	}
	
	public void displayName() {
		System.out.println("水果的名字是：苹果");
	}
}
