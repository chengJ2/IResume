package resume.me.com.base.util.common;

import java.io.UnsupportedEncodingException;
import android.util.Base64;

/**
 * 
* @ClassName: EncryptUncrypt 
* @Description: 使用异或运算进行加解密的方法 
* @author Comsys-WH1510032 
* @date 2016/4/14 下午3:10:08 
*
 */
public class EncryptUncrypt {
	/**
	 * 加密
	 * @param value
	 * @param secret
	 * @return
	 */
	public static String encryptAndUncrypt(String value, char secret) {
		// 对value加密，secret密文字符
		byte[] bt = value.getBytes();
		// 将需要加密的内容转换为字节数组
		for (int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (bt[i] ^ (int) secret); // 通过异或运算进行加密
		}
		/*转为base字节流*/
		byte[] bts=Base64.encode(bt, Base64.DEFAULT);
		return new String(bts, 0, bts.length);// 返回加密后的字符串
	}
	/**
	 * 解密
	 * @param value
	 * @param secret
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String encryptAndcrypt(String value, char secret) throws UnsupportedEncodingException  {
		/*转为base字节流*/
		byte[] bt=Base64.decode(value.getBytes(), Base64.DEFAULT);
		// 对value加密，secret密文字符
		// 将需要加密的内容转换为字节数组
		for (int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (bt[i] ^ (int) secret); // 通过异或运算进行加密
		}
		return new String(bt, "utf-8");// 返回加密后的字符串
	}
	
}