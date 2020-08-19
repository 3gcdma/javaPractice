import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SimpleServer {
	private static List<Product> product;
	static ObjectOutputStream output;
	static ObjectInputStream input;
	public static void main(String[] args) {
		int port = 10010;
		
		
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			
			System.out.println("ChatServer 가 준비되었습니다. 접속 포트는 " + port + " 입니다.");

			while (true) {
				Socket socket = serverSocket.accept();
				output = new ObjectOutputStream(socket.getOutputStream());
				input = new ObjectInputStream(socket.getInputStream());
				//PrintWriter writer = new PrintWriter(output, true);
				//writer.println("Hello SSAFY!");

				String msg ="";
				try {
					msg = (String) input.readObject();
					if(msg.equals("open")) {
						//System.out.println("open");
						OpenThread ot = new OpenThread();
						ot.start();
					}else if(msg.equals("close")) {
						//System.out.println("close");
						
						SaveThread st = new SaveThread();
						st.start();
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(msg);

//				output.close();
//				input.close();
			}
			
		 } catch (IOException e) {
			 System.out.println("NetworkSimpleServer exception: " + e.getMessage());
			 e.printStackTrace();
		 }
		
		 System.out.println("NetworkSimpleServer Ended");
	}
	
	public static class SaveThread extends Thread {
		
		@Override
		public void run() {
			String fileName = "product.dat";
			
			try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName))){
				product = (List<Product>) input.readObject();
				writer.writeObject(product);
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static class OpenThread extends Thread {
		
		@Override
		public void run() {
			try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("product.dat"))){
				product = (List<Product>) reader.readObject();
				output.writeObject(product);
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
}

