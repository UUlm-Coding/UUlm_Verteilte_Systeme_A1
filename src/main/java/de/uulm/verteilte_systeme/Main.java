package de.uulm.verteilte_systeme;

public class Main {
    public static void main(String[] args) {
        String host = "vs.lxd-vs.uni-ulm.de";
        int port = 3211;

        EchoClient client = new EchoClient(host, port);

        client.start();
    }
}