package resume.me.com.base.util.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.ksoap2.transport.ServiceConnection;

public class ServiceConnectionSE implements ServiceConnection {

	private HttpURLConnection connection;

    public ServiceConnectionSE(String url) throws IOException {
        this.connection = ((HttpURLConnection) new URL(url).openConnection());
        this.connection.setUseCaches(false);
        this.connection.setDoOutput(true);
        this.connection.setDoInput(true);
    }
	
	@Override
	public void connect() throws IOException {
		this.connection.connect();
	}

	@Override
	public void disconnect() throws IOException {
		this.connection.disconnect();
	}

	@Override
	public InputStream getErrorStream() {
		return this.connection.getErrorStream();
	}

	@Override
	public InputStream openInputStream() throws IOException {
		return this.connection.getInputStream();
	}

	@Override
	public OutputStream openOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return this.connection.getOutputStream();
	}

	@Override
	public void setRequestMethod(String requestMethod) throws IOException {
		this.connection.setRequestMethod(requestMethod);
	}

	@Override
	public void setRequestProperty(String string, String soapAction) throws IOException {
		this.connection.setRequestProperty(string, soapAction);
	}
	
	// �������ӷ������ĳ�ʱʱ��,���뼶,��Ϊ�Լ���ӵķ���
    public void setConnectionTimeOut(int timeout) {
        this.connection.setConnectTimeout(timeout);
    }

}
