/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author luisj
 */
public class PanelIzquierdo extends JPanel {
Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
Color negro = new Color(42,45,51);
JButton tenFold = new JButton("Ten fold");
    public PanelIzquierdo() {
       this.setBounds(0, 0, 180, d.height);
       this.setBackground(new Color(247,247,247));
       tenFold.setBounds(0, 0, 180, 40);
       tenFold.setBackground(negro);
       tenFold.setBorder(null);
       tenFold.setForeground(Color.white);
       //this.add(tenFold);
       
    }
    
}
