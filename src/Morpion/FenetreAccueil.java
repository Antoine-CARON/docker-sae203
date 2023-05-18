import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetreAccueil extends JFrame implements ActionListener
{
	private Fenetre           fenetre;
	private FenetreLocalChoix locale;


	private JPanel  pnlChoix;
	private JButton btnNormal;
	private JButton btnLocal;

	private Controleur     ctrl;

	public FenetreAccueil(Controleur ctrl)
	{
		//parametrage de la fenetre
		this.setTitle   ("Morpion");
		this.setLocation(20, 20);
		this.setSize(750,750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());
		
		// Creation des Controles
		this.ctrl = ctrl;

		this.fenetre       = new Fenetre      (this.ctrl);
		this.locale        = new FenetreLocalChoix(this.ctrl);

		this.pnlChoix      = new JPanel();

		this.btnNormal     = new JButton("mode solo");
		this.btnLocal      = new JButton("mode local");
		
		// Activation des Controles
		this.pnlChoix.setLayout( new GridLayout (2,1));

		this.add(pnlChoix);

		this.pnlChoix.add(this.btnNormal);
		this.pnlChoix.add(this.btnLocal );

		this.btnNormal.addActionListener(this);
		this.btnLocal.addActionListener(this);
		
		this.fenetre.setVisible(false);
		this.locale.setVisible(false);

		//affichage
		this.pnlChoix.setBackground(Color.RED);

		this.setVisible(true);
	}

	public Controleur getCtrl()
	{
		return this.ctrl;
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.btnNormal)
			this.fenetre.setVisible(true);
		if (e.getSource() == this.btnLocal)
		{
			this.setVisible(false);
			this.locale.setVisible(true);
		}
			

		this.setVisible(false);
	}
}

