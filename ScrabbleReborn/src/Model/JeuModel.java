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
	
	
	/*private ImageIcon lettreA = new ImageIcon(this.getClass().getResource("/images/a.png"));
	private ImageIcon lettreB = new ImageIcon(this.getClass().getResource("/images/b.png"));
	private ImageIcon lettreC = new ImageIcon(this.getClass().getResource("/images/c.png"));
	private ImageIcon lettreD = new ImageIcon(this.getClass().getResource("/images/d.png"));
	private ImageIcon lettreE = new ImageIcon(this.getClass().getResource("/images/e.png"));
	private ImageIcon lettreF = new ImageIcon(this.getClass().getResource("/images/f.png"));
	private ImageIcon lettreG = new ImageIcon(this.getClass().getResource("/images/g.png"));
	private ImageIcon lettreH = new ImageIcon(this.getClass().getResource("/images/h.png"));
	private ImageIcon lettreI = new ImageIcon(this.getClass().getResource("/images/i.png"));
	private ImageIcon lettreJ = new ImageIcon(this.getClass().getResource("/images/j.png"));
	private ImageIcon lettreK = new ImageIcon(this.getClass().getResource("/images/k.png"));
	private ImageIcon lettreL = new ImageIcon(this.getClass().getResource("/images/l.png"));
	private ImageIcon lettreM = new ImageIcon(this.getClass().getResource("/images/m.png"));
	private ImageIcon lettreN = new ImageIcon(this.getClass().getResource("/images/n.png"));
	private ImageIcon lettreO = new ImageIcon(this.getClass().getResource("/images/o.png"));
	private ImageIcon lettreP = new ImageIcon(this.getClass().getResource("/images/p.png"));
	private ImageIcon lettreQ = new ImageIcon(this.getClass().getResource("/images/q.png"));
	private ImageIcon lettreR = new ImageIcon(this.getClass().getResource("/images/r.png"));
	private ImageIcon lettreS = new ImageIcon(this.getClass().getResource("/images/s.png"));
	private ImageIcon lettreT = new ImageIcon(this.getClass().getResource("/images/t.png"));
	private ImageIcon lettreU = new ImageIcon(this.getClass().getResource("/images/u.png"));
	private ImageIcon lettreV = new ImageIcon(this.getClass().getResource("/images/v.png"));
	private ImageIcon lettreW = new ImageIcon(this.getClass().getResource("/images/w.png"));
	private ImageIcon lettreX = new ImageIcon(this.getClass().getResource("/images/x.png"));
	private ImageIcon lettreY = new ImageIcon(this.getClass().getResource("/images/y.png"));
	private ImageIcon lettreZ = new ImageIcon(this.getClass().getResource("/images/z.png"));
	private ImageIcon blank = new ImageIcon(this.getClass().getResource("/images/blank.png"));
	
	public ImageIcon getImgLettre(char i) {
		switch(i) {
			case 'a':
				return lettreA;
			case 'b':
				return lettreB;
			case 'c':
				return lettreC;
			case 'd':
				return lettreD;
			case 'e':
				return lettreE;
			case 'f':
				return lettreF;
			case 'g':
				return lettreG;
			case 'h':
				return lettreH;
			case 'i':
				return lettreI;
			case 'j':
				return lettreJ;
			case 'k':
				return lettreK;
			case 'l':
				return lettreL;
			case 'm':
				return lettreM;
			case 'n':
				return lettreN;
			case 'o':
				return lettreO;
			case 'p':
				return lettreP;
			case 'q':
				return lettreQ;
			case 'r':
				return lettreR;
			case 's':
				return lettreS;
			case 't':
				return lettreT;
			case 'u':
				return lettreU;
			case 'v':
				return lettreV;
			case 'w':
				return lettreW;
			case 'x':
				return lettreX;
			case 'y':
				return lettreY;
			case 'z':
				return lettreZ;
			case ' ':
				return blank;
		}
		return null;
	}*/

	public static boolean caseDispo(int i, int j, Grille grille) {
		boolean dispo = true;
		if(grille.getListe().get(j+15*i).getVal()!=null) {
			dispo = false;
		}
		return dispo;
	}
	
	/* on place la lettre */
	public static void setLettre(int posX, int posY, LettreModel lettre, Grille grille, JPanel panel){
		boolean canSet = false;
		for (int i=0;i<15;i++) {
			/* on cherche la première case de la grille par rapport à l'axe x (donc la ligne où veut être placé le bateau) */
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
