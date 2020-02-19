package Model;

import javax.swing.ImageIcon;

public class ChargerPartieModel {
	private ImageIcon imgFondActive = new ImageIcon(this.getClass().getResource("/images/fond_charger_partie_active.png"));
	private ImageIcon imgFondClicked = new ImageIcon(this.getClass().getResource("/images/fond_charger_partie_clicked.png"));
	private ImageIcon imgLancerPartie = new ImageIcon(this.getClass().getResource("/images/bouton_lancer_partie.png"));
	private ImageIcon imgLancerPartieActive = new ImageIcon(this.getClass().getResource("/images/bouton_lancer_partie_active.png"));
	
	public ImageIcon getImgFondActive() {
		return imgFondActive;
	}
	
	public ImageIcon getImgFondClicked() {
		return imgFondClicked;
	}
	
	public ImageIcon getLancerPartie() {
		return imgLancerPartie;
	}
	
	public ImageIcon getLancerPartieActive() {
		return imgLancerPartieActive;
	}
}
