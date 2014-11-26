package com.xy.sound;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class SpeakTest {

//	32位jdk职能调用32位dll，64位jdk职能调用64位dll
	@Test
	public void fileToString() throws IOException{  
		 
        File f=new File("D:\\speak.txt");   //可以换成工程目录下的其他文本文件  
       
        SpeechUtil speechutil = new SpeechUtil();  
          
        BufferedReader br = new BufferedReader(new InputStreamReader(    
                new FileInputStream(f)));    
        for (String line = br.readLine(); line != null; line = br.readLine()) {    
            speechutil.speakMessage(line, 10, 1);  //100表示读取音量，0表示读取速度（-10，10之间）  
        }    
        br.close();  
              
    } 
}
