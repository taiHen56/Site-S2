package com.stevancorre.cda;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;

final class Discord {
    private final String token;

    public Discord(final String token) {
        this.token = token;
    }

    public void sendText(final String channel, final String content) throws IOException {
        final String requestUrl = String.format("https://discord.com/api/v9/channels/%s/messages", channel);
        final CloseableHttpClient client = HttpClients.createDefault();

        final HttpPost request = new HttpPost(requestUrl) {{
            setEntity(new UrlEncodedFormEntity(new ArrayList<>(1) {{
                add(new BasicNameValuePair("content", content));
            }}, "UTF-8"));

            addHeader("authorization", token);
        }};

        client.execute(request);
        client.close();
    }
}
