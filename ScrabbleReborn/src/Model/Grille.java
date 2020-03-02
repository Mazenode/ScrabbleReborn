package Model;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;

public class Grille extends JPanel {
    private static ArrayList<LettreModel> liste = new ArrayList<>();
    private static final int SIZE = 15;
    public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public Grille() {
        //this.setLayout(null);
        this.liste.clear();
        this.setVisible(true);
        JPanel p = new JPanel();

        p.setLayout(new GridLayout(SIZE, SIZE));
        p.setPreferredSize(new Dimension(700, 700)); // taille de la grille
        for (int j = 0; j < SIZE * SIZE; j++) { // permet de mettre les 100 bouttons
            LettreModel lettre = new LettreModel();
            liste.add(lettre);
            if (j == 0 || j == 7 || j == 14 || j == 105 || j == 119 || j == 210 || j == 217 || j == 224)
                liste.get(j).setBackground(new Color(235, 36, 41));

            else if (j == 3 || j == 11 || j == 36 || j == 38 || j == 45 || j == 52 || j == 59 || j == 92 || j == 96 || j == 98 || j == 102 || j == 108 || j == 116 || j == 122 || j == 126 || j == 128 || j == 132 || j == 165 || j == 172 || j == 179 || j == 186 || j == 188 || j == 213 || j == 221) {
                liste.get(j).setBackground(new Color(61, 191, 238));
            } else if (j == 16 || j == 28 || j == 32 || j == 42 || j == 48 || j == 56 || j == 64 || j == 70 || j == 112 || j == 154 || j == 160 || j == 168 || j == 176 || j == 182 || j == 192 || j == 196 || j == 192 || j == 208) {
                liste.get(j).setBackground(new Color(222, 135, 184));
            } else if (j == 20 || j == 24 || j == 76 || j == 80 || j == 84 || j == 88 || j == 136 || j == 140 || j == 144 || j == 148 || j == 200 || j == 204) {
                liste.get(j).setBackground(new Color(56, 84, 164));
            } else {
                liste.get(j).setBackground(new Color(45, 182, 113));
            }
            lettre.setBorderPainted(true);
            lettre.setBorder(new LineBorder(Color.BLACK, 2));
            p.add(lettre);

        }

        add(p);
        this.setBackground(new Color(254, 211, 7));

    }


    public static ArrayList<LettreModel> getListe() {
        return liste;
    }

    public static int getMultiMot(int j) {
        if (j == 0 || j == 7 || j == 14 || j == 105 || j == 119 || j == 210 || j == 217 || j == 224) {
            return 3;//mot
        }
        else if (j == 16 || j == 28 || j == 32 || j == 42 || j == 48 || j == 56 || j == 64 || j == 70 || j == 112 || j == 154 || j == 160 || j == 168 || j == 176 || j == 182 || j == 192 || j == 196 || j == 192 || j == 208) {
            return 2;//mots
        }

        return 1;
    }
    public static int getMultiLettre(int j){
        if (j == 3 || j == 11 || j == 36 || j == 38 || j == 45 || j == 52 || j == 59 || j == 92 || j == 96 || j == 98 || j == 102 || j == 108 || j == 116 || j == 122 || j == 126 || j == 128 || j == 132 || j == 165 || j == 172 || j == 179 || j == 186 || j == 188 || j == 213 || j == 221) {
            return 2;//lettre
        }
        else if (j == 20 || j == 24 || j == 76 || j == 80 || j == 84 || j == 88 || j == 136 || j == 140 || j == 144 || j == 148 || j == 200 || j == 204) {
            return 3;//lettre
        }
        return 1;
    }

}

