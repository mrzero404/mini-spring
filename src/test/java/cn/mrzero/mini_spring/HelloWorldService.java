package cn.mrzero.mini_spring;

public class HelloWorldService {
	
	private String text;

    public void helloWorld(){
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }
}
