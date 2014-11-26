package com.xy.test.xml;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.xy.util.DateUtil;
import com.xy.xml.PraseXML;

public class TestReadWriteXMl {

	/**
	 * @Description: dom实现
	 * @author: 俞根海
	 * @date: 2014-11-15 下午2:24:32
	 */
	@Test
	public void test01(){
		System.out.println("--start--" + DateUtil.getCurrentDate());
		try {
			File file = new File("src/test/java/com/xy/test/xml/test.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document doc = builder.parse(file);
		
			NodeList nl = doc.getElementsByTagName("VALUE");
			for(int i = 0 ; i < nl.getLength() ; i ++){
				System.out.println("车牌号码："+ doc.getElementsByTagName("NO").item(i).getFirstChild().getNodeValue());
				System.out.println("车主地址："+ doc.getElementsByTagName("ADDR").item(i).getFirstChild().getNodeValue());
			}
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("--start--" + DateUtil.getCurrentDate());
	}
	
	/**
	 * @Description: dom4j实现
	 * @author: 俞根海
	 * @date: 2014-11-15 下午2:44:18
	 */
	@Test
	public void test02(){
		System.out.println("--start--" + DateUtil.getCurrentDate());
		try{
			File file = new File("src/test/java/com/xy/test/xml/test.xml");
			SAXReader reader = new SAXReader();
			org.dom4j.Document doc = reader.read(file);
			Element root = doc.getRootElement();
			
			Element foo ;
			for(Iterator i = root.elementIterator("VALUE") ; i.hasNext();){
				foo = (Element) i.next();
				System.out.println("车牌号码："+ foo.elementText("NO"));
				System.out.println("车主地址："+ foo.elementText("ADDR"));
			}
		}catch(Exception e){
			
		}
		System.out.println("--start--" + DateUtil.getCurrentDate());
	}
	
	/**
	 * @Description: jdom实现
	 * @author: 俞根海
	 * @date: 2014-11-15 下午2:52:08
	 */
	@Test
	public void test03(){
		System.out.println("--start--" + DateUtil.getCurrentDate());
		try{
			File file = new File("src/test/java/com/xy/test/xml/test.xml");
			SAXBuilder builder = new SAXBuilder();
			org.jdom2.Document doc = builder.build(file);
			
			org.jdom2.Element foo = doc.getRootElement();
			
			List allChildren = foo.getChildren();
			for(int i=0 ;i<allChildren.size() ; i++){
				org.jdom2.Element ele = (org.jdom2.Element) allChildren.get(i);
				System.out.println("车牌号码："+ ele.getChild("NO").getText());
				System.out.println("车主地址："+ ele.getChild("ADDR").getText());
			}
			
			
		}catch(Exception e){
			
		}
		System.out.println("--start--" + DateUtil.getCurrentDate());
	}
	
	/**
	 * @Description: SAX实现
	 * @author: 俞根海
	 * @date: 2014-11-15 下午2:59:14
	 */
	@Test
	public void test04(){
		System.out.println("--start--" + DateUtil.getCurrentDate());
		try{
			File file = new File("src/test/java/com/xy/test/xml/test.xml");
		    SAXParserFactory spf = SAXParserFactory.newInstance(); 
		    SAXParser saxParser = spf.newSAXParser(); 
			saxParser.parse(file, new PraseXML()); 
		}catch(Exception e){
			
		}
		System.out.println("--start--" + DateUtil.getCurrentDate());
	}
}