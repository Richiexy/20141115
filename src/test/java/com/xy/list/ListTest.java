package com.xy.list;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	/**
	 * @Description: 外部循环
	 * @author: 俞根海
	 * @date: 2015-1-21 下午8:36:08
	 */
	public void test01(){
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
		
		for(int number : numbers ){
			System.out.println(number);
		}
	}
	
//	@Test
//	/**
//	 * @Description: 内部循环 java 8 
//	 * @author: 俞根海
//	 * @date: 2015-1-21 下午8:36:45
//	 */
//	public void test02(){
//		
//		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
//		
//		numbers.forEach((Integer value) 
//			System.out.println(value)); 
//	}
}
