package com.dev.http.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlExample {

    public static void main(String[] args) throws IOException {

        var url = new URL("file:C:\\Users\\Mers\\Music\\http-servlets-starter\\src\\com\\dev\\http\\socket\\DatagramRunner.java");
        var urlConnection = url.openConnection();

        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));

        //checkGoogle();
    }

    private static void checkGoogle() throws IOException {
        var url = new URL("https://www.google.com");
        var urlConnection = url.openConnection();
        urlConnection.setDoInput(true);

        try (var outputStream = urlConnection.getOutputStream()) {

        }

        System.out.println();
    }
}
