package Morpion.Serveur;

import java.io.*;
import java.net.*;

import java.util.*;

import Morpion.IHM.FenetreServeur;
import Morpion.Controleur;

public class Serveur 
{
	//private FenetreServeur fntrServ;
	private Controleur ctrl;

	private int nbTour = 0;
	private List<Socket> lstClient = new ArrayList<Socket>();

	public Serveur(Controleur ctrl)
	{
		//this.fntrServ = fntrServ;
		this.ctrl = ctrl;
	}

	public void creerServeur() 
	{
		try 
		{
			ServerSocket ss = new ServerSocket(4660);

			while(lstClient.size() < 2)
			{
				System.out.println("Attente d'un client ...");
				Socket toClient = ss.accept();
				System.out.println("client arrivé ...");

				this.lstClient.add(toClient);

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

	public void jouer()
	{
		int j, aj;
		if(this.nbTour % 2 == 0){j = 0;aj = 1;}
		else{j = 1;aj = 0;}

		try
		{
			PrintWriter    out = new PrintWriter   (this.lstClient.get(j).getOutputStream(), true);
			BufferedReader in  = new BufferedReader(new InputStreamReader(this.lstClient.get(j).getInputStream()));

			out.println("Joue gros enculé");

			String sTest = in.readLine();
			while ( !(Integer.parseInt("" + sTest.charAt(0)) <= 2) &&
					!(Integer.parseInt("" + sTest.charAt(0)) >= 0) &&
					!(Integer.parseInt("" + sTest.charAt(2)) <= 2) &&
					!(Integer.parseInt("" + sTest.charAt(2)) >= 0))
			{
				sTest = in.readLine();
			}

			int lig = Integer.parseInt("" + sTest.charAt(0));
			int col = Integer.parseInt("" + sTest.charAt(2));

			this.ctrl.joueCase(lig, col);

			PrintWriter    out1 = new PrintWriter   (this.lstClient.get(aj).getOutputStream(), true);
			BufferedReader in1  = new BufferedReader(new InputStreamReader(this.lstClient.get(aj).getInputStream()));

			out1.println(this.ctrl.getPlateau());
		}
		catch(Exception e){}

	}
}