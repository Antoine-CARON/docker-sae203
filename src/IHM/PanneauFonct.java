package Morpion.IHM;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.*;

class PanneauFonct extends JPanel implements ActionListener
{
	private Fenetre fenetre;

	private JButton btnRelancer; 

	public PanneauFonct (Fenetre f)
	{
		//creation
		this.fenetre = f;
		this.btnRelancer = new JButton("Relancer");

		//positionnement
		this.add(btnRelancer);

		//activation
		this.btnRelancer.addActionListener(this);

	}

	public void actionPerformed (ActionEvent e)
	{
		if (e.getSource() == btnRelancer)
		{
			this.fenetre.getCtrl().relancerPartie();
			this.fenetre.getPnlMorpion().majIHM();
		}
	}
}
