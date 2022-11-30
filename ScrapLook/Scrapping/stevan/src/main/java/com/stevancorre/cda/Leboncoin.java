package com.stevancorre.cda;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class Leboncoin {
    private final WebClient client;

    public Leboncoin() {
        this.client = new WebClient() {{
            getOptions().setUseInsecureSSL(false);
            getOptions().setCssEnabled(false);
            getOptions().setJavaScriptEnabled(false);
        }};
    }

    public List<LeboncoinSearchResult> search(final String query) throws IOException {
        return search(query, Integer.MAX_VALUE);
    }

    public List<LeboncoinSearchResult> search(final String query, final int maxResults) throws IOException {
        final String url = String.format("https://www.leboncoin.fr/recherche?text=%s", query.replace(" ", "%20"));

        return queryResults(url, maxResults);
    }

    public List<LeboncoinSearchResult> search(final String query, final int maxResults, final int minPrice, final int maxPrice) throws IOException {
        final String url = String.format("https://www.leboncoin.fr/recherche?text=%s&price=%d-%d",
                query.replace(" ", "%20"),
                minPrice,
                maxPrice);

        return queryResults(url, maxResults);
    }

    private List<LeboncoinSearchResult> queryResults(final String url, final int maxResults) throws IOException {
        final HtmlPage page = client.getPage(url);

        final List<HtmlAnchor> entries = page.getByXPath("//a[@data-qa-id='aditem_container']");
        final ArrayList<LeboncoinSearchResult> results = new ArrayList<>();

        int count = 0;
        for (final HtmlAnchor entry : entries) {
            if (count++ >= maxResults) break;

            results.add(scrapResult(entry));
        }

        return results;
    }

    private LeboncoinSearchResult scrapResult(final HtmlAnchor anchor) throws IOException {
        final String url = String.format("https://www.leboncoin.fr%s", anchor.getHrefAttribute());
        final HtmlPage page = client.getPage(url);

        final HtmlHeading1 title = page.getFirstByXPath("//h1[@data-qa-id='adview_title']");
        final HtmlDivision price = page.getFirstByXPath("//div[@data-qa-id='adview_price']");
        final HtmlDivision description = page.getFirstByXPath("//div[@data-qa-id='adview_description_container']");

        return new LeboncoinSearchResult(
                title.getTextContent(),
                description == null ? "No description" : description.getTextContent(),
                url,
                price == null ? "No price" : price
                        .getTextContent()
                        .replaceAll("€.*", "€"));
    }
}
