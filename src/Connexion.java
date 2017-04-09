import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Connexion implements Runnable {

	private Socket socket = null;
	public static Thread t2;
	public static String nom = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private Scanner sc = null;
	private boolean connect = false;

	public Connexion(Socket s){
		socket = s;
	}

	public void run() {

		try {

			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
			sc = new Scanner(System.in);

			//while(!connect){ //While inutile
				
				System.out.println(in.readLine()); //Message Identifier vous
				nom = sc.nextLine();
				out.println(nom);
				out.flush();

				//if(in.readLine().equals("connecte")){ //Inutile vient de la classe Identification

					System.out.println("Je suis connecté "); 
					//connect = true;
				//}

				/*else {
					System.err.println("Vos informations sont incorrectes "); 
				}*/

			//}
			
			//Chat point de vue du serveur
			t2 = new Thread(new ChatClient(socket));
			t2.start();

		} catch (IOException e) {
			System.err.println("Le serveur ne répond plus ");
		}
	}

}
