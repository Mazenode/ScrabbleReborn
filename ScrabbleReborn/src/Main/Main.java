package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import Controller.ChargerPartieController;
import Controller.CreerJoueurController;
import Controller.CreerPartieController;
import Controller.JeuController;
import Controller.MenuController;
import Model.ChargerPartieModel;
import Model.CreerJoueurModel;
import Model.CreerPartieModel;
import Model.JeuModel;
import Model.MenuModel;
import View.ChargerPartieView;
import View.CreerJoueurView;
import View.CreerPartieView;
import View.JeuView;
import View.MenuView;

public class Main {

	public static void main(String[] args) throws Exception {
		
		/*MenuView view = new MenuView();
		
		MenuModel model = new MenuModel();
		
		MenuController controller = new MenuController(view, model);*/
		
		/*JeuView jeuView = new JeuView();
		JeuModel jeuModel = new JeuModel();
		JeuController jeuController = new JeuController(jeuView, jeuModel);*/
		
		ChargerPartieView view = new ChargerPartieView();
		ChargerPartieModel model = new ChargerPartieModel();
		ChargerPartieController controller = new ChargerPartieController(view, model);
	}
	
}
