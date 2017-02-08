import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	
	public static void main(String[] args) {
		Socket socket;
		BufferedReader in;
		PrintWriter out;
		
		try {
			//On obtient notre socket
		     socket = new Socket(InetAddress.getLocalHost(),2009);
		     /*
		     //socket.getInputStream : On recupère le flux sortant
		     in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		     //readline : lire une chaine de caractère
		     String messageServeur = in.readLine();
		     //On affiche le message qu'on a reçu
		     System.out.println(messageServeur);
		     */
		     socket.close();

		}catch (UnknownHostException e) {
			e.printStackTrace();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
