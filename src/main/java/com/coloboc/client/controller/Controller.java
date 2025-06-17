package com.coloboc.client.controller;

import com.coloboc.client.service.OrderService;
import com.coloboc.client.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/gateway")
public class Controller {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/payment/get")
    public int paymentGet(@RequestParam int id) throws IOException, InterruptedException {
        return PaymentService.get(id);
    }

    @PostMapping("/payment/insert")
    public void paymentInsert() throws IOException, InterruptedException {
        PaymentService.insert();
    }

    @PostMapping("/payment/add")
    public void paymentAdd(@RequestParam int id, int amount) throws IOException, InterruptedException {
        PaymentService.add(id, amount);
    }

    @PostMapping("/order/get")
    public String orderGet(@RequestParam int id) throws IOException, InterruptedException {
        return OrderService.get(id);
    }

    @PostMapping("/order/add")
    public String orderAdd(@RequestParam int id, int user_id, int amount) throws IOException, InterruptedException {
        return OrderService.add(id, user_id, amount);
    }
}
