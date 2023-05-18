import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;

class PanneauMorpion extends JPanel implements ActionListener
{
	private JButton[][] grilleBtn;
	private Controleur  ctrl;
	private Fenetre     fenetre;

	public PanneauMorpion(Fenetre fenetre)
	{
		this.grilleBtn = new JButton[3][3];
		this.fenetre   = fenetre;
		this.ctrl      = fenetre.getCtrl();

		this.setLayout ( new GridLayout(3,3 , 5, 5));
		
		//creation des composants
		for (int lig = 0; lig < 3; lig++)
		{
			for (int col = 0; col < 3; col++)
			{
				this.grilleBtn[lig][col] = new JButton();
			}
		}

		//placement des composants
		for (int lig = 0; lig < 3; lig++)
			for (int col = 0; col < 3; col++)
				this.add(this.grilleBtn[lig][col]);


		//activation des composants
		for (int lig = 0; lig < 3; lig++)
			for (int col = 0; col < 3; col++)
				this.grilleBtn[lig][col].addActionListener(this);
	}



	public void majIHM ()
	{
		for (int lig = 0; lig < 3; lig++)
			for (int col = 0; col < 3; col++)
				this.grilleBtn[lig][col].setIcon(new ImageIcon(new ImageIcon(ctrl.getIcon(lig, col)).getImage().getScaledInstance(this.getWidth()/3 + 1 ,this.getHeight()/3 + 1,Image.SCALE_DEFAULT)));
	}



	public void actionPerformed (ActionEvent e)
	{
		for (int lig = 0; lig < 3; lig++)
			for (int col = 0; col < 3; col++)
				if(e.getSource() == this.grilleBtn[lig][col])
				{
					if (this.ctrl.joueCase(lig, col))
					{
						switch (this.ctrl.getVictoire())
						{
							case 'X' -> this.fenetre.setMessage('X');
							case 'O' -> this.fenetre.setMessage('O');
							default  -> this.fenetre.setMessage('.');
						}
					}
				}
		
		this.fenetre.majIHM();
	}
}
