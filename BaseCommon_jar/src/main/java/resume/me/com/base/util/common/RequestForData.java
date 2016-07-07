package resume.me.com.base.util.common;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import android.annotation.SuppressLint;
import android.os.StrictMode;

import resume.me.com.base.text.CommonText;


/**
 * 从网络请求数据返回DataSetList
 * 
 * @author Administrator
 * 
 */
public class RequestForData {

	/**
	 * @param nameSpace
	 * @param methodName
	 * @param endPoint
	 * @param params
	 *            请求传递的参数
	 * @return 从网络请求数据返回DataSetList
	 */
	@SuppressLint("NewApi")
	public static DataSetList getResultData(String nameSpace,
			String methodName, String endPoint, String params, byte[] data,
			boolean ISSECRET) {

		DataSetList parsedExampleDataSet = null;
		// android3.0以上需要加上下面几句话
		if (android.os.Build.VERSION.SDK_INT > 10) {
			StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
					.detectDiskReads().detectDiskWrites().detectNetwork()
					.penaltyLog().build());
			StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
					.detectLeakedSqlLiteObjects().detectLeakedSqlLiteObjects()
					.penaltyLog().penaltyDeath().build());
		}
		String soapAction = nameSpace + methodName;
		// 指定WebService的命名空间和调用的方法名
		SoapObject rpc = new SoapObject(nameSpace, methodName);
		// 设置需调用WebService接口需要传入的两个参数mobileCode、userId
		rpc.addProperty("dataTableName", params);
		if (data != null) {
			rpc.addProperty("contentBytes", data);
		}

		// 获取返回的结果
		String result = null;
		// 生成调用WebService方法的SOAP请求信息,并指定SOAP的版本
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.bodyOut = rpc;
		// 设置是否调用的是dotNet开发的WebService
		envelope.dotNet = true;
		// 等价于envelope.bodyOut = rpc;
		envelope.setOutputSoapObject(rpc);
		HttpTransportSE transport = new MyAndroidHttpTransport(endPoint,
				5 * 1000);
		try {
			// 调用WebService
			transport.call(soapAction, envelope);
		} catch (Exception e) {
			result = "<?xml version=\"1.0\" encoding=\"utf-8\"?><root><child><key>msg</key><value>timeout</value></child></root>";
			e.printStackTrace();
		}

		// 获取返回的数据
		SoapObject object;
		try {
			object = (SoapObject) envelope.bodyIn;
		} catch (Exception e1) {
			object = null;
			e1.printStackTrace();
		}

		if (object != null) {
			try {
				result = object.getProperty(0).toString();
				if (ISSECRET) {
					result = EncryptUncrypt.encryptAndcrypt(result,
							CommonText.SECRET);
				}
			} catch (Exception e) {
				result = null;
				e.printStackTrace();
			}
		}

		MyLog.d("==Response==>>" + result);
		if (result != null) {
			try {
				SAXParserFactory saxParserFactory = SAXParserFactory
						.newInstance();
				XMLReader reader = saxParserFactory.newSAXParser()
						.getXMLReader();
				XMLContentHandlerForList myExampleHandler = new XMLContentHandlerForList();
				reader.setContentHandler(myExampleHandler);
				InputSource inputSource = new InputSource();
				inputSource.setEncoding("utf-8");
				inputSource.setCharacterStream(new StringReader(result));
				reader.parse(inputSource);
				parsedExampleDataSet = myExampleHandler.dataSet;
			} catch (SAXException e) {
				parsedExampleDataSet = null;
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				parsedExampleDataSet = null;
				e.printStackTrace();
			} catch (IOException e) {
				parsedExampleDataSet = null;
				e.printStackTrace();
			}
		}
		return parsedExampleDataSet;
	}

}
