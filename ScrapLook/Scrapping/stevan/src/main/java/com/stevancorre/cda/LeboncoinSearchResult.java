package com.stevancorre.cda;

public class LeboncoinSearchResult {
    private final String title;
    private final String description;
    private final String url;
    private final String price;

    public LeboncoinSearchResult(
            final String title,
            final String description,
            final String url,
            final String price) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getPrice() {
        return price;
    }

    public String toString() {
        return "**" + getTitle() + "**\n" +
                "__Prix:__ " + getPrice() + "\n" +
                "__Url:__ <" + getUrl() + ">" + "\n" +
                "__Description:__ \n" + getDescription();
    }
}
