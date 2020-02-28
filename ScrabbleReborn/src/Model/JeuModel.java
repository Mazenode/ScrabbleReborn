package Model;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class JeuModel {
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = (int)screenSize.getWidth();
	public static int height = (int)screenSize.getHeight();

	private static int NombreDeLettreRestante = 102;
	public char [] ListeLettreAlp;

	private ImageIcon imgSauvegarderActive = new ImageIcon(this.getClass().getResource("/images/sauvegarder_active.png"));
	private ImageIcon imgSoumettreActive = new ImageIcon(this.getClass().getResource("/images/soumettre_mot_active.png"));

	private ImageIcon img1Clicked = new ImageIcon(this.getClass().getResource("/images/1_clicked.png"));
	private ImageIcon img2Clicked = new ImageIcon(this.getClass().getResource("/images/2_clicked.png"));
	private ImageIcon img3Clicked = new ImageIcon(this.getClass().getResource("/images/3_clicked.png"));
	private ImageIcon img4Clicked = new ImageIcon(this.getClass().getResource("/images/4_clicked.png"));
	private ImageIcon img5Clicked = new ImageIcon(this.getClass().getResource("/images/5_clicked.png"));
	private ImageIcon img6Clicked = new ImageIcon(this.getClass().getResource("/images/6_clicked.png"));
	private ImageIcon img7Clicked = new ImageIcon(this.getClass().getResource("/images/7_clicked.png"));
	private ImageIcon img8Clicked = new ImageIcon(this.getClass().getResource("/images/8_clicked.png"));
	private ImageIcon img9Clicked = new ImageIcon(this.getClass().getResource("/images/9_clicked.png"));
	private ImageIcon img10Clicked = new ImageIcon(this.getClass().getResource("/images/10_clicked.png"));
	private ImageIcon img11Clicked = new ImageIcon(this.getClass().getResource("/images/11_clicked.png"));
	private ImageIcon img12Clicked = new ImageIcon(this.getClass().getResource("/images/12_clicked.png"));
	
	public ImageIcon getSauvegarderActive() {
		return imgSauvegarderActive;
	}
	
	public ImageIcon getSoumettreActive() {
		return imgSoumettreActive;
	}
	
	public JeuModel(){
		ListeLettreAlp = new char[]{'a','b','c','d','e','f','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','y','z'};
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
							grille.getListe().get(j+15*i).val = now.getVal();
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

	public char[] getListeLettreAlp() {
		return ListeLettreAlp;
	}



	public static void setNbrDeLettreRestante(int compteur){
		NombreDeLettreRestante -= compteur;
		if (NombreDeLettreRestante == 0){
			System.out.println("LA PARTIE EST FINIS");
		}
	}


	public static int getNbrDeLettreRestante(){
		return NombreDeLettreRestante;
	}

	public ImageIcon getImgJoueur(int i) {
		switch (i){
			case 1 : return img1Clicked;
			case 2 : return img2Clicked;
			case 3 : return img3Clicked;
			case 4 : return img4Clicked;
			case 5 : return img5Clicked;
			case 6 : return img6Clicked;
			case 7 : return img7Clicked;
			case 8 : return img8Clicked;
			case 9 : return img9Clicked;
			case 10 : return img10Clicked;
			case 11 : return img11Clicked;
			case 12 : return img12Clicked;

		}
		return null;
	}

	static public boolean lecture() throws IOException {
		String motRetourner = "";
		for (int i = 0; i < Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
			char e = Grille.getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).getVal();
			motRetourner +=  e;
		}
		motRetourner = motRetourner.toUpperCase();
		System.out.println(motRetourner);
		BufferedReader buffer = new BufferedReader(new InputStreamReader (new FileInputStream((new File("Dictionnaire/D.txt")))));
		String line = buffer.readLine();
		while (!(line == null)) {
			if (motRetourner.equals(line)) {
				return true;
			}
			line = buffer.readLine();
		}
		return false;
	}

}
