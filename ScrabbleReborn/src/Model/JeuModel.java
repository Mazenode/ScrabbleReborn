package Model;

import javax.swing.*;

import Controller.JeuController;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.zip.ZipEntry;

import Model.Grille;
import View.JeuView;

public class JeuModel {
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = (int)screenSize.getWidth();
	public static int height = (int)screenSize.getHeight();

	public static int NombreDeLettreRestante;
	public static char [] ListeLettreAlp;
	public String [] ListeMotAverif;
	public static boolean victoire;

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
	
	private static Joueur joueurActuel;
	
	public ImageIcon getSauvegarderActive() {
		return imgSauvegarderActive;
	}
	
	public ImageIcon getSoumettreActive() {
		return imgSoumettreActive;
	}
	
	public JeuModel(){
		ListeLettreAlp = new char[]{'a','a','a','a','a','a','a','b','b','c','d','d','e','e','e','e','e','e','e','e','e','e','e','e','f','g','g','h','h','i','i','i','i','i','k','l','l','m','m','n','n','n','n','n','o','o','o','o','o','p','p','r','r','r','r','r','s','s','s','s','t','t','t','t','u','u','u','u','u','v','x','z','c','h','i','a','s','s','e'};
		victoire = false;
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
	public static boolean canSet(int i, int j, Joueur joueur) {
		boolean surBonneLigneCol = false;
		/* si on a deja pose 2 lettres (ou plus), on verifie que la lettre qu on veut placer est sur la meme ligne/colonne */
		if(joueur.getListeLettrePos().size()>=2) {
			if((joueur.isOnCol == true && joueur.firstPos % 15 == j)||(joueur.isOnLine && ((int) (joueur.firstPos/15)) == i)) {
				surBonneLigneCol = true;
			}
		}
		/* si on a deja pose 1 lettres, on verifie que la lettre qu on veut placer est sur la meme ligne ou la meme colonne */
		if(joueur.getListeLettrePos().size() == 1) {
			if(joueur.firstPos % 15 == j) {
				joueur.isOnCol = true;
				surBonneLigneCol = true;
			}else if(((int) (joueur.firstPos/15)) == i) {
				joueur.isOnLine = true;
				surBonneLigneCol = true;
			}
		}
		/* si on a pose 0 lettres, on garde en memoire la pos de la lettre pour pouvoir verifier la pos des futures lettres */
		if(joueur.getListeLettrePos().size()==0) {
			joueur.firstPos = i*15+j;
			surBonneLigneCol = true;
		}
		return surBonneLigneCol;
	}
	
	/* on place la lettre */
	public static void setLettre(int posX, int posY, LettreModel lettre, Grille grille, JPanel panel, Joueur joueur){
		joueurActuel = joueur;
		boolean canSet = false;
		for (int i=0;i<15;i++) {
			/* on cherche la premiere case de la grille par rapport a  l'axe x */
			if(posY>i*47-22+11 && posY<(i+1)*47-22+11) {
				for(int j=0;j<15;j++) {
					/* on cherche la premiere case de la grille par rapport a  l'axe y */
					if (posX>j*47-22+278 && posX<(j+1)*47-22+278) {
						/* si la lettre peut etre place */
						if(caseDispo(i, j, grille) && canSet(i, j, joueur)) {
							lettre.posLettre=j+15*i;
							grille.getListe().get(j+15*i).add(lettre);
							grille.getListe().get(j+15*i).val = lettre.getVal();
							grille.revalidate();
							joueurActuel.getListeLettrePos().add(j+15*i);
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

	public static char[] getListeLettreAlp() {
		return ListeLettreAlp;
	}



	public static void setNbrDeLettreRestante(int compteur){
		
		NombreDeLettreRestante -= compteur;
		if (NombreDeLettreRestante <= 0){
			victoire = true;
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

	public boolean lecture(JeuView view, Joueur joueur, ArrayList<Joueur> joueurs) throws IOException {
		joueurActuel = joueur;
		getToutLesMots(view);
		//int i = 0;
		if (joueurActuel.getListeLettrePos().size() == 0){
			return false;
		}
		for (int i  = 0; i < getToutLesMots(view).size();i++){
			BufferedReader buffer = new BufferedReader(new InputStreamReader (new FileInputStream((new File("Dictionnaire/"+ getToutLesMots(view).get(i).toUpperCase().charAt(0) +".txt")))));
			String line = buffer.readLine();
			while (!(line == null) ) {
				if (getToutLesMots(view).size() == 0){
					return false;
				}
				if (getToutLesMots(view).get(i).toUpperCase().equals(line)) {
					joueurs.get(i).retrieveScoreActivePlayer(getToutLesMots(view));
					break;
				}
				line = buffer.readLine();
			}
			if (line == null){
				return false;
			}
			if (i == getToutLesMots(view).size() - 1){

				return true;
			}
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

	public ArrayList<String> getToutLesMots(JeuView view){
		ArrayList<String> aRetourner = new ArrayList<String>();
		if (joueurActuel.getListeLettrePos().size() == 0){
			changerLettre(view.lettre1,view);
			changerLettre(view.lettre2,view);
			changerLettre(view.lettre3,view);
			changerLettre(view.lettre4,view);
			changerLettre(view.lettre5,view);
			changerLettre(view.lettre6,view);
			changerLettre(view.lettre7,view);
			return null;
		}

		joueurActuel.getListeLettrePos().get(0);

		int posOri = joueurActuel.getListeLettrePos().get(0);
		int debutDeLigne = (posOri / 15) * 15;
		int debutDeCol =  (posOri - ((posOri / 15) * 15));

		if (joueurActuel.getIsOnLine()){
			aRetourner.add(getMotHorizontal(joueurActuel.getListeLettrePos().get(0)));

			for(int i = posOri; i < debutDeLigne + 14; i++){
				if((i + 15 <= Grille.getListe().size() - 1 && Grille.getListe().get(i+15).getVal() != '#') || (i - 15 >= 0 && Grille.getListe().get(i-15).getVal() != '#')){
					aRetourner.add(getMotVertical(i));
				}
			}
		}
		else if (joueurActuel.getIsOnCol()){
			aRetourner.add(getMotVertical(joueurActuel.getListeLettrePos().get(0)));
			for(int i = posOri; i < 210 +  debutDeCol ; i+=15){
				if((i + 1 <= Grille.getListe().size() && Grille.getListe().get(i+1).getVal() != '#') || (i - 1 >= 0 && Grille.getListe().get(i-1).getVal() != '#')){
					aRetourner.add(getMotHorizontal(i));
				}
			}
		}
		else {
			aRetourner.add(getMotVertical(joueurActuel.getListeLettrePos().get(0)));
			aRetourner.add(getMotHorizontal(joueurActuel.getListeLettrePos().get(0)));
			if (aRetourner.get(1).length() == 1){
				aRetourner.remove(1);
			}
			if (aRetourner.get(0).length() == 1){
				aRetourner.remove(0);
			}

		}
		return aRetourner;
	}


	public void changerLettre(LettreModel Oldlettre, JeuView view){
		Random rand = new Random();
		int element = rand.nextInt(this.getListeLettreAlp().length);
		Oldlettre.val = this.getListeLettreAlp()[element];
		Oldlettre.image = new ImageIcon(this.getClass().getResource("/images/"+Oldlettre.val+".png"));
		Oldlettre.setIcon(Oldlettre.image);
		Oldlettre.posLettre=300;
		Oldlettre.setHorizontalAlignment(SwingConstants.CENTER);
		view.getLettres().add(Oldlettre);
		view.getLettres().revalidate();
	}





}
