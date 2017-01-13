import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	public static void main (String[] args) {
		ServerSocket socketserver  ;
		Socket socketduserveur ;
		
		try {
			
			socketserver = new ServerSocket(2009);
			socketduserveur = socketserver.accept(); 
			System.out.println("Quelqu'un s'est connecté !");
			socketserver.close();
			socketduserveur.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}