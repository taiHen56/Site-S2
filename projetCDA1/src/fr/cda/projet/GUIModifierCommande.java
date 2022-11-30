// Projet 1 CDA
//
// MASSAMPU EVORA TAVARES Rafael
//16.10.22
//
package fr.cda.projet;

import java.util.ArrayList;

import fr.cda.ihm.*;


public class GUIModifierCommande implements FormulaireInt{
	
	private Commande c;
	private GUISite formPP;
	private Site site;
	
	//Constructeur
	public GUIModifierCommande(Commande c, GUISite formPP, Site site) {
		
		this.c=c;
		this.formPP = formPP;
		this.site = site;
		
		
        Formulaire form = new Formulaire("Modifier...",this,320,260);
        form.setPosition(20, 0);
		
        
        //On verifie si c'est livré, et si ça l'est on peut plus la modifier
		if(c.isLivred()) {
			 form.addLabel("Cette commande est livré bg");
		}else {
			
			ArrayList<String> produits = c.getIdTab();
			
			//pour change produit existant on créé un espace de texte 
		    for (int i = 0; i < produits.size() ; i++) {
		    	String[] champs = (produits.get(i)).split("=",2);
		    	form.addText(Integer.toString(i), champs[0], true, champs[1]);	
		    	form.addLabel("");
		    }
			
		}
		
		form.setPosition(20,150);
        form.addButton("VALIDER","Valider");
     // Affichage du formulaire
        form.afficher();
		
	}
	
	public void submit(Formulaire form,String nomSubmit)
    {
		if (nomSubmit.equals("VALIDER"))
        {
			//Si c'est livre il se passe rien
			if(c.isLivred()) {
	            form.fermer();

			}else {
				//On copie la liste des produits pour ensuite la supprimer
				ArrayList<String> produits = c.getIdTab();
				c.unsetId();
				//Comme ca on a juste a la remplir petit a petit avec les 
				//quantites des produits mis a jour
			    for (int i = 0; i < produits.size() ; i++) {
			    	String[] champs = (produits.get(i)).split("=",2);
			    	String ref = champs[0] +"="+ form.getValeurChamp(Integer.toString(i));
			    	c.setRef(ref);
			    }
				
	            form.fermer();

			}
        }
		
    }
	
	

}
