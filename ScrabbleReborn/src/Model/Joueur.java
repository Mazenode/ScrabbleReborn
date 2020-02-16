package Model;

public class Joueur {
	private String name;
	private int numPhoto;
	public Joueur(String name, int numPhoto) {
		this.name = name;
		this.numPhoto = numPhoto;
	}
	
	public String getPseudo() {
		return name;
	}
	
	public int getNumImage() {
		return numPhoto;
	}
}
