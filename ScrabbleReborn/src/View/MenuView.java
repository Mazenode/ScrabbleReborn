package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuView extends JFrame{
	
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static int width = (int)screenSize.getWidth();
	static int height = (int)screenSize.getHeight();
	private ImageIcon imgTitre = new ImageIcon(this.getClass().getResource("/images/menu.png"));
	private ImageIcon imgBoutonCreer = new ImageIcon(this.getClass().getResource("/images/bouton_creer_partie.png"));
	private ImageIcon imgBoutonCharger = new ImageIcon(this.getClass().getResource("/images/bouton_charger_partie.png"));
	private ImageIcon imgQuit = new ImageIcon(this.getClass().getResource("/images/quit.png"));
	private JLabel background, boutonCreer, boutonCharger, boutonQuit;
	public static int widthFrame, heightFrame;
	
	public MenuView() {
		widthFrame = 1200;
		heightFrame = 800;
		int boutonSizeWidth = imgBoutonCreer.getIconWidth();
		int boutonSizeHeight = imgBoutonCreer.getIconHeight();
		this.setSize(widthFrame, heightFrame);
		this.setUndecorated(true);
		this.setLocation(width/2 - this.getSize().width/2, height/2 - this.getSize().height/2);
		
		boutonCreer = new JLabel(imgBoutonCreer);
		boutonCreer.setBounds(375, 400, boutonSizeWidth, boutonSizeHeight);
		add(boutonCreer);
		
		boutonCharger = new JLabel(imgBoutonCharger);
		boutonCharger.setBounds(375, 525, boutonSizeWidth, boutonSizeHeight);
		add(boutonCharger);
		
		boutonQuit = new JLabel(imgQuit);
		boutonQuit.setBounds(1140, 10, imgQuit.getIconWidth(), imgQuit.getIconHeight());
		add(boutonQuit);
		
		background = new JLabel(imgTitre);
		background.setBounds(0, 0, 1200, 800);
		add(background);
		
	}
	
	public ImageIcon imgBoutonCreer() {
		return imgBoutonCreer;
	}
	
	public ImageIcon imgBoutonCharger() {
		return imgBoutonCharger;
	}
	
	public JLabel getBoutonCreer() {
		return boutonCreer;
	}
	
	public JLabel getBoutonCharger() {
		return boutonCharger;
	}
	
	public JLabel getQuit() {
		return boutonQuit;
	}
	
	public JLabel getBg() {
		return background;
	}

}
             