package xyz.minicold.nex.Bilibilis.test;

import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ThreadPoolExecutor;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketClient;
import org.eclipse.jetty.websocket.WebSocketClientFactory;


public class TestMain {
	public static void main(String[] args) throws Exception {
		URI uri = null;
		try {
			 uri=new URI("wss://tx-sh3-live-comet-05.chat.bilibili.com/sub");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebSocketClient websocket=new WebSocketClient(new WebSocketClientFactory());
		websocket.open(uri, new WebSocket() {

			@Override
			public void onOpen(Connection connection) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onClose(int closeCode, String message) {
				// TODO Auto-generated method stub
				
			}
			
		});
		

	}
	

}
