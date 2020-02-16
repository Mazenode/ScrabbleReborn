package Model;

import javax.swing.ImageIcon;

public class MenuModel {
	
	private ImageIcon imgBoutonChargerActive = new ImageIcon(this.getClass().getResource("/images/bouton_charger_partie_active.png"));
	private ImageIcon imgBoutonCreerActive = new ImageIcon(this.getClass().getResource("/images/bouton_creer_partie_active.png"));
	
	public ImageIcon getBoutonChargerActive() {
		return imgBoutonChargerActive;
	}
	
	public ImageIcon getBoutonCreerActive() {
		return imgBoutonCreerActive;
	}
}
