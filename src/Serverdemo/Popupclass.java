/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverdemo;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import Populate.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author KOCHI
 */
public class Popupclass extends JPopupMenu implements ActionListener{
    JMenuItem itm[]=new JMenuItem[10];
    Home h1;
    int flag=0;
    RunningServicesTable rst;
    public Popupclass(RunningServicesTable rst)
    {
        itm[1]=new JMenuItem("Delete");
        itm[2]=new JMenuItem("Edit");
        this.rst=rst;
        
       this.add(itm[1]);
       this.add(new Separator());
   //    this.add(itm[2]);
       itm[1].addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==itm[1])
        {
            try {
                //   h1.st.Senddata("0","Remove",""+h1.table[1].getSelectedRow());
                // h1.update(h1.table[1].getSelectedRow());
                // h1.model.removeRow(h1.table[1].getSelectedRow());
                System.out.println(rst.table[flag].getSelectedRow());
                rst.update(rst.table[flag].getSelectedRow(), flag);
            } catch (IOException ex) {
                Logger.getLogger(Popupclass.class.getName()).log(Level.SEVERE, null, ex);
            }
               JOptionPane.showMessageDialog(null,"DELETED");
        }
    }
}
