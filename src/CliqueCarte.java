import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

//Classe qui contr™le les clics sur les cartes!
class CliqueCarte{
	
	static MousePressedListener listener;
	private Carte carte1;
	private Carte carte2;
	private int counter = 0;
	private Timer t;
	private boolean premierRetournement = true;
	
	
	protected CliqueCarte(){
		listener = new MousePressedListener();
	}
	
	private class MousePressedListener extends MouseAdapter implements MouseListener{
		public void mouseClicked(MouseEvent e){
			switch (counter){
			case 0: carte1 = (Carte) e.getSource();
					if(carte1.estCachee()){
						carte1.retourne();
						counter++;
						if(premierRetournement){
							new CompteurLabel(JeuMemory.compteur, JeuMemory.cartes);
							premierRetournement = false;
						}
					}
					break;
			case 1: carte2 = (Carte) e.getSource();
					if(carte2.estCachee()){
						counter = 2;
						carte2.retourne();
						if(carte1.getClass()!=carte2.getClass() || !carte1.rectoIdentique(carte2)){
							activerLeRetournement();
						}
						else {
							counter = 0;
						}
					}
					break;
			default: break;
			}
		}
	}
	
	//Retournement lorsque l'on a une mauvaise paire.
	private void activerLeRetournement(){
		class TimerListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				carte1.cache();
				carte2.cache();
				counter = 0;
			}
		}
		ActionListener retourneApresDelai = new TimerListener();
		t = new Timer(JeuMemory.delaiAffichageMauvaisePaire, retourneApresDelai);
		t.setRepeats(false);
		t.start();
	}
}

