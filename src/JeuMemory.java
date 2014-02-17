//Devoir 2: Jeu de Memory
//Par Félix Descôteaux (DESF30099001) et Yi Xuan Su (SUXY09129007)

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JeuMemory {
	
	//Variables
	static int nRangees;
	static int nColonnes;
	static int delaiAffichageInitial;
	static int delaiAffichageMauvaisePaire;
	static int theme;
	static boolean lancerJeu = false;
	static int nombreDeCartes;
	static JLabel compteur;
	static Carte [] cartes;
	static String [] args;
	static String nomDuTheme;
	static final Font F = new Font("SansSerif", Font.BOLD, 20);
	static final Font F2 = new Font("SansSerif",Font.BOLD, 15);
	
	//
	//MAIN METHOD//
	//
	public static void main(String[] args) {
		// Vérification des arguments
		if(args.length == 5){
			
			//Classe qui contrôle le retrounement des cartes
			new CliqueCarte();
			
			//Attribution des variables
			JeuMemory.args = args;
			nRangees = Integer.parseInt(args[0]);
			nColonnes = Integer.parseInt(args[1]);
			delaiAffichageInitial = Integer.parseInt(args[2]);
			delaiAffichageMauvaisePaire = Integer.parseInt(args[3]);
			theme = Integer.parseInt(args[4]);
			nombreDeCartes = retourneNombrePair(nRangees*nColonnes);
			
			//Restrictions de lancement
			if(nombreDeCartes>16&&theme==0) System.out.println("Le thème \"Couleurs\" n'accepte que 16 cartes au maximum!");
			else if(nombreDeCartes>25&&theme!=0) System.out.println("Les thèmes n'acceptent qu'un maximum de 25 cartes!");
			else lancerJeu = true;
			
		}
		//Affiche l'avertissement
		else{
			System.out.println("Utilisation: java JeuMemory nRangees nColonnes delaiAffichageInitial(ms) delaiAffichageMauvaisePaire(ms) numeroDeTheme");
			System.out.println("Ex: java JeuMemory 5 6 5000 1000 3\nVoici la liste des themes disponibles:\n" +
					"0: Cartes couleurs\n" +
					"1: Images de Stephen Harper\n" +
					"2: Images de memes\n" +
					"3:\n" +
					"4:\n" +
					"5: Melange des thèmes 1 et 2");	
		}
		//Lancement du jeu 
		if(lancerJeu){
			//VUE
			final JFrame fenetre = new JFrame();
			fenetre.setTitle("Jeu de mémoire");
			fenetre.setVisible(true);
			fenetre.setSize(nColonnes*150, nRangees*150+240);
			//fenetre.setLocationRelativeTo(null);
			fenetre.setBackground(Color.white);
			fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			new Themes();
			
			BorderLayout layout = new BorderLayout();
			layout.setVgap(40);
			JPanel panneauDeCartes = new PanneauDeCartes(nRangees,nColonnes, cartes, delaiAffichageInitial);
			JPanel container = new JPanel();
			container.setLayout(layout);
			container.add(new Entete(), BorderLayout.PAGE_START);
			container.add(panneauDeCartes);
			fenetre.add(container);
			
			JPanel footer = new JPanel();
			footer.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
			JButton retry = new JButton("Relancer la partie!");
			class Retry implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					fenetre.dispose();
					JeuMemory.main(JeuMemory.args);
				}
			}
			retry.addActionListener(new Retry());
			footer.add(retry);
			fenetre.add(footer,BorderLayout.PAGE_END);
			
			fenetre.validate();
	
		}
	}
	
	//Fonction qui retourne le nombre passé en argument s'il est pair ou qui retourne le nombre - 1 s'il est impair.
	 public static int retourneNombrePair(int i){
		if(i%2==0) return i;
		else return i-1;
	}
	
	//Classe qui crée l'entête
	static private class Entete extends JPanel{
		public Entete(){
			BorderLayout layout = new BorderLayout();
			setLayout(layout);
			setBorder(BorderFactory.createEmptyBorder(45,35,10,10));
			setBackground(Color.white);
			JLabel titre = new JLabel("JEU DE MÉMOIRE");
			titre.setFont(F);
			titre.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
			JLabel nomTheme = new JLabel(nomDuTheme);
			nomTheme.setFont(F2);
			
			compteur = new JLabel("00:00");
			compteur.setFont(F2);
			compteur.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
			
			add(titre,BorderLayout.PAGE_START);
			add(nomTheme, BorderLayout.CENTER);
			add(compteur, BorderLayout.PAGE_END);	
		}
	}
}

