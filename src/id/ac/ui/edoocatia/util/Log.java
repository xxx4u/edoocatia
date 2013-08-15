package id.ac.ui.edoocatia.util;

import com.badlogic.gdx.Gdx;

public class Log {
	
	final static String LOG_TAG = "Edoocatia";

	public static void d(String msg) {
		Gdx.app.log(LOG_TAG, msg);
	}
	
	public static void e(String msg, Exception e) {
		Gdx.app.log(LOG_TAG, msg, e);
	}
}
