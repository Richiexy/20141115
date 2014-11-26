package com.xy.test02;

import java.math.BigDecimal;

/**
 * 货币计算
 * 二进制浮点对于货币计算是非常不合适的 double 、 float
 * 解决该问题的一种方式是使用某种证书类型 int 、 long 、bigdecimal
 * 2.0 -1.1 = 0.9
 * @author sunyard
 *
 */
public class TestFloat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(2.0 - 1.1);
		BigDecimal d_2 = new BigDecimal(2.0);//使用参数的精确值来构建一个实例
		BigDecimal d_1 = new BigDecimal(1.1);
		System.out.println(d_2.subtract(d_1));
		
		BigDecimal d_3 = new BigDecimal("2.0");
		BigDecimal d_4 = new BigDecimal("1.1");
		System.out.println(d_3.subtract(d_4));
	}

}
