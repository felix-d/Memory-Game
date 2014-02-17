
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

class CarteMot extends Carte {

	String string;
	
	protected CarteMot(boolean recto, String string) {
		super(recto);
		this.string = string;
	}

	protected CarteMot(CarteMot carte){
		super(carte);
		this.string = carte.string;
	}
	
	@Override
	protected void paintRecto(Graphics2D g) {
		Dimension d = this.getSize();
		g.setFont(JeuMemory.F);
		g.setPaint(Color.DARK_GRAY);
		drawCenteredString(string, d.width, d.height, g);
	}

	@Override
	protected boolean rectoIdentique(Carte carte) {
		if(this.string == ((CarteMot)carte).string){
			return true;
		}
		return false;
	}
	
	//MŽthode qui dessine le texte au milieu de la carte, avec l'utilisation de FontMetrics
	protected void drawCenteredString(String s, int w, int h, Graphics g) {
		    FontMetrics fm = g.getFontMetrics();
		    int x = (w - fm.stringWidth(s)) / 2;
		    int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
		    g.drawString(s, x, y);
		  }

	@Override
	protected Object duplique() {
		Object carteCopie = new CarteMot(this);
		return carteCopie;
	}

}
