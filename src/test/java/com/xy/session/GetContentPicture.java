package com.xy.session;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class GetContentPicture {
	//得到了图片地址并下载图片
	public void getHtmlPicture(String httpUrl) {
		URL url;
		BufferedInputStream in;
		FileOutputStream file;
		int count;                      //图片文件名序号 
		FileNumber num=new FileNumber();//图片文件名序号类，num为对象
		num.NumberWriteToFile(1);
		count=num.NumberReadFromFile();//获取图片文件序号
		try {
		System.out.println("获取网络图片");
		   String fileName = (String.valueOf(count)).concat(httpUrl.substring(httpUrl.lastIndexOf(".")));//图片文件序号加上图片的后缀名，后缀名用了String内的一个方法来获得
		    //httpUrl.substring(httpUrl.lastIndexOf("/"));//这样获得的文件名即是图片链接里图片的名字
		   String filePath = "d:";//图片存储的位置
		   url = new URL(httpUrl);
		
		   in = new BufferedInputStream(url.openStream());
		
		   file = new FileOutputStream(new File(filePath+fileName));
		   int t;
		   while ((t = in.read()) != -1) {
		    file.write(t);
		   }
		   file.close();
		   in.close();
		   System.out.println("图片获取成功");
		   count=count+1;//图片文件序号加1
		   num.NumberWriteToFile(count);//将图片名序号保存
		} catch (MalformedURLException e) {
		   e.printStackTrace();
		} catch (FileNotFoundException e) {
		   e.printStackTrace();
		} catch (IOException e) {
		   e.printStackTrace();
		}
	}
	@Test
	public void test(){
		getHtmlPicture("http://168.3.63.26:8080/workrecord/jsp/img2.jsp");
	}
}
