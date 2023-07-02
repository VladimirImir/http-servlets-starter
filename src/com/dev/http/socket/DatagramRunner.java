package com.dev.http.socket;

import java.io.IOException;
import java.net.*;

public class DatagramRunner {

    public static void main(String[] args) throws IOException {
        var inetAdsress = InetAddress.getByName("localhost");
        try (var datagramSocket = new DatagramSocket()) {
            // -----> [buffer] <-----
            var bytes = "Hello from UDP client".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, inetAdsress, 7777);
            datagramSocket.send(packet);
        }
    }
}
