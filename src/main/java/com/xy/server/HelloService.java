package com.xy.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * WebService
 * 将 Java 类标记为实现 Web Service，或者将 Java 接口标记为定义 Web Service 接口
 */
@WebService(serviceName="MyService",targetNamespace="com.xy.myspace")
//@WebService
public class HelloService {

	@WebMethod(operationName="sayHello")
	@WebResult(name="myReturn")
    public String sayHello(@WebParam(name="name") String name){
        return  "hello: " + name;
    }
	
	public String sayGoodbye(String name){
	    
        return  "goodbye: " + name;
    }
	
	@WebMethod(exclude=true)//当前方法不被发布出去
    public String sayHello2(String name){
        return "(not publish!)hello " + name;
    }
	
	public static void main(String[] args){
		//将WebService发布到指定地址
		Endpoint endPoint = Endpoint.publish("http://192.168.0.109/hello", new HelloService()) ;
		System.out.println("Server ready...");
	}
}
