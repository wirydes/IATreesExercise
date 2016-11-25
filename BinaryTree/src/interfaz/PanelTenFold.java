/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import binarytree.Arbol;
import binarytree.Impresion;
import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author luisj
 */
public class PanelTenFold extends JPanel{
    Funt f = new Funt();
    Color negro = new Color(42,45,51);
    JScrollPane scroll = new JScrollPane();
    JScrollPane scroll2 = new JScrollPane();
    JTable tabla = new JTable();
    String[] columnNames = {"Resultado","Iteración","Valor original","Clase original","Clase resultado","Valor resultado","Distancia"};
    JTable tablaResultados = new JTable();
    String[] columnNames2 = {"Fold","Porcentaje","Tiempo"};
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    DefaultTableModel dtm= new DefaultTableModel(null, columnNames);
    DefaultTableModel dtm2= new DefaultTableModel(null, columnNames2);
    JButton correr = new JButton("Correr programa");
    JLabel success = new JLabel("Porcentaje de éxito:");
    JLabel time = new JLabel("Promedio de tiempo:");
    JLabel success2 = new JLabel();
    JLabel time2 = new JLabel();
    public PanelTenFold() {
        this.setBackground(new Color(247,247,247));
        this.setBounds(0, 0,d.width-180 , d.height);
        this.setLayout(null);
        inicializarTablas();
        inicializarBotones();
        inicializarEtiquetas();
        this.add(scroll);
        this.add(scroll2);
        this.add(correr);
        this.add(success);
        this.add(time);
        this.add(success2);
        this.add(time2);
        this.setVisible(true);
    }

    private void inicializarTablas() {
        tabla.setFont(f.oswaldLight.deriveFont(16f));
        tabla.setForeground(Color.white);
        
        tabla.setBackground(Color.white);
        tabla.setForeground(negro);
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

        @Override
        public Component getTableCellRendererComponent(JTable table, 
                Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            Component c = super.getTableCellRendererComponent(table, 
                value, isSelected, hasFocus, row, column);
            c.setBackground(row%2==0 ? Color.white : new Color(237,237,237));                        
            return c;
        };
    });
        tabla.setShowGrid(false);
        tabla.setShowVerticalLines(true);
        tabla.setRowHeight(40);
        tabla.setGridColor(new Color(52,45,51));   
        tabla.setRowMargin(6);
        tabla.setFillsViewportHeight(true);
        tabla.setModel(dtm);
        Border border2 = BorderFactory.createLineBorder(negro,1); 
        scroll.setBorder(border2);
        scroll.setViewportView (tabla);
        scroll.getVerticalScrollBar().setUI(new ScrollBar());
        scroll.setBounds(0, d.height-500, 700, 440);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setPreferredWidth(80);
        columnModel.getColumn(4).setPreferredWidth(80);
        columnModel.getColumn(5).setPreferredWidth(80);
        columnModel.getColumn(6).setPreferredWidth(80);
        JTableHeader header = tabla.getTableHeader();
        header.setBackground(new Color(247,247,247));
        header.setForeground(new Color(52,45,51));
        header.setFont(f.oswaldLight.deriveFont(17f));
        header.setPreferredSize(new Dimension(100, 40));
        header.setBorder(border2);
        
        
        
    /////////////////////////////////////
        tablaResultados.setFont(f.oswaldLight.deriveFont(16f));
        tablaResultados.setForeground(Color.white);
        
        tablaResultados.setBackground(Color.white);
        tablaResultados.setForeground(negro);
        
        DefaultTableCellRenderer tcr2 = new DefaultTableCellRenderer();
        tcr2.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tablaResultados.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

        @Override
        public Component getTableCellRendererComponent(JTable table, 
                Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            Component c = super.getTableCellRendererComponent(table, 
                value, isSelected, hasFocus, row, column);
            c.setBackground(row%2==0 ? Color.white : new Color(237,237,237));                        
            return c;
        };
    });
    
        tablaResultados.setShowGrid(false);
        tablaResultados.setShowVerticalLines(true);
        tablaResultados.setRowHeight(40);
        tablaResultados.setGridColor(new Color(52,45,51));   
        tablaResultados.setRowMargin(6);
        tablaResultados.setFillsViewportHeight(true);
        tablaResultados.setModel(dtm2);
        
        scroll2.setBorder(border2);
        scroll2.setViewportView (tablaResultados);
        scroll2.getVerticalScrollBar().setUI(new ScrollBar());
        scroll2.setBounds(720, d.height-500, 300, 440);
        TableColumnModel columnModel2 = tablaResultados.getColumnModel();
        columnModel2.getColumn(0).setPreferredWidth(50);
        columnModel2.getColumn(1).setPreferredWidth(80);
        columnModel2.getColumn(2).setPreferredWidth(80);
        
        JTableHeader header2 = tablaResultados.getTableHeader();
        header2.setBackground(new Color(247,247,247));
        header2.setForeground(new Color(52,45,51));
        header2.setFont(f.oswaldLight.deriveFont(17f));
        header2.setPreferredSize(new Dimension(100, 40));
        header2.setBorder(border2);
    }

    private void inicializarBotones() {
        correr.setBounds(0,100, 150, 40);
        correr.addActionListener(generarArbol);
        correr.setFont(f.oswaldLight);
        correr.setForeground(negro);
        correr.setBackground(null);
        correr.setBorder(BorderFactory.createLineBorder(negro, 1));
    }
    ActionListener generarArbol = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           dtm.setRowCount(0);
            dtm2.setRowCount(0);
            Arbol a = new Arbol();
            
            for (Impresion item : a.listaTabla) {
                Object[] newRow={item.correcto,item.tres,item.key,item.key0,item.flor,item.flor0,item.valor};
                dtm.addRow(newRow);
            }
            for (int i = 0; i < a.listaPorcentaje.size(); i++) {
                Object[] newRow={(i+1),a.listaPorcentaje.get(i),a.listaTiempos.get(i)};
                dtm2.addRow(newRow);
            
        }
            success2.setText(a.p);
            time2.setText(a.t);
            
            
        }
    };

    private void inicializarEtiquetas() {
        success.setBounds(0, 0, 200, 30);
        time.setBounds(0,30,200,30);
        success2.setBounds(150, 0, 200, 30);
        time2.setBounds(150,30,250,30);
        success.setFont(f.oswaldLight);
        time.setFont(f.oswaldLight);
        success2.setFont(f.oswaldLight);
        time2.setFont(f.oswaldLight);
    }
    
}
