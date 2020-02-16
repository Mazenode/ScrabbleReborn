package Model;

import javax.swing.JButton;

public class Case {
    private JButton button;
    private int x, y, valeur;

    public Case() {

    }

    public Case(JButton button, int x, int y) {
        this.button = button;
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public JButton getButton() {
        return button;
    }

    public void setValue(int valeur) {
        this.valeur = valeur;
    }

    public int getValue() {
        return this.valeur;
    }
}