package Controller;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import Model.*;
import View.CreerPartieView;
import View.JeuView;
import View.MenuView;

import javax.swing.*;

public class JeuController {

	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public int width = (int)screenSize.getWidth();
	public int height = (int)screenSize.getHeight();
	private ChargerPartieModel chargerPartie;
	private JeuView view;
	private JeuModel model;
	private static int numPartie, compteur,element,joueurAyantJoue,compteurJoueur, numTour,lettreRestantes;
	private String[] listeResultats,listePseudo, data;
	private static ArrayList<Joueur> joueurs;
	private Joueur joueurActuel;

	public JeuController(JeuView view, JeuModel model, int numPartie) {
		this.view = view;
		this.model = model;
		this.numPartie = numPartie;
		listeResultats = new String [9];
		listePseudo = new String [4];
		data = new String[14];
		joueurAyantJoue = 0;
		compteurJoueur = 0;
		view.setVisible(true);

		chargerPartie = new ChargerPartieModel();

		//Fonctions de chargement
		chargerPlateau();
		chargerScores();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Joueur Mathieu = new Joueur("Mathieu",4);///////////////////////////////////Ã  supprimer////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		placerLettre();
		fonctionsDiverses();
		initTour();

	}
	
	public void sauvegarder()  {
		setData();
		try {
			int indice = 0;
			if(numPartie == 1) {
				indice = 2;
			}
			else {
				indice = (numPartie  - 1) * 15;
			}
			int j = 0;

			for(int i = indice; i < indice + 13; i++) {
				 setVariable(i , data[j]);
				 j++;
			 }

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setData() {

		data[0] = "Partie "+ (numPartie - 1);
		data[1] = ChargerPartieModel.dates[numPartie - 1];
		data[2] = Integer.toString(numTour);
		data[3] = Integer.toString(lettreRestantes);
		int j = 4;
		int h = 5;
		for(int i = 0; i < 4; i++) {
			if(i < joueurs.size()) {
				data[j] = joueurs.get(i).getPseudo();
				System.out.println("test");
			}
			else {
				data[j] = "null";
			}
			j+=2;
		}

		for(int i = 0; i < 4; i++) {
			if(i < joueurs.size()) {
				data[h] = Integer.toString(1);
			}
			else {
				data[h] = Integer.toString(0);
			}
			h+=2;
		}

		data[12] = getPlateau();
	}
	
	public String getPlateau() {
		String plateau = "";
		for(int i = 0; i < 225; i++) {
			plateau += view.getGrille().getListe().get(i).val;
		}
		return plateau;
	}

	public static void setVariable(int nombreLignes, String data) throws IOException {
	    Path path = Paths.get("parties.txt");
	    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
	    lines.set(nombreLignes - 1, data);
	    Files.write(path, lines, StandardCharsets.UTF_8);
	}

	public void initTour() {

		if(!model.victoire) {
			if(joueurAyantJoue == 0) {
				joueurActuel = joueurs.get(0);
				System.out.println(joueurActuel.getPseudo());
				view.getTourDuJoueur().setText(joueurs.get(0).getPseudo());
				view.getImgJoueur().setIcon(model.getImgJoueur(1));
				joueurAyantJoue++;
			}
	
			else if(joueurAyantJoue == 1) {
				if(compteurJoueur == 2 || compteurJoueur == 3 || compteurJoueur == 4) {
					joueurActuel = joueurs.get(1);
					System.out.println(joueurActuel.getPseudo());
					view.getTourDuJoueur().setText(joueurs.get(1).getPseudo());
					joueurAyantJoue ++;
				}
				else {
					joueurAyantJoue = 0;
				}
			}
	
			else if(joueurAyantJoue == 2) {
				if(compteurJoueur == 3 || compteurJoueur == 4) {
					joueurActuel = joueurs.get(2);
					System.out.println(joueurActuel.getPseudo());
					view.getTourDuJoueur().setText(joueurs.get(2).getPseudo());
					joueurAyantJoue ++;
				}
				else {
					joueurAyantJoue = 0;
				}
			}
	
			else if(joueurAyantJoue == 3) {
				if(compteurJoueur == 4) {
					joueurActuel = joueurs.get(3);
					System.out.println(joueurActuel.getPseudo());
					view.getTourDuJoueur().setText(joueurs.get(3).getPseudo());
					joueurAyantJoue = 0;
				}
			}
		}
		else {
			int gagnant = 0;
			int[] resultats ={1,2,400,5};
			int [] copie = new int[resultats.length];
			for(int i = 0; i < resultats.length; i++) {	
				copie[i] = resultats[i];
			}
			
			Arrays.sort(resultats);
			for(int i = 0; i < resultats.length; i++) {	
				if(copie[i] == resultats[resultats.length - 1]){
					gagnant = i;
				}
			}

			
			switch(gagnant + 1) {
				case 1:
					view.getVictoire().setBounds(10, 48, 40, 38);
					view.getVictoire().setVisible(true);
					break;
				case 2:
					view.getVictoire().setBounds(10, 78, 40, 38);
					view.getVictoire().setVisible(true);
					break;
				case 3:
					view.getVictoire().setBounds(10, 110, 40, 38);
					view.getVictoire().setVisible(true);
					break;
				case 4:
					view.getVictoire().setBounds(10, 142, 40, 38);
					view.getVictoire().setVisible(true);
					break;
			}
		}
	}


	public void chargerScores() {
		int j = 0;
		joueurs = new ArrayList<Joueur>();
		for(int i = (numPartie * 4 )- 4; i < numPartie * 4; i++) {
			if(!ChargerPartieModel.listejoueurs[i].equals("null")) {
				compteurJoueur++;
				Joueur joueur = new Joueur(ChargerPartieModel.listejoueurs[i],1);
				joueur.setScore(ChargerPartieModel.scores[i]);
				joueurs.add(joueur);
				view.getPseudos(j).setText(ChargerPartieModel.listejoueurs[i]);
				view.getScores(j).setText(Integer.toString(ChargerPartieModel.scores[i]));
			}
			else {
				view.getPseudos(j).setText("");
				view.getScores(j).setText("");
			}
			j++;
		}
	}

	public void chargerPlateau() {
		for(int i = 0; i < 225; i++) {
			view.getGrille().getListe().get(i).val = ChargerPartieModel.plateau[numPartie - 1].charAt(i);
			view.getGrille().getListe().get(i).posLettre = i;
			if(ChargerPartieModel.plateau[numPartie - 1].charAt(i)!='#') {
				view.getGrille().getListe().get(i).image= new ImageIcon(this.getClass().getResource("/images/"+ChargerPartieModel.plateau[numPartie - 1].charAt(i)+".png"));
				view.getGrille().getListe().get(i).setIcon(view.getGrille().getListe().get(i).image);
				view.getGrille().getListe().get(i).setHorizontalAlignment(SwingConstants.CENTER);;
			}

		}
	}

	public void fonctionsDiverses() {

		view.getCollisions(1).addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getBoutonSauvegarder().setIcon(view.getImg(1));

			}
		});

		view.getBoutonSauvegarder().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getBoutonSauvegarder().setIcon(model.getSauvegarderActive());

			}
			public void mousePressed(MouseEvent e){
				sauvegarder();


			}
		});

		view.getBack().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getBoutonSauvegarder().setIcon(view.getImg(1));

			}
			public void mousePressed(MouseEvent e){
				/*MenuView view = new MenuView();

				MenuModel model = new MenuModel();

				MenuController controller = new MenuController(view, model);*/

				CreerPartieView creerPartieView = new CreerPartieView();
				CreerPartieModel creerPartieModel = new CreerPartieModel();
				CreerPartieController creerPartieController = new CreerPartieController(creerPartieView, creerPartieModel);

				view.setVisible(false);

			}
		});

		view.getCollisions(2).addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getBoutonSoumettre().setIcon(view.getImg(2));

			}
		});

		view.getBoutonSoumettre().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getBoutonSoumettre().setIcon(model.getSoumettreActive());

			}
			public void mousePressed(MouseEvent e){
				try {
					if(model.lecture(view)){
						compteur = Joueur.getListeJoueur().get(0).getListeLettrePos().size();
						Model.JeuModel.setNbrDeLettreRestante(compteur);
						view.getLettresRestantes().setText(Integer.toString(JeuModel.getNbrDeLettreRestante()));

						/* On remet les variables a zero */
						Joueur.getListeJoueur().get(0).isOnLine = false;
						Joueur.getListeJoueur().get(0).isOnCol = false;
						Joueur.getListeJoueur().get(0).firstPos=-1;

						figeLettre(view.lettre1);
						figeLettre(view.lettre2);
						figeLettre(view.lettre3);
						figeLettre(view.lettre4);
						figeLettre(view.lettre5);
						figeLettre(view.lettre6);
						figeLettre(view.lettre7);
					}else {
						Joueur.getListeJoueur().get(0).isOnLine = false;
						Joueur.getListeJoueur().get(0).isOnCol = false;
						Joueur.getListeJoueur().get(0).firstPos=-1;
						remettreLettre(view.lettre1);
						remettreLettre(view.lettre2);
						remettreLettre(view.lettre3);
						remettreLettre(view.lettre4);
						remettreLettre(view.lettre5);
						remettreLettre(view.lettre6);
						remettreLettre(view.lettre7);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				view.getGrille().revalidate();
				Joueur.getListeJoueur().get(0).getListeLettrePos().clear();
				initTour();
			}
		});

	}

	public void placerLettre() {
		/* placer une lettre */
		view.lettre1.addMouseListener(new MouseAdapter(){
			/* on place la lettre dans le tableau ou on la remets dans le chevalet */
			public void mouseReleased(MouseEvent e){
				JeuModel.setLettre((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22, view.lettre1, view.getGrille(), view.getLettres(), Joueur.getListeJoueur().get(0));
				view.getLettreMove().remove(view.lettre1);
				view.getLettreMove().setBounds(2000,2000,45,45);

			}
		});
		/* Drag and drop de la lettre */
		view.lettre1.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				enleverLettre(view.lettre1);
				view.lettre1.setBounds(0,0,45,45);
				view.getLettreMove().add(view.lettre1,0);
				view.getLettreMove().setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22,45,45);
			}
		});

		view.lettre2.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				JeuModel.setLettre((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22, view.lettre2, view.getGrille(), view.getLettres(), Joueur.getListeJoueur().get(0));
				view.getLettreMove().remove(view.lettre2);
				view.getLettreMove().setBounds(2000,2000,45,45);
			}
		});
		view.lettre2.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				enleverLettre(view.lettre2);
				view.lettre2.setBounds(0,0,45,45);
				view.getLettreMove().add(view.lettre2,0);
				view.getLettreMove().setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22,45,45);
			}
		});

		view.lettre3.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				JeuModel.setLettre((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22, view.lettre3, view.getGrille(), view.getLettres(), Joueur.getListeJoueur().get(0));
				view.getLettreMove().remove(view.lettre3);
				view.getLettreMove().setBounds(2000,2000,45,45);
			}
		});
		view.lettre3.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				enleverLettre(view.lettre3);
				view.lettre3.setBounds(0,0,45,45);
				view.getLettreMove().add(view.lettre3,0);
				view.getLettreMove().setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22,45,45);
			}
		});

		view.lettre4.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				JeuModel.setLettre((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22, view.lettre4, view.getGrille(), view.getLettres(), Joueur.getListeJoueur().get(0));
				view.getLettreMove().remove(view.lettre4);
				view.getLettreMove().setBounds(2000,2000,45,45);
			}
		});
		view.lettre4.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				enleverLettre(view.lettre4);
				view.lettre4.setBounds(0,0,45,45);
				view.getLettreMove().add(view.lettre4,0);
				view.getLettreMove().setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22,45,45);
			}
		});

		view.lettre5.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				JeuModel.setLettre((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22, view.lettre5, view.getGrille(), view.getLettres(), Joueur.getListeJoueur().get(0));
				view.getLettreMove().remove(view.lettre5);
				view.getLettreMove().setBounds(2000,2000,45,45);
			}
		});
		view.lettre5.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				enleverLettre(view.lettre5);
				view.lettre5.setBounds(0,0,45,45);
				view.getLettreMove().add(view.lettre5,0);
				view.getLettreMove().setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22,45,45);
			}
		});

		view.lettre6.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				JeuModel.setLettre((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22, view.lettre6, view.getGrille(), view.getLettres(), Joueur.getListeJoueur().get(0));
				view.getLettreMove().remove(view.lettre6);
				view.getLettreMove().setBounds(2000,2000,45,45);
			}
		});
		view.lettre6.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				enleverLettre(view.lettre6);
				view.lettre6.setBounds(0,0,45,45);
				view.getLettreMove().add(view.lettre6,0);
				view.getLettreMove().setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22,45,45);
			}
		});

		view.lettre7.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				JeuModel.setLettre((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22, view.lettre7, view.getGrille(), view.getLettres(), Joueur.getListeJoueur().get(0));
				view.getLettreMove().remove(view.lettre7);
				view.getLettreMove().setBounds(2000,2000,45,45);
			}
		});
		view.lettre7.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				enleverLettre(view.lettre7);
				view.lettre7.setBounds(0,0,45,45);
				view.getLettreMove().add(view.lettre7,0);
				view.getLettreMove().setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22,45,45);
			}
		});
	}

	public int getCompteur(){
		return compteur;
	}

	public void figeLettre(LettreModel Oldlettre) {
		/* Pour chaque lettre, si elle a ete pose, on recupere la pos ou elle a ete pos et on fige l'image */
		Random rand = new Random();
		if(Oldlettre.posLettre!=300) {
			for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
				if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==Oldlettre.posLettre) {
					LettreModel lettre = new LettreModel(Oldlettre.val);
					view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).add(lettre,0);
					view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = lettre.val;
					Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
					break;
				}
			}
			/* puis on remet une nouvelle lettre dans le chevalet */
			element = rand.nextInt(model.getListeLettreAlp().length);
			Oldlettre.val = model.getListeLettreAlp()[element];
			Oldlettre.image = new ImageIcon(this.getClass().getResource("/images/"+Oldlettre.val+".png"));
			Oldlettre.setIcon(Oldlettre.image);
			Oldlettre.posLettre=300;
			Oldlettre.setHorizontalAlignment(SwingConstants.CENTER);
			view.getLettres().add(Oldlettre);
			view.getLettres().revalidate();
		}
	}

	public void remettreLettre(LettreModel Oldlettre) {
		if(Oldlettre.posLettre!=300) {
			for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
				if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==Oldlettre.posLettre) {
					view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = '#';
					Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
					break;
				}
			}
			Oldlettre.posLettre=300;
			Oldlettre.setBounds(0,0,45,45);
			Oldlettre.setHorizontalAlignment(SwingConstants.CENTER);
			view.getLettres().add(Oldlettre);
			view.getLettres().revalidate();
		}
	}

	public void enleverLettre(LettreModel OldLettre) {
		/* si la case etait pose dans la grille, on l enleve puis on donne le droit de refaire la pose de lettre */
		if(OldLettre.posLettre!=300) {
			for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
				if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==OldLettre.posLettre) {
					if(Joueur.getListeJoueur().get(0).getListeLettrePos().size()<=2) {
						Joueur.getListeJoueur().get(0).isOnLine = false;
						Joueur.getListeJoueur().get(0).isOnCol = false;
					}
					if(Joueur.getListeJoueur().get(0).getListeLettrePos().size()<=1) {
						Joueur.getListeJoueur().get(0).firstPos=-1;
					}
					view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i));
					view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = '#';
					Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
					break;
				}
			}
			OldLettre.posLettre=300;
			OldLettre.setHorizontalAlignment(SwingConstants.CENTER);
			view.getLettres().add(OldLettre);
			view.getLettres().revalidate();
		}
	}
}
