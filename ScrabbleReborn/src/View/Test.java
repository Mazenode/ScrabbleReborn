package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JCheckBox;

public class Test extends JFrame {

	private JPanel contentPane;
	private JLabel back, boutonQuit, titre, sousTitre;
	private ImageIcon imgBoutonBack = new ImageIcon(this.getClass().getResource("/images/back.png"));
	private ImageIcon imgQuit = new ImageIcon(this.getClass().getResource("/images/quit.png"));
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static int width = (int)screenSize.getWidth();
	static int height = (int)screenSize.getHeight();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(251, 211, 9));	
		this.setSize(1200, 800);
		this.setLocation(width /2 - this.getSize().width/2, height /2 - this.getSize().height/2);
		
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
		
		boutonQuit = new JLabel(imgQuit);
		boutonQuit.setBounds(1140, 10, imgQuit.getIconWidth(), imgQuit.getIconHeight());
		getContentPane().add(boutonQuit);
		
		JPanel gridImages = new JPanel();
		gridImages.setBounds(196, 217, 813, 136);
		gridImages.setBackground(new Color(251, 211, 9));
		getContentPane().add(gridImages);
		gridImages.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Test.class.getResource("/images/1.png")));
		gridImages.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(Test.class.getResource("/images/non_joueur.png")));
		gridImages.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setIcon(new ImageIcon(Test.class.getResource("/images/non_joueur.png")));
		gridImages.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon(Test.class.getResource("/images/non_joueur.png")));
		gridImages.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Test.class.getResource("/images/non_joueur.png")));
		gridImages.add(lblNewLabel_1);
		
		JLabel imageRandom = new JLabel("");
		imageRandom.setHorizontalAlignment(SwingConstants.CENTER);
		imageRandom.setIcon(new ImageIcon(Test.class.getResource("/images/non_joueur.png")));
		gridImages.add(imageRandom);
		
		JLabel boutonCreerJoueur = new JLabel("");
		boutonCreerJoueur.setIcon(new ImageIcon(Test.class.getResource("/images/bouton_creer_un_joueur.png")));
		boutonCreerJoueur.setBounds(413, 423, 382, 87);
		getContentPane().add(boutonCreerJoueur);
		
		JCheckBox tourChrono = new JCheckBox("  Jouer avec des tours chronometres");
		tourChrono.setFont(new Font("Lato", Font.BOLD, 14));
		tourChrono.setBounds(465, 531, 251, 15);
		tourChrono.setBackground(new Color(251, 211, 9));
		getContentPane().add(tourChrono);
		
		JLabel boutonLancerLaPartie = new JLabel("");
		boutonLancerLaPartie.setIcon(new ImageIcon(Test.class.getResource("/images/bouton_lancer_partie.png")));
		boutonLancerLaPartie.setBounds(413, 586, 382, 87);
		getContentPane().add(boutonLancerLaPartie);
		
		JPanel gridPseudo = new JPanel();
		gridPseudo.setBackground(new Color(251, 211, 9));
		gridPseudo.setBounds(196, 354, 813, 25);
		getContentPane().add(gridPseudo);
		gridPseudo.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Mathieu A");
		lblNewLabel_3.setFont(new Font("Lato", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		gridPseudo.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		gridPseudo.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Test.class.getResource("/images/back.png")));
		lblNewLabel.setBounds(20, 11, 70, 54);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(220, 416, 717, 323);
		getContentPane().add(lblNewLabel_7);
		
		JPanel gridJoueur = new JPanel();
		gridJoueur.setBackground(new Color(251, 211, 9));
		gridJoueur.setBounds(196, 192, 813, 25);
		getContentPane().add(gridJoueur);
		gridJoueur.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel emplacement1 = new JLabel();
		emplacement1.setFont(new Font("Lato", Font.BOLD, 17));
		emplacement1.setHorizontalAlignment(SwingConstants.CENTER);
		gridJoueur.add(emplacement1);
		
		JLabel emplacement2 = new JLabel();
		emplacement2.setFont(new Font("Lato", Font.BOLD, 17));
		emplacement2.setHorizontalAlignment(SwingConstants.CENTER);
		gridJoueur.add(emplacement2);
		
		JLabel emplacement3 = new JLabel();
		emplacement3.setFont(new Font("Lato", Font.BOLD, 17));
		emplacement3.setHorizontalAlignment(SwingConstants.CENTER);
		gridJoueur.add(emplacement3);
		
		JLabel emplacement4 = new JLabel();
		emplacement4.setFont(new Font("Lato", Font.BOLD, 17));
		emplacement4.setHorizontalAlignment(SwingConstants.CENTER);
		gridJoueur.add(emplacement4);
		
		JLabel emplacement5 = new JLabel();
		emplacement5.setFont(new Font("Lato", Font.BOLD, 17));
		emplacement5.setHorizontalAlignment(SwingConstants.CENTER);
		gridJoueur.add(emplacement5);
		
		JLabel emplacement6 = new JLabel();
		emplacement6.setFont(new Font("Lato", Font.BOLD, 17));
		emplacement6.setHorizontalAlignment(SwingConstants.CENTER);
		gridJoueur.add(emplacement6);
	}
}
