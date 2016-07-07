package resume.me.com.base.util.common;


import org.ksoap2.transport.HttpTransportSE;
import java.io.IOException;
import org.ksoap2.transport.ServiceConnection;

public class MyAndroidHttpTransport extends HttpTransportSE {

	private int timeout = 30000; // 默认超时时间为30s
	
	public MyAndroidHttpTransport(String url) {
		super(url);
	}

	public MyAndroidHttpTransport(String url,int timeout) {
		super(url);
		this.timeout = timeout;
	}
	
	@Override
    protected ServiceConnection getServiceConnection() throws IOException {
        ServiceConnectionSE serviceConnection = new ServiceConnectionSE(url);
        serviceConnection.setConnectionTimeOut(timeout);
        return serviceConnection;
    }
}
