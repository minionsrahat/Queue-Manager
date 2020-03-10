/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientdemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import Populate.*;
/**
 *
 * @author KOCHI
 */
public class Popupclass extends JPopupMenu implements ActionListener{
      JMenuItem itm[]=new JMenuItem[10];
      Home1 h1;
    public Popupclass(JTable tb,Home1 h1)
    {
        itm[1]=new JMenuItem("Call");
        itm[2]=new JMenuItem("Edit");
        this.h1=h1;
        
       this.add(itm[1]);
       this.add(new JPopupMenu.Separator());
       this.add(itm[2]);
       itm[1].addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==itm[1])
        {
               // h1.st.Senddata("0","Remove",""+h1.table[1].getSelectedRow());
            h1.setrunningservice(h1.table[1].getValueAt(0,0).toString(), h1.table[1].getValueAt(0,1).toString(),h1.table[1].getValueAt(0,2).toString(),h1.table[1].getValueAt(0,3).toString());
            try {
               // h1.rt.send(h1.table[1].getSelectedRow(),"Delete");
            } catch (Exception ex) {
                Logger.getLogger(Popupclass.class.getName()).log(Level.SEVERE, null, ex);
            }
          //  h1.model.removeRow(h1.table[1].getSelectedRow());
          h1.update(h1.table[1].getSelectedRow());
             
               JOptionPane.showMessageDialog(null,"ADDED");
        }
    }
    
}
