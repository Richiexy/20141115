package com.xy.session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.http.Consts;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.junit.Test;

public class Test_001 {

	@Test
	public void test01() throws ClientProtocolException, IOException, InterruptedException, ExecutionException{
		
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
//				.setConnectionManager(connMgr)
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
	public void test02(){
		HttpClientContext context = HttpClientContext.create();
		CloseableHttpClient httpClient = HttpClients.createDefault();
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
}
