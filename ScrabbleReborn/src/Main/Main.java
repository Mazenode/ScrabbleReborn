package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import Controller.CreerJoueurController;
import Controller.CreerPartieController;
import Controller.MenuController;
import Model.CreerJoueurModel;
import Model.CreerPartieModel;
import Model.MenuModel;
import View.CreerJoueurView;
import View.CreerPartieView;
import View.MenuView;
import View.Test;

public class Main {

	public static void main(String[] args) throws Exception {
		
		
		MenuView view = new MenuView();
		
		MenuModel model = new MenuModel();
		
		MenuController controller = new MenuController(view, model);
		
	}
	
}
