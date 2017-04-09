import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatServeur implements Runnable {

	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private String nom = "Inconnu";
	private Thread t3, t4, t5;


	//Le socket correspond au client
	public ChatServeur(Socket s, String nom) {

		socket = s;
		this.nom = nom;

	}
	public void run() {

		try{

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());

			Thread t3 = new Thread(new ReceptionServeur(in,nom));
			t3.start();

			Thread t4 = new Thread(new EnvoyerMessage(out));
			t4.start();
			//Thread t5 = new Thread(new TransmettreMessage(out,login));
			//t5.start();

		} catch (IOException e) {
			System.err.println(nom +"s'est déconnecté ");
		}
	}

}
