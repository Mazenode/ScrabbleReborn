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
	

	public static boolean caseDispo(int i, int j, Grille grille) {
		boolean dispo = true;
		if(grille.getListe().get(j+15*i).getVal()!='\u0000') {
			dispo = false;
		}
		return dispo;
	}
	
	/* on place la lettre */
	public static void setLettre(int posX, int posY, LettreModel lettre, Grille grille, JPanel panel){
		boolean canSet = false;
		for (int i=0;i<15;i++) {
			/* on cherche la premiere case de la grille par rapport à l'axe x (donc la ligne où veut être placé le bateau) */
			if(posY>i*47-22+11 && posY<(i+1)*47-22+11) {
				for(int j=0;j<15;j++) {
					/* on cherche la première case de la grille par rapport à l'axe y (donc la colonne où veut être placé le bateau) */
					if (posX>j*47-22+278 && posX<(j+1)*47-22+278) {
						/* si la lettre peut être placé */
						if(caseDispo(i, j, grille)) {
							LettreModel now = new LettreModel(lettre.getVal());
							grille.getListe().get(j+15*i).add(now);
							grille.getListe().get(j+15*i).val =now.getVal();
							grille.revalidate();
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
}
