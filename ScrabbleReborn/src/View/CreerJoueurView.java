package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreerJoueurView  extends JFrame {
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
	private ImageIcon imgBack = new ImageIcon(this.getClass().getResource("/images/back.png"));
	private ImageIcon imgAide = new ImageIcon(this.getClass().getResource("/images/aide.png"));
	private ImageIcon imgBoutonCreerJoueurLock = new ImageIcon(this.getClass().getResource("/images/bouton_creer_joueur_lock.png"));
	private JLabel boutonQuit, back, boutonCreerJoueur, test, aide, explications;
	private JLabel boutonImg1, boutonImg2, boutonImg3, boutonImg4, boutonImg5, boutonImg6, boutonImg7, boutonImg8, boutonImg9, boutonImg10, boutonImg11, boutonImg12;
	private JTextField pseudo; 
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static int width = (int)screenSize.getWidth();
	static int height = (int)screenSize.getHeight();
	
	public CreerJoueurView(){
		this.setSize(1200, 800);
		this.setUndecorated(true);
		setLocation(width/2 - this.getSize().width/2, height/2 - this.getSize().height/2);
	
		getContentPane().setBackground(new Color(251, 211, 9));	
		
		getContentPane().setLayout(null);
		
		JLabel titre = new JLabel("Creer le joueur :");
		titre.setBounds(0, 75, 1200, 50);
		titre.setHorizontalAlignment(SwingConstants.CENTER); 
		titre.setFont(new Font("Helvetica", Font.BOLD, 34));
		getContentPane().add(titre);
		
		boutonQuit = new JLabel(imgQuit);
		boutonQuit.setBounds(1106, 24, imgQuit.getIconWidth(), imgQuit.getIconHeight());
		getContentPane().add(boutonQuit);
		
		JLabel pseudoTitre = new JLabel("Pseudo :");
		pseudoTitre.setBounds(417, 178, 107, 50);
		pseudoTitre.setFont(new Font("Helvetica", Font.BOLD, 24));
		getContentPane().add(pseudoTitre);
		
		pseudo = new JTextField();
		pseudo.setBounds(531, 190, 186, 28);
		getContentPane().add(pseudo);
		pseudo.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(195, 283, 791, 258);
		panel.setBackground(new Color (251, 211, 9));
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 0, 0, 0));
		
		boutonImg1 = new JLabel(img1);
		panel.add(boutonImg1);
		
		boutonImg2 = new JLabel(img2);
		panel.add(boutonImg2);
		
		boutonImg3 = new JLabel(img3);
		panel.add(boutonImg3);
		
		boutonImg4 = new JLabel(img4);
		panel.add(boutonImg4);
		
		boutonImg5 = new JLabel(img5);
		panel.add(boutonImg5);
		
		boutonImg6 = new JLabel(img6);
		panel.add(boutonImg6);
		
		boutonImg7 = new JLabel(img7);
		panel.add(boutonImg7);
		
		boutonImg8 = new JLabel(img8);
		panel.add(boutonImg8);
		
		boutonImg9 = new JLabel(img9);
		panel.add(boutonImg9);
		
		boutonImg10 = new JLabel(img10);
		panel.add(boutonImg10);
		
		boutonImg11 = new JLabel(img11);
		panel.add(boutonImg11);
		
		boutonImg12 = new JLabel(img12);
		panel.add(boutonImg12);
		
		aide = new JLabel(imgAide);
		aide.setBounds(417, 548, 52, 37);
		getContentPane().add(aide);
		
		explications = new JLabel("Cliquez sur une image pour la selectionner");
		explications.setFont(new Font("SansSerif", Font.BOLD, 14));
		explications.setBounds(479, 552, 400, 28);
		getContentPane().add(explications);
		
		boutonCreerJoueur = new JLabel(imgBoutonCreerJoueurLock);
		boutonCreerJoueur.setBounds(390, 611, 441, 61);
		getContentPane().add(boutonCreerJoueur);
		
		back = new JLabel();
		back.setIcon(imgBack);
		back.setBounds(20, 11, 70, 54);
		getContentPane().add(back);
		
		test = new JLabel();
		test.setBounds(0, 0, 1200, 800);
		getContentPane().add(test);
		
	}
	
	public JLabel getQuit() {
		return boutonQuit;
	}
	
	public JLabel getBoutonJoueur() {
		return boutonCreerJoueur;
	}
	
	public ImageIcon getImgJoueur() {
		return imgBoutonCreerJoueurLock;
	}
	
	public JLabel getTest() {
		return test;
	} 
	
	public JLabel getExplications() {
		return explications;
	}
	
	public JLabel getAide() {
		return aide;
	}
	
	public JLabel getBack() {
		return back;
	}
	
	public String getPseudo() {
		return pseudo.getText();
	}
	
	public JLabel getLabelImg(int i) {
		switch (i) {
			case 1:
				return boutonImg1;
			case 2:
				return boutonImg2;
			case 3:
				return boutonImg3;
			case 4:
				return boutonImg4;
			case 5:
				return boutonImg5;
			case 6:
				return boutonImg6;
			case 7:
				return boutonImg7;
			case 8:
				return boutonImg8;
			case 9:
				return boutonImg9;
			case 10:
				return boutonImg10;
			case 11:
				return boutonImg11;
			case 12:
				return boutonImg12;
		}
		return null;
	}
	
	public ImageIcon getImg(int i) {
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
