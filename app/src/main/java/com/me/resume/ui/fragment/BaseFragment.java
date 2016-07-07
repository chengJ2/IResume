package com.me.resume.ui.fragment;

import java.util.List;
import java.util.Map;

import android.support.v4.app.Fragment;
import android.widget.EditText;
import android.widget.TextView;

import com.me.resume.utils.RegexUtil;
import resume.me.com.base.text.Info;
import resume.me.com.base.util.common.CommonUtil;
import resume.me.com.base.util.common.DbUtilImplement;
import resume.me.com.base.util.interfa.BaseCommonUtil;
import resume.me.com.base.util.interfa.DbLocalUtil;


/**
 * 
* @ClassName: BaseFragment 
* @Description: Fragment基类
* @date 2016/4/22 下午5:27:02 
*
 */
public class BaseFragment extends Fragment {
	
	protected DbLocalUtil dbUtil = new DbUtilImplement();;// 本地数据库对象
	protected BaseCommonUtil baseCommon = new CommonUtil();;// 通用工具对象实例
	protected Info info = new Info();
	
	protected List<String> mList = null;
	
	protected String queryWhere;
	
	protected Map<String, String[]> commap = null;
	
	/**
	 * 获取输入框值
	 * @param editText
	 * @return
	 */
	protected  String getEditTextValue(EditText editText) {
		String value = editText.getText().toString().trim();
		if (RegexUtil.checkNotNull(value)) {
			return value;
		}
		return "";
	}
	
	/**
	 * 获取文本值
	 * @param editText
	 * @return
	 */
	protected String getTextValue(TextView textView) {
		String value = textView.getText().toString().trim();
		if (RegexUtil.checkNotNull(value)) {
			return value;
		}
		return "";
	}
	
}
