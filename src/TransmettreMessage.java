import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TransmettreMessage implements Runnable {

	private BufferedReader in;
	private PrintWriter out;
	private String message = null;
	private Scanner sc = null;
	private String nom = null;

	public TransmettreMessage(BufferedReader in, PrintWriter out,String nom) {
		this.in = in;
		this.out = out;
		this.nom = nom;
	}

	public void run() {

		sc = new Scanner(System.in);

		while(true){
			
			try {
				
				//Ecrit dans la console du serveur le message client qu'il vient de recevoir
				message = in.readLine();
				System.out.println(nom+": "+message);
				
				//Si le serveur parle
				if(sc.hasNextLine() == true) {
					message = sc.nextLine();
					this.nom = "Serveur";
				}

				out.println(message);
				out.flush();
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}

		}
	}
}