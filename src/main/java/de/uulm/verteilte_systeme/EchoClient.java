package de.uulm.verteilte_systeme;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class EchoClient {
    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
        Scanner textInputScanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        try(
                Socket socket = new Socket(host, port);
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader socketInputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String input;

            if ((input = textInputScanner.nextLine()) != null) {
                output.println(input);
                String response = socketInputReader.readLine();
                System.out.println(response);
            }

        } catch (IOException exception) {
            System.out.println("Exception: " + Arrays.toString(exception.getStackTrace()));
        }
    }
}