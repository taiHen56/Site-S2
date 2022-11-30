package fr.cda.projet;

public class JardinPlantes{

    String adresse;
    String emplacement;

    public JardinPlantes(String a, String c){

        this.adresse=a;
        this.emplacement=c;

    }//fin constructeur

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
    
    

}//fin class JardinPlantes
