package com.coloboc.client;

import com.coloboc.client.service.OrderService;
import com.coloboc.client.service.PaymentService;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(PaymentService.get(1));
    }
}
