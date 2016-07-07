package resume.me.com.base.util.common;

import java.util.List;

import resume.me.com.base.text.CommonText;


/**
 * @author 
 * @category 封装成请求json
 */
public class XmlPackage {

	/**
	 * 
	 * @param username 用户名
	 * @param pwd  用户密码
	 * @param functionname  存储过程 
	 * @param style  "操作方式1234，分别代表查询，删除，修改，增加"
	 * @param params  字段名
	 * @param paramvalue 字段值
	 * @return  
	 * @eg 封装成如下格式:<br> 
	 * {"username":"1111","pwd":"1111"},{"functionname":"getYDZF_COMPANY","style":"1"},{"WRY_BM":"2012112218460087481"}
	 */
	public static String getXmlRequest(String username, String pwd,
			String functionname, int style, List<String> params,
			List<String> paramvalue) {

		StringBuffer XmlRequest = new StringBuffer();
		XmlRequest.append("{\"username\":\"" + username + "\",\"pwd\":\"" + pwd + "\"},"
				+ "{\"functionname\":\"" + functionname + "\",\"style\":\"" + style + "\"}");
		if(params != null && paramvalue != null){
			if (paramvalue.size() == params.size()) {
				int size = params.size();
				String str = "";
				for (int i = 0; i < size; i++) {
					str = ",{\"" + params.get(i) + "\":\"" + paramvalue.get(i) + "\"}";
					XmlRequest.append(str);
				}
			}else if(paramvalue.size() != params.size()){
				MyLog.d("输入的两个参数的个数不一致");
			}
		}
		MyLog.d("==Request==>>"+ XmlRequest.toString());//请求语句
		if(CommonText.UNSECRET){
			return EncryptUncrypt.encryptAndUncrypt(XmlRequest.toString(), CommonText.SECRET);
		}else{
			return XmlRequest.toString();
		}
	}
	
	public static String getXmlFileRequest(String username, String pwd,
			String functionname, int style, List<String> params,
			List<String> paramvalue) {

		StringBuffer XmlRequest = new StringBuffer();
		XmlRequest.append("{\"username\":\"" + username + "\",\"pwd\":\"" + pwd + "\"},"
				+ "{\"functionname\":\"" + functionname + "\",\"style\":\"" + style + "\"}");
		if (params != null && params.size() > 0 && paramvalue != null
				&& paramvalue.size() == params.size()) {

			int size = params.size();

			String str = "";

			for (int i = 0; i < size; i++) {

				str = ",{\"" + params.get(i) + "\":\"" + paramvalue.get(i) + "\"}";
				XmlRequest.append(str);

			}

//			XmlRequest.append(str);

		}else if(paramvalue.size() != params.size()){
			MyLog.d("输入的两个参数的个数不一致");
		}
		MyLog.d("Request Xml========>>"+ XmlRequest.toString());//请求语句
		return XmlRequest.toString();
        
	}

}
