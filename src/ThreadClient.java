import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadClient implements Runnable {

	private ServerSocket socketserver;
	private Socket socket;
	private int nbclient = 1;
	
	public ThreadClient(ServerSocket s) {
		socketserver = s;
	}

	public void run() {
		try {
			while(true) {
				socket = socketserver.accept(); //Connexion d'un client
				System.out.println("Client n° "+nbclient+" sest connecté");
				nbclient++;
				socket.close();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
