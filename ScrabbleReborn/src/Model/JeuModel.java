package Model;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class JeuModel {
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = (int)screenSize.getWidth();
	public static int height = (int)screenSize.getHeight();

	private static int NombreDeLettreRestante = 120;
	public char [] ListeLettreAlp;

	private ImageIcon imgSauvegarderActive = new ImageIcon(this.getClass().getResource("/images/sauvegarder_active.png"));
	private ImageIcon imgSoumettreActive = new ImageIcon(this.getClass().getResource("/images/soumettre_mot_active.png"));
	
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
		System.out.println(NombreDeLettreRestante);
	}
	public static int getNbrDeLettreRestante(){
		return NombreDeLettreRestante;
	}

	static public boolean lecture() throws IOException {
		System.out.println("LECTURE\n\n");
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
				System.out.print("TRUE");
				return true;
			}
			line = buffer.readLine();
		}
		return false;
	}

}
