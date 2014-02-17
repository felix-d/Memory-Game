import java.awt.Color;
import java.util.ArrayList;

class GenerateurDeCartesCouleur extends GenerateurDeCartes {
	
	private ArrayList<Color> colors  = new ArrayList<Color>();
	private int nombreDeCartesDifferentes;
	
	protected GenerateurDeCartesCouleur(){
		remplirArrayList();
		nombreDeCartesDifferentes = colors.size();
	}
	
	protected void remplirArrayList(){
		colors.add(Color.RED);
		colors.add(Color.GREEN);
		colors.add(Color.BLUE);
		colors.add(Color.CYAN);
		colors.add(Color.MAGENTA);
		colors.add(Color.YELLOW);
		colors.add(Color.PINK);
		colors.add(Color.ORANGE);
		}
	@Override
	protected Carte genererUneCarte() {
		int positionAleatoireCarteChoisie = (int)(Math.random() * ((colors.size())));
		Color color = colors.get(positionAleatoireCarteChoisie);
		colors.remove(positionAleatoireCarteChoisie);
		CarteCouleur carte = new CarteCouleur(true, color);
		return carte;
	}

	@Override
	protected int nombreDeCartesDifferentes() {
		// TODO Auto-generated method stub
		return nombreDeCartesDifferentes;
	}

}
