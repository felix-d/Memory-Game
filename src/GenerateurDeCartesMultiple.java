import java.util.ArrayList;

class GenerateurDeCartesMultiple extends GenerateurDeCartes {

	private ArrayList<Carte> cartes = new ArrayList<Carte>();
	private int nombreDeCartes;
	
	protected GenerateurDeCartesMultiple(String nom, GenerateurDeCartes[] generateursDeCartes){
		this.nom = nom;
		for(int i=0;i<generateursDeCartes.length;i++){
			Carte [] carte = generateursDeCartes[i].genereCartes(JeuMemory.nombreDeCartes/2);
			for(int j=0;j<carte.length;j++){
				cartes.add(carte[j]);
			}
		}
		nombreDeCartes = cartes.size();
	}
	@Override
	protected Carte genererUneCarte() {
		int positionAleatoireCarteChoisie = (int)(Math.random() * ((cartes.size())));
		Carte carte = cartes.get(positionAleatoireCarteChoisie);
		cartes.remove(positionAleatoireCarteChoisie);
		return carte;
	}

	@Override
	protected int nombreDeCartesDifferentes() {
		// TODO Auto-generated method stub
		return nombreDeCartes;
	}

}
