package Controller;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
	private String[] listeResultats;
	private static ArrayList<Joueur> joueurs;
	private String [] data;
	private Joueur joueurActuel;
	
	public JeuController(JeuView view, JeuModel model, int numPartie) {
		this.view = view;
		this.model = model;
		this.numPartie = numPartie;
		listeResultats = new String [9];
		data = new String[14];
		joueurAyantJoue = 0;
		compteurJoueur = 0;
		lettreRestantes = 999;
		view.setVisible(true);
		chargerPartie = new ChargerPartieModel();

		//Fonctions de chargement
		chargerPlateau();
		chargerScores();
		//chargerNumTour();
		//setData();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Joueur Mathieu = new Joueur("Mathieu",4);///////////////////////////////////à supprimer////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		placerLettre();
		fonctionsDiverses();
		initTour();
		System.out.println(joueurs.get(0).getPseudo());
	}
	

	public void sauvegarder()  {
		setData();
		try {
			int indice = 0;
			if(numPartie == 1) {
				indice = 1;
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
		
		data[12] = "test";
	}
	
	public static void setVariable(int nombreLignes, String data) throws IOException {
	    Path path = Paths.get("parties.txt");
	    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
	    lines.set(nombreLignes - 1, data);
	    Files.write(path, lines, StandardCharsets.UTF_8);
	}

	public void initTour() {
		if(joueurAyantJoue == 0) {
			joueurActuel = joueurs.get(0);
			view.getTourDuJoueur().setText(joueurs.get(0).getPseudo());
			view.getImgJoueur().setIcon(model.getImgJoueur(1));
			joueurAyantJoue++;
		}

		else if(joueurAyantJoue == 1) {
			if(compteurJoueur == 2 || compteurJoueur == 3 || compteurJoueur == 4) {
				joueurActuel = joueurs.get(1);
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
	
	public void print() {
		for(int i = 0; i < 225; i++) {
			System.out.print(view.grille.getListe().get(i).getVal());
			
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
				print();
				Random rand = new Random();
				Joueur.getListeJoueur().get(0).printLettrePos();
				//compteur = Joueur.getListeJoueur().get(0).getListeLettrePos().size();
				//Model.JeuModel.setNbrDeLettreRestante(compteur);
				//view.getLettresRestantes().setText(Integer.toString(JeuModel.getNbrDeLettreRestante()));
				try {
					if(model.lecture()){
						compteur = Joueur.getListeJoueur().get(0).getListeLettrePos().size();
						JeuModel.setNbrDeLettreRestante(compteur);
						view.getLettresRestantes().setText(Integer.toString(JeuModel.getNbrDeLettreRestante()));
						//for (int i = 0; i <compteur ; i++) {
						//element = rand.nextInt(model.getListeLettreAlp().length);
							//view.lettre1 = new LettreModel(model.getListeLettreAlp()[element]);
							//view.getLettres().add(view.lettre1);
							//view.getLettres().revalidate();*/
						
						//}
						/* On remet les variables � zero */
						Joueur.getListeJoueur().get(0).isOnLine = false; 
						Joueur.getListeJoueur().get(0).isOnCol = false;
						Joueur.getListeJoueur().get(0).firstPos=-1;
						
						/* Pour chaque lettre, si elle a ete pose, on r�cupere la pos ou elle a ete pos et on fige l'image */
						if(view.lettre1.posLettre!=300) {
							for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
								if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre1.posLettre) {
									LettreModel lettre = new LettreModel(view.lettre1.val);
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).add(lettre,0);
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = lettre.val;
									Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
									break;
								}
							}
							/* puis on remet une nouvelle lettre dans le chevalet */
							element = rand.nextInt(model.getListeLettreAlp().length);
							view.lettre1.val = model.getListeLettreAlp()[element];
							view.lettre1.image = new ImageIcon(this.getClass().getResource("/images/"+view.lettre1.val+".png"));
							view.lettre1.setIcon(view.lettre4.image);
							view.lettre1.posLettre=300;
							view.lettre1.setHorizontalAlignment(SwingConstants.CENTER);
							view.getLettres().add(view.lettre1);
							view.getLettres().revalidate();
						}
						/* Pour chaque lettre, si elle a ete pose, on r�cupere la pos ou elle a ete pos et on fige l'image */
						if(view.lettre2.posLettre!=300) {
							for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
								if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre2.posLettre) {
									LettreModel lettre = new LettreModel(view.lettre2.val);
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).add(lettre,0);
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = lettre.val;
									Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
									break;
								}
							}
							/* puis on remet une nouvelle lettre dans le chevalet */
							element = rand.nextInt(model.getListeLettreAlp().length);
							view.lettre2.val = model.getListeLettreAlp()[element];
							view.lettre2.image = new ImageIcon(this.getClass().getResource("/images/"+view.lettre2.val+".png"));
							view.lettre2.setIcon(view.lettre2.image);
							view.lettre2.posLettre=300;
							view.lettre2.setHorizontalAlignment(SwingConstants.CENTER);
							view.getLettres().add(view.lettre2);
							view.getLettres().revalidate();
						}
						/* Pour chaque lettre, si elle a ete pose, on r�cupere la pos ou elle a ete pos et on fige l'image */
						if(view.lettre3.posLettre!=300) {
							for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
								if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre3.posLettre) {
									LettreModel lettre = new LettreModel(view.lettre3.val);
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).add(lettre,0);
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = lettre.val;
									Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
									break;
								}
							}
							/* puis on remet une nouvelle lettre dans le chevalet */
							element = rand.nextInt(model.getListeLettreAlp().length);
							view.lettre3.val = model.getListeLettreAlp()[element];
							view.lettre3.image = new ImageIcon(this.getClass().getResource("/images/"+view.lettre3.val+".png"));
							view.lettre3.setIcon(view.lettre3.image);
							view.lettre3.posLettre=300;
							view.lettre3.setHorizontalAlignment(SwingConstants.CENTER);
							view.getLettres().add(view.lettre3);
							view.getLettres().revalidate();
						}
						/* Pour chaque lettre, si elle a ete pose, on r�cupere la pos ou elle a ete pos et on fige l'image */
						if(view.lettre4.posLettre!=300) {
							for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
								if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre4.posLettre) {
									LettreModel lettre = new LettreModel(view.lettre4.val);
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).add(lettre,0);
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = lettre.val;
									Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
									break;
								}
							}
							/* puis on remet une nouvelle lettre dans le chevalet */
							element = rand.nextInt(model.getListeLettreAlp().length);
							view.lettre4.val = model.getListeLettreAlp()[element];
							view.lettre4.image = new ImageIcon(this.getClass().getResource("/images/"+view.lettre4.val+".png"));
							view.lettre4.setIcon(view.lettre4.image);
							view.lettre4.posLettre=300;
							view.lettre4.setHorizontalAlignment(SwingConstants.CENTER);
							view.getLettres().add(view.lettre4);
							view.getLettres().revalidate();
						}
						/* Pour chaque lettre, si elle a ete pose, on r�cupere la pos ou elle a ete pos et on fige l'image */
						if(view.lettre5.posLettre!=300) {
							for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
								if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre5.posLettre) {
									LettreModel lettre = new LettreModel(view.lettre5.val);
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).add(lettre,0);
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = lettre.val;
									Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
									break;
								}
							}
							/* puis on remet une nouvelle lettre dans le chevalet */
							element = rand.nextInt(model.getListeLettreAlp().length);
							view.lettre5.val = model.getListeLettreAlp()[element];
							view.lettre5.image = new ImageIcon(this.getClass().getResource("/images/"+view.lettre5.val+".png"));
							view.lettre5.setIcon(view.lettre5.image);
							view.lettre5.posLettre=300;
							view.lettre5.setHorizontalAlignment(SwingConstants.CENTER);
							view.getLettres().add(view.lettre5);
							view.getLettres().revalidate();
						}
						/* Pour chaque lettre, si elle a ete pose, on r�cupere la pos ou elle a ete pos et on fige l'image */
						if(view.lettre6.posLettre!=300) {
							for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
								if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre6.posLettre) {
									LettreModel lettre = new LettreModel(view.lettre6.val);
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).add(lettre,0);
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = lettre.val;
									Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
									break;
								}
							}
							/* puis on remet une nouvelle lettre dans le chevalet */
							element = rand.nextInt(model.getListeLettreAlp().length);
							view.lettre6.val = model.getListeLettreAlp()[element];
							view.lettre6.image = new ImageIcon(this.getClass().getResource("/images/"+view.lettre6.val+".png"));
							view.lettre6.setIcon(view.lettre6.image);
							view.lettre6.posLettre=300;
							view.lettre6.setHorizontalAlignment(SwingConstants.CENTER);
							view.getLettres().add(view.lettre6);
							view.getLettres().revalidate();
						}
						/* Pour chaque lettre, si elle a ete pose, on r�cupere la pos ou elle a ete pos et on fige l'image */
						if(view.lettre7.posLettre!=300) {
							for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
								if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre7.posLettre) {
									LettreModel lettre = new LettreModel(view.lettre7.val);
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).add(lettre,0);
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = lettre.val;
									Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
									break;
								}
							}
							/* puis on remet une nouvelle lettre dans le chevalet */
							element = rand.nextInt(model.getListeLettreAlp().length);
							view.lettre7.val = model.getListeLettreAlp()[element];
							view.lettre7.image = new ImageIcon(this.getClass().getResource("/images/"+view.lettre7.val+".png"));
							view.lettre7.setIcon(view.lettre4.image);
							view.lettre7.posLettre=300;
							view.lettre7.setHorizontalAlignment(SwingConstants.CENTER);
							view.getLettres().add(view.lettre7);
							view.getLettres().revalidate();
						}
					}else {
						Joueur.getListeJoueur().get(0).isOnLine = false; 
						Joueur.getListeJoueur().get(0).isOnCol = false;
						Joueur.getListeJoueur().get(0).firstPos=-1;
						if(view.lettre1.posLettre!=300) {
							for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
								if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre1.posLettre) {
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = '#';
									Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
									break;
								}
							}
							view.lettre1.posLettre=300;
							view.lettre1.setBounds(0,0,45,45);
							view.lettre1.setHorizontalAlignment(SwingConstants.CENTER);
							view.getLettres().add(view.lettre1);
							view.getLettres().revalidate();
						}
						if(view.lettre2.posLettre!=300) {
							for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
								if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre2.posLettre) {
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = '#';
									Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
									break;
								}
							}
							view.lettre2.posLettre=300;
							view.lettre2.setBounds(0,0,45,45);
							view.lettre2.setHorizontalAlignment(SwingConstants.CENTER);
							view.getLettres().add(view.lettre2);
							view.getLettres().revalidate();
						}
						if(view.lettre3.posLettre!=300) {
							for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
								if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre3.posLettre) {
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = '#';
									Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
									break;
								}
							}
							view.lettre3.posLettre=300;
							view.lettre3.setBounds(0,0,45,45);
							view.lettre3.setHorizontalAlignment(SwingConstants.CENTER);
							view.getLettres().add(view.lettre3);
							view.getLettres().revalidate();
						}
						if(view.lettre4.posLettre!=300) {
							for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
								if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre4.posLettre) {
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = '#';
									Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
									break;
								}
							}
							view.lettre4.posLettre=300;
							view.lettre4.setBounds(0,0,45,45);
							view.lettre4.setHorizontalAlignment(SwingConstants.CENTER);
							view.getLettres().add(view.lettre4);
							view.getLettres().revalidate();
						}
						if(view.lettre5.posLettre!=300) {
							for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
								if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre5.posLettre) {
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = '#';
									Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
									break;
								}
							}
							view.lettre5.posLettre=300;
							view.lettre5.setBounds(0,0,45,45);
							view.lettre5.setHorizontalAlignment(SwingConstants.CENTER);
							view.getLettres().add(view.lettre5);
							view.getLettres().revalidate();
						}
						if(view.lettre6.posLettre!=300) {
							for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
								if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre6.posLettre) {
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = '#';
									Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
									break;
								}
							}
							view.lettre6.posLettre=300;
							view.lettre6.setBounds(0,0,45,45);
							view.lettre6.setHorizontalAlignment(SwingConstants.CENTER);
							view.getLettres().add(view.lettre6);
							view.getLettres().revalidate();
						}
						if(view.lettre7.posLettre!=300) {
							for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
								if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre7.posLettre) {
									view.getGrille().getListe().get(Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)).val = '#';
									Joueur.getListeJoueur().get(0).getListeLettrePos().remove(i);
									break;
								}
							}
							view.lettre7.posLettre=300;
							view.lettre7.setBounds(0,0,45,45);
							view.lettre7.setHorizontalAlignment(SwingConstants.CENTER);
							view.getLettres().add(view.lettre7);
							view.getLettres().revalidate();
						}
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				view.getGrille().revalidate();
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
				/* si la case etait pose dans la grille, on l enleve puis on donne le droit de refaire la pose de lettre */
				if(view.lettre1.posLettre!=300) {
					for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
						if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre1.posLettre) {
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
					view.lettre1.posLettre=300;
					view.lettre1.setHorizontalAlignment(SwingConstants.CENTER);
					view.getLettres().add(view.lettre1);
					view.getLettres().revalidate();
				}
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
				/* si la case etait pose dans la grille, on l enleve puis on donne le droit de refaire la pose de lettre */
				if(view.lettre2.posLettre!=300) {
					for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
						if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre2.posLettre) {
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
					view.lettre2.posLettre=300;
					view.lettre2.setHorizontalAlignment(SwingConstants.CENTER);
					view.getLettres().add(view.lettre2);
					view.getLettres().revalidate();
				}
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
				/* si la case etait pose dans la grille, on l enleve puis on donne le droit de refaire la pose de lettre */
				if(view.lettre3.posLettre!=300) {
					for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
						if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre3.posLettre) {
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
					view.lettre3.posLettre=300;
					view.lettre3.setHorizontalAlignment(SwingConstants.CENTER);
					view.getLettres().add(view.lettre3);
					view.getLettres().revalidate();
				}
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
				/* si la case etait pose dans la grille, on l enleve puis on donne le droit de refaire la pose de lettre */
				if(view.lettre4.posLettre!=300) {
					for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
						if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre4.posLettre) {
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
					view.lettre4.posLettre=300;
					view.lettre4.setHorizontalAlignment(SwingConstants.CENTER);
					view.getLettres().add(view.lettre4);
					view.getLettres().revalidate();
				}
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
				/* si la case etait pose dans la grille, on l enleve puis on donne le droit de refaire la pose de lettre */
				if(view.lettre5.posLettre!=300) {
					for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
						if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre5.posLettre) {
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
					view.lettre5.posLettre=300;
					view.lettre5.setHorizontalAlignment(SwingConstants.CENTER);
					view.getLettres().add(view.lettre5);
					view.getLettres().revalidate();
				}
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
				/* si la case etait pose dans la grille, on l enleve puis on donne le droit de refaire la pose de lettre */
				if(view.lettre6.posLettre!=300) {
					for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
						if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre6.posLettre) {
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
					view.lettre6.posLettre=300;
					view.lettre6.setHorizontalAlignment(SwingConstants.CENTER);
					view.getLettres().add(view.lettre6);
					view.getLettres().revalidate();
				}
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
				/* si la case etait pose dans la grille, on l enleve puis on donne le droit de refaire la pose de lettre */
				if(view.lettre7.posLettre!=300) {
					for(int i=0; i<Joueur.getListeJoueur().get(0).getListeLettrePos().size(); i++) {
						if (Joueur.getListeJoueur().get(0).getListeLettrePos().get(i)==view.lettre7.posLettre) {
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
					view.lettre7.posLettre=300;
					view.lettre7.setHorizontalAlignment(SwingConstants.CENTER);
					view.getLettres().add(view.lettre7);
					view.getLettres().revalidate();
				}
				view.lettre7.setBounds(0,0,45,45);
				view.getLettreMove().add(view.lettre7,0);
				view.getLettreMove().setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-((width-1000)/2)-22,(int)MouseInfo.getPointerInfo().getLocation().getY()-((height-800)/2)-22,45,45);
			}
		});
	}

	public int getCompteur(){
		return compteur;
	}

}
