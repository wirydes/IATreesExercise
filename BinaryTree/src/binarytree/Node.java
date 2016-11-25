/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author luisj
 */
public class Node {
    Double key;
    Double name;
    String flor;
    boolean visitado;
    Node left;
    Node right;

    public Node(Double key, Double name,String flor, boolean visitado) {
        this.key = key;
        this.name = name;
        this.flor = flor;
        this.visitado = visitado;
    }

    @Override
    public String toString() {
        return "Node{" + "key=" + key + ", profundidad=" + name + ", flor=" + flor + '}';
    }

    int compareTo(Node get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
