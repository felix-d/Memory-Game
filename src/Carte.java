import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.*;


abstract class Carte extends JComponent {

	boolean recto;
	
	// Constructeur protected prenant un paramètre booléen  indiquant si la carte est sur sa face recto (côté image) ou verso (sur le dos, image cachée).
	protected Carte(boolean recto){
		this.recto = recto;
		addMouseListener(CliqueCarte.listener);
	}
	// Constructeur de copie protected prenant en paramètre une autre instance de Carte
	protected Carte(Carte carte){
		this.recto = carte.recto;
		addMouseListener(CliqueCarte.listener);
	}

	protected boolean estMontree(){
		return recto;
	}
	
	protected boolean estCachee(){
		return !recto;
	}
	
	protected void montre(){
		recto = true;
		repaint();
	}
	
	protected void cache(){
		recto = false;
		repaint();
	}
	
	protected void retourne(){
		recto = !recto;
		repaint();
	}
	
	private void paintVerso(Graphics2D g){
		g.setPaint(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;      
		if(recto) paintRecto(g2d);
		if(!recto) paintVerso(g2d);
	}
	
	public static void melangeCartes(Carte[] cartes){
		//Mélange des cartes!
		Collections.shuffle(Arrays.asList(cartes));
	}
	
	protected abstract void paintRecto(Graphics2D g);
	
	protected abstract boolean rectoIdentique(Carte carte);
	
	protected abstract Object duplique();
}
