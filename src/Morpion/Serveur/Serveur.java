package Morpion.Serveur;

import java.io.*;
import java.net.*;

import java.util.*;

import Morpion.IHM.FenetreServeur;

public class Serveur 
{
	private InetAddress client1;
	private InetAddress client2;

	private FenetreServeur fntrServ;

	public Serveur(FenetreServeur fntrServ)
	{
		this.fntrServ = fntrServ;
	}

	public void creerServeur() 
	{
		List<Socket> lstClient = new ArrayList<Socket>();

		try 
		{
			ServerSocket ss = new ServerSocket(4660);

			while(lstClient.size() < 2)
			{
				System.out.println("Attente d'un client ...");
				Socket toClient = ss.accept();
				System.out.println("client arrivé ...");

				lstClient.add(toClient);

				PrintWriter    out = new PrintWriter   (toClient.getOutputStream(), true);
				out.println("Bienvenue");

				out.close();
				toClient.close();
			}
		}
		catch (IOException ioe) 
		{
			System.out.println("erreur");
		}
	}
}