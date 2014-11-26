package com.xy.test.quene;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @version 1.0
 * @author sunyard
 *
 */
public class TestBlockingQuene {

	private static final int FILE_QUENE_SIZE = 10;
	private static final int SEARCH_THREAD = 100;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		BlockingQueue<File> quene = new ArrayBlockingQueue<File>(FILE_QUENE_SIZE);
		
	}
}
