abstract class GenerateurDeCartes {

	protected String nom;
	protected Carte[]cartes;
	
	protected String getNom(){
		return nom;
	}
	
	protected Carte[] genereCartes(int n){
		Carte[] cartes = new Carte[n];
		for(int i=0;i<cartes.length;i++){
			cartes[i] = genererUneCarte();
		}
		return cartes;
	}
	
	protected Carte[] generePairesDeCartesMelangees(int n){
		cartes = genereCartes(n);
		Carte[]cartesDoublees = new Carte[2*n];
		for(int i=0;i<cartes.length;i++){
			cartesDoublees[i] = cartes[i];
		}
		for(int i=0;i<cartes.length;i++){
			cartesDoublees[i+cartes.length] = (Carte) cartesDoublees[i].duplique();
		}
		Carte.melangeCartes(cartesDoublees);
		return cartesDoublees;
	}
	
	abstract Carte genererUneCarte();
	abstract int nombreDeCartesDifferentes();

}
