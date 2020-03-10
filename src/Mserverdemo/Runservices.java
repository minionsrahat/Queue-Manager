package Mserverdemo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import MediPopulate.*;
public class Runservices extends JFrame {

    public JPanel p[] = new JPanel[10];
    public Container c;
    public Font f[] = new Font[10];
    public JTextField jtf[] = new JTextField[30];
    public JLabel jl[] = new JLabel[30];
    TitledBorder border[] = new TitledBorder[10];
    public JTable table[] = new JTable[10];
    public JScrollPane scrp[] = new JScrollPane[10];
    DefaultTableModel model[] = new DefaultTableModel[10];
    String colms[] = {"Serial No.", "Customer Name", "Gender", "Description"};

    public Runservices() {
        initcomponents();
        panel();
        border();
        textfield();
        table(); 

    }

    public void initcomponents() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(100, 60, 1800, 900);
        c = this.getContentPane();
        c.setLayout(null);
    }

    public void panel() {
        p[1] = new JPanel();
        c.add(p[1]);
        p[1].setBounds(150, 30, 310, 300);
        p[1].setBackground(new Color(204, 204, 255));
        p[1].setLayout(null);
        jl[1] = new JLabel("Client Name");
        p[1].add(jl[1]);
        jl[1].setBounds(100, 30, 100, 50);
        jl[2] = new JLabel("Serial No:");
        p[1].add(jl[2]);
        jl[2].setBounds(20, 120, 100, 50);
        jl[3] = new JLabel("Updated Message:");
        p[1].add(jl[3]);
        jl[3].setBounds(80, 180, 150, 50);

        p[2] = new JPanel();
        c.add(p[2]);
        p[2].setBounds(730, 30, 310, 300);
        p[2].setBackground(new Color(204, 204, 255));
        p[2].setLayout(null);
        jl[4] = new JLabel("Client Name");
        p[2].add(jl[4]);
        jl[4].setBounds(100, 30, 100, 50);
        jl[5] = new JLabel("Serial No:");
        p[2].add(jl[5]);
        jl[5].setBounds(20, 120, 100, 50);
        jl[6] = new JLabel("Updated Message:");
        p[2].add(jl[6]);
        jl[6].setBounds(80, 180, 150, 50);

        p[3] = new JPanel();
        c.add(p[3]);
        p[3].setBounds(1300, 30, 310, 300);
        p[3].setBackground(new Color(204, 204, 255));
        p[3].setLayout(null);
        jl[7] = new JLabel("Client Name");
        p[3].add(jl[7]);
        jl[7].setBounds(100, 30, 100, 50);
        jl[8] = new JLabel("Serial No:");
        p[3].add(jl[8]);
        jl[8].setBounds(20, 120, 100, 50);
        jl[9] = new JLabel("Updated Message:");
        p[3].add(jl[9]);
        jl[9].setBounds(80, 180, 150, 50);

        p[4] = new JPanel();
        c.add(p[4]);
        p[4].setBounds(30, 370, 550, 400);
        // p[1].setBackground(Color.red);

        p[5] = new JPanel();
        c.add(p[5]);
        p[5].setBounds(600, 370, 550, 400);
        //p[2].setBackground(Color.red);

        p[6] = new JPanel();
        c.add(p[6]);
        p[6].setBounds(1170, 370, 550, 400);
    }

    public void border() {
        f[3] = new Font("Arial", Font.BOLD, 18);
        border[1] = new TitledBorder("HEART DISEASE ");
        border[1].setTitleJustification(TitledBorder.LEFT);
        border[1].setTitlePosition(TitledBorder.TOP);
        border[1].setTitleColor(Color.RED);
        border[1].setTitleFont(f[3]);
        p[1].setBorder(border[1]);

        border[2] = new TitledBorder("EYESIGHT ");
        border[2].setTitleJustification(TitledBorder.LEFT);
        border[2].setTitlePosition(TitledBorder.TOP);
        border[2].setTitleColor(Color.RED);
        border[2].setTitleFont(f[3]);
        p[2].setBorder(border[2]);

        border[3] = new TitledBorder("LIVER ");
        border[3].setTitleJustification(TitledBorder.LEFT);
        border[3].setTitlePosition(TitledBorder.TOP);
        border[3].setTitleColor(Color.RED);
        border[3].setTitleFont(f[3]);
        p[3].setBorder(border[3]);

        f[4] = new Font("Arial", Font.BOLD, 25);
        border[4] = new TitledBorder("SERVICE DESK 1");
        border[4].setTitleJustification(TitledBorder.LEFT);
        border[4].setTitlePosition(TitledBorder.TOP);
        border[4].setTitleColor(Color.RED);
        border[4].setTitleFont(f[4]);
        p[4].setBorder(border[4]);

        border[5] = new TitledBorder("SERVICE DESK 2");
        border[5].setTitleJustification(TitledBorder.LEFT);
        border[5].setTitlePosition(TitledBorder.TOP);
        border[5].setTitleColor(Color.RED);
        border[5].setTitleFont(f[4]);
        p[5].setBorder(border[5]);

        border[6] = new TitledBorder("SERVICE DESK 3");
        border[6].setTitleJustification(TitledBorder.LEFT);
        border[6].setTitlePosition(TitledBorder.TOP);
        border[6].setTitleColor(Color.RED);
        border[6].setTitleFont(f[4]);
        p[6].setBorder(border[6]);

    }

    public void textfield() {
        //panel 1
        f[5] = new Font("Arial", Font.BOLD, 16);
        jtf[1] = new JTextField();
        jtf[1].setFont(f[5]);
        p[1].add(jtf[1]);
        jtf[1].setEditable(false);
        jtf[1].setBounds(50, 70, 200, 40);

        jtf[2] = new JTextField();
        jtf[2].setFont(f[5]);
        p[1].add(jtf[2]);
        jtf[2].setEditable(false);
        jtf[2].setBounds(100, 125, 50, 40);

        jtf[3] = new JTextField();
        jtf[3].setFont(f[5]);
        p[1].add(jtf[3]);
        jtf[3].setEditable(false);
        jtf[3].setBounds(40, 235, 220, 60);

        //panel 2
        jtf[4] = new JTextField();
        jtf[4].setFont(f[5]);
        p[2].add(jtf[4]);
        jtf[4].setEditable(false);
        jtf[4].setBounds(50, 70, 200, 40);

        jtf[5] = new JTextField();
        jtf[5].setFont(f[5]);
        p[2].add(jtf[5]);
        jtf[5].setEditable(false);
        jtf[5].setBounds(100, 125, 50, 40);

        jtf[6] = new JTextField();
        jtf[6].setFont(f[5]);
        p[2].add(jtf[6]);
        jtf[6].setEditable(false);
        jtf[6].setBounds(40, 235, 220, 60);

        //panel 3
        jtf[7] = new JTextField();
        jtf[7].setFont(f[5]);
        p[3].add(jtf[7]);
        jtf[7].setEditable(false);
        jtf[7].setBounds(50, 70, 200, 40);

        jtf[8] = new JTextField();
        jtf[8].setFont(f[5]);
        p[3].add(jtf[8]);
        jtf[8].setEditable(false);
        jtf[8].setBounds(100, 125, 50, 40);

        jtf[9] = new JTextField();
        jtf[9].setFont(f[5]);
        p[3].add(jtf[9]);
        jtf[9].setEditable(false);
        jtf[9].setBounds(40, 235, 220, 60);
    }

    public void table() {
        table[1] = new JTable();
        scrp[1] = new JScrollPane(table[1]);
        p[4].setLayout(null);
        p[4].add(scrp[1]);
        scrp[1].setBounds(20, 30, 510, 350);
        table[1].setRowHeight(table[1].getRowHeight() + 15);
        model[1] = (DefaultTableModel) table[1].getModel();
        for (int i = 0; i < 4; i++) {
            model[1].addColumn(colms[i]);
        }
        table[1].setBackground(Color.decode("#058dc7"));
        table[1].setForeground(Color.WHITE);
        f[1] = new Font("Arial", Font.BOLD, 12);
        table[1].setFont(f[1]);

        table[2] = new JTable();
        scrp[2] = new JScrollPane(table[2]);
        p[5].setLayout(null);
        p[5].add(scrp[2]);
        scrp[2].setBounds(20, 30, 510, 350);
        table[2].setRowHeight(table[2].getRowHeight() + 15);
        model[2] = (DefaultTableModel) table[2].getModel();
        for (int i = 0; i < 4; i++) {
            model[2].addColumn(colms[i]);
        }
        table[2].setBackground(Color.decode("#058dc7"));
        table[2].setForeground(Color.WHITE);
        table[2].setFont(f[1]);

        table[3] = new JTable();
        scrp[3] = new JScrollPane(table[3]);
        p[6].setLayout(null);
        p[6].add(scrp[3]);
        scrp[3].setBounds(20, 30, 510, 350);
        table[3].setRowHeight(table[1].getRowHeight() + 15);
        model[3] = (DefaultTableModel) table[3].getModel();
        for (int i = 0; i < 4; i++) {
            model[3].addColumn(colms[i]);
        }
        table[3].setBackground(Color.decode("#058dc7"));
        table[3].setForeground(Color.WHITE);
        table[3].setFont(f[1]);
        
        
        TableColumn column = null;
      
        // column = table[1].getColumnModel().getColumn(0);
        for (int i = 1; i <=3; i++) {
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
         for (int i = 1; i <=3; i++) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table[i].getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table[i].getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
          }
      
    }
    public void populate(int tableno,Medipopulate t1)
    {
        String ar[]={t1.sn.toString(),t1.cn.toString(),t1.gen.toString(),t1.d.toString()};
        model[tableno].addRow(ar);
    }
   public void populate_desk_1(Medipopulate t1) {
        jtf[1].setText("");
        jtf[2].setText("");
        jtf[3].setText("");
        ////
        jtf[1].setText(t1.cn);
        jtf[2].setText(t1.sn);
    }

    public void populate_desk_2(Medipopulate t1) {
        jtf[4].setText("");
        jtf[5].setText("");
        jtf[6].setText("");
        ////
        jtf[4].setText(t1.cn);
        jtf[5].setText(t1.sn);
    }

    public void populate_desk_3(Medipopulate t1) {
        jtf[7].setText("");
        jtf[8].setText("");
        jtf[9].setText("");
        ////
        jtf[7].setText(t1.cn);
        jtf[8].setText(t1.sn);
    }

    public static void main(String[] args) {
        Runservices f = new Runservices();
        f.setVisible(true);
    }
}
