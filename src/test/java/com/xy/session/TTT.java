package com.xy.session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

public class TTT
{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpclient = HttpClients.createDefault();  
		HttpGet httpget = new HttpGet("http://168.3.63.26:8080/workrecord/netLogin.action");  
		CloseableHttpResponse response = httpclient.execute(httpget);  
		
		System.out.println(response.getProtocolVersion());  
		System.out.println(response.getStatusLine().getStatusCode());  
		System.out.println(response.getStatusLine().getReasonPhrase());  
		System.out.println(response.getStatusLine().toString());  
		
		try {  
		    HttpEntity entity = response.getEntity();  
		    if (entity != null) {  
		        InputStream instream = entity.getContent();  
		        try {  
		        	convertStreamToString(instream);
		        } finally {  
		            instream.close();  
		        }  
		    }  
		} finally {  
		    response.close();  
		}  
	}
	
	@Test
	public void login() throws ClientProtocolException, IOException{
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
		formparams.add(new BasicNameValuePair("loginName", "admin"));  
		formparams.add(new BasicNameValuePair("password", "1"));  
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);  
		HttpPost httppost = new HttpPost("http://localhost/audit/app/loginController/login");  
		httppost.setEntity(entity); 
		CloseableHttpClient httpclient = HttpClients.createDefault();  
		httpclient.execute(httppost);
	}
	
	public static String convertStreamToString(InputStream is) {    
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));    
        StringBuilder sb = new StringBuilder();    
     
        String line = null;    
        try {    
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");    
            }    
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                is.close();    
            } catch (IOException e) {    
               e.printStackTrace();    
            }    
        }    
        System.out.println(sb.toString());
        return sb.toString();    
    }

}