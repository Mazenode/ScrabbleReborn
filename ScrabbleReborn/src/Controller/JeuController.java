package Controller;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
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
	private static int numPartie, compteur,element,joueurAyantJoue,compteurJoueur;
	private String[] listeResultats,listePseudo;
	private static ArrayList<Joueur> joueurs;
	
	public JeuController(JeuView view, JeuModel model, int numPartie) {
		this.view = view;
		this.model = model;
		this.numPartie = numPartie;
		listeResultats = new String [9];
		listePseudo = new String [4];
		joueurAyantJoue = 0;
		compteurJoueur = 0;
		view.setVisible(true);
		
		chargerPartie = new ChargerPartieModel();

		//Fonctions de chargement
		chargerPlateau();
		chargerScores();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Joueur Mathieu = new Joueur("Mathieu",4);///////////////////////////////////à supprimer////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		placerLettre();
		fonctionsDiverses();
		initTour();
		
	}

	public void initTour() {
		if(joueurAyantJoue == 0) {
			view.getTourDuJoueur().setText(joueurs.get(0).getPseudo());
			view.getImgJoueur().setIcon(model.getImgJoueur(1));
			joueurAyantJoue++;
		}

		else if(joueurAyantJoue == 1) {
			if(compteurJoueur == 2 || compteurJoueur == 3 || compteurJoueur == 4) {
				view.getTourDuJoueur().setText(joueurs.get(1).getPseudo());
				joueurAyantJoue ++;
			}
			else {
				joueurAyantJoue = 0;
			}
		}

		else if(joueurAyantJoue == 2) {
			if(compteurJoueur == 3 || compteurJoueur == 4) {
				view.getTourDuJoueur().setText(joueurs.get(2).getPseudo());
				joueurAyantJoue ++;
			}
			else {
				joueurAyantJoue = 0;
			}
		}

		else if(joueurAyantJoue == 3) {
			if(compteurJoueur == 4) {
				view.getTourDuJoueur().setText(joueurs.get(3).getPseudo());
				joueurAyantJoue = 0;
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
			LettreModel lettre = new LettreModel(ChargerPartieModel.plateau[numPartie - 1].charAt(i));
			
			view.grille.getListe().get(i).add(lettre);
			
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
				Random rand = new Random();
				Joueur.getListeJoueur().get(0).print();
				compteur = Joueur.getListeJoueur().get(0).getListeLettrePos().size();
				Model.JeuModel.setNbrDeLettreRestante(compteur);
				view.getLettresRestantes().setText(Integer.toString(JeuModel.getNbrDeLettreRestante()));
				try {
					if(JeuModel.lecture()){
						for (int i = 0; i <compteur ; i++) {
							element = rand.nextInt(model.getListeLettreAlp().length);
							view.lettre1 = new LettreModel(model.getListeLettreAlp()[element]);
							view.getLettres().add(view.lettre1);
							view.getLettres().revalidate();
						}
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				initTour();
			}
		});

	}
	
	public void placerLettre() {
		/* placer une lettre */
		view.lettre1.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				JeuModel.setLettre((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22, view.lettre1, view.getGrille(), view.getLettres());
				view.getLettreMove().remove(view.lettre1);
				view.getLettreMove().setBounds(2000,2000,45,45);

			}
		});
		view.lettre1.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				view.lettre1.setBounds(0,0,45,45);
				view.getLettreMove().add(view.lettre1,0);
				view.getLettreMove().setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22,45,45);
			}
		});
		
		view.lettre2.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				JeuModel.setLettre((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22, view.lettre2, view.getGrille(), view.getLettres());
				view.getLettreMove().remove(view.lettre2);
				view.getLettreMove().setBounds(2000,2000,45,45);
			}
		});
		view.lettre2.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				view.lettre2.setBounds(0,0,45,45);
				view.getLettreMove().add(view.lettre2,0);
				view.getLettreMove().setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22,45,45);
			}
		});
		
		view.lettre3.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				JeuModel.setLettre((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22, view.lettre3, view.getGrille(), view.getLettres());
				view.getLettreMove().remove(view.lettre3);
				view.getLettreMove().setBounds(2000,2000,45,45);
			}
		});
		view.lettre3.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				view.lettre3.setBounds(0,0,45,45);
				view.getLettreMove().add(view.lettre3,0);
				view.getLettreMove().setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22,45,45);
			}
		});
		
		view.lettre4.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				JeuModel.setLettre((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22, view.lettre4, view.getGrille(), view.getLettres());
				view.getLettreMove().remove(view.lettre4);
				view.getLettreMove().setBounds(2000,2000,45,45);
			}
		});
		view.lettre4.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				view.lettre4.setBounds(0,0,45,45);
				view.getLettreMove().add(view.lettre4,0);
				view.getLettreMove().setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22,45,45);
			}
		});
		
		view.lettre5.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				JeuModel.setLettre((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22, view.lettre5, view.getGrille(), view.getLettres());
				view.getLettreMove().remove(view.lettre5);
				view.getLettreMove().setBounds(2000,2000,45,45);
			}
		});
		view.lettre5.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				view.lettre5.setBounds(0,0,45,45);
				view.getLettreMove().add(view.lettre5,0);
				view.getLettreMove().setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22,45,45);
			}
		});
		
		view.lettre6.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				JeuModel.setLettre((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22, view.lettre6, view.getGrille(), view.getLettres());
				view.getLettreMove().remove(view.lettre6);
				view.getLettreMove().setBounds(2000,2000,45,45);
			}
		});
		view.lettre6.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				view.lettre6.setBounds(0,0,45,45);
				view.getLettreMove().add(view.lettre6,0);
				view.getLettreMove().setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22,45,45);
			}
		});
		
		view.lettre7.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				JeuModel.setLettre((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22, view.lettre7, view.getGrille(), view.getLettres());
				view.getLettreMove().remove(view.lettre7);
				view.getLettreMove().setBounds(2000,2000,45,45);
			}
		});
		view.lettre7.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				view.lettre7.setBounds(0,0,45,45);
				view.getLettreMove().add(view.lettre7,0);
				view.getLettreMove().setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22,45,45);
			}
		});
	}
	
	public void sauvegarder() {
		
	}

	public int getCompteur(){
		return compteur;
	}

}
