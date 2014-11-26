package com.xy.test.word;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

import com.xy.util.DateUtil;

public class TestWord {

	@Test
	public void test01(){
		 try {
			 FileChannel fc = new FileOutputStream("D:\\test1.doc").getChannel();  
			 fc.write(ByteBuffer.wrap("你好，".getBytes()));  
			 fc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			System.out.println("---测试结束---");
		}
	}
	@Test
	public void test02(){
		try {
			 //RandomAccessFile不支持只写模式，因为把参数设为“w”是非法的
			 FileChannel fc = new RandomAccessFile("D:\\test2.doc","rw").getChannel();    
			 fc.write(ByteBuffer.wrap("朋友，".getBytes()));  
			 fc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			System.out.println("---测试结束---");
		}
	}
	@Test
	public void test03(){
		try {
			FileWriter fw = new FileWriter("d:\\test32.doc",true);
			PrintWriter pw = new PrintWriter(fw, true);
			pw.print(DateUtil.getCurrentDate("yyyy-MM-dd") + "中文测试");
			pw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			System.out.println("---测试结束---");
		}
	}
	@Test
	public void test04(){
		
	}
}
