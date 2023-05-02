package Morpion.IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetreLocalChoix extends JFrame implements ActionListener
{
	private FenetreLocalJeu locale;
	private FenetreServeur serv;

	private JPanel pnlChoix;

	private JButton    btnServ;
	private JButton    btnClient;

	private Morpion.Controleur     ctrl;

	public FenetreLocalChoix(Morpion.Controleur ctrl)
	{
		//parametrage de la fenetre
		this.setTitle   ("Morpion");
		this.setLocation(20, 20);
		this.setSize(750,750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());
		
		// Création des Controles
		this.ctrl = ctrl;
		this.locale        = new FenetreLocalJeu(this.ctrl);

		this.pnlChoix      = new JPanel();

		this.btnServ       = new JButton("Serveur");
		this.btnClient     = new JButton("Client");
		
		// Activation des Controles
		this.pnlChoix.setLayout( new GridLayout (2,1));

		this.add(pnlChoix);

		this.pnlChoix.add(this.btnServ);
		this.pnlChoix.add(this.btnClient);

		this.btnServ.addActionListener(this);
		this.btnClient.addActionListener(this);

		this.setVisible(true);
	}

	public Morpion.Controleur getCtrl()
	{
		return this.ctrl;
	}

	public void setVisible()
	{
		this.setVisible();
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.btnServ)
		{
			this.serv = new FenetreServeur();
			this.ctrl.launchServ();
			this.dispose();
		}
		if (e.getSource() == this.btnClient)
		{
			this.locale.setVisible(true);
			this.dispose();
		}
	}
}

