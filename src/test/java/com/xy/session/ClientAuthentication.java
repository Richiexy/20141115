package com.xy.session;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class ClientAuthentication {

	@Test
	public void test01() throws ClientProtocolException, IOException, URISyntaxException{
		URI url = new URIBuilder()
		.setScheme("http")
		.setHost("www.baidu.com")
	    .setPath("/s")
	    .setParameter("wd", "httpclient")
	    .setParameter("rsv_spt", "1")
	    .setParameter("issp", "1")
	    .setParameter("rsv_enter", "0")
	    .setParameter("oq", "")
	    .build();
	    HttpGet httpget = new HttpGet(url);
	    System.out.println(httpget.getURI());
	}
	
	@Test
	public void test02() throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
	    HttpGet httpget = new HttpGet("http://www.baidu.com/s?wd=httpclient&rsv_spt=1&issp=1&rsv_enter=0&oq=");
	    CloseableHttpResponse response = httpclient.execute(httpget);
	    try {
	    	System.out.println("--------------");
	    } finally {
	        response.close();
	    }
	}
	
	@Test
	public void test03() throws ClientProtocolException, IOException{
		HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,
				HttpStatus.SC_OK, 
				"ok") ;
		System.out.println(response.getProtocolVersion());
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getStatusLine().getReasonPhrase());
		System.out.println(response.getStatusLine().toString());
	}
	
	@Test
	public void test04() throws ParseException, IOException {
		StringEntity myEntity = new StringEntity("中文输入测试", ContentType.create("text/plain" , "UTF-8")) ;
		System.out.println(myEntity.getContentType());
	    System.out.println(myEntity.getContentLength());
	    System.out.println(EntityUtils.toString(myEntity));
	    System.out.println(EntityUtils.toByteArray(myEntity).length);
	}
	@Test
	public void test05() throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet("http://168.7.88.193/audit/app/systemUserController/getSysUserList");
		CloseableHttpResponse response = httpClient.execute(httpget);
		
		try {
			HttpEntity entity = response.getEntity();
			if(entity != null){
//				EntityUtils.toString(entity);
				InputStream is = entity.getContent();
				try {
					TTT.convertStreamToString(is);
				} catch (Exception e) {
					e.printStackTrace();
				} finally{
					is.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			response.close();
		}
	}
	@Test
	public void test06() throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
	    formparams.add(new BasicNameValuePair("loginName", "admin"));
	    formparams.add(new BasicNameValuePair("password", "1"));
	    UrlEncodedFormEntity urlentity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		    
		HttpPost httpPost = new HttpPost("http://168.7.88.193/audit/app/loginController/login");
		httpPost.setEntity(urlentity);
		
		CloseableHttpResponse response = httpClient.execute(httpPost);
		try {
			HttpEntity httpentity = response.getEntity();
			if(httpentity != null){
//				EntityUtils.toString(entity);
				InputStream is = httpentity.getContent();
				try {
					TTT.convertStreamToString(is);
				} catch (Exception e) {
					e.printStackTrace();
				} finally{
					is.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			response.close();
		}
		httpClient.close();
		System.out.println(response.getStatusLine().toString());
	}
	@Test
	public void test07() {
		
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
		
		CloseableHttpClient httpClient = HttpClients.custom()
				.setKeepAliveStrategy(keepAliveStrat)
				.build();
		
	}
	
	/**
	 * @Description: 自定义异常
	 * @author: 俞根海
	 * @date: 2014-11-22 下午2:33:32
	 */
	@Test
	public void test08(){
		 HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {

		        public boolean retryRequest(
		                IOException exception,
		                int executionCount,
		                HttpContext context) {
		            if (executionCount >= 5) {
		                // 如果已经重试了5次，就放弃
		                return false;
		            }
		            if (exception instanceof InterruptedIOException) {
		                // 超时
		                return false;
		            }
		            if (exception instanceof UnknownHostException) {
		                // 目标服务器不可达
		                return false;
		            }
		            if (exception instanceof ConnectTimeoutException) {
		                // 连接被拒绝
		                return false;
		            }
		            if (exception instanceof SSLException) {
		                // ssl握手异常
		                return false;
		            }
		            HttpClientContext clientContext = HttpClientContext.adapt(context);
		            HttpRequest request = clientContext.getRequest();
		            boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
		            if (idempotent) {
		                // 如果请求是幂等的，就再次尝试
		                return true;
		            }
		            return false;
		        }

		    };  
		    CloseableHttpClient httpclient = HttpClients.custom()
		            .setRetryHandler(myRetryHandler)
		            .build();
	}
	
	@Test
	public void test09() throws ClientProtocolException, IOException, URISyntaxException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
	    HttpClientContext context = HttpClientContext.create();
	    HttpGet httpget = new HttpGet("http://168.7.88.193/audit");
	    CloseableHttpResponse response = httpclient.execute(httpget, context);
	    try {
	        HttpHost target = context.getTargetHost();
	        List<URI> redirectLocations = context.getRedirectLocations();
	        URI location = URIUtils.resolve(httpget.getURI(), target, redirectLocations);
	        System.out.println("Final HTTP location: " + location.toASCIIString());
	        // 一般会取得一个绝对路径的uri
	    } finally {
	        response.close();
	    }
	}
}
