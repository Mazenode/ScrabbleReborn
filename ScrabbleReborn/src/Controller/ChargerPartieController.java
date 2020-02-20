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
		//this.view.c1.show(this.view.sous_panel_1, "2");
		blocked = false;
		chargerPartie();
		animPartie();
		fonctionsDiverses();
	}
	
	public void chargerPartie() {
		setInfos();
		switch(model.getNbParties()) {
			case 0:
				view.c1.show(view.sous_panel_1, "2");
				view.c2.show(view.sous_panel_2, "2");
				view.c3.show(view.sous_panel_3, "2");
				view.c4.show(view.sous_panel_4, "2");
				view.c5.show(view.sous_panel_5, "2");
				view.c6.show(view.sous_panel_6, "2");
				break;
			case 1:
				view.c1.show(view.sous_panel_1, "1");
				view.c2.show(view.sous_panel_2, "2");
				view.c3.show(view.sous_panel_3, "2");
				view.c4.show(view.sous_panel_4, "2");
				view.c5.show(view.sous_panel_5, "2");
				view.c6.show(view.sous_panel_6, "2");
				break;
			case 2:
				view.c1.show(view.sous_panel_1, "1");
				view.c2.show(view.sous_panel_2, "1");
				view.c3.show(view.sous_panel_3, "2");
				view.c4.show(view.sous_panel_4, "2");
				view.c5.show(view.sous_panel_5, "2");
				view.c6.show(view.sous_panel_6, "2");
				break;
			case 3:
				view.c1.show(view.sous_panel_1, "1");
				view.c2.show(view.sous_panel_2, "1");
				view.c3.show(view.sous_panel_3, "1");
				view.c4.show(view.sous_panel_4, "2");
				view.c5.show(view.sous_panel_5, "2");
				view.c6.show(view.sous_panel_6, "2");
				break;
			case 4:
				view.c1.show(view.sous_panel_1, "1");
				view.c2.show(view.sous_panel_2, "1");
				view.c3.show(view.sous_panel_3, "1");
				view.c4.show(view.sous_panel_4, "1");
				view.c5.show(view.sous_panel_5, "2");
				view.c6.show(view.sous_panel_6, "2");
				break;
			case 5:
				view.c1.show(view.sous_panel_1, "1");
				view.c2.show(view.sous_panel_2, "1");
				view.c3.show(view.sous_panel_3, "1");
				view.c4.show(view.sous_panel_4, "1");
				view.c5.show(view.sous_panel_5, "1");
				view.c6.show(view.sous_panel_6, "2");
				break;
			case 6:
				view.c1.show(view.sous_panel_1, "1");
				view.c2.show(view.sous_panel_2, "1");
				view.c3.show(view.sous_panel_3, "1");
				view.c4.show(view.sous_panel_4, "1");
				view.c5.show(view.sous_panel_5, "1");
				view.c6.show(view.sous_panel_6, "1");
				break;
		}
	}
	
	public void setInfos() {
		int j = 1;
		int h = 2;
		
		for(int i = 1; i < model.getNbParties()+1 ; i ++) {
			view.getDates(i).setText(model.infosParties[j]);
			view.getNumTours(i).setText(model.infosParties[h]);
			j+=4;
			h+=4;
		}
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
				if(!blocked && model.getNbParties() > 0) {
					resetAll();
					view.fond1.setIcon(model.getImgFondActive());
				}
			}
			public void mousePressed(MouseEvent e){
				if(!blocked && model.getNbParties() > 0) {
					view.fond1.setIcon(model.getImgFondClicked());
					blocked = true;
					setDelock();
				}
			}
		});
		
		view.panel_2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!blocked && model.getNbParties() > 1) {
					resetAll();
					view.fond2.setIcon(model.getImgFondActive());
				}
			}
			public void mousePressed(MouseEvent e){
				if(!blocked && model.getNbParties() > 1) {
					view.fond2.setIcon(model.getImgFondClicked());
					blocked = true;
					setDelock();
				}
			}
		});
		
		view.panel_3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!blocked && model.getNbParties() > 2) {
					resetAll();
					view.fond3.setIcon(model.getImgFondActive());
				}
			}
			public void mousePressed(MouseEvent e){
				if(!blocked && model.getNbParties() > 2) {
					view.fond3.setIcon(model.getImgFondClicked());
					blocked = true;
					setDelock();
				}
			}
		});
		
		view.panel_4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!blocked && model.getNbParties() > 3) {
					resetAll();
					view.fond4.setIcon(model.getImgFondActive());
				}
			}
			public void mousePressed(MouseEvent e){
				if(!blocked && model.getNbParties() > 3) {
					view.fond4.setIcon(model.getImgFondClicked());
					blocked = true;
					setDelock();
				}
			}
		});
		
		view.panel_5.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!blocked && model.getNbParties() > 4) {
					resetAll();
					view.fond5.setIcon(model.getImgFondActive());
				}
			}
			public void mousePressed(MouseEvent e){
				if(!blocked && model.getNbParties() > 4) {
					view.fond5.setIcon(model.getImgFondClicked());
					blocked = true;
					setDelock();
				}
			}
		});
		
		view.panel_6.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				if(!blocked && model.getNbParties() > 5) {
					resetAll();
					view.fond6.setIcon(model.getImgFondActive());
				}
			}
			public void mousePressed(MouseEvent e){
				if(!blocked && model.getNbParties() > 5) {
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
