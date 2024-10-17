package de.uulm.verteilte_systeme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        String host = "vs.lxd-vs.uni-ulm.de";
        int port = 3211;

        try (
                Socket socket = new Socket(host, port);
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader socketInputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader textInputReader = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String input;

            if ((input = textInputReader.readLine()) == null) return;
            output.println(input);
            String response = socketInputReader.readLine();
            System.out.println(response);

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}