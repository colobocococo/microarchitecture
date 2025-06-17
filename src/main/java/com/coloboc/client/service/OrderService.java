package com.coloboc.client.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OrderService {
    private static String url = "http://localhost:8080/orders";

    public static String get(int id) throws IOException, InterruptedException {
        String params = "id=" + id;
        String dir = "/get";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + dir))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(params))
                .build();

        HttpResponse response  = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body().toString();
    }

    public static String add(int id, int user_id, int amount) throws IOException, InterruptedException {
        String params = "id=" + id +
                        "&user_id=" + user_id +
                        "&amount=" + amount;

        String dir = "/add";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + dir))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(params))
                .build();

        HttpResponse response  = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body().toString();
    }
}
