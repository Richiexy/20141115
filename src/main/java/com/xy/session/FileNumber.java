package com.xy.session;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileNumber {

	//文件写
	public void NumberWriteToFile(int x){
	   int c=0;
	   c=x;
	   File filePath=new File("d:");
	   File f1=new File(filePath,"number.txt");
	   try{
	    FileOutputStream fout=new FileOutputStream(f1);
	    DataOutputStream out=new DataOutputStream(fout);
	    out.writeInt(c);
	   
	   }
	   catch(FileNotFoundException e){
	    System.err.println(e);
	   }
	   catch(IOException e){
	    System.err.println(e);
	   }
	}
	
	//文件读
	public int NumberReadFromFile(){
	   int c1 = 0;
	   File filePath=new File("d:");
	   File f1=new File(filePath,"number.txt");
	   try{
	    FileInputStream fin=new FileInputStream(f1);
	    DataInputStream in=new DataInputStream(fin);
	    c1=in.readInt();
	    System.out.println(c1);//输出文件内容至屏幕
	   }
	   catch(FileNotFoundException e){
	    System.err.println(e);
	   }
	   catch(IOException e){
	    System.err.println(e);
	   }
	   return c1;
	}
}
