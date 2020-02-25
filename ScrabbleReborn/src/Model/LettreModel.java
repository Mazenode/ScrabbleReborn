package Model;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class LettreModel extends JButton {
	private static final long serialVersionUID = 1L;
	private ImageIcon image;
	public boolean isSet;
	public char val;
	private int scoreLettre;
	
	public LettreModel() {
		this.setVisible(true);
		this.val = '#';
		this.scoreLettre = getScoreLettre(this.val);
		this.setHorizontalAlignment(SwingConstants.CENTER);
	}

	public LettreModel(char val) {
		if(val != '#') {
			this.setVisible(true);
			this.val = val;
			this.scoreLettre = getScoreLettre(val);
			this.image = new ImageIcon(this.getClass().getResource("/images/"+val+".png"));
			this.setIcon(image);
			this.setHorizontalAlignment(SwingConstants.CENTER);
		}
		else {
			this.setVisible(false);
		}
	}
	
	public ImageIcon getImage(){
		return image;
	}
	
	public boolean getIsSet(){
		return isSet;
	}
	
	public char getVal(){
		return val;
	}

	public int getScoreLettre(char i) {
        switch(i) {
            case 'a':
                return 1;
            case 'b':
                return 3;
            case 'c':
                return 4;
            case 'd':
                return 2;
            case 'e':
                return 1;
            case 'f':
                return 4;
            case 'g':
                return 2;
            case 'h':
                return 4;
            case 'i':
                return 1;
            case 'j':
                return 8;
            case 'k':
                return 10;
            case 'l':
                return 1;
            case 'm':
                return 2;
            case 'n':
                return 1;
            case 'o':
                return 1;
            case 'p':
                return 3;
            case 'q':
                return 8;
            case 'r':
                return 1;
            case 's':
                return 1;
            case 't':
                return 1;
            case 'u':
                return 1;
            case 'v':
                return 4;
            case 'w':
                return 10;
            case 'x':
                return 10;
            case 'y':
                return 10;
            case 'z':
                return 10;
            case ' ':
                return 0;
            case '#':
                return -1;
        }
        return -1;
	}
}
