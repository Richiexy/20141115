package com.xy.client;


public class HelloClientApp {

	public static void main(String[] args){
		/**
         * <service name="MyService">
         * 获得服务名称
         */
        MyService mywebService = new MyService();
        
        /**
         * <port name="HelloServicePort" binding="tns:HelloServicePortBinding">
         */
        HelloService hs = mywebService.getHelloServicePort();
        
        /**
         * 调用方法
         */
        System.out.println(hs.sayGoodbye("sjk"));
        
        System.out.println(hs.sayHello("sjk"));
	}
}
