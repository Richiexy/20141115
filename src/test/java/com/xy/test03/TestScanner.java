package com.xy.test03;

import java.nio.charset.Charset;
import java.util.Scanner;

public class TestScanner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("what's your name?");
		String s = in.nextLine();
		String aName = new String(s.getBytes(),Charset.forName("utf-8"));
		System.out.println(aName);
	}

}
