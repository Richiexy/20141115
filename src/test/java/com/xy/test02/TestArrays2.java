package com.xy.test02;

import java.util.Arrays;

public class TestArrays2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 50;
		int[][] a = new int[3][2];
		for(int i=0;i<3;i++){
			for(int j=0;j<2;j++){
				int r = (int) (Math.random()*n);
				a[i][j] = r;
			}
		}
		System.out.println(Arrays.deepToString(a));
	}

}
