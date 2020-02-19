package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;

public class CreerPartieModel {
	private ImageIcon creerJoueur = new ImageIcon(this.getClass().getResource("/images/bouton_creer_un_joueur.png"));
	private ImageIcon creerJoueurActive = new ImageIcon(this.getClass().getResource("/images/bouton_creer_un_joueur_active.png"));
	private ImageIcon lancerPartieActive = new ImageIcon(this.getClass().getResource("/images/bouton_lancer_partie_active.png"));
	private ImageIcon lancerPartie = new ImageIcon(this.getClass().getResource("/images/bouton_lancer_partie.png"));
	private String[] listeResultats;
	private int[] listeImg;
	private String[] listePseudo;
	public static int length;
	private ImageIcon imgQuit = new ImageIcon(this.getClass().getResource("/images/quit.png"));
	private ImageIcon img1 = new ImageIcon(this.getClass().getResource("/images/1.png"));
	private ImageIcon img2 = new ImageIcon(this.getClass().getResource("/images/2.png"));
	private ImageIcon img3 = new ImageIcon(this.getClass().getResource("/images/3.png"));
	private ImageIcon img4 = new ImageIcon(this.getClass().getResource("/images/4.png"));
	private ImageIcon img5 = new ImageIcon(this.getClass().getResource("/images/5.png"));
	private ImageIcon img6 = new ImageIcon(this.getClass().getResource("/images/6.png"));
	private ImageIcon img7 = new ImageIcon(this.getClass().getResource("/images/7.png"));
	private ImageIcon img8 = new ImageIcon(this.getClass().getResource("/images/8.png"));
	private ImageIcon img9 = new ImageIcon(this.getClass().getResource("/images/9.png"));
	private ImageIcon img10 = new ImageIcon(this.getClass().getResource("/images/10.png"));
	private ImageIcon img11 = new ImageIcon(this.getClass().getResource("/images/11.png"));
	private ImageIcon img12 = new ImageIcon(this.getClass().getResource("/images/12.png"));
	
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
	
	public CreerPartieModel() {
		/*Le fichier .txt est fait de cette maniere : 
		 * - pseudo
		 * - image
		 * - autre pseudo
		 * - autre image
		 * On autorise au maximum 6 joueurs*/
		
		//Le tableau de base contient donc 2 * 6 +1 = 13 cases, pour toutes les valeurs possibles + 1 ligne vide à la fin du fichier.
		listeResultats = new String[13];
		
		listePseudo = new String[6];
		listeImg = new int[6];
		
		try {
			readFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void readFile() throws IOException {
		//On ouvre le buffer...
		BufferedReader buffer = new BufferedReader(new FileReader("profils.txt"));
		
		//...et on initialise le nombre de lignes a 0.
		length = 0;
		
		//Chaque ligne sera stockee dans cette variable, a tour de role.
	    String line;
	    
	    //Tant que la ligne n'est pas vide, on la met dans line et on incremente la taille.
	    while ((line = buffer.readLine()) != null) {
	        length += 1;
	        listeResultats[length] = line;
	        
	    }
	    
	    //Premiere boucle for qui nous permet de recuperer les pseudos que l'on stockera dans listePseudo[].
	    int j = 1;
		for(int i = 0; i < length /2; i ++) {
			listePseudo[i] = listeResultats[j];
			j+=2;
			
		}
		
		//Idem avec les images.
		j = 2;
		for(int i = 0; i < length /2; i ++) {
			listeImg[i] = Integer.parseInt(listeResultats[j]);
			j+=2;
		}
	}
	
	public ImageIcon getCreerJoueur() {
		return creerJoueur;
	}
	
	public ImageIcon getCreerJoueurActive() {
		return creerJoueurActive;
	}
	
	public String[] getPseudos() {
		return listePseudo;
	}
	
	public int[] getImg() {
		return listeImg;
	}
	
	public int getLength() {
		return (length / 2) + 1;
	}
	
	public ImageIcon getImg(int i, boolean active) {
		
		if(active) {
			switch (i) {
			case 1:
				return img1Clicked;
			case 2:
				return img2Clicked;
			case 3:
				return img3Clicked;
			case 4:
				return img4Clicked;
			case 5:
				return img5Clicked;
			case 6:
				return img6Clicked;
			case 7:
				return img7Clicked;
			case 8:
				return img8Clicked;
			case 9:
				return img9Clicked;
			case 10:
				return img10Clicked;
			case 11:
				return img11Clicked;
			case 12:
				return img12Clicked;
		}
		return null;
		}
		else {
			switch (i) {
			case 1:
				return img1;
			case 2:
				return img2;
			case 3:
				return img3;
			case 4:
				return img4;
			case 5:
				return img5;
			case 6:
				return img6;
			case 7:
				return img7;
			case 8:
				return img8;
			case 9:
				return img9;
			case 10:
				return img10;
			case 11:
				return img11;
			case 12:
				return img12;
		}
		return null;
		}
	}
	
	public ImageIcon getLancerPartie(boolean active) {
		if(active) {
			return lancerPartieActive;
		}
		else {
			return lancerPartie;
		}
	}
}

