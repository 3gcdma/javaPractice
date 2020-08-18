import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) {
		int port = 10010;
		
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			
			System.out.println("ChatServer 가 준비되었습니다. 접속 포트는 " + port + " 입니다.");

			while (true) {
				Socket socket = serverSocket.accept();
				ObjectInputStream output = new ObjectInputStream(socket.getInputStream());
				
				//PrintWriter writer = new PrintWriter(output, true);
				//writer.println("Hello SSAFY!");

				String msg ="";
				try {
					msg = (String) output.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(msg);

				
			}
			
		 } catch (IOException e) {
			 System.out.println("NetworkSimpleServer exception: " + e.getMessage());
			 e.printStackTrace();
		 }
		
		 System.out.println("NetworkSimpleServer Ended");
	}
}

