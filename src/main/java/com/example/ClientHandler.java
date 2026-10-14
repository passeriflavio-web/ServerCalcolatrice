package com.example;

import java.io.*;
import java.net.*;

class ClientHandler implements Runnable {
    private Socket socket;
    private Calcolatore mioCalcolatore;

    public ClientHandler(Socket socket, Calcolatore mioCalcolatore) {
        this.socket = socket;
        this.mioCalcolatore = mioCalcolatore;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                
                out.println("Scrivi l'operazione (es. 2+3 o 12*4):");
            
            String riga;
            while ((riga = in.readLine()) != null) {
                if (riga.trim().equalsIgnoreCase("exit")) break;
                
                try {
                    double risposta = mioCalcolatore.Calcolatrice(riga);
                    out.println(risposta); 
                } catch (Exception e) {
                    out.println("ERRORE: Ricontrolla i dati inseriti.");
                }
            }
        } catch (IOException e) {
            System.err.println("Errore di comunicazione con il client: " + e.getMessage());
        } finally {
            try {
                socket.close();
                System.out.println("Connessione client chiusa.");
            } catch (IOException e) {
                System.err.println("Impossibile chiudere la socket: " + e.getMessage());
            }
        }
    }
}
