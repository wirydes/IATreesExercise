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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AurioAlejandro
 */
public class Kdtree {
   
    URL url = this.getClass().getResource( "/data/data.txt" );
    File file = new File(url.getPath());
   
    
    ArrayList<ArrayList<Node>> casos=new ArrayList<ArrayList<Node>>();
 
    ArrayList<ArrayList<Node>> wea=new ArrayList<ArrayList<Node>>();
   
    NodeRoot root;
    
    ArrayList<String> Renglones=new ArrayList<String>();
   
    int eje=0;
    int size;
    int depth = 0;
    
    public Kdtree(int caso) {
        try {
            leerCadena();
            int i=0;
            for (Node n : root.caso)
            {
                System.out.println("i:"+i+++" valor:"+n);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(NIARTree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void leerCadena() throws FileNotFoundException, IOException {
        String cadena;
        Double caso = 1.0;
        
        FileReader f = new FileReader(file);
        BufferedReader bR = new BufferedReader(f);
        int ban=0;
        while((cadena = bR.readLine())!=null) 
        {
            
            //String flor = cadena.substring(16, cadena.length());
            String  renglon[] = cadena.split(",");
            
//           
                    
                    
            for(int i=0;i<renglon.length-1;i++)
            {
                Double doublec=Double.parseDouble(renglon[i]);
                Node node= new Node(doublec, caso,renglon[renglon.length-1],false);
//                System.out.println(node);
                if(ban==0)
                {
                    ArrayList<Node> tempo=new ArrayList<Node>();
                    tempo.add(node);
                    wea.add(tempo);
                    //System.out.println("agrego"+wea.get(i).toString()); 
                }
                else
                {
                    wea.get(i).add(node);
                    //System.out.println("agrego2"+wea.get(i).toString());
                }  
            }
            ban++;
        }
//        
        bR.close();
        kdTre(wea, 0);
//   
    }
    public NodeRoot addRoot(ArrayList<ArrayList<Node>> lista,int profundidad)
    {
        if(lista.isEmpty())
        {
            return null;
        }
        else
        {
            int longitud=lista.get(0).size();
            eje=profundidad%longitud;
           
            zort(lista,eje);
            int mediana=lista.size()/2;
            NodeRoot rot=new NodeRoot();
            
            rot.setCaso(lista.get(mediana));
            
            ArrayList<ArrayList<Node>> izq = menor(mediana,lista);
            rot.setLeftChild(addRoot(izq,profundidad+1));
            
            ArrayList<ArrayList<Node>> der =mayor(mediana,lista);
            rot.setRightChild( addRoot(der,profundidad+1));

            return rot;
        }
       
    }
    public void kdTre(ArrayList<ArrayList<Node>> lista, double profundidad){
        int i = 0;
       
        int x=0;
       while(x<lista.get(0).size())
       {
           ArrayList<Node> caso=new ArrayList<Node>();
           while(i< lista.size())
           {
                caso.add(lista.get(i++).get(x));
           }
           i=0;
           casos.add(caso);
           x++;
           
       }
       
      root=addRoot(casos, 0);
    }
    public void zort(ArrayList<ArrayList<Node>> lista,double eje)
    {
        int i=0;
         
        Collections.sort(lista,SENIORITY_ORDER);
    }
    public ArrayList<ArrayList<Node>> menor(int mediana,ArrayList<ArrayList<Node>> lista)
    {
        ArrayList<ArrayList<Node>> izq = new ArrayList<ArrayList<Node>>();
        int i=0;
        while(i < mediana)
        {
            izq.add(lista.get(i++));
        }
        return izq;
    }
    public ArrayList<ArrayList<Node>> mayor(int mediana,ArrayList<ArrayList<Node>> lista)
    {
        ArrayList<ArrayList<Node>> izq = new ArrayList<ArrayList<Node>>();
        int i=mediana+1;
        while(i < lista.size())
        {
            izq.add(lista.get(i++));
        }
        return izq;
    }
    public static void main(String[] args) {
//        System.out.println("Selecionar arbol:");
//        Scanner v = new Scanner(System.in);
//        int x = v.nextInt();
        Kdtree t = new Kdtree(0);
        
        
        
    }
    
     final Comparator <ArrayList<Node>> SENIORITY_ORDER = new Comparator<ArrayList<Node>>()
         {
            

        @Override
        public int compare(ArrayList<Node> o1, ArrayList<Node> o2) {
            return (o1.get(eje).key).compareTo(o2.get(eje).key); //To change body of generated methods, choose Tools | Templates.
        }
         };
}

