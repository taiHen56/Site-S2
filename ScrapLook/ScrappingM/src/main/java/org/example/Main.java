package org.example;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        // Instantiating a BufferedReader to read keyboard inputs
        //
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Entrez le nom du produit à chercher : ");
        String search = keyboard.readLine();
        String url = "https://www.leboncoin.fr/recherche?text=ordinateur%20portable";

        WebClient webClient = new WebClient();

        webClient.getOptions().setUseInsecureSSL(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        HtmlPage htmlPage = webClient.getPage(url);

        File rep = new File("Recherches");
        rep.mkdir();
        String fileExit = "search" + File.separator + search + ".txt";

        PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(fileExit)));

        // title page
        System.out.println("aditem_containerTitle of page " + htmlPage.getTitleText());
        //get charset
        System.out.println(htmlPage.getCharset() + htmlPage.getContentType());

        List<HtmlElement> titles = htmlPage.getByXPath("//div[@class='sc-bdVaJa blRwRU']");
        List<HtmlElement> prices = htmlPage.getByXPath("//span[@class='_137P- _35DXM P4PEa']");
        List<HtmlAnchor> links = htmlPage.getByXPath("//a[@data-qa-id='aditem_container']");

        String show = "";
        for(HtmlAnchor a:links){
            //System.out.println(a.click().getUrl());
            String result = a.getHrefAttribute();
            String res = "https://www.leboncoin.fr";
            //String resultUrl = res.concat(result);
            String resultUrl = String.valueOf(a.click().getUrl());
            //System.out.println(res.concat(result));
            try{
            HtmlPage htmlPage1 = webClient.getPage(resultUrl);

            String title = ((HtmlHeading1) htmlPage1.getByXPath(".//h1[@data-qa-id='adview_title']").get(0)).getTextContent();
            String price = ((HtmlDivision) htmlPage1.getByXPath(".//div[@data-qa-id='adview_price']").get(0)).getTextContent();
            String p1 = (htmlPage1.getByXPath("/html/body/div[2]/div/div[2]/div/div[1]/main/div[5]/div/div[6]/div[1]/div[1]/div[1]/a/div/div[2]/div[1]/div[2]/p/span/span").toString());
            String description = ((HtmlDivision) htmlPage1.getByXPath(".//div[@data-qa-id='adview_description_container']").get(0)).getTextContent();
            show += "Title :-" + title+ ";  " + "Price :- " + p1 + '\n' +"Description :- " + description + '\n' + "URL :- " + resultUrl +
                    "\n--------------------------------------------------------------------------------------------\n";;
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        write.println(show);
        write.close();
    }
}