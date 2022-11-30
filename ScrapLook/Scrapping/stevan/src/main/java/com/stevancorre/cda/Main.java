package com.stevancorre.cda;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String token = "LE TOKEN ICI";

    public static void main(String[] args) throws IOException {
        final Discord discord = new Discord(token);
        final Leboncoin leboncoin = new Leboncoin();
        final List<LeboncoinSearchResult> results = leboncoin.search("ordinateur", 10);

        System.out.format("Found %d results", results.size());

        for (final LeboncoinSearchResult result : results) {
            discord.sendText("1017751842932928583", result.toString() + "\n" + "-".repeat(20));

            System.out.println(result);
        }
    }
}