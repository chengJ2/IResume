package resume.me.com.base.util.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
* @ClassName: DataSetList 
* @Description: 从网络获取数据后存储的数据结构
* @author Comsys-WH1510032 
* @date 2016/4/14 下午3:12:50 
*
 */
public class DataSetList implements Serializable{
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	public Map<String, List<String>> map=new HashMap<String, List<String>>();
	public String type;
	public List<String> nameList=new ArrayList<String>();

	public List<String> valueList=new ArrayList<String>();
	public List<String> Documentid = new ArrayList<String>();
	public List<String> CONTENTID=new ArrayList<String>();
	public String ERROR="";
	public String SUCCESS="";
	
	public static String autoTextData[];//搜索企业的数据源
	public static String groupsValue[];//父节点值数组
	public static String childrenValue[][];//子节点值数组
	public static String childrenId[][];//企业编号
//	没有子节点的调用此方法
	public Map<String, List<String>> getMap(){
		int num=nameList.size();
		for(int i=0;i<num;i++){
			List<String> list=new ArrayList<String>();
			for(int j=i+1;j<=valueList.size();j=j+num){
				list.add(valueList.get(j-1));
			}
			map.put(nameList.get(i), list);
		}
		return map;
	}
//	有子节点的调用此方法


}
