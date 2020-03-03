package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Joueur {
	private String name;
	private int numPhoto,score, Multi;
	private ArrayList<Integer> listeLettrePos = new ArrayList<Integer>();
	private static ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
	private ArrayList<Character> listeLettreChevalet = new ArrayList<Character>();
	public boolean isOnLine = false, isOnCol = false;
	public int firstPos;



	public Joueur(String name, int numPhoto) {
		this.name = name;
		this.numPhoto = numPhoto;
		this.listeLettreChevalet.clear();
		for(int i=0;i<7;i++) {
			Random rand = new Random();
			int element = rand.nextInt(JeuModel.getListeLettreAlp().length);
			this.listeLettreChevalet.add(JeuModel.getListeLettreAlp()[element]);
		}
		listeJoueur.add(this);
	}


	
	public String getPseudo() {
		return name;
	}
	
	public int getNumImage() {
		return numPhoto;
	}
	
	public ArrayList<Character> getListeLettreChevalet(){
		return listeLettreChevalet;
	}

	public ArrayList<Integer> getListeLettrePos(){
		return listeLettrePos;
	}

	public static ArrayList<Joueur> getListeJoueur(){
		return listeJoueur;
	}

	public void setScore(int i){
		this.score = i;
	}

	public boolean getIsOnLine(){
		return isOnLine;
	}
	public boolean getIsOnCol(){
		return isOnCol;
	}


	private int getMotMultiBonus(String s) {
		int bonusMul = 1;
		for(int l : listeLettrePos) {
			bonusMul *= Grille.getMultiMot(l);
		}

		return bonusMul;
	}

	public void retrieveScoreActivePlayer(ArrayList<String> s) {
		int totalScore = 0;
		totalScore += getScoreMotAvecLettre(s.get(0));
		totalScore *= getMotMultiBonus(s.get(0));



		s.remove(s.get(0));

		for(String st : s) {
			for(int i = 0; i < st.length(); i++) totalScore += LettreModel.getScoreLettre(st.charAt(i));
		}

		score += totalScore;

	}


	private int getScoreMotAvecLettre(String st) {
		String s = st;

		int LetterScore = 0;

		for(int l : listeLettrePos) {
			LetterScore += LettreModel.getScoreLettre(Grille.getListe().get(l).getVal()) * Grille.getMultiLettre(l);
		}

		return  LetterScore;
	}

	public int getScore(){
		return score;
	}

}
