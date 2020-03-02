package Controller;

import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	private String[] setJoueur;
	private int etatBloquant;

	public CreerPartieController(CreerPartieView view, CreerPartieModel model) {
		this.view = view;
		this.model = model;
		view.setVisible(true);
		nbJoueur = 0;
		setJoueur = new String[4];	
		etatBloquant = 0;		
	
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
					setJoueur(1);
					view.getImg(1).setIcon(model.getImg(model.getImg()[0], true));
					creerPartie();
				}
			}
		});	
		
		view.getImg(2).addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(model.getLength() > 2 && view.getNumJoueur(2).getText().isEmpty() && nbJoueur < 4) {
					nbJoueur++;
					marqueNumJoueur(2, nbJoueur);
					setJoueur(2);
					view.getImg(2).setIcon(model.getImg(model.getImg()[1], true));
					creerPartie();
				}
			}
		});	
		
		view.getImg(3).addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(model.getLength() > 3 && view.getNumJoueur(3).getText().isEmpty() && nbJoueur < 4) {
					nbJoueur++;			
					marqueNumJoueur(3,nbJoueur);
					setJoueur(3);
					view.getImg(3).setIcon(model.getImg(model.getImg()[2], true));
					creerPartie();
				}
			}
		});	
		
		view.getImg(4).addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(model.getLength() > 4 && view.getNumJoueur(4).getText().isEmpty() && nbJoueur < 4) {
					nbJoueur++;
					marqueNumJoueur(4, nbJoueur);
					setJoueur(4);
					view.getImg(4).setIcon(model.getImg(model.getImg()[3], true));
					creerPartie();
				}
			}
		});	
		
		view.getImg(5).addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(model.getLength() > 5 && view.getNumJoueur(5).getText().isEmpty() && nbJoueur < 4) {
					nbJoueur++;
					marqueNumJoueur(5, nbJoueur);
					setJoueur(5);
					view.getImg(5).setIcon(model.getImg(model.getImg()[4], true));
					creerPartie();
				}
			}
		});	
		
		view.getImg(6).addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(model.getLength() > 6 && view.getNumJoueur(6).getText().isEmpty() && nbJoueur < 4) {
					nbJoueur++;
					marqueNumJoueur(6, nbJoueur);
					setJoueur(6);
					view.getImg(6).setIcon(model.getImg(model.getImg()[5], true));
					creerPartie();
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
	
	public void creerPartie() {
		if(nbJoueur > 1 && etatBloquant < 1) {
			etatBloquant++;

			view.getLancerPartie().setIcon(model.getLancerPartie(false));
			view.getLancerPartie().addMouseListener(new MouseAdapter(){
				public void mouseEntered(MouseEvent e){
					view.getLancerPartie().setIcon(model.getLancerPartie(true));
				}
				public void mousePressed(MouseEvent e){
					
					
					try {
						if( getNumPartie() == 6) {
							String msg = "<html>Vous avez atteint le nombre limite de parties !<br> "
									+ "Re-creer une partie effacera les sauvegardes precedentes. <br> "
									+ "Etes-vous sur de vouloir continuer ?</html>";
							int reponse = JOptionPane.showConfirmDialog(null, msg, "Avertissement", JOptionPane.YES_NO_OPTION);
							if (reponse == JOptionPane.YES_OPTION) {
								ecritDonnees(true);
						    }
							
						}
						else {
							
							ecritDonnees(false);
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
			});	
		}
	}
	
	public int getNumPartie() throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader("parties.txt"));
		
		int length = 0;
		
	    String line;
	    
	    while ((line = buffer.readLine()) != null) {
	        length += 1;
	        
	    }

	    switch(length ) {
			case 1:
				return 0;
			case 14:
				return 1;
			case 27:
				return 2;
			case 40:
				return 3;
			case 53:
				return 4;
			case 66:
				return 5;
			case 79:
				return 6;
		}
		return -1;
	}
	
	public void setJoueur(int i) {
		i -= 1;
		if(nbJoueur == 1) {
			setJoueur[0] = model.getPseudos()[i];
		}
		else if(nbJoueur == 2) {
			setJoueur[1] = model.getPseudos()[i];
		}
		else if(nbJoueur == 3) {
			setJoueur[2] = model.getPseudos()[i];
		}
		else if(nbJoueur == 4) {
			setJoueur[3] = model.getPseudos()[i];
		}
	}
	
	public void ecritDonnees(boolean plein) {
		try {
			FileOutputStream path;
			if(plein) {
				path = new FileOutputStream("parties.txt");
			}
			else {
				path = new FileOutputStream("parties.txt", true);
			}
			
			PrintWriter pw = new PrintWriter(path);
			
			
			try {
				if(plein) {
					pw.println();
					pw.println("Partie 0");
				}
				else {
					pw.println("Partie " + getNumPartie());
				}
				Date date = new Date();  
			    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");  
			    String strDate= formatter.format(date);  
				pw.println(strDate);
				
				//Nombre de tours
				pw.println("0");
				
				//Nombre de lettres restantes
				pw.println("102");
				
				for(int i = 1; i < 5; i++) {
					pw.println(setJoueur[i - 1]);
					pw.println("0");
				}
				
				pw.println("#################################################################################################################################################################################################################################");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			pw.close();
			
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		view.setVisible(false);
		
		JeuView jeuView = new JeuView();
		JeuModel jeuModel = new JeuModel();
		try {
			JeuController jeuController = new JeuController(jeuView, jeuModel, getNumPartie());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
