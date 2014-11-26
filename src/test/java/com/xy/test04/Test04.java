package com.xy.test04;

import org.junit.Test;

public class Test04 {

	@Test
	public void test01(){
		String a = "FBXMSLRY,FBFZR" ;
		String b = ",XMSLRY" ;
		String c = ",XMSLRY" ;
		
		System.out.println(" a contains b = " + a.contains(b));
		System.out.println(" c indexof b = " + c.indexOf(b));
	}
}
