package com.example;

public class Calcolatore {
    
    public double Calcolatrice(String[] TmpVal){
        double Ans = 0;
        
        int Operator = Integer.parseInt(TmpVal[0]);
        double val1 = Double.parseDouble(TmpVal[1]);
        double val2 = Double.parseDouble(TmpVal[2]);
        
        switch (Operator) {
            case 1 :
                Ans = val1 + val2;
                break;
            case 2 :
                Ans = val1 - val2;
                break;
            case 3 :
                Ans = val1 * val2;
                break;
            case 4 :
                Ans = val1 / val2;
                break;
            default:
                break;
        }
        
        
        
        
        
        return Ans;
    }

}
