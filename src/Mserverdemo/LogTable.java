
package Mserverdemo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import MediPopulate.*;

public class LogTable extends JFrame{
     DefaultTableModel model=new DefaultTableModel();
     JScrollPane scr;
     Container c;
     JPanel p;
     TitledBorder border[] = new TitledBorder[10];
     JTable tb;
     String colms[] = {"Serial No.", "Customer Name", "Gender", "Description","Desk No"};
   
      Font f[]=new Font[10];
    LogTable()
    {
        initcomponents();
    }
    public void initcomponents() {
    //  this.setVisible(true);
       this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       this.setBounds(500,100,800,900);
        c=this.getContentPane();
         c.setLayout(null);
         p=new JPanel();
         c.add(p);
         p.setBounds(40,80,730,750);
        tb = new JTable();
        scr = new JScrollPane(tb);
        p.setLayout(null);
        p.add(scr);
        scr.setBounds(10, 50, 710, 690);
        tb.setBackground(Color.decode("#058dc7"));
        tb.setForeground(Color.WHITE);
        f[1] = new Font("Arial", Font.BOLD, 14);
       f[2] = new Font("Arial", Font.BOLD, 20);
       tb.setFont(f[1]);
        tb.setRowHeight(tb.getRowHeight()+15);
        model=(DefaultTableModel)tb.getModel();
        for (int l = 0; l <5; l++) {
            model.addColumn(colms[l]);     
        }
            TableColumn column = null;
      
        // column = table[1].getColumnModel().getColumn(0);

          for (int t = 0; t < 5; t++) {
            column = tb.getColumnModel().getColumn(t);
            if (t == 0) {
                column.setPreferredWidth(80);
            }
            if (t == 1) {
                column.setPreferredWidth(200);
            }
            if (t == 2) {
                column.setPreferredWidth(180);
            }
            if (t == 3) {
                column.setPreferredWidth(200);
            }
             if (t == 4) {
                column.setPreferredWidth(170);
            }
        }
        border[1] = new TitledBorder("LOG TABLE");
        border[1].setTitleJustification(TitledBorder.LEFT);
        border[1].setTitlePosition(TitledBorder.TOP);
        border[1].setTitleColor(Color.RED);
          border[1].setTitleFont(f[2]);
      p.setBorder(border[1]);
        
    }
      public void populate(Medipopulate t1,String deskno )
   {
       String rows[]={t1.sn,t1.cn,t1.gen,t1.d,deskno};
       model.addRow(rows);
       
          }
      
      public void filewriter(Medipopulate t1,String deskno )
      {
           //String data[]={sn,cn,ty,des};
         try {
             FileWriter fr=new FileWriter("History.txt",true);
             fr.write(t1.sn+" "+" ");
             fr.write(t1.cn+" "+" ");
             fr.write(t1.gen+" "+" ");
             fr.write(t1.d+" "+" ");
             fr.write(deskno+" "+" ");
             fr.write(System.getProperty("line.separator"));
             fr.close();
             
         } catch (IOException ex) {
             Logger.getLogger(LogTable.class.getName()).log(Level.SEVERE, null, ex);
         }
          
      }
    public static void main(String[] args) {
        LogTable frame=new LogTable();
    }

    
    
}
