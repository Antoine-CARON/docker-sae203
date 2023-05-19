public class Controleur 
{
	private GrilleMorpion mrpn;

	private FenetreAccueil fntrAcc;

	private Serveur serv;

	private boolean tourJoueurX = true;

	public Controleur()
	{
		this.mrpn = new GrilleMorpion();
		this.fntrAcc = new FenetreAccueil(this);
	} 

	public static void main (String[] args)
	{
		new Controleur();
	}

	public boolean joueCase (int ligne, int colonne)
	{
		this.tourJoueurX = !tourJoueurX;
		this.mrpn.jouer(ligne, colonne, tourJoueurX);
		return this.mrpn.finDePartie();
	}

	public String getIcon(int lig, int col)
	{
		String sRet ="";

		switch (this.mrpn.getCase(lig, col))
		{
			case 'X' : { sRet = "./Images/Croix.png";break;}
			case 'O' : { sRet = "./Images/rond.png"; break;}
		}

		return sRet;
	}

	public String getPlateau()
	{
		return this.mrpn.getPlateau();
	}

	public char getVictoire()
	{
		if (this.mrpn.victoire('X'))
		{
			return 'X';
		}
		if (this.mrpn.victoire('O'))
		{
			return 'O';
		}
		if (this.mrpn.finDePartie())
		{
			return '.';
		}
		return '?';
	}

	public void relancerPartie()
	{
		this.mrpn.relancerPartie();
	}

	public int getNbParties()
	{
		return this.mrpn.getNbParties();
	}
	public int getPartiesO()
	{
		return this.mrpn.getPartiesO();
	}
	public int getPartiesX()
	{
		return this.mrpn.getPartiesX();
	}

	public void launchServ()
	{
		this.serv = new Serveur(this);
		this.serv.creerServeur();

		while(!this.mrpn.finDePartie() && !this.mrpn.matchNul())
		{
			this.serv.jouer();
			System.out.println(this.mrpn.finDePartie());
			System.out.println(this.mrpn.matchNul());
		}

		System.out.println("egalite");

		if(this.mrpn.matchNul()) {this.serv.ServeurFinNul();}
		else {this.serv.ServeurFin();}
	}
}
