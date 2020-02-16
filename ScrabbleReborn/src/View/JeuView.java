package View;

import javax.swing.JFrame;

import Model.Grille;

import java.awt.*;

public class JeuView extends JFrame {
    public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int width = (int)screenSize.getWidth();
    public int height = (int)screenSize.getHeight();
    public JeuView(){
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(width, height);
        getContentPane().setBackground(new Color(254,211,7));
        //this.setLocation(width /2 - this.getSize().width/2, height /2 - this.getSize().height/2);
        Grille grille = new Grille();
        grille.setBounds(450,0, 1000, 1000);
        add(grille);
        grille.revalidate();
    }
   }
