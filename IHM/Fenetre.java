package Morpion.IHM;

import javax.swing.*;
import java.awt.*;

import Morpion.Controleur;

public class Fenetre extends JFrame
{
	private PanneauMorpion pnlMorpion;
	private PanneauFonct   pnlFonct;

	private JPanel         pnlScore;
	private JLabel         lblScore;
	private JLabel         lblGagn;

	private Morpion.Controleur     ctrl;

	public Fenetre(Morpion.Controleur ctrl)
	{
		//parametrage de la fenetre
		this.setTitle   ("Morpion");
		this.setLocation(20, 20);
		this.setSize(750,750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());
		
		// Création des Controles
		this.ctrl = ctrl;
		this.pnlMorpion  = new PanneauMorpion(this);
		this.pnlFonct    = new PanneauFonct(this);
		this.pnlScore    = new JPanel();

		this.lblScore    = new JLabel();
		this.lblGagn     = new JLabel();
		
		// Activation des Controles
		this.pnlScore.setLayout( new BorderLayout ());

		this.add(pnlMorpion, BorderLayout.CENTER);
		this.add(pnlFonct  ,BorderLayout.SOUTH);
		this.add(pnlScore  ,BorderLayout.NORTH);

		this.pnlScore.add(this.lblScore, BorderLayout.NORTH);
		this.pnlScore.add(this.lblGagn , BorderLayout.SOUTH);

		this.majIHM();
		
		//affichage
		this.pnlScore.setBackground  (Color.PINK);
		this.pnlMorpion.setBackground(Color.PINK);
		this.pnlFonct.setBackground  (Color.PINK);

		this.lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblGagn.setHorizontalAlignment (SwingConstants.CENTER);

		this.setVisible(true);
	}

	public Morpion.Controleur getCtrl()
	{
		return this.ctrl;
	}

	public PanneauMorpion getPnlMorpion()
	{
		return this.pnlMorpion;
	}

	public void majIHM()
	{
		this.pnlMorpion.majIHM();
		this.lblScore.setText("Vous avez fait "                   + this.ctrl.getNbParties() + " parties " +
		                      ", le joueur X a fait un score de " + this.ctrl.getPartiesX()  +
		                      ", le joueur O a fait un score de " + this.ctrl.getPartiesO()  + ".");
	}

	public void setMessage (char fin)
	{
		switch (fin)
		{
			case 'X' -> this.lblGagn.setText("Le joueur X a gagné la partie");
			case 'O' -> this.lblGagn.setText("Le joueur O a gagné la partie");
			default  -> this.lblGagn.setText("La partie se conclue par un match nul !");
		}
	}
}

