package Model;

import javax.swing.ImageIcon;

public class CreerJoueurModel {
	private ImageIcon imgBoutonCreerJoueurActive = new ImageIcon(this.getClass().getResource("/images/bouton_creer_joueur_active.png"));
	private ImageIcon img1Active = new ImageIcon(this.getClass().getResource("/images/1_active.png"));
	private ImageIcon img2Active = new ImageIcon(this.getClass().getResource("/images/2_active.png"));
	private ImageIcon img3Active = new ImageIcon(this.getClass().getResource("/images/3_active.png"));
	private ImageIcon img4Active = new ImageIcon(this.getClass().getResource("/images/4_active.png"));
	private ImageIcon img5Active = new ImageIcon(this.getClass().getResource("/images/5_active.png"));
	private ImageIcon img6Active = new ImageIcon(this.getClass().getResource("/images/6_active.png"));
	private ImageIcon img7Active = new ImageIcon(this.getClass().getResource("/images/7_active.png"));
	private ImageIcon img8Active = new ImageIcon(this.getClass().getResource("/images/8_active.png"));
	private ImageIcon img9Active = new ImageIcon(this.getClass().getResource("/images/9_active.png"));
	private ImageIcon img10Active = new ImageIcon(this.getClass().getResource("/images/10_active.png"));
	private ImageIcon img11Active = new ImageIcon(this.getClass().getResource("/images/11_active.png"));
	private ImageIcon img12Active = new ImageIcon(this.getClass().getResource("/images/12_active.png"));
	
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
	
	private ImageIcon boutonCreerJoueur = new ImageIcon(this.getClass().getResource("/images/bouton_creer_joueur.png"));
	
	public ImageIcon getBoutonActive() {
		return imgBoutonCreerJoueurActive;
	}
	
	
	public ImageIcon getImgActive(int i) {
		switch (i) {
		case 1:
			return img1Active;
		case 2:
			return img2Active;
		case 3:
			return img3Active;
		case 4:
			return img4Active;
		case 5:
			return img5Active;
		case 6:
			return img6Active;
		case 7:
			return img7Active;
		case 8:
			return img8Active;
		case 9:
			return img9Active;
		case 10:
			return img10Active;
		case 11:
			return img11Active;
		case 12:
			return img12Active;
	}
	return null;
	}
	
	public ImageIcon getImgClicked(int i) {
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
	
	public ImageIcon getImgJoueur() {
		return boutonCreerJoueur;
	}
}
