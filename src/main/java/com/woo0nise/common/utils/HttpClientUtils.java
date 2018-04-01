
package com.woo0nise.common.utils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * HttpClient工具类
 * <p>Title: HttpClientUtils</p>
 * <p>Description: </p>
 * <p>date: 2018年3月30日 </p>
 * <p>Email woo0nise@gmail.com </p>
 * <p>Company:www.hack-gov.com </p>
 * @author: 0nise
 * @version: 1.0.0
 */
public class HttpClientUtils {
	
	/**
	 * 私有化构造,防止被实例化
	 */
	private HttpClientUtils() {}
	// 延迟时间
	private static Integer REQUEST_CONNECTION_TIME = 60*1000;
	
	/**
	 * 发送get请求
	 * @param url　请求url
	 * @param param　请求参数map
	 * @return 请求结果
	 */
	public static String doGet(String url, Map<String, String> param) {
		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();
			
			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);
			// 设置请求头
			httpGet.setHeader("Accept-Charset", "utf-8");
			httpGet.setHeader("contentType", "utf-8");
			httpGet.setHeader("accept", "*/*");
			httpGet.setHeader("connection", "Keep-Alive");
			httpGet.setHeader("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
	
	/**
	 * 发送get请求
	 * @param url　请求url
	 * @return 请求结果
	 */
	public static String doGet(String url) {
		return doGet(url, null);
	}

	/**
	 * 发送post请求
	 * @param url　请求url
	 * @param param　请求参数map
	 * @return 请求结果
	 */
	public static String doPost(String url, Map<String, String> param) {
		return doPost(url,param,null);
	}

	/**
	 * 发送post请求
	 * @param url　请求url
	 * @return 请求结果
	 */
	public static String doPost(String url) {
		return doPost(url, null);
	}
	
	/**
	 * 发送post请求
	 * @param url　请求url
	 * @param param　请求参数map
	 * @param proxy 代理配置
	 * @return 请求结果
	 */
	public static String doPost(String url, Map<String, String> param,HttpHost proxy) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient  = null;
		RequestConfig defaultRequestConfig = null;
		if(proxy != null) {
		   //把代理设置到请求配置
		   defaultRequestConfig = RequestConfig.custom()
		            .setProxy(proxy).setSocketTimeout(REQUEST_CONNECTION_TIME).setConnectionRequestTimeout(REQUEST_CONNECTION_TIME)
		            .build();
		}else {
			defaultRequestConfig = RequestConfig.custom()
		            .setSocketTimeout(REQUEST_CONNECTION_TIME).setConnectionRequestTimeout(REQUEST_CONNECTION_TIME)
		            .build();
		}
		httpClient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 设置请求头
			httpPost.setHeader("Accept-Charset", "utf-8");
			httpPost.setHeader("contentType", "utf-8");
			httpPost.setHeader("accept", "*/*");
            httpPost.setHeader("connection", "Keep-Alive");
            httpPost.setHeader("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
				httpPost.setEntity(entity);
			}
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultString;
	}

	/**
	 * 发送post请求
	 * @param url　请求url
	 * @param json　请求参数json
	 * @param proxy 代理配置
	 * @return 请求结果
	 */
	public static String doPostJson(String url, String json,HttpHost proxy) 
	{
		// 创建Httpclient对象
		CloseableHttpClient httpClient  = null;
		RequestConfig defaultRequestConfig = null;
		if(proxy != null) {
		   //把代理设置到请求配置
		   defaultRequestConfig = RequestConfig.custom()
		            .setProxy(proxy).setSocketTimeout(5000).setConnectionRequestTimeout(5000)
		            .build();
		}else {
			defaultRequestConfig = RequestConfig.custom()
		            .setSocketTimeout(5000).setConnectionRequestTimeout(5000)
		            .build();
		}
		httpClient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建请求内容
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
	
	/**
	 * 发送post请求
	 * @param url　请求url
	 * @param json　请求参数json
	 * @return 请求结果
	 */
	public static String doPostJson(String url, String json) {
		return doPostJson(url,json,null);
	}

	/**
	 * 随机提取代理
	 * @return 代理
	 */
	public static HttpHost getRandomProxy() {
		HttpHost proxy = null;
		String url = "http://api.xdaili.cn/xdaili-api//greatRecharge/getGreatIp?spiderId=2a30f86b1ca240be8182fc69d6489373&orderno=YZ20183301066arqphv&returnType=2&count=1";
		String rsp = HttpClientUtils.doPost(url);
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(rsp);
			String code = jsonNode.path("ERRORCODE").asText();
			if("0".equals(code)) {
				JsonNode result = jsonNode.get("RESULT");
				JsonNode json = result.get(0);
				String ip = json.path("ip").asText();
				int port = Integer.parseInt(json.path("port").asText().trim());
				proxy = new HttpHost(ip, port, "http");
				System.out.println(proxy.toString()+" --> ok!");
			}else if("10055".equals(code)) {
				Thread.sleep(5*1000);
				proxy = getRandomProxy();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proxy;
	}
}
