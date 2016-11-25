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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisj
 */
public class Arbol {
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
public ArrayList<Double> listaPorcentaje = new ArrayList();
public ArrayList <Long> listaTiempos = new ArrayList();
public ArrayList <Impresion> listaTabla = new ArrayList();
public String p,t;
Node root;
int size;
    public Arbol() {
    try {
        leerCadena(s);
        addRoot(listaC);
        for (int i = 0; i < 10; i++) {
            
            ArrayList<Node> copy = new ArrayList(listaArbol);
            randomize(copy);
        }
        promedios();
        
    } catch (IOException ex) {
        Logger.getLogger(Arbol.class.getName()).log(Level.SEVERE, null, ex);
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
    public void addRoot(ArrayList<Node> lista){
       
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
        String correcto = "";
        for (Harambe tresResultado : tresResultados) {
            c++;
            
            if(tresResultado.flor.equals(a.get(tres-1).flor)){
                correcto = "v/";
                bien++;
            }
            else
                correcto = "x";
            Impresion i = new Impresion(correcto,tres,a.get(tres-1).key,tresResultado.key,a.get(tres-1).flor,tresResultado.flor,tresResultado.valor);
            listaTabla.add(i);
            
            if(c % 3 == 0)
                tres++;
        }
        listaPorcentaje.add((bien/45)*100);
        Long tiempoFinal = System.nanoTime();
        listaTiempos.add(tiempoFinal-tI);
        
    }
    public void sortHarambe(ArrayList<Harambe> list){
        Collections.sort(list, new Comparator<Harambe>() {
            @Override
            public int compare(Harambe o1, Harambe o2) {
                return o1.valor.compareTo(o2.valor);
            }
        });
    }

    private void promedios() {
        Double promedioPorcentajes = 0.0;
        Double promedioTiempo = 0.00;
        
        for (Double list : listaPorcentaje) {
            promedioPorcentajes+=list;
        }
        for (Long list : listaTiempos) {
            promedioTiempo+=list;
        }
        
        promedioTiempo/= listaTiempos.size();
        promedioPorcentajes /= listaPorcentaje.size();
        p = promedioPorcentajes+ "%";
        t = promedioTiempo+ " Nanosegundos";
    }
}
