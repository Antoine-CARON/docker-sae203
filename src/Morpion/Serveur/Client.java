// package Morpion.Serveur;

// import java.io.*;
// import java.net.*;
import iut.algo.*;

// public class Client 
// {
// 	private final static int PORT = 4660;
// 	private Socket toServer;

// 	public Client (String ipServ)
// 	{
// 		try {
// 			this.toServer = new Socket(ipServ, PORT);
// 		} catch (Exception e) {
// 			System.out.println("erreur");
// 		}
// 	}

// 	public String attMess() 
// 	{
// 		try 
// 		{
// 			BufferedReader in  = new BufferedReader(new InputStreamReader(toServer.getInputStream()));
		
// 			System.out.println(in.readLine());

// 			String sRet = in.readLine();
// 			while (sRet != null && !sRet.equals(""))
// 			{
// 				sRet = in.readLine();
// 				return sRet;
// 			}

// 			in.close();
// 		} 
// 		catch (IOException ioe) 
// 		{
// 			System.out.println("erreur");
// 		}
// 		return "";
// 	}

// 	public void envoie(String message) 
// 	{
// 		try 
// 		{			
// 			PrintWriter    out = new PrintWriter(this.toServer.getOutputStream(), true);
		
// 			out.println(message);

// 			out.close();
// 		} 
// 		catch (IOException ioe) 
// 		{
// 			System.out.println("erreur");
// 		}
// 	}
// }
import java.io.*;
import java.net.*;
import iut.algo.*;

public class Client
{
	public static void main(String[] args) 
	{
		System.out.println("attente d'un client ...");

		try 
		{
			System.out.println("connexion au serveur ...");
			Socket toServer = new Socket("di-724-15", 4660);
			System.out.println ("connectÃ© ...");
			
			PrintWriter    out = new PrintWriter(toServer.getOutputStream(), true);
			BufferedReader in  = new BufferedReader(new InputStreamReader(toServer.getInputStream()));
		

			String sTest = in.readLine();
			while (true)
			{
				out.println(Clavier.lireString());
				System.out.println(sTest);
				out.println(sTest);

				sTest = in.readLine();

				in.close();
				out.close();
				toServer.close();
			}
		} 
		catch (IOException ioe) 
		{
			System.out.println("erreur");
		}
	}
}
