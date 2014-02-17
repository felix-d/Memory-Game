import java.util.ArrayList;


class GenerateurDeCartesImage extends GenerateurDeCartes {

	private ArrayList <String> list = new ArrayList<String>();
	private int nombreDimages;
	
	protected GenerateurDeCartesImage(String nom, String[]path){
		this.nom = nom;
		for(int i=0;i<path.length;i++){
			list.add(path[i]);
		}
		nombreDimages = list.size();
	}
	@Override
	protected Carte genererUneCarte() {
		// TODO Auto-generated method stub
		int positionAleatoireCarteChoisie = (int)(Math.random() * ((list.size())));
		String path = list.get(positionAleatoireCarteChoisie);
		list.remove(positionAleatoireCarteChoisie);
		CarteImage carte = new CarteImage(true, path);
		return carte;
	}

	@Override
	protected int nombreDeCartesDifferentes() {
		// TODO Auto-generated method stub
		return nombreDimages;
	}

}
