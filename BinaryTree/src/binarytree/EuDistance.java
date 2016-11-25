/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.util.ArrayList;

/**
 *
 * @author luisj
 */
public class EuDistance {
    ArrayList<Double> numerosA = new ArrayList();
    ArrayList<Double> numerosB = new ArrayList();
    public EuDistance() {
        numerosA.add(2.0);
        numerosA.add(3.0);
        numerosA.add(4.0);
        numerosA.add(7.0);
        numerosA.add(12.0);
        numerosA.add(15.0);
        numerosA.add(8.0);
        
        numerosB.add(2.0);
        numerosB.add(3.0);
        numerosB.add(4.0);
        numerosB.add(7.0);
        numerosB.add(0.0);
        numerosB.add(15.0);
        numerosB.add(8.0);
        calcularDistancia(numerosA, numerosB);
    }
    public Double calcularDistancia(ArrayList<Double> a, ArrayList<Double> b){
        Double suma=0.0;
        for (int i = 0; i < a.size(); i++) 
            suma += Math.pow(a.get(i)-b.get(i),2);
        
        return Math.sqrt(suma);
    }
    public static void main(String[] args) {
        EuDistance  e = new EuDistance();
    }
    
}
