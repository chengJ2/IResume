package resume.me.com.base.util.common;

import java.util.List;

import resume.me.com.base.text.CommonText;
import resume.me.com.base.util.interfa.BaseCommonUtil;


/**
 * 数据传输请求
 * @author Administrator
 *
 */
public class CommonUtil implements BaseCommonUtil {

	String nameSpace = "http://huanbaoyun.com/";// uploadFile
	String methodName = "getDataFromProcs";
	String getuploadFile = "getFileFromProc";
	
	/**
	 * 文件上传
	 */
	public DataSetList datasetlistUpdata(String username, String pwd,
			String functionname, int style, List<String> params,
			List<String> paramvalue, byte[] data) {
		DataSetList dataSetlist = new DataSetList();
		String sqlxml;
		sqlxml = XmlPackage.getXmlFileRequest(username, pwd, functionname, style,
				params, paramvalue);
		dataSetlist = RequestForData.getResultData(nameSpace, getuploadFile,
				CommonText.ENDPOINT+"/MyService.asmx?wsdl", sqlxml, data,!CommonText.UNSECRET);
		return dataSetlist;
	}

	/**
	 * 数据请求
	 */
	public DataSetList selects(String username, String pwd,
			String functionname, int style, List<String> params,
			List<String> paramvalue) {
		DataSetList dataSetlist = new DataSetList();
		String sqlxml;
		sqlxml = XmlPackage.getXmlRequest(username, pwd, functionname, style,
				params, paramvalue);
		dataSetlist = RequestForData.getResultData(nameSpace, methodName,
				CommonText.ENDPOINT+"/MyService.asmx?wsdl", sqlxml, null,CommonText.UNSECRET);
		return dataSetlist;
	}

}