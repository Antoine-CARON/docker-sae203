package Morpion.IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetreLocalChoix extends JFrame implements ActionListener
{
	private FenetreLocalJeu locale;

	private JPanel pnlChoix;

	private ButtonGroup choixMode;

	private JRadioButton  cbServer;
	private JButton    btnServ;

	private JRadioButton  cbClient;
	private JTextField txtClientServ;
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

		this.choixMode = new ButtonGroup();

		this.cbServer      = new JRadioButton("Port 4660");
		this.btnServ       = new JButton("Serveur");

		this.cbClient      = new JRadioButton();
		this.txtClientServ = new JTextField();
		this.btnClient     = new JButton("Client");
		
		// Activation des Controles
		this.pnlChoix.setLayout( new GridLayout (5,1));

		this.add(pnlChoix);

		this.choixMode.add(cbServer);
		this.choixMode.add(cbClient);

		this.pnlChoix.add(this.cbServer);
		this.pnlChoix.add(this.btnServ);
		this.pnlChoix.add(this.cbClient );
		this.pnlChoix.add(this.txtClientServ);
		this.pnlChoix.add(this.btnClient);

		this.btnServ.addActionListener(this);
		this.btnClient.addActionListener(this);
		
		//affichage
		this.pnlChoix.setBackground(Color.YELLOW);

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
		if (e.getSource() == this.btnServ && cbServer.isEnabled())
		{
			this.locale.setVisible(true);
			this.dispose();
			this.ctrl.setServeur();
		}
		if (e.getSource() == this.btnClient && cbClient.isEnabled())
		{
			this.locale.setVisible(true);
			this.dispose();
			this.ctrl.setClient(this.txtClientServ.getText());
		}
	}
}

