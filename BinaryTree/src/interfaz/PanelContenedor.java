/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author luisj
 */
public class PanelContenedor extends JPanel {
Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
CardLayout cl = new CardLayout();
PanelTenFold p10 = new PanelTenFold();
    public PanelContenedor() {
        this.setBounds(180, 0, d.width-180, d.height);
        this.setLayout(cl);
        this.add(p10,"10fold");
        cl.show(PanelContenedor.this, "10fold");
    }
    
}
