package Model;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import Model.Grille;

public class JeuModel {
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = (int)screenSize.getWidth();
	public static int height = (int)screenSize.getHeight();

	private static int NombreDeLettreRestante = 102;
	public char [] ListeLettreAlp;
	public String [] ListeMotAverif;

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
							lettre.posLettre=j+15*i;
							grille.getListe().get(j+15*i).add(lettre);
							grille.getListe().get(j+15*i).val = lettre.getVal();
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
		//getMotHorizontal(169);
		System.out.println(getMotHorizontal(5));
		//getToutLesMots();
		String lettrePose = "";
		for (int i = 0; i < Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
			char e = Grille.getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).getVal();
			lettrePose +=  e;
		}
		lettrePose = lettrePose.toUpperCase();
		System.out.println(lettrePose);
		BufferedReader buffer = new BufferedReader(new InputStreamReader (new FileInputStream((new File("Dictionnaire/D.txt")))));
		String line = buffer.readLine();
		while (!(line == null)) {
			if (lettrePose.equals(line)) {
				return true;
			}
			line = buffer.readLine();
		}
		return false;
	}

	 static public String getMotHorizontal(int posLettre){
		String motAretourne = "";

		int posOri =  posLettre;

		int cordDebut = posOri;
		int cordFin = posOri;
		int debutDeLigne = ((posOri / 15) * 15);

		for (int i = posOri; i <= debutDeLigne + 14; i++) {
			if (Grille.getListe().get(i).getVal() != '#') cordFin = i;
				else break;

		}
		 for (int i = posOri; i >= debutDeLigne; i--) {
		 	if (Grille.getListe().get(i).getVal() != '#') cordDebut = i;
		 	else break;
		 }
		for (int i = cordDebut; i <= cordFin; i++){
			motAretourne += Grille.getListe().get(i).getVal();
		}
		return motAretourne;
	 }


	static public String getMotVertical(int posLettre){
		String motAretourne = "";

		int posOri =  posLettre;

		int cordDebut = posOri;
		int cordFin = posOri;
		int debutDeColonne = (posOri - ((posOri / 15) * 15));

		for (int i = posOri; i >= debutDeColonne + 14; i-=15) {
			if (Grille.getListe().get(i).getVal() != '#') cordDebut = i;
			else break;

		}
		for (int i = posOri; i <= 210 + debutDeColonne; i+=15) {
			if (Grille.getListe().get(i).getVal() != '#') cordFin = i;
			else break;
		}
		for (int i = cordDebut; i <= cordFin; i+=15){
			motAretourne += Grille.getListe().get(i).getVal();
		}
		return motAretourne;
	}

	static public ArrayList<String> getToutLesMots(){
		ArrayList<String> aRetourner = new ArrayList<String>();
		Joueur.getListeJoueur().get(0).getListeLettrePos().get(0);

		if (Joueur.getListeJoueur().get(0).getIsOnLine()){
			aRetourner.add(getMotHorizontal(Joueur.getListeJoueur().get(0).getListeLettrePos().get(0)));
		}
		if (Joueur.getListeJoueur().get(0).getIsOnCol()){
			aRetourner.add(getMotVertical(Joueur.getListeJoueur().get(0).getListeLettrePos().get(0)));

		}
		for (String s : aRetourner){
			System.out.println("mot lu : "+s);
		}
		return aRetourner;
	}


}
