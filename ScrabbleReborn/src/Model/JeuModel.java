package Model;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Model.Grille;

public class JeuModel {
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = (int)screenSize.getWidth();
	public static int height = (int)screenSize.getHeight();
    
	private ImageIcon imgSauvegarderActive = new ImageIcon(this.getClass().getResource("/images/sauvegarder_active.png"));
	private ImageIcon imgSoumettreActive = new ImageIcon(this.getClass().getResource("/images/soumettre_mot_active.png"));
	
	public ImageIcon getSauvegarderActive() {
		return imgSauvegarderActive;
	}
	
	public ImageIcon getSoumettreActive() {
		return imgSoumettreActive;
	}
	
	/* on verifie que la case est vide (pas d'autre lettre deja pose dedans) */
	public static boolean caseDispo(int i, int j, Grille grille) {
		boolean dispo = true;
		if(grille.getListe().get(j+15*i).getVal()!='#') {
			dispo = false;
		}
		return dispo;
	}
	
	/* on verifie que les cases sont sur la meme ligne/colonne */
	public static boolean canSet(int i, int j, Grille grille, Joueur joueur) {
		boolean surBonneLigneCol = false;
		/* si on a deja pose 2 lettres (ou plus), on verifie que la lettre qu on veut placer est sur la meme ligne/colonne */
		if(joueur.getListeLettrePos().size()>=2) {
			if((joueur.isOnCol == true && joueur.firstPos % 15 == j)||(joueur.isOnLine && ((int) (joueur.firstPos/15)) == i)) {
				surBonneLigneCol = true;
				System.out.println("ok l/c");
			}
		}
		/* si on a deja pose 1 lettres, on verifie que la lettre qu on veut placer est sur la meme ligne ou la meme colonne */
		if(joueur.getListeLettrePos().size() == 1) {
			if(joueur.firstPos % 15 == j) {
				joueur.isOnCol = true;
				surBonneLigneCol = true;
				System.out.println("ok c");
			}else if(((int) (joueur.firstPos/15)) == i) {
				joueur.isOnLine = true;
				surBonneLigneCol = true;
				System.out.println("ok l");
			}
		}
		/* si on a pose 0 lettres, on garde en memoire la pos de la lettre pour pouvoir verifier la pos des futures lettres */
		if(joueur.getListeLettrePos().size()==0) {
			joueur.firstPos = i*15+j;
			surBonneLigneCol = true;
			System.out.println("ok 1");
		}
		return surBonneLigneCol;
	}
	
	/* on place la lettre */
	public static void setLettre(int posX, int posY, LettreModel lettre, Grille grille, JPanel panel, Joueur joueur){
		boolean canSet = false;
		for (int i=0;i<15;i++) {
			/* on cherche la premiere case de la grille par rapport a  l'axe x */
			if(posY>i*47-22+11 && posY<(i+1)*47-22+11) {
				for(int j=0;j<15;j++) {
					/* on cherche la premiere case de la grille par rapport a  l'axe y */
					if (posX>j*47-22+278 && posX<(j+1)*47-22+278) {
						/* si la lettre peut etre place */
						if(caseDispo(i, j, grille) && canSet(i, j, grille, joueur)) {
							grille.getListe().get(j+15*i).add(lettre);
							grille.getListe().get(j+15*i).val = lettre.getVal();
							lettre.isSet=true;
							grille.revalidate();
							Joueur.getListeJoueur().get(0).getListeLettrePos().add(j+15*i);
							canSet=true;
						}
					}
				}
			}
		}
		if(canSet==false) {
			lettre.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(lettre);
			panel.revalidate();
		}

	}

	static public void lecture(){
		String motRetourner = "";

	}

}
