package com.cloud.test.utils;

import java.io.IOException;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * <h2>CreateHttpConnection</h2> Creates HttpURLConnection and returns content
 * returned from the API
 * 
 * @author SAKSHI
 *
 */
public class CreateHttpConnection {

	private String accessToken = "User B8bOYEJFrrg9p5E4heZEsjADT8+HMxTumGTDp/5U3g4=, Organization 6568b63d94f9af404214928a85336c50, Element U/J33cSxeN0Stk73gjrKobJXyfV25vup2vA2VLS/cn8=";

	/**
	 * @param requestUrl
	 * @return
	 * @throws IOException
	 */
	public StringBuilder responseContent(String requestUrl) throws IOException {
		URL obj = new URL(requestUrl);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", accessToken);
		con.setRequestProperty("accept", "application/json");
		con.setDoOutput(true);
		Reader reader = new java.io.InputStreamReader((java.io.InputStream) con.getContent());
		StringBuilder content = new StringBuilder();
		char[] buf = new char[1024];
		for (int n = reader.read(buf); n > -1; n = reader.read(buf))
			content.append(buf, 0, n);
		con.disconnect();
		return content;

	}

}
