// Projet 1 CDA
//
// MASSAMPU EVORA TAVARES Rafael
//16.10.22
//
package fr.cda.projet;

import java.util.*;

import fr.cda.util.*;

// Classe de definition du site de vente
//
public class Site
{
    private ArrayList<Produit> stock;       // Les produits du stock
    private ArrayList<Commande> commandes;  // Les bons de commande

    // Constructeur
    //
    public Site()
    {
        stock = new ArrayList<Produit>();
        commandes = new ArrayList<Commande>();

        // lecture du fichier data/Produits.txt
        //  pour chaque ligne on cree un Produit que l'on ajoute a stock
        initialiserStock("data/Produits.txt");
        initialiserCommandes("data/Commandes.txt");

        //  lecture du fichier data/Commandes.txt
        //  pour chaque ligne on cree une commande ou on ajoute une reference
        //  d'un produit a une commande existante.
        // AC AC 
        
    }
    
    
    
    // Methode qui retourne sous la forme d'une chaine de caractere
    //  tous les produits du stock
    //
    public String listerTousProduits()
    {
        String res="";
        for(Produit prod : stock)
            res=res+prod.toString()+"\n";

        return res;
    }

    // Methode qui retourne sous la forme d'une chaine de caractere
    //  toutes les commandes
    //
    public String listerToutesCommandes()
    {
        String res="";
        for(Commande c: commandes) {
        	
        	 res=res + "Commande   :" + Integer.toString(c.getNum())  
        	 + "\n" + "   Date   :"+ c.getDate()
        	 + "\n" + "   Client   :" + c.getClient()
        	 +"\n" +"   RefProduits   :" + c.getIdRef()
        	 +"\n ------------------------------------------------ \n";
        }

        return res;
    }

    // Methode qui retourne sous la forme d'une chaine de caractere
    //  une commande
    //
    public String listerCommande(int numero)
    {
    	String res="";
        for(Commande c: commandes) {
        	
        	if(c.getNum()==numero) {
        		
        		res=res + "Commande   :" + Integer.toString(c.getNum())  
           	 + "\n" + "   Date   :"+ c.getDate()
           	 + "\n" + "   Client   :" + c.getClient()
           	 +"\n" +"   RefProduits   :" + c.getIdRef()
           	 + c.getPq()
           	 +"\n ------------------------------------------------ \n";
        		
        	}
        	
        	 
        }
        
        return res;
    }

    // Chargement du fichier de stock
    //
    private void initialiserStock(String nomFichier)
    {
        String[] lignes = Terminal.lireFichierTexte(nomFichier);
        for(String ligne :lignes)
            {
                System.out.println(ligne);
                String[] champs = ligne.split("[;]",4);
                String reference = champs[0];
                String nom = champs[1];
                double prix = Double.parseDouble(champs[2]);
                int quantite =  Integer.parseInt(champs[3]);
                Produit p = new Produit(reference,
                                        nom,
                                        prix,
                                        quantite
                                        );
                stock.add(p);
            }
    }//fin initialiserStocks
    
    
    //methode qui permet de verifer qu'une commande est bien presente deja
    public boolean verifCommande(Commande e) {
		
		boolean estla=false;
		for(Commande emp : commandes) {
			if(emp.getNum()==e.getNum()) {
				estla=true;
			}//fin if
		}//fin for
		return estla;
		
	}//fin verifInscrit
    
    
    //Methode qui permet de rajouter une reference de produit a une commande precise
    public void ajoutRefCommande(int c, String ref) {
    	
    	
    	
		for(Commande emp : commandes) {
			if(emp.getNum()==c) {
				emp.setRef(ref);
			}//fin if
		}//fin for
    	
    }//fin TrouverCommande
    
    
    // Chargement du fichier des commmandes
    private void initialiserCommandes(String nomFichier) {
    	
    	
        String[] lignes = Terminal.lireFichierTexte(nomFichier);
        for(String ligne :lignes)
            {
                System.out.println(ligne);
                String[] champs = ligne.split("[;]",4);
                
                int num =  Integer.parseInt(champs[0]);
                String date = champs[1];
                String client = champs[2];
                String ref= champs[3];
                
                Commande p = new Commande(num,date,client);
                //On verifie neanmoins si cette commande est deja dedans
                if(verifCommande(p)) {
                	
                	ajoutRefCommande(num,ref);
                	
                }else {
                	
                	p.setRef(ref);
                	commandes.add(p);
                	
                }
                
                
            }
    }//fin initCommandes
    
    
    //Methode qui donne une commande précise a partir d'un numero
    public Commande getCommande(int n){
    	
    	Commande res = new Commande(0,"","");
    	
    	for(Commande c: commandes) {
    		if(c.getNum()==n) {
    			res=c;
    		}
    	}
    	
    	return res;
    }
    
    	
    //Methode qui permet de livrer les commandes
    public String livrerCom() {
    		
    	//preparation du resultat
    		String res ="Commmande non livrées:"
    				+ "\n =========================================== \n";
    		String manque = "";
    		
    		// Recherche dans commandes
    		for(Commande c: commandes) {
    			
    			ArrayList<String> produits = c.getIdTab();
    			
    			//On y va produit par produit
			    for (int i = 0; i < produits.size() ; i++) {
			    	
			    	String[] champs = (produits.get(i)).split("=",2);
			    	int quantite= Integer.parseInt(champs[1]);
			    	
			    	//on cherche dans le stock de produits...
			    	for(Produit p: stock) {
			    		
			    		//grace a la reference
			    		if(p.getReference().equals(champs[0])){
			    			
			    			//Et on verifie qu'il reste quelque chose a mettre a jour
			    			if(p.getQuantite()>0) {
			    				//Si ya quelque chose on calcule la difference
			    				int newStock = p.getQuantite() - quantite;
			    				
			    				//Et si cette derniere est plus petite
			    				//Ca veut forcemennt dire que quantite Commande > quantite stock
			    				if(newStock<=0){
			    					//On soustrait les deux pour savoir combiennil en manque du coup
 			    					quantite = quantite - p.getQuantite(); 			    					
 			    					
 			    					manque = manque + "il manque : " + Integer.toString(quantite)
 				    				+ " " + champs[0] + "\n";
 			    					
 			    				}else if(newStock>0) {
 			    					//Si au final y en avait assez
 			    					//on met a jour le stock de ce produit
 			    					p.setQuantite(newStock);
 			    				}
			    				
			    				
			    				
			    			}//fin if(p.getQuantite()>0) {	
			    		}//fin if(p.getReference().equals(champs[0]))
			    	}//fin for(Produit p: stock)
			    	
			    	
			    }//fin for (int i = 0; i < produits.size() ; i++)
			   
			    //la variable manque permet de 
			    //savoir egalement si ya eu assez de stock 
			    //Si au final elle est inchange, ca veut dire que la commande a ete livre
			    if(manque.equals("")) {
			    	c.setLivred(true);
			    	
			    }else{
			    	//Sinon bien sur on met a jour la raison de la non livraison
			    	c.setPq(manque);
			    	res = res + listerCommande(c.getNum());
			    }
			    
			    manque = "";
    			
    		}// fin for Commandes
    		
    		return res;
    	}
    	
    	//Methode qui montre le nombre de ventes, rend une string
    	public String ventesCom(){
    		
    		String res="";
    		
    		for (Commande c: commandes) {
    			
    			
    			//On verifie que la commande est livré
    			if(c.isLivred()) {
    				
    				String nom="";
    				String prix="";
    				double prixT=0;
    				//On recopie la liste des produits de la commande pour
    				//les manipuler
    				ArrayList<String> produits = c.getIdTab();
    			    for (int i = 0; i < produits.size() ; i++) {
    			    	
    			    	String[] champs = (produits.get(i)).split("=",2);
    			    	int quantite= Integer.parseInt(champs[1]);
    			    	//On verifie que le Produit fait bien partie du stock
    			    	for(Produit p: stock) {
    			    		if(p.getReference().equals(champs[0])) {
    			    			nom=p.getNom();
    			    			prix=p.getPrix()+"";
    			    			prixT= prixT + quantite*p.getPrix();
    			    		}
    			    	}
    			    	//On met a jour le resultat
    			    	res = res +
    			    			"           " + 
    			    			nom +
    			    			"           " +
    			    			Integer.toString(quantite)+
    			    			"           " + prix +
    			    			"\n";
    			    	
    			    }
    			    //Et on l'affiche
    			    res = "Commande : " + Integer.toString(c.getNum()) 
    			    		+"\n" 
    			    		+ res 
    			    		+ "\n ================================ \n" 
    			    		+ "Somme : " + prixT;
    				
    			}
    			
    			
    		}
    		
    		
    		
    		return res;
    	}
    
}//fin Site

	