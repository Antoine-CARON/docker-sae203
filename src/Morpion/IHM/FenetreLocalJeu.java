package Morpion.IHM;

import java.net.*;
import java.util.*;
import java.io.*;

import javax.swing.*;
import java.awt.*;

import Morpion.Controleur;

public class FenetreLocalJeu extends Fenetre
{
	private ServerSocket serv;

	private Socket cli;

	public FenetreLocalJeu(Morpion.Controleur ctrl)
	{
		super(ctrl);

		this.serv = null;
		this.cli  = null;
	}

	public void setClient  (String socket)
	{
		try 
		{
			this.cli = new Socket(socket, 4660);
		} 
		catch (IOException ioe) 
		{
			System.out.println("erreur client");
		}
	}

	public void setServeur ()
	{
		try 
		{
			this.serv = new ServerSocket(4660);
		} 
		catch (IOException ioe) 
		{
			System.out.println("erreur serveur");
		}
	}

	public void setVisible(boolean b)
	{
		super.setVisible(b);
	}
}

