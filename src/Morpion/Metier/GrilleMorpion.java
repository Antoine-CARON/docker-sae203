package Morpion.Metier;

import iut.algo.*;

/** objet morpion qui gère le plateau
 *  Morpion avec IHM
 *  @author  Caron Antoine
 *  @version 1 du 04/03/2023
 */

public class GrilleMorpion
{
	private char[][]    grille;

	private boolean     partieFinie;

	private int         nbParties;
	private int         partiesX;
	private int         partiesO;

	public GrilleMorpion ()
	{
		this.grille = new char[3][3];
		
		this.initGrille();

		nbParties = partiesO = partiesX = 0;
	}
	
	public boolean victoire ( char lettre )
	{
		/*-----------------------------*/
		/* Declaration des variables   */
		/*-----------------------------*/
		
		int     troisALaSuite;

		boolean victory;
		
		/*-----------------------------*/
		/* Instructions                */
		/*-----------------------------*/

		victory = false;
		
		//diag "\"
		troisALaSuite = 0;
		for (int lig = 0; lig < this.grille.length; lig++)
		{
			for (int col = 0; col < this.grille[lig].length; col++)
			{
				if ((lig == col) && (this.grille[lig][col]==lettre)){troisALaSuite += 1;}
			}
		}
		if (troisALaSuite == 3) { victory = true ;}

		//diag "/"
		troisALaSuite = 0;
		for (int lig = 0; lig < this.grille.length; lig++)
		{
			for (int col = 0; col < this.grille[lig].length; col++)
			{
				if ((lig + col == 2) && (this.grille[lig][col]==lettre)) 
				{
					troisALaSuite += 1;
				}
			}
		}
		if (troisALaSuite == 3) { victory = true ;}

		troisALaSuite = 0;
		//lignes
		for (int lig = 0; lig < this.grille.length; lig++)
		{
			troisALaSuite = 0;
			for (int col = 0; col < this.grille[lig].length; col++)
			{
				if (this.grille[lig][col]==lettre) 
				{
					troisALaSuite += 1;
				}
			}
			if (troisALaSuite == 3) { victory = true ;}
		}

		troisALaSuite = 0;
		//colonnes
		for (int col = 0; col < this.grille.length; col++)
		{
			troisALaSuite = 0;
			for (int lig = 0; lig < this.grille[col].length; lig++)
			{
				if (this.grille[lig][col]==lettre) {troisALaSuite += 1;}
			}
			if (troisALaSuite == 3) { victory = true ;}
		}

		if (victory && !this.partieFinie) 
		{
			this.partieFinie = true;
			if (lettre == 'O')
				this.partiesO++;
			if (lettre == 'X')
				this.partiesX++;
			
			this.nbParties++;
		}
		
		return victory;

	}

	
	
	public void jouer(int lig, int col, boolean joueurX)
	{
		if (!partieFinie)
		{
			char joueur;

			if (joueurX)
				joueur = 'X';
			else
				joueur = 'O';
			
			if (this.grille[lig][col] == '.')
			{
				this.grille[lig][col] = joueur;
			}
		}
	}

	public boolean matchNul ()
	{
		boolean matchContinue = this.partieFinie;
		for (int lig = 0; lig < this.grille.length; lig++)
		{
			for (int col = 0; col < this.grille[lig].length; col++)
			{
				if(this.grille[lig][col] == '.')
				{
					matchContinue = true;
				}
			}
		}

		if (!matchContinue)
		{
			this.nbParties++;
		}

		return !matchContinue;
	}

	public boolean finDePartie ()
	{
		if (!this.partieFinie && this.matchNul() || this.victoire('X') || this.victoire('O')) 
		{		
			this.partieFinie = true;
			return true;
		}

		return false;
	}
	
	public char getCase(int lig, int col)
	{
		return this.grille[lig][col];
	}

	public void relancerPartie()
	{
		this.partieFinie = false;
		this.initGrille();
	}

	private void initGrille()
	{
		for (int lig = 0; lig < this.grille.length; lig++)
		{
			for (int col = 0; col < this.grille[lig].length; col++)
			{
				this.grille[lig][col] = '.';
			}
		}
	}

	public int getNbParties() 
	{
		return nbParties;
	}
	public int getPartiesO()
	{
		return partiesO;
	}
	public int getPartiesX()
	{
		return partiesX;
	}

	public String getPlateau()
	{
		String sRet = "";

		for(int lig = 0; lig < 3; lig ++)
		{
			sRet += "-------------\n";
			sRet += "| ";
			for(int col = 0; col < 3; col ++)
			{
				sRet += this.grille[lig][col] + " | ";
			}
			sRet += "\n";
		}
		sRet += "-------------";

		return sRet;
	}
}
