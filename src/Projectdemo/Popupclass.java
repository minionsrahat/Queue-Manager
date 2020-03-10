
package Projectdemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

public class Popupclass extends JPopupMenu implements ActionListener {
    JMenuItem itm[]=new JMenuItem[10];
    Home2 h1;
    int flag;
   // public Popupclass(JTable tb,Home2 h1)
    public Popupclass(Home2 h1)
    {
       // itm[1]=new JMenuItem("Call");
        itm[2]=new JMenuItem("Edit");
        itm[1]=new JMenuItem("Delete");
       // itm[4]=new JMenuItem("Call");
       this.add(itm[1]);
       this.add(new Separator());
       this.add(itm[2]);
     
       //this.add(itm[3]);
       this.h1=h1;
       itm[1].addActionListener(this);
       
     
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==itm[1]&&flag==1)
        {
             h1.update(h1.table[1].getSelectedRow());
        
        }//
    }
    
}
