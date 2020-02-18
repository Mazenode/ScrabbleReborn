package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import Controller.CreerJoueurController;
import Controller.CreerPartieController;
import Controller.JeuController;
import Controller.MenuController;
import Model.CreerJoueurModel;
import Model.CreerPartieModel;
import Model.JeuModel;
import Model.MenuModel;
import View.CreerJoueurView;
import View.CreerPartieView;
import View.JeuView;
import View.MenuView;
import View.Test;

public class Main {

	public static void main(String[] args) throws Exception {
		
		MenuView view = new MenuView();
		
		MenuModel model = new MenuModel();
		
		MenuController controller = new MenuController(view, model);
		
		/*JeuView jeuView = new JeuView();
		JeuModel jeuModel = new JeuModel();
		JeuController jeuController = new JeuController(jeuView, jeuModel);*/
		/*
		Test test = new Test();
		test.setVisible(true);*/
		
	}
	
}
