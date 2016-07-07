package com.me.resume.ui;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.me.resume.BaseActivity;

import com.me.resume.R;

/**
 * 
* @ClassName: UserRegProtocal 
* @Description: 用户注册协议 
* @date 2016/4/27 下午12:06:31 
*
 */
public class UserRegProtocalActivity extends BaseActivity implements OnClickListener{

	private TextView protocol;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		boayLayout.removeAllViews();
		View v = View.inflate(self,R.layout.activity_user_regprotocol_layout, null);
		boayLayout.addView(v);
		
		setTopTitle(getString(R.string.protocol_title));
		setMsgHide();
		setRightIconVisible(View.GONE);
		setRight2IconVisible(View.GONE);
		setfabLayoutVisible(View.GONE);
		
		protocol = findView(R.id.protocol);
		protocol.setText(Html.fromHtml(getString(R.string.protocol_content)));
	}
	
	@Override
	public void onClick(View v) {
		super.onClick(v);
	}
}
