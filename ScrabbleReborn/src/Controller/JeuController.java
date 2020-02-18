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
	
	public JeuController(JeuView view, JeuModel model) {
		this.view = view;
		this.model = model;
		view.setVisible(true);
		
		view.getGrille().getListe().get(0).getButton().setIcon(model.getImgLettre('n'));
		view.getGrille().getListe().get(1).getButton().setIcon(model.getImgLettre('i'));
		view.getGrille().getListe().get(2).getButton().setIcon(model.getImgLettre('q'));
		view.getGrille().getListe().get(3).getButton().setIcon(model.getImgLettre('u'));
		view.getGrille().getListe().get(4).getButton().setIcon(model.getImgLettre('e'));
		view.getGrille().getListe().get(6).getButton().setIcon(model.getImgLettre('l'));
		view.getGrille().getListe().get(7).getButton().setIcon(model.getImgLettre('a'));
		view.getGrille().getListe().get(9).getButton().setIcon(model.getImgLettre('p'));
		view.getGrille().getListe().get(10).getButton().setIcon(model.getImgLettre('o'));
		view.getGrille().getListe().get(11).getButton().setIcon(model.getImgLettre('l'));
		view.getGrille().getListe().get(12).getButton().setIcon(model.getImgLettre('i'));
		view.getGrille().getListe().get(13).getButton().setIcon(model.getImgLettre('c'));
		view.getGrille().getListe().get(14).getButton().setIcon(model.getImgLettre('e'));
		view.getGrille().getListe().get(30).getButton().setIcon(model.getImgLettre('v'));
		view.getGrille().getListe().get(31).getButton().setIcon(model.getImgLettre('i'));
		view.getGrille().getListe().get(32).getButton().setIcon(model.getImgLettre('v'));
		view.getGrille().getListe().get(33).getButton().setIcon(model.getImgLettre('e'));
		view.getGrille().getListe().get(35).getButton().setIcon(model.getImgLettre('l'));
		view.getGrille().getListe().get(36).getButton().setIcon(model.getImgLettre('a'));
		view.getGrille().getListe().get(38).getButton().setIcon(model.getImgLettre('g'));
		view.getGrille().getListe().get(39).getButton().setIcon(model.getImgLettre('u'));
		view.getGrille().getListe().get(40).getButton().setIcon(model.getImgLettre('e'));
		view.getGrille().getListe().get(41).getButton().setIcon(model.getImgLettre('d'));
		view.getGrille().getListe().get(42).getButton().setIcon(model.getImgLettre('r'));
		view.getGrille().getListe().get(43).getButton().setIcon(model.getImgLettre('o'));
		
		view.getBack().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				MenuView view = new MenuView();
				
				MenuModel model = new MenuModel();
				
				MenuController controller = new MenuController(view, model);
				view.setVisible(false);
				
			}
		});	
	}
}
