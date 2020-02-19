package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.ChargerPartieModel;
import Model.CreerPartieModel;
import Model.MenuModel;
import View.ChargerPartieView;
import View.CreerPartieView;
import View.MenuView;

public class MenuController {
	
	private MenuView view;
	private MenuModel model;
	
	public MenuController(MenuView view, MenuModel model) {
		this.view = view;
		this.model = model;
		view.setVisible(true);
		
		view.getBoutonCreer().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getBoutonCreer().setIcon(model.getBoutonCreerActive());
				}
			});		
		
		view.getBoutonCharger().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getBoutonCharger().setIcon(model.getBoutonChargerActive());
				}
			});	
		
		view.getBg().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getBoutonCharger().setIcon(view.imgBoutonCharger());
				view.getBoutonCreer().setIcon(view.imgBoutonCreer());
				}
			});	
		
		view.getQuit().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				System.exit(0);
			}
		});	

		view.getBoutonCreer().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				CreerPartieView creerPartieView = new CreerPartieView();
				CreerPartieModel creerPartieModel = new CreerPartieModel();
				CreerPartieController creerPartieController = new CreerPartieController(creerPartieView, creerPartieModel);
				view.setVisible(false);
			}
		});	
		
		view.getBoutonCharger().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				ChargerPartieView chargerPartieView = new ChargerPartieView();
				ChargerPartieModel chargerPartieModel = new ChargerPartieModel();
				ChargerPartieController chargerPartieController = new ChargerPartieController(chargerPartieView, chargerPartieModel);
				view.setVisible(false);
			}
		});	
		
	}
}
