package Morpion.IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetreServeur extends JFrame
{
	private JLabel lblInfo;
	private JLabel lblPort;

	private final String portServ = "4660";

	public FenetreServeur()
	{
		//parametrage de la fenetre
		this.setTitle   ("Serveur Morpion");
		this.setLocation(50, 50);
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new GridLayout(2, 1));
		
		// Création des Controles
		this.lblInfo       = new JLabel("Serveur en cours d'éxécution ...");
		this.lblPort       = new JLabel("Port du serveur : " + this.portServ);
		
		// Activation des Controles
		this.add(this.lblInfo);
		this.add(this.lblPort);

		this.setVisible(true);
	}

	public void setMessage(String mess)
	{
		this.lblInfo.setText(mess);
	}
}