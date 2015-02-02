package com.xy.session;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.http.Consts;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.ProxyClient;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xy.util.DateUtil;

public class Test_001 {
	
	private Logger log = LoggerFactory.getLogger(Test_001.class);

	@Test
	public void testLocalData() throws ClientProtocolException, IOException, InterruptedException, ExecutionException{
		
		ConnectionKeepAliveStrategy keepAliveStrat = new DefaultConnectionKeepAliveStrategy(){
			@Override
			public long getKeepAliveDuration(HttpResponse response,
					HttpContext context) {
				long keepAlive = super.getKeepAliveDuration(response, context);
				if (keepAlive == -1) {
                    //如果服务器没有设置keep-alive这个参数，我们就把它设置成1小时
                    keepAlive = 1000 * 60 * 60;
                }
                return keepAlive;
			}
			
		};
		
		HttpClientContext context = HttpClientContext.create();
		
		HttpClientConnectionManager connMgr = new BasicHttpClientConnectionManager();
		HttpRoute route = new HttpRoute(new HttpHost("168.7.88.193" , 80));
		
		ConnectionRequest connRequest = connMgr.requestConnection(route, null);
		
		HttpClientConnection conn = connRequest.get(10, TimeUnit.SECONDS);
		try {
			// If not open
			if (!conn.isOpen()) {
				System.out.println(" ---------------- establish connection based on its route info");
				connMgr.connect(conn, route, 1000, context);
				System.out.println(" ---------------- and mark it as route complete");
				connMgr.routeComplete(conn, route, context);
			}
			System.out.println(" ---------------- Do useful things with the connection.");
		} finally {
			connMgr.releaseConnection(conn, null, 1, TimeUnit.MINUTES);
		}
		
		CloseableHttpClient httpClient = HttpClients.custom()
				.setConnectionManager(connMgr)
				.setKeepAliveStrategy(keepAliveStrat)
				.build();
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
	    formparams.add(new BasicNameValuePair("loginName", "000000314"));
	    formparams.add(new BasicNameValuePair("password", "1"));
	    UrlEncodedFormEntity urlentity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		    
		HttpPost httpPost = new HttpPost("http://168.7.88.193/audit/app/loginController/login");
		httpPost.setEntity(urlentity);
		
		CloseableHttpResponse response = httpClient.execute(httpPost , context);
		System.out.println(response.getFirstHeader("Set-Cookie").getValue());
		if(response.getStatusLine().getStatusCode() == 200){
			httpPost = new HttpPost("http://168.7.88.193/audit/app/systemUserController/getSysUserList");
			response = httpClient.execute(httpPost , context);
			try{
				HttpEntity httpentity = response.getEntity();
				if(httpentity != null){
					InputStream is = httpentity.getContent();
					if(is != null){
						TTT.convertStreamToString(is);
						is.close();
					}
				}
			}catch(Exception e){
				
			}
		}
	}
	
	@Test
	public void test02() throws ClientProtocolException, IOException{
		ConnectionKeepAliveStrategy keepAliveStrat = new DefaultConnectionKeepAliveStrategy(){
			@Override
			public long getKeepAliveDuration(HttpResponse response,
					HttpContext context) {
				long keepAlive = super.getKeepAliveDuration(response, context);
				if (keepAlive == -1) {
                    //如果服务器没有设置keep-alive这个参数，我们就把它设置成1小时
                    keepAlive = 1000 * 60 * 60;
                }
                return keepAlive;
			}
			
		};
		
		HttpClientContext context = HttpClientContext.create();
		
		CloseableHttpClient httpClient = HttpClients.custom()
				.setKeepAliveStrategy(keepAliveStrat)
				.build();
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
	    formparams.add(new BasicNameValuePair("username", "haojp"));
	    formparams.add(new BasicNameValuePair("password", "111111"));
	    formparams.add(new BasicNameValuePair("rand", ""));
	    UrlEncodedFormEntity urlentity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		    
		HttpPost httpPost = new HttpPost("http://168.3.63.26:8080/workrecord/netLogin.action");
		httpPost.setEntity(urlentity);
		
		CloseableHttpResponse response = httpClient.execute(httpPost , context);
		
		HttpEntity httpentity = response.getEntity();
		if(httpentity != null){
			 System.out.println("--------------------------------------");  
             System.out.println("Response content: " + EntityUtils.toString(httpentity, "UTF-8")); 
             System.out.println("----" +  context.getUserToken());
             System.out.println("--------------------------------------");  
		}
	}
	
	@Test
	public void test03() throws IOException{
		 URL url = new URL("http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theCityCode=%E4%B8%8A%E6%B5%B7");//要调用的url
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setConnectTimeout(5000);
	        conn.setRequestMethod("GET");//设置get方式获取数据
	 
	        if (conn.getResponseCode() == 200) {//如果连接成功
	            BufferedReader br = new BufferedReader(new InputStreamReader(conn
	                    .getInputStream()));//创建流
	            String lines = null;
	            while ((lines = br.readLine()) != null) {
	                System.out.println(lines.replaceAll("&[lg]t;",""));//将读取到的数据打印
	            }
	            br.close();
	        }
	        conn.disconnect();
	}
	
	@Test
	public void test04() throws IOException, HttpException{
		
		ProxyClient proxyClient = new ProxyClient();
        HttpHost target = new HttpHost("www.baidu.com", 80);
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
	        } finally {
	            socket.close();
	        }
		 
	}
	
	@Test
	public void getCookie() throws IOException, URISyntaxException{
		 BasicCookieStore cookieStore = new BasicCookieStore();
	        CloseableHttpClient httpclient = HttpClients.custom()
	                .setDefaultCookieStore(cookieStore)
	                .build();
	        try {
	            HttpGet httpget = new HttpGet("http://168.3.63.26:8080/workrecord/netLogin.action");
	            CloseableHttpResponse response1 = httpclient.execute(httpget);
	            try {
	                HttpEntity entity = response1.getEntity();

	                System.out.println("Login form get: " + response1.getStatusLine());
	                EntityUtils.consume(entity);

	                System.out.println("Initial set of cookies:");
	                List<Cookie> cookies = cookieStore.getCookies();
	                if (cookies.isEmpty()) {
	                    System.out.println("None");
	                } else {
	                	System.out.println("-----JSESSIONID="+ cookies.get(0).getValue());
	                    for (int i = 0; i < cookies.size(); i++) {
	                        System.out.println("---cookies---" + cookies.get(i).toString());
	                    }
	                }
	            } finally {
	                response1.close();
	            }
	        }finally {
	        	httpclient.close();
            }
	}
	
	@Test
	public void downloadImage() throws ClientProtocolException, IOException{
		
		
		HttpClientContext context = HttpClientContext.create();
		
		CloseableHttpClient httpClient = HttpClients.custom()
				.build();
		
		HttpPost httpPost = new HttpPost("http://168.3.63.26:8080/workrecord/jsp/img2.jsp");
		System.out.println("Executing request: " + httpPost.getRequestLine());
		//循环30次取30张图片
		for(int i=0 ;i<30;i++){
			
			CloseableHttpResponse response = httpClient.execute(httpPost , context);
			
			HttpEntity httpentity = response.getEntity();
			if(httpentity != null){
				 System.out.println("--------------------------------------");  
				 if(httpentity != null){
						InputStream is = httpentity.getContent();
						if(is != null){
							BufferedImage image = ImageIO.read(is);
				            ImageIO.write(image, "JPEG", new File("F:/workspace/javaocr/img/hehe" + i + ".jpg")); 
						}
					}
				
	             System.out.println("--------------------------------------");  
			}
			response.close();
		}
		httpClient.close();
	}
	
	/**
	 * @Description: 签到
	 * @author: 俞根海
	 * @date: 2014-12-5 下午4:21:44
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void qdlogin() throws ClientProtocolException, IOException{
		HttpClientContext context = HttpClientContext.create();
		BasicCookieStore cookieStore = new BasicCookieStore();
		CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
				.build();
		
		HttpPost httpPost = new HttpPost("http://168.3.63.26:8080/workrecord/jsp/img2.jsp");
		System.out.println("Executing request: " + httpPost.getRequestLine());
		CloseableHttpResponse response1 = httpClient.execute(httpPost , context);
		
		HttpEntity httpentity = response1.getEntity();
		if(httpentity != null){
			 System.out.println("-----------生成图片开始---------------------------");  
			 if(httpentity != null){
					InputStream is = httpentity.getContent();
					if(is != null){
						BufferedImage image = ImageIO.read(is);
			            ImageIO.write(image, "JPEG", new File("d:/hehe.jpg")); 
					}
				}
			
             System.out.println("-----------生成图片结束---------------------------");  
		}
		response1.close();
		//登陆
		httpPost = new HttpPost("http://168.3.63.26:8080/workrecord/login.action");
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
	    formparams.add(new BasicNameValuePair("username", "zhouy"));
	    formparams.add(new BasicNameValuePair("password", "111111"));
	    //手工读入密码
	    InputStream inputStream = System.in;
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	    System.out.println("请输入验证码:");
	    String rand = bufferedReader.readLine();
	    
	    formparams.add(new BasicNameValuePair("rand", rand));
	    UrlEncodedFormEntity urlentity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
	    httpPost.setEntity(urlentity);
	    
	    CloseableHttpResponse response3 = httpClient.execute(httpPost , context);
		httpentity = response3.getEntity();
		if(httpentity != null){
			 System.out.println("--------------登陆后------------------------");  
             System.out.println("Response content: " + EntityUtils.toString(httpentity, "UTF-8")); 
             System.out.println("----" +  context.getUserToken());
             System.out.println("--------------------------------------");  
		}
		
		//签到
		httpPost = new HttpPost("http://168.3.63.26:8080/workrecord/check/checkIn.action");
	    formparams.add(new BasicNameValuePair("place ", "上海"));
	    formparams.add(new BasicNameValuePair("empType ", "1"));
//	    formparams.add(new BasicNameValuePair("workck.ckStatus", "1"));
//	    formparams.add(new BasicNameValuePair("workck.stasName", "已签到"));
	    formparams.add(new BasicNameValuePair("workck.id", "2883bf9a49f6834e014a17ffbb60244b"));
	    formparams.add(new BasicNameValuePair("workck.empId", "2883959026025980012607f21fce0168"));
	    formparams.add(new BasicNameValuePair("workck.ckDate", "2014-11-15"));
	    formparams.add(new BasicNameValuePair("workck.inTime", "08:45:47"));
	    urlentity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
	    httpPost.setEntity(urlentity);
	    
	    CloseableHttpResponse response4 = httpClient.execute(httpPost , context);
		httpentity = response4.getEntity();
		if(httpentity != null){
			 System.out.println("--------------签到后------------------------");  
             System.out.println("Response content: " + EntityUtils.toString(httpentity, "UTF-8")); 
             System.out.println("----" +  context.getUserToken());
             System.out.println("--------------------------------------");  
		}
		
		
	}
}
