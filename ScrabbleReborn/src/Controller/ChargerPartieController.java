package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.ChargerPartieModel;
import Model.CreerPartieModel;
import Model.MenuModel;
import View.ChargerPartieView;
import View.CreerPartieView;
import View.MenuView;

public class ChargerPartieController {
	
	private ChargerPartieView view;
	private ChargerPartieModel model;
	private boolean blocked;
	
	public ChargerPartieController(ChargerPartieView view, ChargerPartieModel model) {
		this.view = view;
		this.model = model;
		view.setVisible(true);
		blocked = false;
		
		animPartie();
		fonctionsDiverses();
	}
	
	public void setDelock() {
		view.boutonLancerLaPartie.setIcon(model.getLancerPartie());
		view.boutonLancerLaPartie.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				view.boutonLancerLaPartie.setIcon(model.getLancerPartieActive());
			}
		});
		
		view.cache.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				view.boutonLancerLaPartie.setIcon(model.getLancerPartie());
			}
		});
	}
	
	public void fonctionsDiverses() {
		view.boutonQuit.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				System.exit(0);
			}
		});	
		
		view.back.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				MenuView menuView = new MenuView();
				MenuModel menuModel = new MenuModel();
				MenuController controller = new MenuController(menuView, menuModel);
				view.setVisible(false);
				
			}
		});	
	}
	
	public void animPartie() {

		view.panel_1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!blocked) {
					resetAll();
					view.fond1.setIcon(model.getImgFondActive());
				}
			}
			public void mousePressed(MouseEvent e){
				if(!blocked) {
					view.fond1.setIcon(model.getImgFondClicked());
					blocked = true;
					setDelock();
				}
			}
		});
		
		view.panel_2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!blocked) {
					resetAll();
					view.fond2.setIcon(model.getImgFondActive());
				}
			}
			public void mousePressed(MouseEvent e){
				if(!blocked) {
					view.fond2.setIcon(model.getImgFondClicked());
					blocked = true;
					setDelock();
				}
			}
		});
		
		view.panel_3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!blocked) {
					resetAll();
					view.fond3.setIcon(model.getImgFondActive());
				}
			}
			public void mousePressed(MouseEvent e){
				if(!blocked) {
					view.fond3.setIcon(model.getImgFondClicked());
					blocked = true;
					setDelock();
				}
			}
		});
		
		view.panel_4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!blocked) {
					resetAll();
					view.fond4.setIcon(model.getImgFondActive());
				}
			}
			public void mousePressed(MouseEvent e){
				if(!blocked) {
					view.fond4.setIcon(model.getImgFondClicked());
					blocked = true;
					setDelock();
				}
			}
		});
		
		view.panel_5.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!blocked) {
					resetAll();
					view.fond5.setIcon(model.getImgFondActive());
				}
			}
			public void mousePressed(MouseEvent e){
				if(!blocked) {
					view.fond5.setIcon(model.getImgFondClicked());
					blocked = true;
					setDelock();
				}
			}
		});
		
		view.panel_6.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!blocked) {
					resetAll();
					view.fond6.setIcon(model.getImgFondActive());
				}
			}
			public void mousePressed(MouseEvent e){
				if(!blocked) {
					view.fond6.setIcon(model.getImgFondClicked());
					blocked = true;
					setDelock();
				}
			}
		});
	}
	
	public void resetAll() {
		view.fond1.setIcon(view.getImageFond());
		view.fond2.setIcon(view.getImageFond());
		view.fond3.setIcon(view.getImageFond());
		view.fond4.setIcon(view.getImageFond());
		view.fond5.setIcon(view.getImageFond());
		view.fond6.setIcon(view.getImageFond());
	}
}
