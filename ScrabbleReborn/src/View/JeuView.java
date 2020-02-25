package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Model.Grille;
import Model.LettreModel;

import java.awt.*;

public class JeuView extends JFrame {
    public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int width = (int)screenSize.getWidth();
    public int height = (int)screenSize.getHeight();
    private ImageIcon imgBack = new ImageIcon(this.getClass().getResource("/images/back.png"));
    private ImageIcon imgSauvegarder = new ImageIcon(this.getClass().getResource("/images/sauvegarder.png"));
    private ImageIcon imgFondScore = new ImageIcon(this.getClass().getResource("/images/fond_score.png"));
    private ImageIcon imgFondLettresRestantes = new ImageIcon(this.getClass().getResource("/images/lettres_restantes.png"));
    private ImageIcon imgSoumettreMot = new ImageIcon(this.getClass().getResource("/images/soumettre_mot.png"));
    
    public Grille grille;
    private JLabel back, sauvegarderCollisions, soumettreCollisions, titreScores, tourDe, tourDuJoueur,lettresRestantesFond, lettresRestantes, boutonSoumettreMot, imgJoueur, boutonSauvegarder;
    private JLabel J1, J2, J3, J4, scoreJ1, scoreJ2, scoreJ3, scoreJ4;
    private JPanel ongletLettresRestantes,ongletSoumettreMot, lettres,ongletTour, lettreMove;
    public LettreModel lettre1, lettre2, lettre3, lettre4, lettre5, lettre6, lettre7;
    
    public JeuView(){
    	this.setSize(1000, 800);
		this.setUndecorated(true);
		setLocation(width/2 - this.getSize().width/2, height/2 - this.getSize().height/2);
        getContentPane().setLayout(null);
        this.setVisible(true);
        getContentPane().setBackground(new Color(254,211,7));
        
        back = new JLabel();
		back.setIcon(imgBack);
		back.setBounds(20, 11, 70, 54);
		getContentPane().add(back);
		
		
		lettreMove = new JPanel();
        lettreMove.setBounds(340+590, 727, 45, 45);
        getContentPane().add(lettreMove);
        lettreMove.setVisible(true);
        lettreMove.setLayout(null);
        lettreMove.setOpaque(false);


        boutonSauvegarder = new JLabel("");
        boutonSauvegarder.setIcon(imgSauvegarder);
        boutonSauvegarder.setBounds(86, 25, 182, 42);
        getContentPane().add(boutonSauvegarder);
        
        sauvegarderCollisions = new JLabel("");
        sauvegarderCollisions.setBounds(80, 20, 200, 54);
        getContentPane().add(sauvegarderCollisions);
		

        JPanel ongletScore = new JPanel();
        ongletScore.setBackground(new Color(254, 211, 7));
        ongletScore.setBounds(0, 76, 268, 191);
        getContentPane().add(ongletScore);
		ongletScore.setLayout(null);
        
		titreScores = new JLabel("Scores :");
		titreScores.setFont(new Font("Lato", Font.BOLD, 18));
        titreScores.setForeground(Color.WHITE);
        titreScores.setBounds(38, 22, 63, 22);
        ongletScore.add(titreScores);
		
        
        JPanel scores = new JPanel();
        scores.setBounds(38, 56, 206, 124);
        scores.setBackground(new Color(137, 80, 160));
        ongletScore.add(scores);
        
        JLabel fondScore = new JLabel("");
        fondScore.setHorizontalAlignment(SwingConstants.CENTER);
        fondScore.setIcon(imgFondScore);
        fondScore.setBounds(0, 5, 278, 186);
        ongletScore.add(fondScore);
        
        GridBagLayout gbl_scores = new GridBagLayout();
        gbl_scores.columnWidths = new int[]{170, 14, 0};
        gbl_scores.rowHeights = new int[]{31, 31, 31, 31, 0};
        gbl_scores.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_scores.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        scores.setLayout(gbl_scores);
        
        J1 = new JLabel("J1 - Quentin");
        J1.setFont(new Font("Lato", Font.BOLD, 16));
        J1.setForeground(Color.WHITE);
        J1.setBackground(Color.GREEN);
        GridBagConstraints gbc_J1 = new GridBagConstraints();
        gbc_J1.fill = GridBagConstraints.BOTH;
        gbc_J1.insets = new Insets(0, 0, 5, 5);
        gbc_J1.gridx = 0;
        gbc_J1.gridy = 0;
        scores.add(J1, gbc_J1);
        
        scoreJ1 = new JLabel("2010");
        scoreJ1.setHorizontalAlignment(SwingConstants.TRAILING);
        scoreJ1.setForeground(Color.WHITE);
        scoreJ1.setFont(new Font("Lato", Font.BOLD, 16));
        GridBagConstraints gbc_scoreJ1 = new GridBagConstraints();
        gbc_scoreJ1.anchor = GridBagConstraints.EAST;
        gbc_scoreJ1.fill = GridBagConstraints.VERTICAL;
        gbc_scoreJ1.insets = new Insets(0, 0, 5, 0);
        gbc_scoreJ1.gridx = 1;
        gbc_scoreJ1.gridy = 0;
        scores.add(scoreJ1, gbc_scoreJ1);
        
        J2 = new JLabel("J2 - Mathieu");
        J2.setFont(new Font("Lato", Font.BOLD, 16));
        J2.setForeground(Color.WHITE);
        GridBagConstraints gbc_J2 = new GridBagConstraints();
        gbc_J2.fill = GridBagConstraints.BOTH;
        gbc_J2.insets = new Insets(0, 0, 5, 5);
        gbc_J2.gridx = 0;
        gbc_J2.gridy = 1;
        scores.add(J2, gbc_J2);
        
        scoreJ2 = new JLabel("1220");
        scoreJ2.setHorizontalAlignment(SwingConstants.TRAILING);
        scoreJ2.setFont(new Font("Lato", Font.BOLD, 16));
        scoreJ2.setForeground(Color.WHITE);
        scoreJ2.setBackground(Color.RED);
        GridBagConstraints gbc_scoreJ2 = new GridBagConstraints();
        gbc_scoreJ2.fill = GridBagConstraints.BOTH;
        gbc_scoreJ2.insets = new Insets(0, 0, 5, 0);
        gbc_scoreJ2.gridx = 1;
        gbc_scoreJ2.gridy = 1;
        scores.add(scoreJ2, gbc_scoreJ2);
        
        J3 = new JLabel("J3 - Mathieu 2");
        J3.setForeground(Color.WHITE);
        J3.setFont(new Font("Lato", Font.BOLD, 16));
        GridBagConstraints gbc_J3 = new GridBagConstraints();
        gbc_J3.fill = GridBagConstraints.BOTH;
        gbc_J3.insets = new Insets(0, 0, 5, 5);
        gbc_J3.gridx = 0;
        gbc_J3.gridy = 2;
        scores.add(J3, gbc_J3);
        
        scoreJ3 = new JLabel("24");
        scoreJ3.setHorizontalAlignment(SwingConstants.TRAILING);
        scoreJ3.setForeground(Color.WHITE);
        scoreJ3.setFont(new Font("Lato", Font.BOLD, 16));
        GridBagConstraints gbc_scoreJ3 = new GridBagConstraints();
        gbc_scoreJ3.fill = GridBagConstraints.BOTH;
        gbc_scoreJ3.insets = new Insets(0, 0, 5, 0);
        gbc_scoreJ3.gridx = 1;
        gbc_scoreJ3.gridy = 2;
        scores.add(scoreJ3, gbc_scoreJ3);
        
        J4 = new JLabel("");
        J4.setFont(new Font("Lato", Font.BOLD, 16));
        J4.setForeground(Color.WHITE);
        GridBagConstraints gbc_J4 = new GridBagConstraints();
        gbc_J4.fill = GridBagConstraints.BOTH;
        gbc_J4.insets = new Insets(0, 0, 0, 5);
        gbc_J4.gridx = 0;
        gbc_J4.gridy = 3;
        scores.add(J4, gbc_J4);
        
        scoreJ4 = new JLabel("");
        scoreJ4.setHorizontalAlignment(SwingConstants.TRAILING);
        scoreJ4.setForeground(Color.WHITE);
        scoreJ4.setFont(new Font("Lato", Font.BOLD, 16));
        GridBagConstraints gbc_scoreJ4 = new GridBagConstraints();
        gbc_scoreJ4.fill = GridBagConstraints.BOTH;
        gbc_scoreJ4.gridx = 1;
        gbc_scoreJ4.gridy = 3;
        scores.add(scoreJ4, gbc_scoreJ4);

        ongletLettresRestantes = new JPanel();
        ongletLettresRestantes.setBounds(49, 524, 180, 186);
        ongletLettresRestantes.setBackground(new Color(254, 211, 7));
        getContentPane().add(ongletLettresRestantes);
        ongletLettresRestantes.setLayout(new BorderLayout(0, 0));
        
        
        lettresRestantes = new JLabel("102");
        lettresRestantes.setHorizontalAlignment(SwingConstants.CENTER);
        lettresRestantes.setFont(new Font("Lato", Font.BOLD, 70));
        lettresRestantes.setForeground(Color.WHITE);
        lettresRestantes.setBounds(0, 70, 175, 85);
        ongletLettresRestantes.add(lettresRestantes);
        
        lettresRestantesFond = new JLabel("");
        lettresRestantesFond.setHorizontalAlignment(SwingConstants.CENTER);
        lettresRestantesFond.setIcon(imgFondLettresRestantes);
        lettresRestantesFond.setBounds(0, 0, 175, 186);
        ongletLettresRestantes.add(lettresRestantesFond);

        
        ongletTour = new JPanel();
        ongletTour.setBounds(62, 290, 167, 200);
        ongletTour.setBackground(new Color(254, 211, 7));
        getContentPane().add(ongletTour);
        
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{200, 0};
        gbl_panel_1.rowHeights = new int[]{30, 134, 20, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        ongletTour.setLayout(gbl_panel_1);
        
        tourDe = new JLabel("Au tour de :");
        tourDe.setHorizontalAlignment(SwingConstants.CENTER);
        tourDe.setFont(new Font("Lato", Font.BOLD, 24));
        GridBagConstraints gbc_tourDe = new GridBagConstraints();
        gbc_tourDe.anchor = GridBagConstraints.NORTH;
        gbc_tourDe.insets = new Insets(0, 0, 5, 0);
        gbc_tourDe.gridx = 0;
        gbc_tourDe.gridy = 0;
        ongletTour.add(tourDe, gbc_tourDe);
        
        imgJoueur = new JLabel("");
        GridBagConstraints gbc_imgJoueur = new GridBagConstraints();
        gbc_imgJoueur.insets = new Insets(0, 0, 5, 0);
        gbc_imgJoueur.gridx = 0;
        gbc_imgJoueur.gridy = 1;
        ongletTour.add(imgJoueur, gbc_imgJoueur);
        
        tourDuJoueur = new JLabel("J2 - Mathieu");
        tourDuJoueur.setFont(new Font("Lato", Font.BOLD, 16));
        tourDuJoueur.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_tourDuJoueur = new GridBagConstraints();
        gbc_tourDuJoueur.anchor = GridBagConstraints.NORTH;
        gbc_tourDuJoueur.gridx = 0;
        gbc_tourDuJoueur.gridy = 2;
        ongletTour.add(tourDuJoueur, gbc_tourDuJoueur);
        
        
        
        ongletSoumettreMot = new JPanel();
        ongletSoumettreMot.setBounds(20, 727, 274, 62);
        ongletSoumettreMot.setBackground(new Color(254, 211, 7));
        getContentPane().add(ongletSoumettreMot);
        
        boutonSoumettreMot = new JLabel("");
        boutonSoumettreMot.setIcon(imgSoumettreMot);
        ongletSoumettreMot.add(boutonSoumettreMot);
        
        soumettreCollisions = new JLabel("");
        soumettreCollisions.setBounds(19, 726, 276, 64);
        getContentPane().add(soumettreCollisions);
        
        grille = new Grille();
        grille.setBounds(278,11, 700, 710);
        getContentPane().add(grille);
        
        lettres = new JPanel();
        lettres.setBounds(340, 727, 585, 62);
        lettres.setBackground(new Color(31, 63, 28));
        getContentPane().add(lettres);
        lettres.setLayout(new GridLayout(1, 0, 0, 0));
        
        lettre1 = new LettreModel('a');
        lettre1.setOpaque(false);
        lettre1.setContentAreaFilled(false);
        lettre1.setBorder(null);
        lettre2 = new LettreModel('b');
        lettre2.setOpaque(false);
        lettre2.setContentAreaFilled(false);
        lettre2.setBorder(null);
        lettre3 = new LettreModel('c');
        lettre3.setOpaque(false);
        lettre3.setContentAreaFilled(false);
        lettre3.setBorder(null);
        lettre4 = new LettreModel('d');
        lettre4.setOpaque(false);
        lettre4.setContentAreaFilled(false);
        lettre4.setBorder(null);
        lettre5 = new LettreModel('e');
        lettre5.setOpaque(false);
        lettre5.setContentAreaFilled(false);
        lettre5.setBorder(null);
        lettre6 = new LettreModel('f');
        lettre6.setOpaque(false);
        lettre6.setContentAreaFilled(false);
        lettre6.setBorder(null);
        lettre7 = new LettreModel('g');
        lettre7.setOpaque(false);
        lettre7.setContentAreaFilled(false);
        lettre7.setBorder(null);
        lettres.add(lettre1);
        lettres.add(lettre2);
        lettres.add(lettre3);
        lettres.add(lettre4);
        lettres.add(lettre5);
        lettres.add(lettre6);
        lettres.add(lettre7);
        
        grille.revalidate();
    }
    
    public JLabel getBoutonSauvegarder() {
    	return boutonSauvegarder;
    }
    
    public JLabel getBoutonSoumettre() {
    	return boutonSoumettreMot;
    }
    
    public Grille getGrille() {
    	return grille;
    }
    
    public JLabel getBack() {
    	return back;
    }

    public JPanel getLettres() {
    	return lettres;
    }
    
    public JPanel getLettreMove() {
    	return lettreMove;
    }
    
    public JLabel getCollisions(int i) {
    	if(i == 1) {
    		return sauvegarderCollisions;
    	}
    	else {
    		return soumettreCollisions;
    	}
    }
    
    public ImageIcon getImg(int i) {
    	if(i == 1) {
    		return imgSauvegarder;
    	}
    	else {
    		return imgSoumettreMot;
    	}
    }
    
    public JLabel getPseudos(int i) {
    	switch(i) {
    		case 0:
    			return J1;
    		case 1:
    			return J2;
    		case 2:
    			return J3;
    		case 3:
    			return J4;
    	}
    	return null;
    }
    
    public JLabel getScores(int i) {
    	switch(i) {
    		case 0:
    			return scoreJ1;
    		case 1:
    			return scoreJ2;
    		case 2:
    			return scoreJ3;
    		case 3:
    			return scoreJ4;
    	}
    	return null;
    }
}
