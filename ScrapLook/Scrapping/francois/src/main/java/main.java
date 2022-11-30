import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.*;

import java.util.List;


public class main {
    public static void main(String args[]) throws Exception {
        PrintWriter ecrire;
        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Entrez le nom du produit à chercher : ");
        String search = clavier.readLine();
        System.out.println("Entrez le prix minimum : ");
        String min = clavier.readLine();
        System.out.println("Entrez le prix maximum : ");
        String max = clavier.readLine();
        System.out.println("Entrez le numéro du département : ");
        String loc = clavier.readLine();
        String url = "https://leboncoin.fr/recherche?text=" + search + "&locations=d_" + loc + "&price=" + min + "-" + max;
        System.out.println("Vous recherchez " + search + " entre " + min + " et " + max + " euros dans le " + loc + ".\nVeuillez patienter...");

        WebClient webClient = new WebClient(BrowserVersion.FIREFOX);

        webClient.getOptions().setUseInsecureSSL(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        HtmlPage htmlPage = webClient.getPage(url);

        File rep = new File("Recherches");
        rep.mkdir();
        String nomFichierSortie = "Recherches" + File.separator + search + ".txt";

        List<HtmlElement> li = htmlPage.getByXPath("//div[1]/div[1]/p");


        ecrire = new PrintWriter(new BufferedWriter
                (new FileWriter(nomFichierSortie)));

        String res = "";
        for (HtmlElement e : li) {
            HtmlPage htmlPage1 = webClient.getPage(e.click().getUrl());
            String nomArticle = "";
            String prixArticle = "";
            String description = "";

            List<HtmlElement> nom = htmlPage1.getByXPath("//div[3]/div/div/h1");
            List<HtmlElement> prix = htmlPage1.getByXPath("//div[3]/div/span//div/div[1]/div/span");
            List<HtmlElement> desc = htmlPage1.getByXPath("//div[5]/div/div/p");

            for (HtmlElement n : nom) {
                nomArticle = n.getTextContent();

            }
            for (HtmlElement p : prix) {
                prixArticle = p.getTextContent();
                prixArticle = prixArticle.replace("\u00a0", "");
            }
            for (HtmlElement d : desc) {
                description = d.getTextContent();
            }
            res += "Article : " + nomArticle + "\nPrix : " + prixArticle + "\nDescription de l'article : " + description + "\nlien : " + htmlPage1.getUrl() +
                    "\n--------------------------------------------------------------------------------------------\n";

        }
        ecrire.println(res);
        ecrire.close();
    }
}

