package Serverdemo;

import Projectdemo.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import Populate.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.table.DefaultTableCellRenderer;
public class RunningServicesTable extends JFrame implements MouseListener{

    public JPanel p[] = new JPanel[10];
    public JTable table[] = new JTable[10];
    public JScrollPane scrp[] = new JScrollPane[10];
    public Container c;
    DefaultTableModel model[] = new DefaultTableModel[10];
    TitledBorder border[] = new TitledBorder[10];
    Font f[] = new Font[30];
    String colms[] = {"Serial No.", "Customer Name", "Type", "Description"};
    Popupclass pop;
    Home h1;
    RunningServicesTable(Home h1)
    {
        initcomponents();
        panel();
        border();
        table();
        popupmenu();
        this.h1=h1;
    }

    public void initcomponents() {

        this.setBounds(0, 100, 1900, 900);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);

    }

    public void panel() {
        p[1] = new JPanel();
        c.add(p[1]);
        p[1].setBounds(30, 30, 600, 400);
        // p[1].setBackground(Color.red);

        p[2] = new JPanel();
        c.add(p[2]);
        p[2].setBounds(1250, 30, 600, 400);
        //p[2].setBackground(Color.red);

        p[3] = new JPanel();
        c.add(p[3]);
        p[3].setBounds(1250, 450, 600, 380);
        //  p[3].setBackground(Color.red);

        p[4] = new JPanel();
        c.add(p[4]);
        p[4].setBounds(30, 450, 600, 380);
        //p[4].setBackground(Color.red);

        p[5] = new JPanel();
        c.add(p[5]);
        p[5].setBounds(640, 250, 600, 400);
        // p[5].setBackground(Color.red);

    }

    public void border() {
        f[3] = new Font("Arial", Font.BOLD, 25);
        border[1] = new TitledBorder("SERVICE DESK 1");
        border[1].setTitleJustification(TitledBorder.LEFT);
        border[1].setTitlePosition(TitledBorder.TOP);
        border[1].setTitleColor(Color.RED);
        border[1].setTitleFont(f[3]);
        p[1].setBorder(border[1]);

        border[2] = new TitledBorder("SERVICE DESK 2");
        border[2].setTitleJustification(TitledBorder.LEFT);
        border[2].setTitlePosition(TitledBorder.TOP);
        border[2].setTitleColor(Color.RED);
        border[2].setTitleFont(f[3]);
        p[2].setBorder(border[2]);

        border[3] = new TitledBorder("SERVICE DESK 3");
        border[3].setTitleJustification(TitledBorder.LEFT);
        border[3].setTitlePosition(TitledBorder.TOP);
        border[3].setTitleColor(Color.RED);
        border[3].setTitleFont(f[3]);
        p[3].setBorder(border[3]);

        border[4] = new TitledBorder("SERVICE DESK 4");
        border[4].setTitleJustification(TitledBorder.LEFT);
        border[4].setTitlePosition(TitledBorder.TOP);
        border[4].setTitleColor(Color.RED);
        border[4].setTitleFont(f[3]);
        p[4].setBorder(border[4]);

        border[5] = new TitledBorder("SERVICE DESK 5");
        border[5].setTitleJustification(TitledBorder.LEFT);
        border[5].setTitlePosition(TitledBorder.TOP);
        border[5].setTitleColor(Color.RED);
        border[5].setTitleFont(f[3]);
        p[5].setBorder(border[5]);
       
    }

    public void table() {
        table[1] = new JTable();
        scrp[1] = new JScrollPane(table[1]);
        p[1].setLayout(null);
        p[1].add(scrp[1]);
        scrp[1].setBounds(20, 30, 560, 350);
        table[1].setRowHeight(table[1].getRowHeight() + 15);
        model[1] = (DefaultTableModel) table[1].getModel();
        for (int i= 0; i< 4; i++) {
            model[1].addColumn(colms[i]);
        }    
         table[1].setBackground(Color.decode("#058dc7"));
         table[1].setForeground(Color.WHITE);
         f[1] = new Font("Arial", Font.BOLD, 12);
         table[1].setFont(f[1]);
         
         
         table[2] = new JTable();
        scrp[2] = new JScrollPane(table[2]);
        p[2].setLayout(null);
        p[2].add(scrp[2]);
        scrp[2].setBounds(20, 30, 560, 350);
        table[2].setRowHeight(table[2].getRowHeight() + 15);
        model[2] = (DefaultTableModel) table[2].getModel();
        for (int i= 0; i< 4; i++) {
            model[2].addColumn(colms[i]);
        }     
         table[2].setBackground(Color.decode("#058dc7"));
         table[2].setForeground(Color.WHITE);
         table[2].setFont(f[1]);
        
        
        
         table[3] = new JTable();
        scrp[3] = new JScrollPane(table[3]);
        p[3].setLayout(null);
        p[3].add(scrp[3]);
        scrp[3].setBounds(20, 30, 560, 340);
        table[3].setRowHeight(table[1].getRowHeight() + 15);
        model[3] = (DefaultTableModel) table[3].getModel();
        for (int i= 0; i< 4; i++) {
            model[3].addColumn(colms[i]);
        }   
         table[3].setBackground(Color.decode("#058dc7"));
         table[3].setForeground(Color.WHITE);
         table[3].setFont(f[1]);
        
        
         table[4] = new JTable();
        scrp[4] = new JScrollPane(table[4]);
        p[4].setLayout(null);
        p[4].add(scrp[4]);
        scrp[4].setBounds(20, 30, 560, 340);
        table[4].setRowHeight(table[4].getRowHeight() + 15);
        model[4] = (DefaultTableModel) table[4].getModel();
        for (int i= 0; i< 4; i++) {
            model[4].addColumn(colms[i]);
        }   
         table[4].setBackground(Color.decode("#058dc7"));
         table[4].setForeground(Color.WHITE);
         table[4].setFont(f[1]);
        
        
         table[5] = new JTable();
        scrp[5] = new JScrollPane(table[5]);
        p[5].setLayout(null);
        p[5].add(scrp[5]);
        scrp[5].setBounds(20, 30, 560, 350);
        table[5].setRowHeight(table[5].getRowHeight() + 15);
        model[5] = (DefaultTableModel) table[5].getModel();
        for (int i= 0; i< 4; i++) {
            model[5].addColumn(colms[i]);
        } 
         table[5].setBackground(Color.decode("#058dc7"));
         table[5].setForeground(Color.WHITE);
         table[5].setFont(f[1]);
        
       
     TableColumn column = null;
      
        // column = table[1].getColumnModel().getColumn(0);
        for (int i = 1; i <=5; i++) {
        for (int t = 0; t < 4; t++) {
            column = table[i].getColumnModel().getColumn(t);
            if (t == 0) {
                column.setPreferredWidth(80);
            }
            if (t == 1) {
                column.setPreferredWidth(220);
            }
            if (t == 2) {
                column.setPreferredWidth(200);
            }
            if (t == 3) {
                column.setPreferredWidth(300);
            }

        }
        }
         cellallignment();
    }
      public void cellallignment() {
         for (int i = 1; i <=5; i++) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table[i].getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table[i].getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
          }
      
    }
    public void update(int r,int tableno) throws IOException
    {
        h1.st.deletemsg(tableno, r);
        model[tableno].removeRow(r);
       int temp=model[tableno].getRowCount();
        System.out.println(""+r);              
       // System.out.println(""+temp+" "+k);
        for (int i = r; i <temp; i++) {
           table[tableno].setValueAt(""+(i+1), i,0);   
        }
     h1.arr[tableno-1]--;
        
    }
      
    public void popupmenu()
    {
        pop=new Popupclass(this);
        table[1].addMouseListener(this);
        table[2].addMouseListener(this);
        table[3].addMouseListener(this);
        table[4].addMouseListener(this);
        table[5].addMouseListener(this);
    }
    public void populate(int tableno,Populate t1)
    {
        String ar[]={t1.sn.toString(),t1.cn.toString(),t1.t.toString(),t1.d.toString()};
        model[tableno].addRow(ar);
    }

    public static void main(String[] args) {
      //  RunningServicesTable frame = new RunningServicesTable();
       // frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
          if(e.getSource()==table[1])
        {
            System.out.println("Clicked");
               pop.flag=1;
           if(SwingUtilities.isRightMouseButton(e))
               {
                   pop.show(e.getComponent(),e.getX(),e.getY());
                  
               }
        }
          if(e.getSource()==table[2])
        {
               pop.flag=2;
           if(SwingUtilities.isRightMouseButton(e))
               {
                   pop.show(e.getComponent(),e.getX(),e.getY());
                  
               }
        }
            if(e.getSource()==table[3])
        {
               pop.flag=3;
           if(SwingUtilities.isRightMouseButton(e))
               {
                   pop.show(e.getComponent(),e.getX(),e.getY());
                  
               }
        }
              if(e.getSource()==table[4])
        {
               pop.flag=4;
           if(SwingUtilities.isRightMouseButton(e))
               {
                   pop.show(e.getComponent(),e.getX(),e.getY());
                  
               }
        }
                if(e.getSource()==table[5])
        {
               pop.flag=5;
           if(SwingUtilities.isRightMouseButton(e))
               {
                   pop.show(e.getComponent(),e.getX(),e.getY());
                  
               }
        }
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
