package ru.geekbrains.java2.lessons.lesson7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;


public class ChatServer {
    private final ServerSocket socket;
    private final AutenticationService autenticationService;
    private final Set<ClientHandler> loggedClients;

    public ChatServer(ServerSocket socket) {
        try {
            autenticationService = new AutenticationService();
            loggedClients = new HashSet<>();
            this.socket = new ServerSocket(8888);

            while (true) {
                System.out.println("Waiting for a new connection....");
                Socket client = socket.accept();
                System.out.println("Client accepted.");
                new Thread(() -> new ClientHandler(client, this)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong during inbound message read-operation", e);
        }
    }


    public AutenticationService getAutenticationService() {
        return autenticationService;
    }

    public synchronized void addClient(ClientHandler client){
        loggedClients.add(client);
    }

    public synchronized void removeClient(ClientHandler client){
        loggedClients.remove(client);
    }


    public synchronized boolean isUsernameOccupied(String username) {
       return loggedClients.stream().anyMatch(c -> c.getName().equals(username));
    }

    public synchronized void broadcastMessage(String message){
        loggedClients.forEach(ch -> ch.sendMessage(message));
    }
    public void privateMsg(ClientHandler from, String to, String msg)
    {

        for (ClientHandler client: loggedClients) {
            if(client.getName().equals(to)) {
                client.sendMessage("[W from: " + from.getName() + "] " + msg);
                break;
            }
        }
        from.sendMessage("[W to: " + to + "] " + msg);
    }


    public ServerSocket getSocket() {
        return socket;
    }

}

