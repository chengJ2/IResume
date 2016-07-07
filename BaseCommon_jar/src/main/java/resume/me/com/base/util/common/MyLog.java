package resume.me.com.base.util.common;

import android.util.Log;

import resume.me.com.base.text.CommonText;

public class MyLog {

	public static void d(String tag, String msg) {
		if (CommonText.DEBUG)
			Log.d(tag, msg);
	}
	
	public static void d(String msg) {
		if (CommonText.DEBUG)
			Log.d(CommonText.LOGTAG, msg);
	}

	public static void v(String tag, String msg) {
		if (CommonText.DEBUG)
			Log.v(tag, msg);
	}
}
