import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;


//On remarque l'absence du délai de retournement après l'obtention d'une mauvaise paire
//dans le constructeur! La gestion des délais de retournement suite à l'obtention d'une mauvaise paire s'effectue
//dans la classe CliqueCarte.
class PanneauDeCartes extends JPanel {
	
	public PanneauDeCartes(int nRangees, int nColonnes, Carte[] cartes, int delaiAffichageInitial) {
		GridLayout layout = new GridLayout(nRangees,nColonnes);
		layout.setHgap(10);
		layout.setVgap(10);
		setLayout(layout);
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		setBackground(Color.white);
		for(int i=0;i<cartes.length;i++){
			add(cartes[i]);
		}
		
		//Initialisation de l'action de retournement des cartes après le délai initia;
		ActionListener retourneApresDelai = new TimerListener(cartes);
		Timer t = new Timer(delaiAffichageInitial, retourneApresDelai);
		t.setRepeats(false);
		t.start();		
	}
	
	//L'action de retournement de toutes les cartes.
	private class TimerListener implements ActionListener{
		Carte [] cartes;
		public TimerListener(Carte[] cartes){
			this.cartes = cartes;
		}
		public void actionPerformed(ActionEvent e) {
			for(int i=0;i<cartes.length;i++){
				cartes[i].retourne();
			}
		}
	}
}
