package Model;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class LettreModel extends JButton {
	private static final long serialVersionUID = 1L;
	private ImageIcon image;
	public String val;
	
	public LettreModel() {
		this.setVisible(true);
		this.val = null;
		this.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public LettreModel(String val) {
		this.setVisible(true);
		this.val = val;
		this.image = new ImageIcon(this.getClass().getResource("/images/"+val+".png"));
		this.setIcon(image);
		this.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public ImageIcon getImage(){
		return image;
	}
	
	public String getVal(){
		return val;
	}
}
