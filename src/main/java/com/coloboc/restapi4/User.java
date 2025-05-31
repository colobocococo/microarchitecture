package com.coloboc.restapi4;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class User {
    private static String getUrl = "http://localhost:8080/gateway/get";
    private static String loadUrl = "http://localhost:8080/gateway/load";
    private static String alayzeUrl = "http://localhost:8080/gateway/analyze";
    public static int loadFile(String name, String content) throws IOException, InterruptedException {
        String params = "name=" + URLEncoder.encode(name, StandardCharsets.UTF_8) +
                "&content=" + URLEncoder.encode(content, StandardCharsets.UTF_8);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(loadUrl))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(params))
                .build();

        HttpResponse response  = client.send(request, HttpResponse.BodyHandlers.ofString());
        return Integer.parseInt(response.body().toString());
    }

    public static String getFile(int id) throws IOException, InterruptedException {
        String params = "id=" + id;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getUrl))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(params))
                .build();

        HttpResponse response  = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body().toString();
    }

    public static String getAnalysis(int id) throws IOException, InterruptedException {
        String params = "id=" + id;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(alayzeUrl))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(params))
                .build();

        HttpResponse response  = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body().toString();
    }
}
