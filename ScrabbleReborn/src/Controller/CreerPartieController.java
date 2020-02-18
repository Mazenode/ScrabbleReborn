package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Model.CreerJoueurModel;
import Model.CreerPartieModel;
import Model.JeuModel;
import Model.MenuModel;
import View.CreerJoueurView;
import View.CreerPartieView;
import View.JeuView;
import View.MenuView;

public class CreerPartieController {
	private CreerPartieView view;
	private CreerPartieModel model;
	private JLabel boutonQuit; 
	private int nbJoueur;

	public CreerPartieController(CreerPartieView view, CreerPartieModel model) {
		this.view = view;
		this.model = model;
		view.setVisible(true);
		nbJoueur = 0;
	
		//Boucle qui nous permet de remplacer les pseudos vides par les pseudos des joueurs.
		for (int i = 1; i < model.getLength(); i++) {
			view.getPseudo(i).setText(model.getPseudos()[i-1]);
		}
		
		//Idem pour les images.
		for (int i = 1; i < model.getLength(); i++) {
			view.getImg(i).setIcon(model.getImg(model.getImg()[i-1], false));
		}
		
		imgEnter();
		fonctionsBoutons();	
	}
	
	public void imgEnter() {
		view.getImg(1).addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(model.getLength() > 1 && view.getNumJoueur(1).getText().isEmpty() && nbJoueur < 4) {
					nbJoueur++;
					marqueNumJoueur(1, nbJoueur);
					view.getImg(1).setIcon(model.getImg(model.getImg()[0], true));
					plusDeDeuxJoueurs();
				}
			}
		});	
		
		view.getImg(2).addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(model.getLength() > 2 && view.getNumJoueur(2).getText().isEmpty() && nbJoueur < 4) {
					nbJoueur++;
					marqueNumJoueur(2, nbJoueur);
					view.getImg(2).setIcon(model.getImg(model.getImg()[1], true));
					plusDeDeuxJoueurs();
				}
			}
		});	
		
		view.getImg(3).addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(model.getLength() > 3 && view.getNumJoueur(3).getText().isEmpty() && nbJoueur < 4) {
					nbJoueur++;
					marqueNumJoueur(3,nbJoueur);
					view.getImg(3).setIcon(model.getImg(model.getImg()[2], true));
					plusDeDeuxJoueurs();
				}
			}
		});	
		
		view.getImg(4).addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(model.getLength() > 4 && view.getNumJoueur(4).getText().isEmpty() && nbJoueur < 4) {
					nbJoueur++;
					marqueNumJoueur(4, nbJoueur);
					view.getImg(4).setIcon(model.getImg(model.getImg()[3], true));
					plusDeDeuxJoueurs();
				}
			}
		});	
		
		view.getImg(5).addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(model.getLength() > 5 && view.getNumJoueur(5).getText().isEmpty() && nbJoueur < 4) {
					nbJoueur++;
					marqueNumJoueur(5, nbJoueur);
					view.getImg(5).setIcon(model.getImg(model.getImg()[4], true));
					plusDeDeuxJoueurs();
				}
			}
		});	
		
		view.getImg(6).addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(model.getLength() > 6 && view.getNumJoueur(6).getText().isEmpty() && nbJoueur < 4) {
					nbJoueur++;
					marqueNumJoueur(6, nbJoueur);
					view.getImg(6).setIcon(model.getImg(model.getImg()[5], true));
					plusDeDeuxJoueurs();
				}
			}
		});	
	}

	

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void fonctionsBoutons() {
		view.getQuit().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				System.exit(0);
			}
		});	
		
		view.getBack().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				MenuView menuView = new MenuView();
				
				MenuModel model = new MenuModel();
				
				MenuController controller = new MenuController(menuView, model);
				
				view.setVisible(false);
			}
		});	
		
		view.getCreerJoueur().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getCreerJoueur().setIcon(model.getCreerJoueurActive());
			}
		});	
		
		view.getCreerJoueur().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(model.getLength() > 6) {
					
					String msg = "<html>Vous avez atteint le nombre limite de joueurs !<br> "
							+ "Re-creer un joueur effacera les profils existants. <br> "
							+ "Etes-vous sur de vouloir continuer ?</html>";
					int reponse = JOptionPane.showConfirmDialog(null, msg, "Avertissement", JOptionPane.YES_NO_OPTION);
					if (reponse == JOptionPane.YES_OPTION) {
						CreerJoueurView creerJoueurView = new CreerJoueurView();
						CreerJoueurModel creerJoueurModel = new CreerJoueurModel();
						CreerJoueurController creerJoueurController = new CreerJoueurController(creerJoueurView, creerJoueurModel);
						view.setVisible(false);
				        }
					
				}
				else {
					CreerJoueurView creerJoueurView = new CreerJoueurView();
					CreerJoueurModel creerJoueurModel = new CreerJoueurModel();
					CreerJoueurController creerJoueurController = new CreerJoueurController(creerJoueurView, creerJoueurModel);
					view.setVisible(false);
				}	
			}
		});	
		
		view.getCollisionDetecter().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getCreerJoueur().setIcon(model.getCreerJoueur());
				if(nbJoueur > 1) {
					view.getLancerPartie().setIcon(model.getLancerPartie(false));
				}
			}
		});	
	}
	
	public void resetAll() {
		if(nbJoueur < 0) {
			for (int i = 1; i < model.getLength() + 1; i++) {
				view.getImg(i).setIcon(model.getImg(model.getImg()[i-1], false));
			}
		}
	}
	
	public void marqueNumJoueur(int i, int nbJoueur) {
		view.getNumJoueur(i).setText("J"+ nbJoueur);
	}
	
	public void plusDeDeuxJoueurs() {
		if(nbJoueur > 1) {
			view.getLancerPartie().setIcon(model.getLancerPartie(false));
			view.getLancerPartie().addMouseListener(new MouseAdapter(){
				public void mouseEntered(MouseEvent e){
					view.getLancerPartie().setIcon(model.getLancerPartie(true));
				}
				public void mousePressed(MouseEvent e){
					JeuView jeuView = new JeuView();
					JeuModel jeuModel = new JeuModel();
					JeuController jeuController = new JeuController(jeuView, jeuModel);
					view.setVisible(false);
				}
			});	
		}
	}
}
