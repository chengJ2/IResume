package resume.me.com.base.util.interfa;

import java.util.List;

import resume.me.com.base.util.common.DataSetList;


public interface BaseCommonUtil {

	/**
	 * 
	 * @param username 用户名
	 * @param pwd  密码
	 * @param functionname  接口名 
	 * @param style  "1,2,3,4.."
	 * @param params  字段名
	 * @param paramvalue 字段值
	 * @return DataSetList
	 * @eg:<br>
	 * 		List list1=new ArrayList<String>();<br>
	 * 		List list2=new ArrayList<String>();<br>
	 * 		list1.add("WRY_BM");<br>
	 * 		list2.add("2012112218460087481");<br>
	 * 		BaseCommonUtil baseCommonUtil=new CommonUtil();  <br>    
	 *      baseCommonUtil.selects("1111","1111","getYDZF_COMPANY",1,list1,list2);
	 */
	public abstract DataSetList selects(String username, String pwd,
										String functionname, int style, List<String> params,
										List<String> paramvalue);
	
	/**
	 * @param username
	 * @param pwd
	 * @param functionname
	 * @param style
	 * @param params
	 * @param paramvalue
	 * @return  �ϴ�
	 */
	public abstract DataSetList datasetlistUpdata(String username, String pwd,
												  String functionname, int style, List<String> params,
												  List<String> paramvalue, byte[] data);

}
