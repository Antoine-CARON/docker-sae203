import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetreLocalChoix extends JFrame implements ActionListener
{
	private FenetreClient client;
	private FenetreServeur serv;

	private JPanel pnlChoix;

	private JButton    btnServ;
	private JButton    btnClient;

	private Controleur     ctrl;

	public FenetreLocalChoix(Controleur ctrl)
	{
		//parametrage de la fenetre
		this.setTitle   ("Morpion");
		this.setLocation(20, 20);
		this.setSize(750,750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());
		
		// Creation des Controles
		this.ctrl = ctrl;

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

	public Controleur getCtrl()
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
			this.client = new FenetreClient();
			this.dispose();
		}
	}
}

