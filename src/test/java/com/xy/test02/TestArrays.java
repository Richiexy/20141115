package com.xy.test02;

import java.util.Arrays;

public class TestArrays {

	/**
	 * 从50个数总选6个不同数字
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 50;
		int k = 6;
		int[] numbers = new int[n];
		for(int i=0;i< numbers.length;i++){
			numbers[i] = i+1;
		}
		
		System.out.println("binarySearch 37 is :" + Arrays.binarySearch(numbers, 37));
		
		int[] result = new int[k];
		for(int i=0;i<result.length;i++){
			//在0到n之间随机选取一个数字r
			int r = (int) (Math.random()*n);
			//选取数组r位置数值
			result[i] = numbers[r];
			//将数组最后一个数移到r位置
			numbers[r] = numbers[n-1];
			n--;
			
		}
		
		Arrays.sort(result);
		for(int a:result){
			System.out.println(a);
		}
	}

}
