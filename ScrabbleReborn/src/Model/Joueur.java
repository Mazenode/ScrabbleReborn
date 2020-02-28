package Model;

import java.util.ArrayList;

public class Joueur {
	private String name;
	private int numPhoto,score;
	private ArrayList<Integer> listeLettrePos = new ArrayList<Integer>();
	private static ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();


	public Joueur(String name, int numPhoto) {
		this.name = name;
		this.numPhoto = numPhoto;
		listeJoueur.add(this);
	}
	
	public String getPseudo() {
		return name;
	}
	
	public int getNumImage() {
		return numPhoto;
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


	public void print(){
		for (int i : listeLettrePos) {
			System.out.println(i);
		}
	}
}
