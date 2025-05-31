package com.coloboc.restapi4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class Restapi4Application {

	public static void main(String[] args) throws IOException, InterruptedException {
		String name = "NewFile23467gggfjhjgjfgv";
		String content = "somethintg xmk jhjhhj";

		int id = User.loadFile(name, content);
		//System.out.println(id);

		content = User.getAnalysis(id);
		System.out.println(content);
	}
}
