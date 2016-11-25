/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author luisj
 */
public class Frame extends JFrame {

    public Frame() {
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        
        this.add(new PanelContenedor());
        this.add(new PanelIzquierdo());
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Frame();
    }
    
}
