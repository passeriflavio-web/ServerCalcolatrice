package com.example;

public class Calcolatore {
    
    public double Calcolatrice(String espressione) {
        String testo = espressione.replaceAll(" ", "");
        
        String operatore = "";
        int posizioneOperatore = -1;
    
        if (testo.substring(1).contains("+")) {
            operatore = "+";
            posizioneOperatore = testo.indexOf("+", 1);
        } else if (testo.substring(1).contains("-")) {
            operatore = "-";
            posizioneOperatore = testo.lastIndexOf("-"); 
        } else if (testo.contains("*")) {
            operatore = "*";
            posizioneOperatore = testo.indexOf("*");
        } else if (testo.contains("/")) {
            operatore = "/";
            posizioneOperatore = testo.indexOf("/");
        }
        if (posizioneOperatore <= 0 || posizioneOperatore == testo.length() - 1) {
            System.out.println("Errore: Operazione non valida.");
            return 0;
        }
        
        // Dividisione stringa
        String parte1 = testo.substring(0, posizioneOperatore);
        String parte2 = testo.substring(posizioneOperatore + 1);
        
        //onversione in numeri
        double val1 = Double.parseDouble(parte1);
        double val2 = Double.parseDouble(parte2);
        
        double ans = 0;
        switch (operatore) {
            case "+": ans = val1 + val2; 
            break;
            case "-": ans = val1 - val2; 
            break;
            case "*": ans = val1 * val2; 
            break;
            case "/": 
                if (val2 != 0) {
                    ans = val1 / val2;
                } else {
                    System.out.println("Errore: Divisione per zero.");
                }
                break;
        }
        return ans;
    }
}
