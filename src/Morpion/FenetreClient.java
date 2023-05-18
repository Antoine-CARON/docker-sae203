
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetreClient extends JFrame
{
	private JLabel lblInfo;
	private JLabel lblCommande;

	public FenetreClient()
	{
		//parametrage de la fenetre
		this.setTitle   ("Client Morpion");
		this.setLocation(50, 50);
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new GridLayout(2, 1));
		
		// Création des Controles
		this.lblInfo       = new JLabel("Pour jouer en tant que client, connecter vous à un serveur ouvert via\n" 
										+ " la commande suivante (sur ce projet, nous utiliserons le port 4660) :");
		this.lblCommande       = new JLabel("nc <nom de machine/adresse ip> <port>");
		
		// Activation des Controles
		this.add(this.lblInfo);
		this.add(this.lblCommande);

		this.setVisible(true);
	}
}