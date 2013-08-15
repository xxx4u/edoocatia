package id.ac.ui.edoocatia.feature;

import id.ac.ui.edoocatia.util.Log;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Hashtable;


public class Connector {
	protected HttpURLConnection urlConnection;
	protected Hashtable<String, String> params;
	protected final String BASE_URL = "http://edu.yahya.mn/index.php/";
	
	/**
	 * TO get a page content with GET method
	 * @param url the url
	 * @return String of page content, most likely json formatted String
	 */
	protected String getPage(String theUrl) {
		return getPage(theUrl, null);
	}
	
	/**
	 * TO get a page content with POST method
	 * @param url the url
	 * @param params parameters name as key, and the value as value
	 * @return the content of page, most likely json formatted String
	 */
	protected String getPage(String theUrl, Hashtable<String,String> params) {
		String data = "";
		try {
			URL url = new URL(theUrl);
			urlConnection = (HttpURLConnection) url.openConnection();
			if (params != null) {
				String urlParameters = createParamsString(params);
				urlConnection.setDoOutput(true);
				urlConnection.setRequestMethod("POST");
				urlConnection.setRequestProperty("Content-Type", 
			           "application/x-www-form-urlencoded");
				urlConnection.setRequestProperty("Content-Length", "" + 
			               Integer.toString(urlParameters.getBytes().length));
			    urlConnection.setRequestProperty("Content-Language", "en-US");  
				urlConnection.setUseCaches(false);

			    //Send request
				DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
		      	wr.writeBytes(urlParameters);
		      	wr.flush();
		      	wr.close();
			}
			InputStream in = new BufferedInputStream(urlConnection.getInputStream());
		    data = readStream(in);
		} catch (IOException e) {
			Log.e(e.toString(), e);
		} finally {
			urlConnection.disconnect();
		}
		Log.d(data);
		return data;
	}

	protected String createParamsString(Hashtable<String, String> params) 
			throws UnsupportedEncodingException {
		Enumeration<String> keys = params.keys();
		String key;
		StringBuilder paramsString = new StringBuilder();
		while (keys.hasMoreElements()) {
			key = keys.nextElement();
			paramsString.append(key);
			paramsString.append('=');
			paramsString.append(URLEncoder.encode(params.get(key), "UTF-8"));
			paramsString.append('&');
		}
		paramsString.setLength(paramsString.length() - 1);
		Log.d(paramsString.toString());
		return paramsString.toString();
	}

	protected String readStream(InputStream in) throws IOException {
		int ch;
		StringBuilder bf = new StringBuilder();
		while ((ch = in.read()) != -1) {
			bf.append((char) ch);
		}
		return bf.toString();
	}
}
