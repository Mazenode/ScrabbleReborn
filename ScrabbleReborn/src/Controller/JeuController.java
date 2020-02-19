package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.CreerPartieModel;
import Model.JeuModel;
import Model.MenuModel;
import View.CreerPartieView;
import View.JeuView;
import View.MenuView;

public class JeuController {
	
	private JeuView view;
	private JeuModel model;
	
	public JeuController(JeuView view, JeuModel model, int numPartie) {
		this.view = view;
		this.model = model;
		view.setVisible(true);
		
		view.getGrille().getListe().get(0).getButton().setIcon(model.getImgLettre('n'));
		
		view.getBoutonSauvegarder().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getBoutonSauvegarder().setIcon(model.getSauvegarderActive());

			}
			public void mousePressed(MouseEvent e){
				sauvegarder();

			}
		});	
		
		view.getBack().addMouseListener(new MouseAdapter(){
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
	}
	
	public void sauvegarder() {
		
	}
}
