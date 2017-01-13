import java.net.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InetAddress LocaleAdresse;
		InetAddress ServeurAdresse;
		
		try {
			LocaleAdresse = InetAddress.getLocalHost();
			System.out.println("L'adresse locale est : "+LocaleAdresse);
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
