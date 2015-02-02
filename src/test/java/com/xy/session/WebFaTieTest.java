package com.xy.session;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.ProxyClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class WebFaTieTest {

	@Test
	public void loginWeb() throws IOException, HttpException{
		
		ProxyClient proxyClient = new ProxyClient();
		HttpHost target = new HttpHost("www.xuancheng.org", 80);
		HttpHost proxy = new HttpHost("168.2.4.106", 999);
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("user", "pwd");
		Socket socket = proxyClient.tunnel(proxy, target, credentials);
		    try {
		        Writer out = new OutputStreamWriter(socket.getOutputStream(), HTTP.DEF_CONTENT_CHARSET);
		        out.write("GET / HTTP/1.1\r\n");
		        out.write("Host: " + target.toHostString() + "\r\n");
		        out.write("Agent: whatever\r\n");
		        out.write("Connection: close\r\n");
		        out.write("\r\n");
		        out.flush();
		        BufferedReader in = new BufferedReader(
		                new InputStreamReader(socket.getInputStream(), HTTP.DEF_CONTENT_CHARSET));
		        String line = null;
		        while ((line = in.readLine()) != null) {
		            System.out.println(line);
		        }
		        this.login();
		    } finally {
		        socket.close();
		    }
	}
	
	@Test
	public void login() throws ClientProtocolException, IOException{
		HttpPost httpPost = new HttpPost("http:/60.173.112.58/member.php?mod=logging&action=login&username=登陆测试&password=qwertyuiop");
//		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
//	    formparams.add(new BasicNameValuePair("username", "登陆测试"));
//	    formparams.add(new BasicNameValuePair("password", "qwertyuiop"));
//	    UrlEncodedFormEntity urlentity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
//	    httpPost.setEntity(urlentity);
	    
	    CloseableHttpClient httpClient = HttpClients.createDefault();
	    
	    CloseableHttpResponse response = httpClient.execute(httpPost);
	    
	    HttpEntity httpentity = response.getEntity();
		if(httpentity != null){
			 System.out.println("--------------------------------------");  
             System.out.println("Response content: " + EntityUtils.toString(httpentity, "UTF-8")); 
             System.out.println("--------------------------------------");  
		}
	}
	
	@Test
	public void unicom() throws ClientProtocolException, IOException{
		String name = "中国联通手机号码";
	    String pwd = "手机服务密码";

	    String url = "https://uac.10010.com/portal/homeLogin?userName=" + name + "&userPwd=" + pwd + "&pwdType=01";

	    HttpClient httpClient = HttpClients.createDefault();
	    HttpGet httpGet = new HttpGet(url);
	    HttpResponse loginResponse = httpClient.execute(httpGet);

	    if (loginResponse.getStatusLine().getStatusCode() == 200) {
	      for (Header head : loginResponse.getAllHeaders()) {
	        System.out.println(head);
	      }
	      HttpEntity loginEntity = loginResponse.getEntity();
	      String loginEntityContent = EntityUtils.toString(loginEntity);
	      System.out.println("登录状态:" + loginEntityContent);
	      //如果登录成功
	      if (loginEntityContent.contains("resultCode:\"0000\"")) {

	        //月份
	        String months[] = new String[]{"201401", "201402", "201403", "201404", "201405"};

	        for (String month : months) {
	          String billurl = "http://iservice.10010.com/ehallService/static/historyBiil/execute/YH102010002/QUERY_YH102010002.processData/QueryYH102010002_Data/" + month + "/undefined";

	          HttpPost httpPost = new HttpPost(billurl);
	          HttpResponse billresponse = httpClient.execute(httpPost);

	          if (billresponse.getStatusLine().getStatusCode() == 200) {
	            saveToLocal(billresponse.getEntity(), "chinaunicom.bill." + month + ".2.html");
	          }
	        }
	      }
	}
	}	    
	    public void saveToLocal(HttpEntity httpEntity , String filename) {
	    	 try {

	    	      File dir = new File("d:/");
	    	      if (!dir.isDirectory()) {
	    	        dir.mkdir();
	    	      }

	    	      File file = new File(dir.getAbsolutePath() + "/" + filename);
	    	      FileOutputStream fileOutputStream = new FileOutputStream(file);
	    	      InputStream inputStream = httpEntity.getContent();

	    	      if (!file.exists()) {
	    	        file.createNewFile();
	    	      }
	    	      byte[] bytes = new byte[1024];
	    	      int length = 0;
	    	      while ((length = inputStream.read(bytes)) > 0) {
	    	        fileOutputStream.write(bytes, 0, length);
	    	      }
	    	      inputStream.close();
	    	      fileOutputStream.close();
	    	    } catch (Exception e) {
	    	      e.printStackTrace();
	    	    }
	    }
}
