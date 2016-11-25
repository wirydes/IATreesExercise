/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisj
 */
public class NIARTree {
    String s = "C:/Users/luisj/Desktop/bd/data.txt";
    URL url = this.getClass().getResource( "/data/data.txt" );
    File file = new File(url.getPath());
    ArrayList<Node> listaA = new ArrayList();
    ArrayList<Node> listaB = new ArrayList();
    ArrayList<Node> listaC = new ArrayList();
    ArrayList<Node> listaD = new ArrayList();
    ArrayList<Node> listaArbol = new ArrayList();
    ArrayList<Node> menor = new ArrayList();
    ArrayList<Node> mayor = new ArrayList();
    ArrayList<ArrayList> lista = new ArrayList();
    Node root;
    int size;
    int depth = 0;
    public NIARTree(int caso) {
        try {
            leerCadena(s);
            if(caso < 3){
                addRoot(lista.get(caso),promedio(lista.get(caso)));
                for (Node node : listaArbol) {
                    findNode(node.name, node.key);
                }
                
                System.out.println("profundidad: "+depth);
            }
            else
                for (int i = 0; i < 4; i++) {
                    listaArbol.clear();
                    root = null;
                    menor.clear();
                    mayor.clear();
                    addRoot(lista.get(i),promedio(lista.get(i)));
                for (Node node : listaArbol) {
                    findNode(node.name, node.key);
                }
                System.out.println("profundidad: "+depth);
                    
                }
            
            
        } catch (IOException ex) {
            Logger.getLogger(NIARTree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void leerCadena(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        Double caso = 1.0;
        
        FileReader f = new FileReader(file);
        BufferedReader bR = new BufferedReader(f);
        while((cadena = bR.readLine())!=null) {
            String flor = cadena.substring(16, cadena.length());
            String a = cadena.substring(0, 3);
            String b = cadena.substring(4, 7);
            String c = cadena.substring(8, 11);
            String d = cadena.substring(12, 15);
           Double doubleA = Double.parseDouble(a);
           Double doubleB = Double.parseDouble(b);
           Double doubleC = Double.parseDouble(c);
           Double doubleD = Double.parseDouble(d);
//            Double valor = Double.parseDouble(cadena);
            Node nodeA = new Node(doubleA, caso,flor,false);
            Node nodeB = new Node(doubleB, caso,flor,false);
            Node nodeC = new Node(doubleC, caso,flor,false);
            Node nodeD = new Node(doubleD, caso,flor,false);
            caso ++;
            listaA.add(nodeA);
            listaB.add(nodeB);
            listaC.add(nodeC);
            listaD.add(nodeD);
        }
        bR.close();
        sort(listaA);
        sort(listaB);
        sort(listaC);
        sort(listaD);
        lista.add(listaA);
        lista.add(listaB);
        lista.add(listaC);
        lista.add(listaD);
        
        size=(int)caso.intValue();
        
        
    }
    public void sort(ArrayList<Node> list){
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.key.compareTo(o2.key);
            }
        });
    }
    public void addRoot(ArrayList<Node> lista,Double p){
        Double menors = 1000000.0;
        int index = 0;
        if(root == null){
            for (int j = 0; j < lista.size(); j++){
                Double valor = Math.abs(Math.sqrt(Math.pow(p - lista.get(j).key,2)));
                if(valor<=menors){
                    menors = valor;
                    index = j;
                }
            }
            listaArbol.add(lista.get(index));
            lista.remove(index);
            if(lista.size() % 2 == 0)
                index = (lista.size()/2)-1;
            
            else{
                index = (lista.size()/2);
                
            }
            root = new Node(listaArbol.get(0).key,listaArbol.get(0).name,listaArbol.get(0).flor,false);
            
            for (int i = 0; i < index; i++){
                menor.add(lista.get(i));
                
            }
            for (int i = (index); i < lista.size(); i++){
                mayor.add(lista.get(i));
            }
            
        }
        
        obtenerMediana(menor,mayor);
        for (int i = 1; i < listaArbol.size(); i++) {
            tree(listaArbol.get(i).key, listaArbol.get(i).name,listaArbol.get(i).flor);
        }
        
//        Collections.sort(listaArbol, new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return o1.name.compareTo(o2.name);
//            }
//        });

    }
    public void obtenerMediana(ArrayList<Node> listaMenor, ArrayList<Node> listaMayor){
        ArrayList <Node> provMenor = new ArrayList();
        ArrayList <Node> provMayor = new ArrayList();
        if(listaMenor.isEmpty());
        else{
            
                Double p = promedio(listaMenor);
                
                Double menors = 1000000.0;
                int index = 0;
                int imdex = 0;
                for (int j = 0; j < listaMenor.size(); j++){
                    Double valor = Math.abs(Math.sqrt(Math.pow(p - listaMenor.get(j).key,2)));
                    if(valor<=menors){
                        menors = valor;
                        imdex = j;
                    }
                }
                listaArbol.add(listaMenor.get(imdex));
                
                if(listaMenor.size() % 2 == 0)
                    index = (listaMenor.size()/2)-1;
            
                else
                    index = (listaMenor.size()/2);
                listaMenor.remove(imdex);
                provMenor.clear();
                provMayor.clear();
                for (int i = 0; i < index; i++){
                    provMenor.add(listaMenor.get(i));
                }
                for (int i = (index); i < listaMenor.size(); i++){
                    provMayor.add(listaMenor.get(i));
                }
                
                obtenerMediana(provMenor,provMayor);    
            
            
        }
        if(listaMayor.isEmpty());
        else{
            
                Double p = promedio(listaMayor);
                
                Double menors = 1000000.0;
                int index = 0;
                int imdex = 0;
                for (int j = 0; j < listaMayor.size(); j++){
                    Double valor = Math.abs(Math.sqrt(Math.pow(p - listaMayor.get(j).key,2)));
                    if(valor<=menors){
                        menors = valor;
                        imdex = j;
                    }
                }
                listaArbol.add(listaMayor.get(imdex));
                
                if(listaMayor.size() % 2 == 0)
                    index = (listaMayor.size()/2)-1;
            
                else
                    index = (listaMayor.size()/2);
                listaMayor.remove(imdex);    
                provMenor.clear();
                provMayor.clear();
                for (int i = 0; i < index; i++){
                    provMenor.add(listaMayor.get(i));
                }
                for (int i = (index); i < listaMayor.size(); i++){
                    provMayor.add(listaMayor.get(i));
                }
                
                obtenerMediana(provMenor,provMayor);    
            
            
        }
    }
    public void tree(Double key, Double name, String flor){
        Node currentNode = root;
        Node parent;

        while(true){
            parent = currentNode;

            if(key <= currentNode.key){
                currentNode = currentNode.left;

                if(currentNode == null){
                    parent.left = new Node(key,name,flor,false);
                    return;
                }
            }
            else{
                currentNode = currentNode.right;

                if(currentNode == null){
                    parent.right = new Node(key,name,flor,false);
                    return;
                }
            }
        }
    }
    private Double promedio(ArrayList<Node> listaC) {
        Double p = 0.0;
        for (Node node : listaC) {
            p += node.key;
        }
        p /= listaC.size();
        return p;
    }
    public int findNode(Double caso, Double key){
        
        int profundidad =1;
        Node thisNode = root;
        
        while(thisNode.name != caso ){
            profundidad++;
            if(key  <= thisNode.key)
                thisNode = thisNode.left;
            else
                thisNode = thisNode.right;
            if(thisNode == null)
                return 0;
            
        }
        if(profundidad > depth)
            depth = profundidad;
        return profundidad;
    }
    public static void main(String[] args) {
        System.out.println("Selecionar arbol:");
        Scanner v = new Scanner(System.in);
        int x = v.nextInt();
        NIARTree a = new NIARTree(x);
        
        
        
    }
}
