import java.net.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;

public class Identification implements Runnable {

	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String nom = "Inconnu";
	public boolean identification = false;
	public Thread t2;

	public Identification(Socket s){
		socket = s;
	}
	
	public void run() {

		try {

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());

			while(!identification){
				
				//Demande au client de s'identifier
				out.println("Identifier vous :");
				out.flush();
				nom = in.readLine();

				//out.println("connecte"); //Inutile
				//out.flush();
				System.out.println(nom +" vient de se connecter ");
				identification = true;	

			}
			//On crée un tchat entre le serveur et cette personne (nom du Client)
			t2 = new Thread(new ChatServeur(socket,nom));
			t2.start();
			
			//On ajoute le client a la liste des clients du serveur
			//Cette liste du client est comme une room contenant tous les clients
			Serveur.listeDesClients.add(socket);

		} catch (IOException e) {

			System.err.println(nom+" ne répond pas !");
		}
	}

}
