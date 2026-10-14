package com.example;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        Calcolatore mioCalcolatore = new Calcolatore();
        System.out.println("Server in ascolto sulla porta 3000");
       
        try (ServerSocket server = new ServerSocket(3000)) {
            do{
                Socket socket = server.accept();
                System.out.println("Nuovo client connesso al server");
                
                Thread clientThread = new Thread(new ClientHandler(socket, mioCalcolatore));
                clientThread.start();
            }while (true);

        } catch (IOException e) {
            System.err.println("Errore nel server: " + e.getMessage());
        }
    }
}
