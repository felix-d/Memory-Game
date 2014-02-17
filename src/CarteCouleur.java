import java.awt.Color;
import java.awt.Graphics2D;

class CarteCouleur extends Carte {

	Color color;
	
	protected CarteCouleur(boolean recto, Color color) {
		super(recto);
		this.color = color;
	}
	
	protected CarteCouleur(CarteCouleur carte){
		super(carte);
		this.color = carte.color;
	}

	@Override
	protected Object duplique() {
		Object carteCopie = new CarteCouleur(this);
		return carteCopie;
	}

	@Override
	protected void paintRecto(Graphics2D g) {
		g.setPaint(color);
		g.fillRect(0, 0, this.getWidth(), this.getHeight()); 
		
	}

	protected boolean rectoIdentique(Carte carte) {
		if(this.color == ((CarteCouleur)carte).color){
			return true;
		}
		return false;
	}
}
