package fr.cda.projet;

public class Plantation <T1,T2> {
	
	private T1 TypePlantation;
	private T2 adresseJardin;
	
	public Plantation(T1 a, T2 b) {
		
		this.TypePlantation=a;
		this.adresseJardin=b;
		
	}

	@Override
	public String toString() {
		return "Plantation [TypePlantation=" + TypePlantation + ", adresseJardin=" + adresseJardin + "]";
	}

	public T1 getTypePlantation() {
		return TypePlantation;
	}

	public void setTypePlantation(T1 typePlantation) {
		TypePlantation = typePlantation;
	}

	public T2 getAdresseJardin() {
		return adresseJardin;
	}

	public void setAdresseJardin(T2 adresseJardin) {
		this.adresseJardin = adresseJardin;
	}

}
