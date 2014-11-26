package com.xy.test;

import org.junit.Test;

import com.xy.util.Descrypt;


public class TestPwd {
	
	@Test
	public void test() {
		String users = "123,234,156";
		String s1 = getUserName(users);
		String s2 = getUserName("admin");
		String s3 = getUserName("");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
	
	private String getUserName(String users) {
		StringBuffer retsb = new StringBuffer();
		String[] userIds = users.split(",");
		for(String userId:userIds){
			retsb.append(userId+"(123),") ;
		}
		
		return retsb.length() > 0 ? retsb.substring(0,retsb.length()-1).toString() : "";
	}
	
	/**
	 * 解密用户密码
	 */
	@Test
	public void descrypt() {
		
			Descrypt des=new Descrypt();
			StringBuffer inBuffer=new StringBuffer("108513838249585323/");
			StringBuffer outPwdBuffer=new StringBuffer();
			outPwdBuffer=des.StrDescrypt(inBuffer,outPwdBuffer);
			System.out.println(outPwdBuffer.toString());
			
		
	}
}
