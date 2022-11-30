// Projet 1 CDA
// 
// NOM,Prenom
// NOM,Prenom
//
package fr.cda.projet;

import java.io.*;
import java.util.*;

import fr.cda.util.*;

// Classe principale d'execution du projet
//
public class Projet
{
    public static void main(String a_args[])
    {
        Terminal.ecrireStringln("Execution du projet ");
        
        //Tomate t= new Tomate("Courant", "rouge");
        //Carotte c= new Carotte("Courant", "orange");
        JardinPlantes j= new JardinPlantes("VictorHugo", "Vannes");
        Garage g = new Garage("Momo", "5 rue Napo", 5);
        
        Tomate t= new Tomate("Courant", "rouge",j);
        Carotte c= new Carotte("Courant", "orange",g);
        Legume l1= new Tomate("Courant", "noir",j);
        
        
        Plantation<Tomate,Garage> pg= new Plantation(t,g);
        Plantation<Carotte,JardinPlantes> pj = new Plantation(c,j); 
        
        Terminal.ecrireStringln("Plantation 1 : " + pg.toString() + " // Plantation 2 : " + pj.toString());

        
    }
}
