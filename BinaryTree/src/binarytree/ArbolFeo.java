/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.math.*;
import java.util.Random;

/**
 *
 * @author luisj
 */
public class ArbolFeo {
    public ArrayList<Double> listaPorcentaje = new ArrayList();
    public ArrayList <Long> listaTiempos = new ArrayList();
    static String s ="C:/Users/luisj/Desktop/bd/data.txt";
    static String fw = "C:/Users/luisj/Desktop/bd/arbolMediana.txt";
    static String fw2 = "C:/Users/luisj/Desktop/bd/arbolPromedio.txt";
    public static ArrayList<Node> listaA = new ArrayList();
    public static ArrayList<Node> listaB = new ArrayList();
    public static ArrayList<Node> listaC = new ArrayList();
    public static ArrayList<Node> listaD = new ArrayList();
    public ArrayList<Node> menor = new ArrayList();
    public ArrayList<Node> mayor = new ArrayList();
    public  ArrayList<Node> listaArbol = new ArrayList();
    Node root;
    int size;
    public ArbolFeo() {
        
    }
    public void obtenerMediana(ArrayList<Node> listaMenor, ArrayList<Node> listaMayor){
        ArrayList <Node> provMenor = new ArrayList();
        ArrayList <Node> provMayor = new ArrayList();
        if(listaMenor.isEmpty());
        else{
            if(listaMenor.size()% 2 == 0){
                int index = (listaMenor.size()/2)-1;
                listaArbol.add(listaMenor.get(index));
                provMenor.clear();
                provMayor.clear();
                for (int i = 0; i < index; i++){
                    provMenor.add(listaMenor.get(i));
                }
                for (int i = (index+1); i < listaMenor.size(); i++){
                    provMayor.add(listaMenor.get(i));
                }
                listaMenor.remove(index);
                obtenerMediana(provMenor,provMayor);    
            }
            else{
                int index = (listaMenor.size()/2);
                listaArbol.add(listaMenor.get(index));
                provMenor.clear();
                provMayor.clear();
                for (int i = 0; i < index; i++){
                    provMenor.add(listaMenor.get(i));
                }
                for (int i = (index+1); i < listaMenor.size(); i++){
                    provMayor.add(listaMenor.get(i));
                }
                listaMenor.remove(index);
                obtenerMediana(provMenor,provMayor);   
            }
        }
        if(listaMayor.isEmpty());
        else{
            if(listaMayor.size()% 2 == 0){
                int index = (listaMayor.size()/2)-1;
                listaArbol.add(listaMayor.get(index));
                provMenor.clear();
                provMayor.clear();
                for (int i = 0; i < index; i++){
                    provMenor.add(listaMayor.get(i));
                }
                for (int i = (index+1); i < listaMayor.size(); i++){
                    provMayor.add(listaMayor.get(i));
                }
                listaMayor.remove(index);
                obtenerMediana(provMenor,provMayor);    
            }
            else{
                int index = (listaMayor.size()/2);
                listaArbol.add(listaMayor.get(index));
                provMenor.clear();
                provMayor.clear();
                for (int i = 0; i < index; i++){
                    provMenor.add(listaMayor.get(i));
                }
                for (int i = (index+1); i < listaMayor.size(); i++){
                    provMayor.add(listaMayor.get(i));
                }
                listaMayor.remove(index);
                obtenerMediana(provMenor,provMayor);   
            }
        }
    }
    public void obtenerPromedio(ArrayList<Node> listaMenor, ArrayList<Node> listaMayor){
        ArrayList <Node> provMenor = new ArrayList();
        ArrayList <Node> provMayor = new ArrayList();
        if(listaMenor.isEmpty());
        else{
            
                int index = comparar(promedio(listaMenor),listaMenor);
                listaArbol.add(listaMenor.get(index));
                provMenor.clear();
                provMayor.clear();
                for (int i = 0; i < index; i++){
                    provMenor.add(listaMenor.get(i));
                }
                for (int i = (index+1); i < listaMenor.size(); i++){
                    provMayor.add(listaMenor.get(i));
                }
                listaMenor.remove(index);
                obtenerPromedio(provMenor,provMayor);    
            
            
        }
        if(listaMayor.isEmpty());
        else{
                int index = comparar(promedio(listaMayor),listaMayor);
                listaArbol.add(listaMayor.get(index));
                provMenor.clear();
                provMayor.clear();
                for (int i = 0; i < index; i++){
                    provMenor.add(listaMayor.get(i));
                }
                for (int i = (index+1); i < listaMayor.size(); i++){
                    provMayor.add(listaMayor.get(i));
                }
                listaMayor.remove(index);
                obtenerPromedio(provMenor,provMayor);    
            
            
        }
    }
    
    public void addRoot(ArrayList<Node> lista){
        //System.out.println("inicio Arbol: "+System.currentTimeMillis());
        int index = 0;
        if(root == null){
            if(size % 2 == 0){
                index = (size/2)-1;
                listaArbol.add(lista.get(index));
                lista.remove(index);
                size = lista.size();
            }
            else{
                index = (size/2);
                listaArbol.add(lista.get(index));
                lista.remove(index);
                size = lista.size();
            }
            root = new Node(listaArbol.get(0).key,listaArbol.get(0).name,listaArbol.get(0).flor,false);
            for (int i = 0; i < index; i++){
                menor.add(lista.get(i));
                
            }
            for (int i = (index); i < size; i++){
                mayor.add(lista.get(i));
            }
        }
        
        obtenerMediana(menor,mayor);
        for (int i = 1; i < listaArbol.size(); i++) {
            tree(listaArbol.get(i).key, listaArbol.get(i).name,listaArbol.get(i).flor);
        }
        
        Collections.sort(listaArbol, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.name.compareTo(o2.name);
            }
    });
//        System.out.println("Caso\tProfundidad\tKey");
//        
//        for (Node node : listaArbol) {
//            String c = node.name+"";
//            String k = c.replaceAll("\\.0", "");
//            System.out.println(k+"\t\t"+findNode(node.name, node.key)+"\t"+node.key );
//        }
//        System.out.println("Fin"+System.currentTimeMillis());
    }
    public void addRootPromedio(ArrayList<Node>lista){
        //System.out.println("Inicio P"+System.currentTimeMillis());
        int index = 0;
        if(root == null){
                
                index=comparar(promedio(lista),lista);
                listaArbol.add(lista.get(index));
                lista.remove(index);
                size = lista.size();
            
            
            root = new Node(listaArbol.get(0).key,listaArbol.get(0).name,listaArbol.get(0).flor,false);
            for (int i = 0; i < index; i++){
                menor.add(lista.get(i));
                
            }
            for (int i = (index); i < size; i++){
                mayor.add(lista.get(i));
            }
        }
        
        obtenerPromedio(menor,mayor);
        for (int i = 1; i < listaArbol.size(); i++) {
            tree(listaArbol.get(i).key, listaArbol.get(i).name,listaArbol.get(i).flor);
        }
        
        Collections.sort(listaArbol, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.name.compareTo(o2.name);
            }
    });
//        System.out.println("Caso Promedio\tProfundidad\tKey");
//        
//        for (Node node : listaArbol) {
//            String c = node.name+"";
//            String k = c.replaceAll("\\.0", "");
//            System.out.println(k+"\t\t"+findNode(node.name, node.key)+"\t"+node.key );
//    }
//        System.out.println("FinP"+System.currentTimeMillis());
    }
    public Double promedio(ArrayList<Node> lista){
        Double promedio =0.0;
        for (Node node : lista) {
            promedio+=node.key;
        }
        promedio/=lista.size();
        return promedio;
    }
    public int comparar(Double promedio, ArrayList<Node> lista){
        ArrayList<Double> numeros = new ArrayList();
        Double menor = 100000.0;
        Double valor = 0.0;
        int index =0;
        for (Node node : lista) {
            valor =node.key-promedio;
            valor=Math.abs(valor);
            numeros.add(valor);
            
        }
        for (int i =0 ; i < numeros.size(); i++) {
            if(numeros.get(i) <= menor){
                menor=numeros.get(i);
                index =i;
            }
        }
        return index;
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
    public void inOrder(Node currentNode){
        if(currentNode == null)
            return;
        inOrder(currentNode.left);
        System.out.println(currentNode);
        inOrder(currentNode.right);
    }
    public void preOrder(Node currentNode){
        if(currentNode == null)
            return;
        System.out.println(currentNode);
        preOrder(currentNode.left);
        preOrder(currentNode.right);
    }
    public void postOrder(Node currentNode){
        if(currentNode == null)
            return;
        postOrder(currentNode.left);
        postOrder(currentNode.right);
        System.out.println(currentNode);
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
        
        return profundidad;
    }
    public void leerCadena(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        Double caso = 1.0;
        FileReader f = new FileReader(archivo);
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
    public static void main(String[] args) throws IOException {
        System.out.println("inicio"+System.currentTimeMillis());
        ArbolFeo arbolA = new ArbolFeo();
        ArbolFeo arbolB = new ArbolFeo();
        ArbolFeo arbolC = new ArbolFeo();
        ArbolFeo arbolD = new ArbolFeo();
        
        ArbolFeo arbolAA = new ArbolFeo();
        ArbolFeo arbolBB = new ArbolFeo();
        ArbolFeo arbolCC = new ArbolFeo();
        ArbolFeo arbolDD = new ArbolFeo();
        
        
        arbolA.leerCadena(s);
        arbolA.addRoot(listaA);
        
        
        listaB.clear();
        arbolB.leerCadena(s);
        arbolB.addRoot(listaB);
        
        listaC.clear();
        arbolC.leerCadena(s);
        arbolC.addRoot(listaC);
        for (int i = 0; i < 10; i++) {
            System.out.println("*********************************************************************************************************************************");
            System.out.println("Lista"+(i+1));
            
            ArrayList<Node> copy = new ArrayList(arbolC.listaArbol);
            arbolC.randomize(copy);
        }
        
        Double promedioPorcentajes = 0.0;
        Double promedioTiempo = 0.00;
        
        for (Double list : arbolC.listaPorcentaje) {
           promedioPorcentajes+=list;
        }
        for (Long list : arbolC.listaTiempos) {
            promedioTiempo+=list;
        }
        for (int i = 0; i < arbolC.listaPorcentaje.size(); i++) {
            System.out.print("Fold "+(i+1)+" Porcentaje: ");
            System.out.printf("%.2f",arbolC.listaPorcentaje.get(i));
            System.out.print("% Tiempo "+arbolC.listaTiempos.get(i)+"\n");
        }
        promedioTiempo/= arbolC.listaTiempos.size();
        promedioPorcentajes/=arbolC.listaPorcentaje.size();
        System.out.println("Success rate: "+promedioPorcentajes+ "%");
        System.out.println(" Promedio de tiempo: "+promedioTiempo+ " Nanosegundos");
        
        listaD.clear();
        arbolD.leerCadena(s);
        arbolD.addRoot(listaD);
        
        listaA.clear();
        arbolAA.leerCadena(s);
        arbolAA.sort(listaA);
        arbolAA.addRootPromedio(listaA);
        
        listaB.clear();
        arbolBB.leerCadena(s);
        arbolBB.sort(listaB);
        arbolBB.addRootPromedio(listaB);
        
        listaC.clear();
        arbolCC.leerCadena(s);
        arbolCC.sort(listaC);
        arbolCC.addRootPromedio(listaC);
        
        listaD.clear();
        arbolDD.leerCadena(s);
        arbolDD.sort(listaD);
        arbolDD.addRootPromedio(listaD);
        ArrayList<Depth> saltos = new ArrayList();
        for (int i = 0; i < arbolA.listaArbol.size(); i++) {
            Depth d = new Depth(arbolA.findNode(arbolA.listaArbol.get(i).name, arbolA.listaArbol.get(i).key),
                    arbolB.findNode(arbolB.listaArbol.get(i).name, arbolB.listaArbol.get(i).key),
                    arbolC.findNode(arbolC.listaArbol.get(i).name, arbolC.listaArbol.get(i).key),
                    arbolD.findNode(arbolD.listaArbol.get(i).name, arbolD.listaArbol.get(i).key));
            saltos.add(d);
        }
        ArrayList<Depth> saltosPromedio = new ArrayList();
        for (int i = 0; i < arbolA.listaArbol.size(); i++) {
            Depth d = new Depth(arbolAA.findNode(arbolAA.listaArbol.get(i).name, arbolAA.listaArbol.get(i).key),
                    arbolBB.findNode(arbolBB.listaArbol.get(i).name, arbolBB.listaArbol.get(i).key),
                    arbolCC.findNode(arbolCC.listaArbol.get(i).name, arbolCC.listaArbol.get(i).key),
                    arbolDD.findNode(arbolDD.listaArbol.get(i).name, arbolDD.listaArbol.get(i).key));
            saltosPromedio.add(d);
        }
        
        int i =0;
        int a=0,b=0,c=0,d=0,menor=10000000;
        Writer fileWriter = new FileWriter(fw);
        fileWriter.write("Caso\tArbol A\t\tArbol B\t\tArbol C\t\tArbolD\r\n");
        
        for (Depth salto : saltos) {
            menor=10000000;
            i++;
            fileWriter.write("  "+i+"\t   "+salto.a+"\t\t   "+salto.b+"\t\t   "+salto.c+"\t\t   "+salto.d+"\r\n");
            if(salto.a<menor)
                menor=salto.a;
            if(salto.b<menor)
                menor=salto.b;
            if(salto.c<menor)
                menor=salto.c;
            if(salto.d<menor)
                menor=salto.d;
            if(salto.a == menor)
                a++;
            if(salto.b == menor)
                b++;
            if(salto.c == menor)
                c++;
            if(salto.d == menor)
                d++;
            
        }
        fileWriter.close();
        Writer fileWriter2 = new FileWriter(fw2);
        fileWriter2.write("Caso\tArbol A\t\tArbol B\t\tArbol C\t\tArbolD\r\n");
        int j =0;
        int aa=0,bb=0,cc=0,dd=0,menorP=10000000;
        for (Depth salto : saltosPromedio) {
            menorP=10000000;
            j++;
            fileWriter2.write("  "+j+"\t   "+salto.a+"\t\t   "+salto.b+"\t\t   "+salto.c+"\t\t   "+salto.d+"\r\n");
            if(salto.a<menorP)
                menorP=salto.a;
            if(salto.b<menorP)
                menorP=salto.b;
            if(salto.c<menorP)
                menorP=salto.c;
            if(salto.d<menorP)
                menorP=salto.d;
            if(salto.a == menorP)
                aa++;
            if(salto.b == menorP)
                bb++;
            if(salto.c == menorP)
                cc++;
            if(salto.d == menorP)
                dd++;
            
        }
        fileWriter2.close();
        System.out.println("Mediana: A: "+a+" B: "+b+" C: "+c+" D: "+d);
        System.out.println("Promedio: A: "+aa+" B: "+bb+" C: "+cc+" D: "+dd);
        
        
    }
    public void randomize(ArrayList<Node> lista){
        Long tiempoInicial = System.nanoTime();
        Random random = new Random();
        ArrayList<Node> listaRandom = new ArrayList();
        int sizzze = lista.size();
        int t = lista.size()-1;
        do{
            int n = random.nextInt(t - 0 + 1) + 0 ;
            if(lista.get(n).visitado ==false){
                listaRandom.add(lista.get(n));
                lista.get(n).visitado = true;
                lista.remove(n);
                t =t-1;
            }
        }
        while(listaRandom.size() < sizzze/10);
        
        //
        ArrayList<Node> copy135 = new ArrayList(lista);
        ArbolFeo tree = new ArbolFeo();
        tree.size = copy135.size();
        tree.addRoot(copy135);
        calcularDistancia(listaRandom, tree.listaArbol, tiempoInicial);
    }
    public void calcularDistancia(ArrayList<Node> a, ArrayList<Node> b, Long tI){
        
        Double suma=0.0;
        ArrayList<Harambe> resultados = new ArrayList();
        ArrayList<Harambe> tresResultados = new ArrayList();
        for (int i = 0 ; i < a.size(); i++)//15
        {
            for (int j = 0; j < b.size(); j++)//135
            {
                
                Double valor = Math.abs(Math.sqrt(Math.pow(a.get(i).key - b.get(j).key,2)));
                Harambe h = new Harambe(valor, b.get(j).key,b.get(j).flor);
                resultados.add(h);
            }
            sortHarambe(resultados);
            tresResultados.add(new Harambe(resultados.get(0).valor,resultados.get(0).key,resultados.get(0).flor));
            tresResultados.add(new Harambe(resultados.get(1).valor,resultados.get(1).key,resultados.get(0).flor));
            tresResultados.add(new Harambe(resultados.get(2).valor,resultados.get(2).key,resultados.get(0).flor));
            resultados.clear();
            
       
        }
        int c =0,tres=1;
        Double bien=0.0;
        for (Harambe tresResultado : tresResultados) {
            c++;
            
            if(tresResultado.flor.equals(a.get(tres-1).flor)){
                System.out.print("v/");
                bien++;
            }
            else
                System.out.print("x");
            System.out.println(" |"+tres+" |valor original "+a.get(tres-1).key+" "+"|key "+tresResultado.key +"|Clase original:"+a.get(tres-1).flor+"\t|Clase resultado:"+
                    tresResultado.flor+"\t Distancia| "+tresResultado.valor  );
            if(c % 3 == 0)
                tres++;
        }
        System.out.println("Porcentaje: "+(bien/45)*100 +"%");
        listaPorcentaje.add((bien/45)*100);
        Long tiempoFinal = System.nanoTime();
        listaTiempos.add(tiempoFinal-tI);
        
    }
    //// sacar el porcentaje final
   
    public void sortHarambe(ArrayList<Harambe> list){
        Collections.sort(list, new Comparator<Harambe>() {
            @Override
            public int compare(Harambe o1, Harambe o2) {
                return o1.valor.compareTo(o2.valor);
            }
        });
    }
}
