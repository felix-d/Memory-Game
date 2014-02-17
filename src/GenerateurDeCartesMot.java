import java.util.ArrayList;


class GenerateurDeCartesMot extends GenerateurDeCartes {

	private ArrayList <String> list = new ArrayList<String>();
	private int nombreDeMots;
	
	protected GenerateurDeCartesMot(String nom, String [] mots){
		this.nom = nom;
		nombreDeMots = mots.length;
		for(int i=0;i<mots.length;i++){
			list.add(mots[i]);
		}
	}
	
	@Override
	protected Carte genererUneCarte() {
		int positionAleatoireCarteChoisie = (int)(Math.random() * ((list.size())));
		String mot = list.get(positionAleatoireCarteChoisie);
		list.remove(positionAleatoireCarteChoisie);
		CarteMot carte = new CarteMot(true, mot);
		return carte;
	}

	@Override
	protected int nombreDeCartesDifferentes() {
		// TODO Auto-generated method stub
		return nombreDeMots;
	}

}
