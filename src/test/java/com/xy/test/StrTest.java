package com.xy.test;

import org.junit.Test;


public class StrTest {

	public static void getUserName(String userId) {
		String[] ss = userId.split(",");
		StringBuffer sb = new StringBuffer();
		for(String s:ss){
			sb.append( s+",");
			System.out.println(s);
		}
		System.out.println(sb.toString().substring(0,sb.length()-1));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 100000.0/3;
		System.out.println(x);
		System.out.printf("$%,8.2f \n", x);
		int lotteryodds = 1;
		int n = 50;
		int k = 6;
		for(int i=1;i<=k;i++)
			lotteryodds = lotteryodds*(n-i+1)/i;
		System.out.println(lotteryodds);
	}
	
	@Test
	public void test04(){
		String sss = "'123','234'";
		String sss2 = "123,234";
		
		System.out.println("sss = " + sss.replace("'", ""));
		System.out.println("sss2 = " + sss2.replace("'", ""));
	}

}
