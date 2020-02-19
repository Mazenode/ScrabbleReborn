package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Random;

import Model.CreerJoueurModel;
import Model.CreerPartieModel;
import Model.JeuModel;
import Model.Joueur;
import Model.MenuModel;
import View.CreerJoueurView;
import View.CreerPartieView;
import View.JeuView;
import View.MenuView;

public class CreerJoueurController {
	
	private CreerJoueurView view;
	private CreerJoueurModel model;
	private boolean imageBloquee;
	private int imageChoisie;
	private String pseudo;
	
	public CreerJoueurController(CreerJoueurView view, CreerJoueurModel model) {
		this.view = view;
		this.model = model;
		view.setVisible(true);
		
		//On initialise l'image a 0 (pas d'image) et on autorise la selection d'image
		imageChoisie = 0;
		imageBloquee = false;
		
		//Fonction qui permet de "surligner" en violet les images lorsque l'on passe la souris par dessus
		animImageEnter();
		
		//Fonction qui met imageBloquee a true et permet de debloquer la creation du joueur.
		//A partir de cette fonction, un profil joueur peut etre creer, meme s'il ne dispose pas de pseudo.
		animImagePressed();
		
		//Pas grand chose d'interessant ici, cette fonction gere les collisions avec le fond ainsi que le bouton quitter.
		fonctionsDiverses();
		
		/*! FONCTION LA PLUS IMPORTANTE !
		Permet de creer le profil du joueur en instanciant la classe Joueur, a qui on passe en parametres
		le pseudo ainsi que le numero de l'image selectionnee. Puis on sauvegarde cet objet dans un inputstream.
		Pour finir, la fonction redirige l'utilisateur vers CreerPartie.*/

		creerJoueur();

	}
	
	public void creerJoueur() {
		view.getBoutonJoueur().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if (imageBloquee) {
					Joueur joueur = new Joueur(view.getPseudo(), imageChoisie);
					
					FileOutputStream path;
					try {
							if(CreerPartieModel.length == 12) {
								path = new FileOutputStream("profils.txt");
							}
							else {
								path = new FileOutputStream("profils.txt", true);
							}
							
							PrintWriter pw = new PrintWriter(path);
							
							if(joueur.getPseudo().isEmpty()) {
								Random r = new Random();
								char a = (char)(r.nextInt(26) + 'a');
								char b = (char)(r.nextInt(26) + 'a');
								int c = (r.nextInt(9));
								
								pw.println(a + "" + b + "" + c);
							}
							else {
								pw.println(joueur.getPseudo());
							}
							
							pw.print(joueur.getNumImage());
							pw.println();
							pw.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					CreerPartieView creerPartieView = new CreerPartieView();
					CreerPartieModel creerPartieModel = new CreerPartieModel();
					CreerPartieController creerPartieController = new CreerPartieController(creerPartieView, creerPartieModel);
					view.setVisible(false);
				}
			}
		});
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void fonctionsDiverses() {
		view.getBoutonJoueur().addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(imageBloquee) {
					view.getBoutonJoueur().setIcon(model.getBoutonActive());
				}
			}
		});
		
		view.getTest().addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(imageBloquee) {
					view.getBoutonJoueur().setIcon(model.getImgJoueur());
				}
			}
		});
		
		view.getQuit().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				System.exit(0);
			}
		});	
		
		view.getBack().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				CreerPartieView creerPartieView = new CreerPartieView();
				CreerPartieModel creerPartieModel = new CreerPartieModel();
				CreerPartieController creerPartieController = new CreerPartieController(creerPartieView, creerPartieModel);
				view.setVisible(false);
				
			}
		});	
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void animImageEnter() {
		view.getLabelImg(1).addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!imageBloquee) {
					resetAll();
					view.getLabelImg(1).setIcon(model.getImgActive(1));
				}
			}
		});
		
		view.getLabelImg(2).addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!imageBloquee) {
					resetAll();
					view.getLabelImg(2).setIcon(model.getImgActive(2));
				}
			}
		});
		
		view.getLabelImg(3).addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!imageBloquee) {
					resetAll();
					view.getLabelImg(3).setIcon(model.getImgActive(3));
				}
			}
		});
		
		view.getLabelImg(4).addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!imageBloquee) {
					resetAll();
					view.getLabelImg(4).setIcon(model.getImgActive(4));
				}
			}
		});
		
		view.getLabelImg(5).addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!imageBloquee) {
					resetAll();
					view.getLabelImg(5).setIcon(model.getImgActive(5));
				}
			}
		});
		
		view.getLabelImg(6).addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!imageBloquee) {
					resetAll();
					view.getLabelImg(6).setIcon(model.getImgActive(6));
				}
			}
		});
		
		view.getLabelImg(7).addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!imageBloquee) {
					resetAll();
					view.getLabelImg(7).setIcon(model.getImgActive(7));
				}
			}
		});
		
		view.getLabelImg(8).addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!imageBloquee) {
					resetAll();
					view.getLabelImg(8).setIcon(model.getImgActive(8));
				}
			}
		});
		
		view.getLabelImg(9).addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!imageBloquee) {
					resetAll();
					view.getLabelImg(9).setIcon(model.getImgActive(9));
				}
			}
		});
		
		view.getLabelImg(10).addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!imageBloquee) {
					resetAll();
					view.getLabelImg(10).setIcon(model.getImgActive(10));
				}
			}
		});
		
		view.getLabelImg(11).addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!imageBloquee) {
					resetAll();
					view.getLabelImg(11).setIcon(model.getImgActive(11));
				}
			}
		});
		
		view.getLabelImg(12).addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!imageBloquee) {
					resetAll();
					view.getLabelImg(12).setIcon(model.getImgActive(12));
				}
			}
		});
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void animImagePressed() {
		view.getLabelImg(1).addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if (!imageBloquee) {
					resetAll();
					view.getLabelImg(1).setIcon(model.getImgClicked(1));
					imageBloquee = true;
					setDelock();
					imageChoisie = 1;
				}
			}
		});
		
		view.getLabelImg(2).addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if (!imageBloquee) {
					resetAll();
					view.getLabelImg(2).setIcon(model.getImgClicked(2));
					imageBloquee = true;
					setDelock();
					imageChoisie = 2;
				}
			}
		});
		
		view.getLabelImg(3).addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if (!imageBloquee) {
					resetAll();
					view.getLabelImg(3).setIcon(model.getImgClicked(3));
					imageBloquee = true;
					setDelock();
					imageChoisie = 3;
				}
			}
		});
		
		view.getLabelImg(4).addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if (!imageBloquee) {
					resetAll();
					view.getLabelImg(4).setIcon(model.getImgClicked(4));
					imageBloquee = true;
					setDelock();
					imageChoisie = 4;
				}
			}
		});
		
		view.getLabelImg(5).addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if (!imageBloquee) {
					resetAll();
					view.getLabelImg(5).setIcon(model.getImgClicked(5));
					imageBloquee = true;
					setDelock();
					imageChoisie = 5;
				}
			}
		});
		
		view.getLabelImg(6).addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if (!imageBloquee) {
					resetAll();
					view.getLabelImg(6).setIcon(model.getImgClicked(6));
					imageBloquee = true;
					setDelock();
					imageChoisie = 6;
				}
			}
		});
		
		view.getLabelImg(7).addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if (!imageBloquee) {
					resetAll();
					view.getLabelImg(7).setIcon(model.getImgClicked(7));
					imageBloquee = true;
					setDelock();
					imageChoisie = 7;
				}
			}
		});
		
		view.getLabelImg(8).addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if (!imageBloquee) {
					resetAll();
					view.getLabelImg(8).setIcon(model.getImgClicked(8));
					imageBloquee = true;
					setDelock();
					imageChoisie = 8;
				}
			}
		});
		
		view.getLabelImg(9).addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if (!imageBloquee) {
					resetAll();
					view.getLabelImg(9).setIcon(model.getImgClicked(9));
					imageBloquee = true;
					setDelock();
					imageChoisie = 9;
				}
			}
		});
		
		view.getLabelImg(10).addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if (!imageBloquee) {
					resetAll();
					view.getLabelImg(10).setIcon(model.getImgClicked(10));
					imageBloquee = true;
					setDelock();
					imageChoisie = 10;
				}
			}
		});
		
		view.getLabelImg(11).addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if (!imageBloquee) {
					resetAll();
					view.getLabelImg(11).setIcon(model.getImgClicked(11));
					imageBloquee = true;
					setDelock();
					imageChoisie = 11;
				}
			}
		});
		
		view.getLabelImg(12).addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if (!imageBloquee) {
					resetAll();
					view.getLabelImg(12).setIcon(model.getImgClicked(12));
					imageBloquee = true;
					setDelock();
					imageChoisie = 12;
				}	
			}
		});
	}
	
	public void resetAll() {
		for(int i = 1; i < 13; i++) {
			view.getLabelImg(i).setIcon(view.getImg(i));
		}
	}
	
	public void setDelock() {
		view.getAide().setVisible(false);
		view.getExplications().setVisible(false);
		view.getBoutonJoueur().setIcon(model.getImgJoueur());
	}
}
