package Morpion.Metier;

import java.io.*;
import java.net.*;

import java.util.*;

//import Morpion.IHM.FenetreServeur;
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

			System.out.println("Attente de deux clients ...");
			while(this.lstClient.size() < 2)
			{
				Socket toClient = ss.accept();

				this.lstClient.add(toClient);

				PrintWriter    out = new PrintWriter   (toClient.getOutputStream(), true);
				out.println("Bienvenue, nous allons bientot jouer !!!\n");
			}
		}
		catch (IOException ioe) 
		{
			System.out.println("erreur");
		}
		System.out.println("\nLes deux joueurs sont arrivés\nLa partie peut commencer\n");
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

			PrintWriter    out1 = new PrintWriter   (this.lstClient.get(aj).getOutputStream(), true);
			BufferedReader in1  = new BufferedReader(new InputStreamReader(this.lstClient.get(aj).getInputStream()));

			out.println("-------------");
			out1.println("-------------");

			out.println("C'est à vous de jouez (<lig>:<col>) : ");
			out1.println("C'est au tour de l'autre joueur !!!\n");

			String sTest = in.readLine();
			while ( !(sTest.length() >= 3) &&
					!(Integer.parseInt("" + sTest.charAt(0)) <= 2) &&
					!(Integer.parseInt("" + sTest.charAt(0)) >= 0) &&
					!(Integer.parseInt("" + sTest.charAt(2)) <= 2) &&
					!(Integer.parseInt("" + sTest.charAt(2)) >= 0))
			{
				out.println("Saisie invalide, recommencez");
				sTest = in.readLine();
			}

			int lig = Integer.parseInt("" + sTest.charAt(0));
			int col = Integer.parseInt("" + sTest.charAt(2));

			this.ctrl.joueCase(lig, col);

			out.println("Voici votre coup : ");
			out.println(this.ctrl.getPlateau());

			out1.println("Le coup est joué, voici le plateau : ");
			out1.println(this.ctrl.getPlateau());

			out.println("\n");
			out1.println("\n");
		}
		catch(Exception e){ System.out.println(e);}

		this.nbTour++;
	}

	public void ServeurFin()
	{
		int j, aj;
		if(this.nbTour % 2 == 0){j = 0;aj = 1;}
		else{j = 1;aj = 0;}

		try
		{

			PrintWriter    out = new PrintWriter   (this.lstClient.get(j).getOutputStream(), true);
			PrintWriter    out1 = new PrintWriter   (this.lstClient.get(aj).getOutputStream(), true);

			out.println("Fin de la partie, vous avez perdu");
			out1.println("Fin de la partie, bravo vous avez gagné");

		}catch (Exception e){}

		System.exit(0);
	}
}