package fr.cda.projet;


//Projet 1 CDA
//
//MASSAMPU EVORA TAVARES Rafael
//16.10.22
//
import fr.cda.ihm.*;

// Classe de definition de l'IHM principale du compte
//
public class GUISite implements FormulaireInt
{
    private Site site;  // Le site

    // Constructeur
    //
    public GUISite(Site site)
    {
        this.site = site;

        // Creation du formulaire
        Formulaire form = new Formulaire("Site de vente",this,1100,730);
        
        //  Creation des elements de l'IHM
        //
        form.addLabel("Afficher tous les produits du stock");
        form.addButton("AFF_STOCK","Tous le stock");
        form.addLabel("");
        form.addLabel("Afficher tous les bons de commande");
        form.addButton("AFF_COMMANDES","Toutes les commandes");
        form.addLabel("");
        form.addText("NUM_COMMANDE","Numero de commande",true,"1");
        form.addButton("AFF_COMMANDE","Afficher");
        form.addLabel("");
        form.addText("NUM_MOD", "Modifier une commande", true, "1");
        form.addButton("MOD", "Modifier");
        form.addLabel("");
        form.addButton("LIV", "Livrer");
        form.addButton("VENTES", "Calculer Ventes");

        form.setPosition(400,0);
        form.addZoneText("RESULTATS","Resultats",
                            true,
                            "",
                            600,700);

        // Affichage du formulaire
        form.afficher();
    }

    // Methode appellee quand on clique dans un bouton
    //
    public void submit(Formulaire form,String nomSubmit)
    {

        // Affichage de tous les produits du stock
        //
        if (nomSubmit.equals("AFF_STOCK"))
            {
                String res = site.listerTousProduits();
                form.setValeurChamp("RESULTATS",res);
            }

        // Affichage de toutes les commandes
        //
        if (nomSubmit.equals("AFF_COMMANDES"))
            {
                String res = site.listerToutesCommandes();
                form.setValeurChamp("RESULTATS",res);
            }

        // Affichage d'une commande
        //
        if (nomSubmit.equals("AFF_COMMANDE"))
            {
                String numStr = form.getValeurChamp("NUM_COMMANDE");
                int num = Integer.parseInt(numStr);
                String res = site.listerCommande(num);
                form.setValeurChamp("RESULTATS",res);
            }
        
        //Livre toutes les commandes et affiche ceux non livres
        //
        if (nomSubmit.equals("LIV"))
        {
        	
        	
        	String res = site.livrerCom();       
            form.setValeurChamp("RESULTATS",res);

        	
        }
        
        
        //Modifier une commande specifique
        //
        if (nomSubmit.equals("MOD"))
        {
        	String numStr = form.getValeurChamp("NUM_MOD");
            int num = Integer.parseInt(numStr);
            GUIModifierCommande md= new GUIModifierCommande(site.getCommande(num),this,this.site);
        	
        }
        //Affiche les commandes livres
        //
        if (nomSubmit.equals("VENTES")) {
        	
        	String res = site.ventesCom();       
            form.setValeurChamp("RESULTATS",res);
        	
        }
        
        
        
        
        }//fin void submit
        
    }

