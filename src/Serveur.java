import java.io.*;
import java.net.*;
import java.util.ArrayList;


public class Serveur {
	
	 public static ServerSocket socketduserveur = null;
	 public static Thread t;
	 public static int port = 2017;
	 
	 public static ArrayList<Socket> listeDesClients = new ArrayList<Socket>();

	public static void main(String[] args) {

		try {
			
			socketduserveur = new ServerSocket(port);
			System.out.println("Le serveur est à l'écoute du port "+socketduserveur.getLocalPort());
			Thread t = new Thread(new Acceptation_clients(socketduserveur));
			t.start();

		} catch (IOException e) {
			System.err.println("Le port "+socketduserveur.getLocalPort()+" est déjà utilisé !");
		}
	}
	
}

/*
 * Quand il y a plusieurs clients des espaces se créé pour que le serveur parle à un a la fois (bug)
 * Il faudrait que le serveur ait une liste de ses clients et qu'il envoi le même message à tous ses clients
 */