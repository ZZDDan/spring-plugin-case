package com.rxx.spider.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.apache.poi.util.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HTTP 访问的Util
 * @author zhang
 */
public class HttpClientUtil {
	private static Logger logger = Logger.getLogger(HttpClientUtil.class);

	/**
	 * 模拟 GET 请求
	 * @param url
	 * @return
	 */
	public static String httpGet(String url) {
		HttpGet httpget = new HttpGet(url);
		httpget.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
		String content = null;
		try (CloseableHttpResponse httpResponse = HttpClients.createDefault().execute(httpget)) {
			content=getResult(httpResponse);
		} catch (Exception e) {
			logger.error("httpGet获取结果失败！！！", e);
		}
		return content;
	}

	/**
	 * 采用HttpClient进行post
	 * @param api_url
	 * @param postParameters
	 * @return
	 */
	public static String post(String api_url, Map<String, String> postParameters) {
		HttpPost httpPost = new HttpPost(api_url);// 创建 HTTP POST 请求
		httpPost.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
		if (buildParam(postParameters, httpPost)) {
			return "error";
		}

		try (CloseableHttpClient client = HttpClients.createDefault();
			 CloseableHttpResponse httpResponse = client.execute(httpPost)){
			return getResult(httpResponse);
		} catch (Exception e) {
			logger.error("httpPost获取结果失败！！！", e);
			return "error";
		}
	}

    /**
     * 构建请求参数
     * @param postParameters
     * @param httpPost
     * @return
     */
	private static boolean buildParam(Map<String, String> postParameters, HttpPost httpPost) {
		try{
			if(postParameters!=null&&postParameters.size()>0){
				List<NameValuePair> list = new ArrayList<>();
				postParameters.forEach((a,b)->list.add(new BasicNameValuePair(a, b)));
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8");
				httpPost.setEntity(entity);
			}
		}catch(Exception e){
			logger.error("httpPost获取结果失败！！！", e);
			return true;
		}
		return false;
	}

    /**
     * 解析响应结果
     * @param httpResponse
     * @return
     */
	private static String getResult(CloseableHttpResponse httpResponse){
		String result=null;
		try{
			if (httpResponse.getStatusLine().getStatusCode() == 200) {

				String contentType = httpResponse.getEntity().getContentType() == null ? ""
						: httpResponse.getEntity().getContentType().getValue();
				byte[] bytes = IOUtils.toByteArray(httpResponse.getEntity().getContent());

				String htmlCharset = detectCharset(contentType, bytes);
				if (htmlCharset != null) {
					result = new String(bytes, htmlCharset);
				} else {
					result = new String(bytes);
				}
			}
		}catch(Exception e){

		}finally{
			if(httpResponse!=null) {
				try {
					httpResponse.close();
				} catch (IOException e) {
				}
			}
		}
		return result;
	}


	private static final Pattern patternForCharset = Pattern.compile("charset\\s*=\\s*['\"]*([^\\s;'\"]*)", Pattern.CASE_INSENSITIVE);

    /**
     * 根据响应的类型找到文件的编码
     * @param contentType text/html; charset=utf-8
     * @return utf-8
     */
	private static String getCharset(String contentType) {
		Matcher matcher = patternForCharset.matcher(contentType);
		if (matcher.find()) {
			String charset = matcher.group(1);
			if (Charset.isSupported(charset)) {
				return charset;
			}
		}
		return null;
	}

    /**
     * 监测编码
     * @param contentType
     * @param contentBytes
     * @return
     * @throws IOException
     */
	private static String detectCharset(String contentType, byte[] contentBytes) throws IOException {

		// charset
		// 1、encoding in http header Content-Type
		String charset = getCharset(contentType);
		if (StringUtils.isNotBlank(contentType) && StringUtils.isNotBlank(charset)) {
			logger.debug("Auto get charset: " + charset);
			return charset;
		}
		// use default charset to decode first time
		Charset defaultCharset = Charset.defaultCharset();
		String content = new String(contentBytes, defaultCharset);
		// 2、charset in meta
		if (StringUtils.isNotEmpty(content)) {
			Document document = Jsoup.parse(content);
			Elements links = document.select("meta");
			for (Element link : links) {
				// 2.1、html4.01 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
				String metaContent = link.attr("content");
				String metaCharset = link.attr("charset");
				if (metaContent.indexOf("charset") != -1) {
					metaContent = metaContent.substring(metaContent.indexOf("charset"), metaContent.length());
					charset = metaContent.split("=")[1];
					break;
				}
				// 2.2、html5 <meta charset="UTF-8" />
				else if (StringUtils.isNotEmpty(metaCharset)) {
					charset = metaCharset;
					break;
				}
			}
		}
		logger.debug("Auto get charset: " + charset);
		// 3、todo use tools as cpdetector for content decode
		return charset;
	}

	/**
	 * 构建请求参数
	 * @param api_url
	 * @param postParameters
	 * @param postHeaders
	 * @return
	 */
	public static String post(String api_url, Map<String, String> postParameters, Map<String, String> postHeaders) {
		HttpPost httpPost = new HttpPost(api_url);// 创建 HTTP POST 请求
		httpPost.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        Set<Entry<String, String>> headers = postHeaders.entrySet();
        headers.forEach((entry)-> httpPost.setHeader(entry.getKey(), entry.getValue()));
		if (buildParam(postParameters, httpPost)) {
			return "error";
		}

		try (CloseableHttpClient client = HttpClients.createDefault();
			 CloseableHttpResponse httpResponse = client.execute(httpPost)){

			return getResult(httpResponse);
		} catch (Exception e) {
			logger.error("httpPost获取结果失败！！！", e);
			return "error";
		}
	}
}
