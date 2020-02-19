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
import javax.swing.SwingConstants;
import java.awt.CardLayout;

public class ChargerPartieView extends JFrame{
	
	public static JLabel boutonQuit, titre, back, boutonLancerLaPartie,collisonDetecter;
	private ImageIcon imgLancerPartie = new ImageIcon(this.getClass().getResource("/images/bouton_lancer_partie_lock.png"));
	private ImageIcon imgQuit = new ImageIcon(this.getClass().getResource("/images/quit.png"));
	private ImageIcon imgBack = new ImageIcon(this.getClass().getResource("/images/back.png"));
	private ImageIcon imgFond = new ImageIcon(this.getClass().getResource("/images/fond_charger_partie.png"));
	
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static int width = (int)screenSize.getWidth();
	static int height = (int)screenSize.getHeight();
	public static JPanel panel_1, panel_2, panel_3, panel_4, panel_5, panel_6;
	public static JLabel fond1, fond2, fond3, fond4, fond5, fond6;
	private JPanel sous_panel_1, sous_panel_2, sous_panel_3, sous_panel_4, sous_panel_5, sous_panel_6;
	private JLabel partie1, partie2, partie3, partie4, partie5, partie6;
	private static JLabel tour, lblNewLabel;
	public static JLabel cache;
	private JLabel label, label_1, label_2, label_3, label_4, label_5, label_6, label_7, label_8, label_9;
	private JLabel tour1, tour2, tour3, tour4, tour5, tour6;
	private JLabel date1, date2, date3, date4, date5, date6;
	private JPanel panel1Rempli, panel2Rempli, panel3Rempli, panel4Rempli, panel5Rempli, panel6Rempli;
	private JPanel panel1Vide, panel2Vide, panel3Vide, panel4Vide, panel5Vide, panel6Vide;

	
	public ChargerPartieView() {
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(251, 211, 9));	
		this.setSize(1200, 800);
		this.setLocation(width /2 - this.getSize().width/2, height /2 - this.getSize().height/2);
		
		afficherTitres();
		afficherBoutons();

	}
	
	public void afficherBoutons() {
		

		boutonQuit = new JLabel(imgQuit);
		boutonQuit.setBounds(1140, 10, imgQuit.getIconWidth(), imgQuit.getIconHeight());
		getContentPane().add(boutonQuit);
		
		back = new JLabel();
		back.setIcon(imgBack);
		back.setBounds(20, 11, 70, 54);
		getContentPane().add(back);
		
		boutonLancerLaPartie = new JLabel();
		boutonLancerLaPartie.setIcon(imgLancerPartie);
		boutonLancerLaPartie.setBounds(415, 669, 382, 87);
		getContentPane().add(boutonLancerLaPartie);
		
		cache = new JLabel();
		cache.setBounds(371, 645, 470, 133);
		getContentPane().add(cache);
		
		collisonDetecter = new JLabel();
		collisonDetecter.setBounds(220, 668, 717, 88);
		getContentPane().add(collisonDetecter);
		
		JPanel listeParties = new JPanel();
		listeParties.setBounds(141, 153, 906, 481);
		listeParties.setBackground(new Color(251, 211, 9));
		getContentPane().add(listeParties);
		listeParties.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(251, 211, 9));	
		listeParties.add(panel_1);
		panel_1.setLayout(null);
		
		sous_panel_1 = new JPanel();
		sous_panel_1.setBounds(23, 14, 862, 54);
		sous_panel_1.setBackground(new Color(244, 214, 88));
		panel_1.add(sous_panel_1);
		sous_panel_1.setLayout(new CardLayout(0, 0));
		
		panel1Rempli = new JPanel();
		panel1Rempli.setBackground(new Color(244, 214, 88));
		sous_panel_1.add(panel1Rempli);
		panel1Rempli.setLayout(null);
		
		partie1 = new JLabel("Partie 1");
		partie1.setHorizontalAlignment(SwingConstants.RIGHT);
		partie1.setBounds(0, 0, 113, 58);
		partie1.setFont(new Font("Lato", Font.BOLD, 24));
		panel1Rempli.add(partie1);
		
		tour = new JLabel("Tour n\u00B0");
		tour.setHorizontalAlignment(SwingConstants.CENTER);
		tour.setFont(new Font("Lato", Font.BOLD, 24));
		tour.setBounds(410, 0, 101, 58);
		panel1Rempli.add(tour);
		
		tour1 = new JLabel("1");
		tour1.setHorizontalAlignment(SwingConstants.LEFT);
		tour1.setFont(new Font("Lato", Font.BOLD, 24));
		tour1.setBounds(503, 0, 44, 58);
		panel1Rempli.add(tour1);
		
		date1 = new JLabel("20/02/20");
		date1.setHorizontalAlignment(SwingConstants.RIGHT);
		date1.setFont(new Font("Lato", Font.BOLD, 24));
		date1.setBounds(740, 0, 122, 58);
		panel1Rempli.add(date1);
		
		panel1Vide = new JPanel();
		panel1Vide.setBounds(0, 0, 862, 58);
		panel1Vide.setBackground(new Color(244, 214, 88));
		sous_panel_1.add(panel1Vide);
		panel1Vide.setLayout(null);
		
		lblNewLabel = new JLabel("Emplacement Vide");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Lato", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 862, 58);
		panel1Vide.add(lblNewLabel);
		
		fond1 = new JLabel("");
		fond1.setHorizontalAlignment(SwingConstants.CENTER);
		fond1.setIcon(imgFond);
		fond1.setBounds(0, 0, 906, 80);
		panel_1.add(fond1);
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(251, 211, 9));	
		listeParties.add(panel_2);
		panel_2.setLayout(null);
		
		sous_panel_2 = new JPanel();
		sous_panel_2.setBounds(23, 14, 862, 52);
		sous_panel_2.setBackground(new Color(244, 214, 88));
		panel_2.add(sous_panel_2);
		sous_panel_2.setLayout(new CardLayout(0, 0));
		
		panel2Rempli = new JPanel();
		panel2Rempli.setBackground(new Color(244, 214, 88));
		sous_panel_2.add(panel2Rempli);
		panel2Rempli.setLayout(null);
		
		panel2Vide = new JPanel();
		panel2Vide.setBackground(new Color(244, 214, 88));
		sous_panel_2.add(panel2Vide);
		panel2Vide.setLayout(null);
		
		label_5 = new JLabel("Emplacement Vide");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.DARK_GRAY);
		label_5.setFont(new Font("Lato", Font.BOLD, 20));
		label_5.setBounds(0, 0, 862, 58);
		panel2Vide.add(label_5);
		
		partie2 = new JLabel("Partie 2");
		partie2.setBounds(0, 0, 113, 58);
		partie2.setHorizontalAlignment(SwingConstants.RIGHT);
		partie2.setFont(new Font("Lato", Font.BOLD, 24));
		panel2Rempli.add(partie2, "name_535786527582800");
		
		label = new JLabel("Tour n\u00B0");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lato", Font.BOLD, 24));
		label.setBounds(410, 0, 101, 58);
		panel2Rempli.add(label);
		
		tour2 = new JLabel("1");
		tour2.setHorizontalAlignment(SwingConstants.LEFT);
		tour2.setFont(new Font("Lato", Font.BOLD, 24));
		tour2.setBounds(503, 0, 44, 58);
		panel2Rempli.add(tour2);
		
		date2 = new JLabel("20/02/20");
		date2.setHorizontalAlignment(SwingConstants.RIGHT);
		date2.setFont(new Font("Lato", Font.BOLD, 24));
		date2.setBounds(740, 0, 122, 58);
		panel2Rempli.add(date2);
		
		fond2 = new JLabel("");
		fond2.setHorizontalAlignment(SwingConstants.CENTER);
		fond2.setIcon(imgFond);
		fond2.setBounds(13, 5, 886, 67);
		panel_2.add(fond2);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(251, 211, 9));	
		listeParties.add(panel_3);
		panel_3.setLayout(null);
		
		sous_panel_3 = new JPanel();
		sous_panel_3.setBounds(23, 14, 862, 52);
		sous_panel_3.setBackground(new Color(244, 214, 88));
		panel_3.add(sous_panel_3);
		sous_panel_3.setLayout(new CardLayout(0, 0));
		
		panel3Rempli = new JPanel();
		panel3Rempli.setBackground(new Color(244, 214, 88));
		sous_panel_3.add(panel3Rempli);
		panel3Rempli.setLayout(null);
		
		panel3Vide = new JPanel();
		panel3Vide.setBackground(new Color(244, 214, 88));
		sous_panel_3.add(panel3Vide);
		panel3Vide.setLayout(null);
		
		label_6 = new JLabel("Emplacement Vide");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.DARK_GRAY);
		label_6.setFont(new Font("Lato", Font.BOLD, 20));
		label_6.setBounds(0, 0, 862, 58);
		panel3Vide.add(label_6);
		
		partie3 = new JLabel("Partie 3");
		partie3.setBounds(0, 0, 113, 58);
		partie3.setHorizontalAlignment(SwingConstants.RIGHT);
		partie3.setFont(new Font("Lato", Font.BOLD, 24));
		panel3Rempli.add(partie3, "name_535794618673700");
		
		label_1 = new JLabel("Tour n\u00B0");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(410, 0, 101, 58);
		label_1.setFont(new Font("Lato", Font.BOLD, 24));
		panel3Rempli.add(label_1, "name_535794633032800");
		
		tour3 = new JLabel("1");
		tour3.setBounds(503, 0, 44, 58);
		tour3.setHorizontalAlignment(SwingConstants.LEFT);
		tour3.setFont(new Font("Lato", Font.BOLD, 24));
		panel3Rempli.add(tour3, "name_535794647179699");
		
		date3 = new JLabel("20/02/20");
		date3.setBounds(740, 0, 122, 58);
		date3.setHorizontalAlignment(SwingConstants.RIGHT);
		date3.setFont(new Font("Lato", Font.BOLD, 24));
		panel3Rempli.add(date3, "name_535794660783099");
		
		fond3 = new JLabel("");
		fond3.setHorizontalAlignment(SwingConstants.CENTER);
		fond3.setIcon(imgFond);
		fond3.setBounds(13, 5, 886, 67);
		panel_3.add(fond3);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(251, 211, 9));	
		listeParties.add(panel_4);
		panel_4.setLayout(null);

		sous_panel_4 = new JPanel();
		sous_panel_4.setBounds(23, 14, 862, 52);
		sous_panel_4.setBackground(new Color(244, 214, 88));
		panel_4.add(sous_panel_4);
		sous_panel_4.setLayout(new CardLayout(0, 0));
		
		panel4Rempli = new JPanel();
		panel4Rempli.setBackground(new Color(244, 214, 88));
		sous_panel_4.add(panel4Rempli);
		panel4Rempli.setLayout(null);
		
		panel4Vide = new JPanel();
		panel4Vide.setBackground(new Color(244, 214, 88));
		sous_panel_4.add(panel4Vide);
		panel4Vide.setLayout(null);
		
		partie4 = new JLabel("Partie 4");
		partie4.setBounds(0, 0, 113, 58);
		partie4.setHorizontalAlignment(SwingConstants.RIGHT);
		partie4.setFont(new Font("Lato", Font.BOLD, 24));
		panel4Rempli.add(partie4, "name_535819019416100");
		
		label_2 = new JLabel("Tour n\u00B0");
		label_2.setBounds(410, 0, 101, 58);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Lato", Font.BOLD, 24));
		panel4Rempli.add(label_2, "name_535819033231199");
		
		tour4 = new JLabel("1");
		tour4.setBounds(503, 0, 44, 58);
		tour4.setHorizontalAlignment(SwingConstants.LEFT);
		tour4.setFont(new Font("Lato", Font.BOLD, 24));
		panel4Rempli.add(tour4, "name_535819046748700");
		
		date4 = new JLabel("20/02/20");
		date4.setBounds(740, 0, 122, 58);
		date4.setHorizontalAlignment(SwingConstants.RIGHT);
		date4.setFont(new Font("Lato", Font.BOLD, 24));
		panel4Rempli.add(date4, "name_535819060417500");
		
		label_7 = new JLabel("Emplacement Vide");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.DARK_GRAY);
		label_7.setFont(new Font("Lato", Font.BOLD, 20));
		label_7.setBounds(0, 0, 862, 58);
		panel4Vide.add(label_7);
		
		fond4 = new JLabel("");
		fond4.setHorizontalAlignment(SwingConstants.CENTER);
		fond4.setIcon(imgFond);
		fond4.setBounds(10, 5, 886, 67);
		panel_4.add(fond4);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(251, 211, 9));	
		listeParties.add(panel_5);
		panel_5.setLayout(null);
		
		sous_panel_5 = new JPanel();
		sous_panel_5.setBounds(23, 14, 862, 52);
		sous_panel_5.setBackground(new Color(244, 214, 88));
		panel_5.add(sous_panel_5);
		sous_panel_5.setLayout(new CardLayout(0, 0));
		
		panel5Rempli = new JPanel();
		panel5Rempli.setBackground(new Color(244, 214, 88));
		sous_panel_5.add(panel5Rempli);
		panel5Rempli.setLayout(null);
		
		panel5Vide = new JPanel();
		panel5Vide.setBackground(new Color(244, 214, 88));
		sous_panel_5.add(panel5Vide);
		panel5Vide.setLayout(null);
		
		partie5 = new JLabel("Partie 5");
		partie5.setBounds(0, 0, 113, 58);
		partie5.setHorizontalAlignment(SwingConstants.RIGHT);
		partie5.setFont(new Font("Lato", Font.BOLD, 24));
		panel5Rempli.add(partie5, "name_535822905148200");
		
		label_3 = new JLabel("Tour n\u00B0");
		label_3.setBounds(410, 0, 101, 58);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Lato", Font.BOLD, 24));
		panel5Rempli.add(label_3, "name_535822919082000");
		
		tour5 = new JLabel("1");
		tour5.setBounds(503, 0, 44, 58);
		tour5.setHorizontalAlignment(SwingConstants.LEFT);
		tour5.setFont(new Font("Lato", Font.BOLD, 24));
		panel5Rempli.add(tour5, "name_535822933169600");
		
		date5 = new JLabel("20/02/20");
		date5.setBounds(740, 0, 122, 58);
		date5.setHorizontalAlignment(SwingConstants.RIGHT);
		date5.setFont(new Font("Lato", Font.BOLD, 24));
		panel5Rempli.add(date5, "name_535822947254600");
		
		label_8 = new JLabel("Emplacement Vide");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.DARK_GRAY);
		label_8.setFont(new Font("Lato", Font.BOLD, 20));
		label_8.setBounds(0, 0, 862, 58);
		panel5Vide.add(label_8);
		
		fond5 = new JLabel("");
		fond5.setHorizontalAlignment(SwingConstants.CENTER);
		fond5.setIcon(imgFond);
		fond5.setBounds(10, 5, 886, 67);
		panel_5.add(fond5);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		panel_6 = new JPanel();
		panel_6.setBackground(new Color(251, 211, 9));	
		listeParties.add(panel_6);
		panel_6.setLayout(null);
		
		sous_panel_6 = new JPanel();
		sous_panel_6.setBounds(23, 14, 862, 52);
		sous_panel_6.setBackground(new Color(244, 214, 88));
		panel_6.add(sous_panel_6);
		sous_panel_6.setLayout(new CardLayout(0, 0));
		
		panel6Rempli = new JPanel();
		panel6Rempli.setBackground(new Color(244, 214, 88));
		sous_panel_6.add(panel6Rempli);
		panel6Rempli.setLayout(null);
		
		panel6Vide = new JPanel();
		panel6Vide.setBackground(new Color(244, 214, 88));
		sous_panel_6.add(panel6Vide);
		panel6Vide.setLayout(null);
		
		partie6 = new JLabel("Partie 6");
		partie6.setBounds(0, 0, 113, 58);
		partie6.setHorizontalAlignment(SwingConstants.RIGHT);
		partie6.setFont(new Font("Lato", Font.BOLD, 24));
		panel6Rempli.add(partie6, "name_535827006589000");
		
		label_4 = new JLabel("Tour n\u00B0");
		label_4.setBounds(410, 0, 101, 58);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Lato", Font.BOLD, 24));
		panel6Rempli.add(label_4, "name_535827020212000");
		
		tour6 = new JLabel("1");
		tour6.setBounds(503, 0, 44, 58);
		tour6.setHorizontalAlignment(SwingConstants.LEFT);
		tour6.setFont(new Font("Lato", Font.BOLD, 24));
		panel6Rempli.add(tour6, "name_535827033537499");
		
		date6 = new JLabel("20/02/20");
		date6.setBounds(740, 0, 122, 58);
		date6.setHorizontalAlignment(SwingConstants.RIGHT);
		date6.setFont(new Font("Lato", Font.BOLD, 24));
		panel6Rempli.add(date6, "name_535827046956300");
		
		label_9 = new JLabel("Emplacement Vide");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.DARK_GRAY);
		label_9.setFont(new Font("Lato", Font.BOLD, 20));
		label_9.setBounds(0, 0, 862, 58);
		panel6Vide.add(label_9);
		
		fond6 = new JLabel("");
		fond6.setHorizontalAlignment(SwingConstants.CENTER);
		fond6.setIcon(imgFond);
		fond6.setBounds(10, 5, 886, 67);
		panel_6.add(fond6);
	}
	
	public void afficherTitres() {
		titre = new JLabel("Selectionnez la partie : ");
		titre.setBounds(0, 60, 1200, 50);
		titre.setHorizontalAlignment(SwingConstants.CENTER); 
		titre.setFont(new Font("Helvetica", Font.BOLD, 28));
		getContentPane().add(titre);
	}
	
	public ImageIcon getImageFond() {
		return imgFond;
	}
	
	public JLabel getCache() {
		return cache;
	}
	
}
	