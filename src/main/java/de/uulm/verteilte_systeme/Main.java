package de.uulm.verteilte_systeme;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String host = "vs.lxd-vs.uni-ulm.de";
        int port = 3211;

        EchoClient client = new EchoClient(host, port);

        Scanner textInputScanner = new Scanner(System.in, StandardCharsets.UTF_8);

        try {
            String message;
            while (!(message = textInputScanner.nextLine()).equals("exit")) {
                client.connect();
                System.out.println("Server response: " + client.sendMessage(message));
            }
        } catch (IOException e) {
            System.out.println("Could not connect to server: " + e.getMessage());
        }
    }
}