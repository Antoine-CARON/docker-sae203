package Morpion.Metier;

import java.io.*;
import java.net.*;
import iut.algo.*;

public class Client 
{
	private final static int PORT = 4660;
	private Socket toServer;

	public Client (String ipServ)
	{
		try {
			this.toServer = new Socket(ipServ, PORT);
		} catch (Exception e) {
			System.out.println("erreur");
		}
	}

	public String attMess() 
	{
		try 
		{
			BufferedReader in  = new BufferedReader(new InputStreamReader(toServer.getInputStream()));
		
			System.out.println(in.readLine());

			String sRet = in.readLine();
			while (sRet != null && !sRet.equals(""))
			{
				sRet = in.readLine();
				return sRet;
			}

			in.close();
		} 
		catch (IOException ioe) 
		{
			System.out.println("erreur");
		}
		return "";
	}

	public void envoie(String message) 
	{
		try 
		{			
			PrintWriter    out = new PrintWriter(this.toServer.getOutputStream(), true);
		
			out.println(message);

			out.close();
		} 
		catch (IOException ioe) 
		{
			System.out.println("erreur");
		}
	}
}

