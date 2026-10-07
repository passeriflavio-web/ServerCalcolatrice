package com.example;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("Server in ascolto sulla porta 3000...");
        
        Calcolatore mioCalcolatore = new Calcolatore();

        try (ServerSocket server = new ServerSocket(3000);
             Socket socket = server.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
             System.out.println("Client connesso al server");
            
             String riga;
            double risposta;
            while ((riga = in.readLine()) != null) {
                
                if (riga.trim().equalsIgnoreCase("exit")) break;
                String[] TmpVal = riga.split(";");

                risposta = mioCalcolatore.Calcolatrice(TmpVal);
                  
                out.println(risposta); 
            }
        }
        System.out.println("Server chiuso.");
    }
}