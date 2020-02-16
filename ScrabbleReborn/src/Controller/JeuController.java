package Controller;

import Model.JeuModel;
import View.JeuView;

public class JeuController {
	
	private JeuView view;
	private JeuModel model;
	
	public JeuController(JeuView view, JeuModel model) {
		this.view = view;
		this.model = model;
		view.setVisible(true);
	}
}
