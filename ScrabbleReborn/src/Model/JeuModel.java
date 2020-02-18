package Model;

import javax.swing.ImageIcon;

public class JeuModel {
	private ImageIcon lettreA = new ImageIcon(this.getClass().getResource("/images/a.png"));
	private ImageIcon lettreB = new ImageIcon(this.getClass().getResource("/images/b.png"));
	private ImageIcon lettreC = new ImageIcon(this.getClass().getResource("/images/c.png"));
	private ImageIcon lettreD = new ImageIcon(this.getClass().getResource("/images/d.png"));
	private ImageIcon lettreE = new ImageIcon(this.getClass().getResource("/images/e.png"));
	private ImageIcon lettreF = new ImageIcon(this.getClass().getResource("/images/f.png"));
	private ImageIcon lettreG = new ImageIcon(this.getClass().getResource("/images/g.png"));
	private ImageIcon lettreH = new ImageIcon(this.getClass().getResource("/images/h.png"));
	private ImageIcon lettreI = new ImageIcon(this.getClass().getResource("/images/i.png"));
	private ImageIcon lettreJ = new ImageIcon(this.getClass().getResource("/images/j.png"));
	private ImageIcon lettreK = new ImageIcon(this.getClass().getResource("/images/k.png"));
	private ImageIcon lettreL = new ImageIcon(this.getClass().getResource("/images/l.png"));
	private ImageIcon lettreM = new ImageIcon(this.getClass().getResource("/images/m.png"));
	private ImageIcon lettreN = new ImageIcon(this.getClass().getResource("/images/n.png"));
	private ImageIcon lettreO = new ImageIcon(this.getClass().getResource("/images/o.png"));
	private ImageIcon lettreP = new ImageIcon(this.getClass().getResource("/images/p.png"));
	private ImageIcon lettreQ = new ImageIcon(this.getClass().getResource("/images/q.png"));
	private ImageIcon lettreR = new ImageIcon(this.getClass().getResource("/images/r.png"));
	private ImageIcon lettreS = new ImageIcon(this.getClass().getResource("/images/s.png"));
	private ImageIcon lettreT = new ImageIcon(this.getClass().getResource("/images/t.png"));
	private ImageIcon lettreU = new ImageIcon(this.getClass().getResource("/images/u.png"));
	private ImageIcon lettreV = new ImageIcon(this.getClass().getResource("/images/v.png"));
	private ImageIcon lettreW = new ImageIcon(this.getClass().getResource("/images/w.png"));
	private ImageIcon lettreX = new ImageIcon(this.getClass().getResource("/images/x.png"));
	private ImageIcon lettreY = new ImageIcon(this.getClass().getResource("/images/y.png"));
	private ImageIcon lettreZ = new ImageIcon(this.getClass().getResource("/images/z.png"));
	private ImageIcon blank = new ImageIcon(this.getClass().getResource("/images/blank.png"));
	
	public ImageIcon getImgLettre(char i) {
		switch(i) {
			case 'a':
				return lettreA;
			case 'b':
				return lettreB;
			case 'c':
				return lettreC;
			case 'd':
				return lettreD;
			case 'e':
				return lettreE;
			case 'f':
				return lettreF;
			case 'g':
				return lettreG;
			case 'h':
				return lettreH;
			case 'i':
				return lettreI;
			case 'j':
				return lettreJ;
			case 'k':
				return lettreK;
			case 'l':
				return lettreL;
			case 'm':
				return lettreM;
			case 'n':
				return lettreN;
			case 'o':
				return lettreO;
			case 'p':
				return lettreP;
			case 'q':
				return lettreQ;
			case 'r':
				return lettreR;
			case 's':
				return lettreS;
			case 't':
				return lettreT;
			case 'u':
				return lettreU;
			case 'v':
				return lettreV;
			case 'w':
				return lettreW;
			case 'x':
				return lettreX;
			case 'y':
				return lettreY;
			case 'z':
				return lettreZ;
			case ' ':
				return blank;
		}
		return null;
	}
}
