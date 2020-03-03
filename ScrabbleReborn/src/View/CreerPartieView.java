package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CreerPartieView extends JFrame{
	
	private JLabel boutonQuit, titre, sousTitre, back, boutonCreerJoueur, boutonLancerLaPartie,collisonDetecter;
	private JLabel imgJoueur1, imgJoueur2, imgJoueur3, imgJoueur4, imgJoueur5, imgJoueur6;
	private JLabel pseudo1, pseudo2, pseudo3, pseudo4, pseudo5, pseudo6;
	private JLabel emplacement1, emplacement2, emplacement3, emplacement4, emplacement5, emplacement6;
	private ImageIcon imgLancerPartie = new ImageIcon(this.getClass().getResource("/images/bouton_lancer_partie_lock.png"));
	private ImageIcon imgBoutonBack = new ImageIcon(this.getClass().getResource("/images/back.png"));
	private ImageIcon imgQuit = new ImageIcon(this.getClass().getResource("/images/quit.png"));
	private ImageIcon imgBoutonCreerJoueur = new ImageIcon(this.getClass().getResource("/images/bouton_creer_un_joueur.png"));
	private ImageIcon imgBack = new ImageIcon(this.getClass().getResource("/images/back.png"));
	private ImageIcon imgNonJoueur = new ImageIcon(this.getClass().getResource("/images/non_joueur.png"));
	
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static int width = (int)screenSize.getWidth();
	static int height = (int)screenSize.getHeight();
	private Font font = new Font("Lato", Font.BOLD, 16);
	
	public CreerPartieView() {
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(251, 211, 9));	
		this.setSize(1200, 800);
		this.setLocation(width /2 - this.getSize().width/2, height /2 - this.getSize().height/2);
		
		afficherTitres();
		afficherBoutons();
		afficherNumJoueur();
		afficherImages();
		afficherPseudo();

	}
	
	public void afficherBoutons() {

		boutonQuit = new JLabel(imgQuit);
		boutonQuit.setBounds(1140, 10, imgQuit.getIconWidth(), imgQuit.getIconHeight());
		getContentPane().add(boutonQuit);
		
		back = new JLabel();
		back.setIcon(imgBack);
		back.setBounds(20, 11, 70, 54);
		getContentPane().add(back);
		
		boutonCreerJoueur = new JLabel();
		boutonCreerJoueur.setIcon(imgBoutonCreerJoueur);
		boutonCreerJoueur.setBounds(413, 423, 382, 87);
		getContentPane().add(boutonCreerJoueur);

		boutonLancerLaPartie = new JLabel();
		boutonLancerLaPartie.setIcon(imgLancerPartie);
		boutonLancerLaPartie.setBounds(413, 586, 382, 87);
		getContentPane().add(boutonLancerLaPartie);
		
		collisonDetecter = new JLabel();
		collisonDetecter.setBounds(220, 416, 717, 323);
		getContentPane().add(collisonDetecter);
	}
	
	public void afficherTitres() {
		titre = new JLabel("Selectionnez les joueurs participants a la partie : ");
		titre.setBounds(0, 75, 1200, 50);
		titre.setHorizontalAlignment(SwingConstants.CENTER); 
		titre.setFont(new Font("Helvetica", Font.BOLD, 28));
		getContentPane().add(titre);
		
		sousTitre = new JLabel("(2 minimum, 4 maximum)");
		sousTitre.setBounds(0, 110, 1200, 50);
		sousTitre.setHorizontalAlignment(SwingConstants.CENTER); 
		sousTitre.setFont(new Font("Helvetica", Font.BOLD, 18));
		getContentPane().add(sousTitre);
	}
	
	public void afficherNumJoueur() {
		JPanel gridJoueur = new JPanel();
		gridJoueur.setBackground(new Color(251, 211, 9));
		gridJoueur.setBounds(196, 192, 813, 25);
		getContentPane().add(gridJoueur);
		gridJoueur.setLayout(new GridLayout(1, 0, 0, 0));
		
		emplacement1 = new JLabel();
		emplacement1.setFont(new Font("Lato", Font.BOLD, 17));
		emplacement1.setForeground(new Color(229, 26, 106));
		emplacement1.setHorizontalAlignment(SwingConstants.CENTER);
		gridJoueur.add(emplacement1);
		
		emplacement2 = new JLabel();
		emplacement2.setFont(new Font("Lato", Font.BOLD, 17));
		emplacement2.setForeground(new Color(229, 26, 106));
		emplacement2.setHorizontalAlignment(SwingConstants.CENTER);
		gridJoueur.add(emplacement2);
		
		emplacement3 = new JLabel();
		emplacement3.setFont(new Font("Lato", Font.BOLD, 17));
		emplacement3.setForeground(new Color(229, 26, 106));
		emplacement3.setHorizontalAlignment(SwingConstants.CENTER);
		gridJoueur.add(emplacement3);
		
		emplacement4 = new JLabel();
		emplacement4.setFont(new Font("Lato", Font.BOLD, 17));
		emplacement4.setForeground(new Color(229, 26, 106));
		emplacement4.setHorizontalAlignment(SwingConstants.CENTER);
		gridJoueur.add(emplacement4);
		
		emplacement5 = new JLabel();
		emplacement5.setFont(new Font("Lato", Font.BOLD, 17));
		emplacement5.setForeground(new Color(229, 26, 106));
		emplacement5.setHorizontalAlignment(SwingConstants.CENTER);
		gridJoueur.add(emplacement5);
		
		emplacement6 = new JLabel();
		emplacement6.setFont(new Font("Lato", Font.BOLD, 17));
		emplacement6.setForeground(new Color(229, 26, 106));
		emplacement6.setHorizontalAlignment(SwingConstants.CENTER);
		gridJoueur.add(emplacement6);
	}
	
	public void afficherImages() {
		JPanel gridImages = new JPanel();
		gridImages.setBounds(196, 217, 813, 136);
		gridImages.setBackground(new Color(251, 211, 9));
		getContentPane().add(gridImages);
		gridImages.setLayout(new GridLayout(1, 0, 0, 0));
		
		imgJoueur1 = new JLabel();
		imgJoueur1.setHorizontalAlignment(SwingConstants.CENTER);
		imgJoueur1.setIcon(imgNonJoueur);
		gridImages.add(imgJoueur1);
		
		imgJoueur2 = new JLabel();
		imgJoueur2.setHorizontalAlignment(SwingConstants.CENTER);
		imgJoueur2.setIcon(imgNonJoueur);
		gridImages.add(imgJoueur2);
		
		imgJoueur3 = new JLabel();
		imgJoueur3.setHorizontalAlignment(SwingConstants.CENTER);
		imgJoueur3.setIcon(imgNonJoueur);
		gridImages.add(imgJoueur3);
		
		imgJoueur4 = new JLabel();
		imgJoueur4.setHorizontalAlignment(SwingConstants.CENTER);
		imgJoueur4.setIcon(imgNonJoueur);
		gridImages.add(imgJoueur4);
		
		imgJoueur5 = new JLabel();
		imgJoueur5.setHorizontalAlignment(SwingConstants.CENTER);
		imgJoueur5.setIcon(imgNonJoueur);
		gridImages.add(imgJoueur5);
		
		imgJoueur6 = new JLabel();
		imgJoueur6.setHorizontalAlignment(SwingConstants.CENTER);
		imgJoueur6.setIcon(imgNonJoueur);
		gridImages.add(imgJoueur6);
	}
	
	
	
	public void afficherPseudo() {
		
		JPanel gridPseudo = new JPanel();
		gridPseudo.setBackground(new Color(251, 211, 9));
		gridPseudo.setBounds(196, 354, 813, 25);
		getContentPane().add(gridPseudo);
		gridPseudo.setLayout(new GridLayout(1, 0, 0, 0));
		
		pseudo1 = new JLabel("");
		pseudo1.setFont(font);
		pseudo1.setHorizontalAlignment(SwingConstants.CENTER);
		gridPseudo.add(pseudo1);
		
		pseudo2 = new JLabel("");
		pseudo2.setFont(font);
		pseudo2.setHorizontalAlignment(SwingConstants.CENTER);
		gridPseudo.add(pseudo2);
		
		pseudo3 = new JLabel("");
		pseudo3.setFont(font);
		pseudo3.setHorizontalAlignment(SwingConstants.CENTER);
		gridPseudo.add(pseudo3);
		
		pseudo4 = new JLabel("");
		pseudo4.setFont(font);
		pseudo4.setHorizontalAlignment(SwingConstants.CENTER);
		gridPseudo.add(pseudo4);
		
		pseudo5 = new JLabel("");
		pseudo5.setFont(font);
		pseudo5.setHorizontalAlignment(SwingConstants.CENTER);
		gridPseudo.add(pseudo5);
		
		pseudo6 = new JLabel("");
		pseudo6.setFont(font);
		pseudo6.setHorizontalAlignment(SwingConstants.CENTER);
		gridPseudo.add(pseudo6);
	}
	
	public JLabel getBack() {
		return back;
	}
	
	public JLabel getQuit() {
		return boutonQuit;
	}
	
	public JLabel getCreerJoueur() {
		return boutonCreerJoueur;
	}
	
	public JLabel getLancerPartie() {
		return boutonLancerLaPartie;
	}
	
	public JLabel getCollisionDetecter() {
		return collisonDetecter;
	}
	
	public JLabel getNumJoueur(int i) {
		switch (i) {
		case 1:
			return emplacement1;
		case 2:
			return emplacement2;
		case 3:
			return emplacement3;
		case 4:
			return emplacement4;
		case 5:
			return emplacement5;
		case 6:
			return emplacement6;
		}
	return null;
	}
	
	public JLabel getImg(int i) {
		switch (i) {
		case 1:
			return imgJoueur1;
		case 2:
			return imgJoueur2;
		case 3:
			return imgJoueur3;
		case 4:
			return imgJoueur4;
		case 5:
			return imgJoueur5;
		case 6:
			return imgJoueur6;
		}
	return null;
	}
	
	public JLabel getPseudo(int i) {
		switch (i) {
		case 1:
			return pseudo1;
		case 2:
			return pseudo2;
		case 3:
			return pseudo3;
		case 4:
			return pseudo4;
		case 5:
			return pseudo5;
		case 6:
			return pseudo6;
		}
	return null;
	}
}
