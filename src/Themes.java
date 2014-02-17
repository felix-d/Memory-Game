//Classe de gestion des thèmes
class Themes {
	
	//Themes de mots
	private String [] mots1 = {"Awesome","Great","Perfect","Terrific","Wonderful","Excellent","Exceptionel","Brillant","Incroyable","Super","Magnificent","Good"};
	private String [] mots2 = {"Colombien","Arabica","MokaJava","Luwak","Kenya","Peaberry","Tarrazu","Cattura","Harrar","Cappucino","Espresso","Americano"};
	
	//Themes d'images
	private String [] imagesHarper = {"images/harper/h1.jpg","images/harper/h2.jpg","images/harper/h3.jpg","images/harper/h4.jpg","images/harper/h5.jpg","images/harper/h6.jpg","images/harper/h7.jpg","images/harper/h8.jpg","images/harper/h9.jpg","images/harper/h10.jpg","images/harper/h11.jpg","images/harper/h12.jpg"};
	private String [] imagesMemes = {"images/memes/1.jpg","images/memes/2.jpg","images/memes/3.jpg","images/memes/4.jpg","images/memes/5.jpg","images/memes/6.jpg","images/memes/7.jpg","images/memes/8.jpg","images/memes/9.jpg","images/memes/10.jpg","images/memes/11.jpg","images/memes/12.jpg"};
	
	protected Themes(){
		//Initialisation des générateurs de cartes
		GenerateurDeCartesMot gMots1 = new GenerateurDeCartesMot("Mots bilingues qui décrivent notre jeu", mots1);
		GenerateurDeCartesMot gMots2 = new GenerateurDeCartesMot("La drogue des universitaires", mots2);
		GenerateurDeCartesCouleur gCouleur = new GenerateurDeCartesCouleur();
		GenerateurDeCartesImage gMemes = new GenerateurDeCartesImage("Memes",imagesMemes);
		GenerateurDeCartesImage gHarper = new GenerateurDeCartesImage("Stephen Harper",imagesHarper);
		
		GenerateurDeCartes [] gen = {gMemes,gHarper};
		
		switch(JeuMemory.theme){
		case 0:
			JeuMemory.cartes = gCouleur.generePairesDeCartesMelangees(JeuMemory.nombreDeCartes/2);
			JeuMemory.nomDuTheme = "Cartes couleurs";
			break;
		case 1:
			JeuMemory.cartes = gHarper.generePairesDeCartesMelangees(JeuMemory.nombreDeCartes/2);
			JeuMemory.nomDuTheme = gHarper.nom;
			break;
		case 2:
			JeuMemory.cartes = gMemes.generePairesDeCartesMelangees(JeuMemory.nombreDeCartes/2);
			JeuMemory.nomDuTheme = gMemes.nom;
			break;
		case 3:
			JeuMemory.cartes = gMots1.generePairesDeCartesMelangees(JeuMemory.nombreDeCartes/2);
			JeuMemory.nomDuTheme = gMots1.nom;
			break;
		case 4:
			JeuMemory.cartes = gMots2.generePairesDeCartesMelangees(JeuMemory.nombreDeCartes/2);
			JeuMemory.nomDuTheme = gMots2.nom;
			break;
		case 5:
			GenerateurDeCartesMultiple gMultiple = new GenerateurDeCartesMultiple("Stephen Harper & Memes",gen);
			JeuMemory.cartes = gMultiple.generePairesDeCartesMelangees(JeuMemory.nombreDeCartes/2);
			JeuMemory.nomDuTheme = gMultiple.nom;
			break;
		}
	}

}
