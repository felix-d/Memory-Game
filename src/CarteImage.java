import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


class CarteImage extends Carte {

	String path;

	protected CarteImage(boolean recto, String path) {
		super(recto);
		this.path = path;
	}
	
	protected CarteImage(CarteImage carte) {
		super(carte);
		this.path = carte.path;
	}

	@Override
	protected void paintRecto(Graphics2D g) {
		try {
		      Image img = ImageIO.read(new File(path));
		      g.drawImage(img, 0, 0, this.getWidth(),this.getHeight(), this);
		    } 
		catch (IOException e) {
		      e.printStackTrace();
		    }             
	}

	@Override
	protected boolean rectoIdentique(Carte carte) {
		if(this.path == ((CarteImage)carte).path){
			return true;
		}
		return false;
	}

	@Override
	protected Object duplique() {
		Object carteCopie = new CarteImage(this);
		return carteCopie;
	}

}
