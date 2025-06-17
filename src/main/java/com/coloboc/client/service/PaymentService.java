package com.coloboc.client.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PaymentService {
    private static String url = "http://localhost:8000/payments";

    public static void insert() throws IOException, InterruptedException {
        String dir = "/insert";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + dir))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();

        client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static int get(int id) throws IOException, InterruptedException {
        String dir = "/get";
        String params = "id=" + id;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + dir))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(params))
                .build();

        HttpResponse response  = client.send(request, HttpResponse.BodyHandlers.ofString());
        return Integer.parseInt(response.body().toString());
    }

    public static void add(int id, int amount) throws IOException, InterruptedException {
        String params = "id=" + id +
                        "&amount=" + amount;

        String dir = "/add";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + dir))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(params))
                .build();

        client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
