/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.util.ArrayList;

public class NodeRoot 
{
    ArrayList<Node> caso;
    NodeRoot leftChild;
    NodeRoot rightChild;
    
    public NodeRoot()
    {
        
    }

    public ArrayList<Node> getCaso() {
        return caso;
    }

    public void setCaso(ArrayList<Node> caso) {
        this.caso = caso;
    }

    public NodeRoot getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeRoot leftChild) {
        this.leftChild = leftChild;
    }

    public NodeRoot getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodeRoot rightChild) {
        this.rightChild = rightChild;
    }
}
