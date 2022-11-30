package com.bankonet;

public enum Civilité {

	MADAME("Madame"), MADEMOISELLE("Mademoiselle"), MONSIEUR("Monsieur");
	
	private String civil;
	
	private Civilité(String c) {
		
		this.civil=c;
		
	}
	
	private String getCivilite() {
		
		return this.civil;
		
	}
	
}
