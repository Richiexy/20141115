package com.xy.statics;

public class StaticTest {

	/**
	 * @Description: 可以使用静态方法来使用一个值为null的引用类型变量。
	 * 因为静态方法使用静态绑定，不会抛出空指针异常
	 * @author: 俞根海
	 * @date: 2015-1-21 下午8:57:34
	 * @param args
	 */
	public static void main(String args[]){
		StaticTest myObject = null;
	      myObject.iAmStaticMethod();
	      myObject.iAmNonStaticMethod();                             
	   }

	   private static void iAmStaticMethod(){
	        System.out.println("I am static method, can be called by null reference");
	   }

	   private void iAmNonStaticMethod(){
	       System.out.println("I am NON static method, don't date to call me by null");
	   }
}
