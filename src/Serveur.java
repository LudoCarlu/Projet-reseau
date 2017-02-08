import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	public static void main (String[] args) {
		ServerSocket socketserver  ;
		Socket socketduserveur ;
		BufferedReader in;
		PrintWriter out;
		
		try {
			
			socketserver = new ServerSocket(2009);
			System.out.println("Serveur port = "+socketserver.getLocalPort());
			Thread t = new Thread(new ThreadClient(socketserver));
			t.start();
			/*
			//On obtient le socket du serveur après la connexion
			socketduserveur = socketserver.accept(); 
			System.out.println("Quelqu'un s'est connecté !");
			
			//On l'utilise pour générer un flux sortant
			out = new PrintWriter(socketduserveur.getOutputStream());
			//print : pour parler au client
			out.println("Client vous êtes connecté");
			//On vide le buffer
			out.flush();
			*/
			//Fermeture de la connexion
			//socketserver.close();
			//socketduserveur.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
