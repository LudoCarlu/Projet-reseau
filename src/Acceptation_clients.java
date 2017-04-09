import java.io.IOException;
import java.net.*;

public class Acceptation_clients implements Runnable {

	private ServerSocket socketserver;
	private Socket socket;
	public Thread t1;
	
	
	public Acceptation_clients(ServerSocket s){
		socketserver = s;
	}

	public void run() {

		try {
			while(true){
				socket = socketserver.accept(); // Un client se connecte on l'accepte
				System.out.println("Quelqu'un veut entrer dans la discussion");
				
				//On lui demande de s'identifier
				t1 = new Thread(new Identification(socket));
				t1.start();
			}

		} catch (IOException e) {
			System.err.println("Erreur serveur");
		}
	}

}