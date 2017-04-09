import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class EnvoyerMessage implements Runnable {

	private PrintWriter out;
	private String message = null;
	private Scanner sc = null;
	
	public EnvoyerMessage(PrintWriter out) {
		this.out = out;
	}

	public void run() {
		
		  sc = new Scanner(System.in);
		  
		  while(true){
			  	
			    System.out.print("Votre message :");
			    System.out.println("");
				message = sc.nextLine();
				out.println(message);
			    out.flush();
			  }
	}
}