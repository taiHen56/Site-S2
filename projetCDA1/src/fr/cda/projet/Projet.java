// Projet 1 CDA
//
// MASSAMPU EVORA TAVARES Rafael
//16.10.22
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
        //On cree le site mais aussi l'interface
        Site site = new Site();
        GUISite ihm = new GUISite(site);
    }
}
