package Model;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class LettreModel extends JButton {
	private static final long serialVersionUID = 1L;
	private ImageIcon image;
	public char val;
	
	public LettreModel() {
		this.setVisible(true);
		this.val = '\u0000';
		this.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public LettreModel(char val) {
		if(val != '#') {
			this.setVisible(true);
			this.val = val;
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
	
	public char getVal(){
		return val;
	}
}
