package Serverdemo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView.TableRow;

public class Home extends JFrame implements ActionListener {
    public static int a= 0, q = 0, r=1;
    public static int i = 0, j = 0, t;
    public static int flag = 0;
    public static int k = 1;
    private Container c;
    JTable table[] = new JTable[10];
    DefaultTableModel model=new DefaultTableModel();
    JPanel p[] = new JPanel[10];
    JLabel jl[] = new JLabel[16];
    JTextField jtf[] = new JTextField[30];
    JTextArea jta[] = new JTextArea[30];
    JButton btn[] = new JButton[20];
    JScrollPane pane;
    TitledBorder border[] = new TitledBorder[10];
    JFrame frame;
    JComboBox jcb[] = new JComboBox[10];
    JScrollPane srp[] = new JScrollPane[10];
    Font f[] = new Font[30];
    String colms[] = {"Serial No.", "Customer Name", "Type", "Description"};
    String rows[][] = new String[100][4];
    String item[] = {"Software", "Hardware"};
    JMenuBar mb;
     JMenu menu;
    JMenuItem mitem[]=new  JMenuItem[20];
    LogTable lt=new LogTable();
     Sendthread st;
     //Home h1;
    // Thread t1=new Thread(st);
   // LogTable lt = new LogTable();
    Home() throws IOException {
    
        initcomponents();
        panel();
        label();
        textfield();
        combobox();
        Button();
        table();
        font();
        menu();
       st=new Sendthread(this);
      // Sendthread st=new Sendthread();
       st.Connect();
       st.start();
    }

    public void initcomponents() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 100, 1300, 800);
        c = this.getContentPane();
        c.setLayout(null);
        f[3] = new Font("Arial", Font.BOLD, 25);

        border[1] = new TitledBorder("Server SERVICE");
        border[1].setTitleJustification(TitledBorder.LEFT);
        border[1].setTitlePosition(TitledBorder.TOP);
        border[1].setTitleColor(Color.RED);
        border[1].setTitleFont(f[3]);
    
        border[2] = new TitledBorder("RUNNING SERVICE");
        border[2].setTitleJustification(TitledBorder.LEFT);
        border[2].setTitlePosition(TitledBorder.TOP);
        border[2].setTitleFont(f[3]);
        border[2].setTitleColor(Color.RED);
        border[3] = new TitledBorder("LIST OF SERVICES");
        border[3].setTitleJustification(TitledBorder.LEFT);
        border[3].setTitlePosition(TitledBorder.TOP);
        border[3].setTitleColor(Color.RED);
        border[3].setTitleFont(f[3]);
    }

    public void panel() {
        // p[4] = new JPanel();
        // c.add(p[4]);
        //  p[4].setBounds(0, 00, 900, 700);
        // p[4].setBorder(border[3]);
        //panel(1)
        p[1] = new JPanel();
        c.add(p[1]);
        p[1].setBounds(20, 20, 450, 300);
        p[1].setBackground(new Color(204, 204, 255));

        p[1].setBorder(border[1]);
        //panel(2)
        p[2] = new JPanel();
        c.add(p[2]);
        p[2].setBounds(580, 20, 450, 300);
        p[2].setBackground(new Color(204, 255, 153));
        p[1].setBorder(border[1]);
        p[2].setBorder(border[2]);
        //panel(3)
        p[3] = new JPanel();
        c.add(p[3]);
        p[3].setBounds(20, 350, 930, 400);
        p[3].setBackground(Color.lightGray);
        p[3].setBorder(border[3]);
    }

    public void label() {
        // panel(1)
        jl[1] = new JLabel("Name");
        p[1].setLayout(null);
        p[1].add(jl[1]);
        jl[1].setBounds(20, 30, 100, 50);
        jl[2] = new JLabel("Type");
        p[1].add(jl[2]);
        jl[2].setBounds(20, 90, 100, 50);
        jl[3] = new JLabel("Description");
        p[1].add(jl[3]);
        jl[3].setBounds(20, 150, 100, 50);

        //panel(2)
        p[2].setLayout(null);
        jl[4] = new JLabel("Name");
        p[2].add(jl[4]);
        jl[4].setBounds(20, 30, 100, 50);
        jl[5] = new JLabel("Type");
        p[2].add(jl[5]);
        jl[5].setBounds(20, 90, 100, 50);
        jl[6] = new JLabel("Description");
        p[2].add(jl[6]);
        jl[6].setBounds(20, 150, 100, 50);
        jl[7] = new JLabel("Serial");
        p[2].add(jl[7]);
        jl[7].setBounds(20, 210, 100, 50);

    }

    public void textfield() {
        //panel(1)
        jtf[1] = new JTextField();
        jta[1] = new JTextArea();
        jta[1].setLineWrap(true);
        jta[1].setWrapStyleWord(true);
        p[1].add(jtf[1]);
        jtf[1].setBounds(105, 37, 210, 40);
        srp[1] = new JScrollPane(jta[1]);
        p[1].add(srp[1]);
        srp[1].setBounds(105, 157, 210, 60);
        //panel(2)
        jtf[3] = new JTextField();
        jta[2] = new JTextArea();
        jta[2].setLineWrap(true);
        jta[2].setWrapStyleWord(true);
        p[2].add(jtf[3]);
        jtf[3].setBounds(105, 37, 210, 40);
        srp[2] = new JScrollPane(jta[2]);
        p[2].add(srp[2]);
        srp[2].setBounds(105, 157, 210, 40);
        jtf[4] = new JTextField();
        p[2].add(jtf[4]);
        jtf[4].setBounds(105, 94, 210, 40);
        jtf[5] = new JTextField();
        p[2].add(jtf[5]);
        jtf[5].setBounds(105, 220, 100, 30);

    }

    public void combobox() {
        jcb[1] = new JComboBox(item);
        p[1].add(jcb[1]);
        jcb[1].setBounds(105, 94, 210, 40);
    }

    public void Button() {
        //panel(1);
        btn[1] = new JButton();
        p[1].add(btn[1]);
        btn[1].setText("Add Queue");
        btn[1].setBounds(110, 235, 200, 35);

        //panel(2);
        btn[2] = new JButton();
        p[2].add(btn[2]);
        btn[2].setText("Complete");
        btn[2].setBounds(215, 220, 100, 30);
        btn[3] = new JButton();
        p[2].add(btn[3]);
        btn[3].setText("Start");
        btn[3].setBounds(125, 260, 150, 30);
        //Actionlistener

        btn[1].addActionListener(this);
        btn[2].addActionListener(this);
        btn[3].addActionListener(this);

    }
     public void menu() {
         System.out.println("1111");
         mb=new JMenuBar();
        //  c.setJMenuBar(mb);
        p[4]=new JPanel();
         p[4].setBounds(490,30,80,70);
         p[4].add(mb);
         c.add(p[4]);

         menu=new JMenu("MENU");
         mitem[1]=new JMenuItem("History Log Table");
         mitem[2]=new JMenuItem("Priority Search");
         mitem[3]=new JMenuItem("Delete Queue Member");
         mitem[4]=new JMenuItem("Reset");
         mb.add(menu);
        
         for (int l = 1; l <=4; l++) {
             menu.add(mitem[l]);
         }
        mitem[1].addActionListener(this);
        mitem[2].addActionListener(this);
       
    }
   public void populate(String sn,String cn,String ty,String des )
   {
       String rows[]={sn,cn,ty,des};
       model.addRow(rows);
       
          }
    public void table() {
        
        table[1] = new JTable();
        srp[3] = new JScrollPane(table[1]);
        p[3].setLayout(null);
        p[3].add(srp[3]);
        srp[3].setBounds(50, 50, 800, 300);
        table[1].setBackground(Color.decode("#058dc7"));
        table[1].setForeground(Color.WHITE);
        f[4] = new Font("Arial", Font.BOLD, 14);
        table[1].setFont(f[4]);
        table[1].setRowHeight(table[1].getRowHeight()+15);
        model=(DefaultTableModel)table[1].getModel();
        for (int l = 0; l <4; l++) {
            model.addColumn(colms[l]);     
        }
            TableColumn column = null;
      
        // column = table[1].getColumnModel().getColumn(0);

        for (int t = 0; t < 4; t++) {
            column = table[1].getColumnModel().getColumn(t);
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
        cellallignment();
      
    }
public void cellallignment()
{
  DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
  centerRenderer.setHorizontalAlignment( JLabel.CENTER );
  table[1].getColumnModel().getColumn(0).setCellRenderer( centerRenderer );   
  table[1].getColumnModel().getColumn(2).setCellRenderer( centerRenderer );   
   
   
}
  public void filter(String query)
     {
         TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
         table[1].setRowSorter(tr);
         tr.setRowFilter(RowFilter.regexFilter(query));
     }
    public void font() {
        //panel(1)
        f[1] = new Font("Arial", Font.BOLD, 16);
        f[2] = new Font("Arial", Font.BOLD, 14);

        jtf[1].setFont(f[1]);
        jta[1].setFont(f[2]);
        jcb[1].setFont(f[2]);

        //panel(2)
        jtf[3].setFont(f[1]);
        jta[2].setFont(f[2]);
        jtf[4].setFont(f[1]);
        jtf[5].setFont(f[1]);
    }

    public void delete() {
        int p = 1;
        for (int l = 0; l <= i; l++) {
            for (int m = 0; m <= 3; m++) {
                rows[l][m] = rows[p][m];

            }
            p++;

        }
        if (i != 0) {
            i--;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn[1]) {

            if (jtf[1].getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "ENTER CUSTOMER NAME");

            } else if (jta[1].getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ENTER SHORT DESCRIPTION");
            } else { 
                
                String s=""+k;
               populate(s,jtf[1].getText().toString(),jcb[1].getSelectedItem().toString(),jta[1].getText().toString());
               
              lt.populate(s,jtf[1].getText().toString(),jcb[1].getSelectedItem().toString(),jta[1].getText().toString());
             // lt.filewriter(s,jtf[1].getText().toString(),jcb[1].getSelectedItem().toString(),jta[1].getText().toString());
              st.Senddata(jtf[1].getText().toString(),jcb[1].getSelectedItem().toString(),jta[1].getText().toString());
             
            ///   jtf[1].setText("");
             //  jta[1].setText("");
                k++;
          
            }

        } else if (e.getSource() == btn[3]) {
            if (table[1].getRowCount()==0) {

                JOptionPane.showMessageDialog(null, "NO PENDING SERVICES");
            } else if (flag == 0) {
                jtf[5].setText("" +table[1].getValueAt(0,0));
                jtf[3].setText("" + table[1].getValueAt(0,1));
                jtf[4].setText("" +table[1].getValueAt(0,2));
                jta[2].setText("" + table[1].getValueAt(0,3));
                 model.removeRow(0);
                 flag=1;
            } else {
                JOptionPane.showMessageDialog(null, "YOU ALREADY STARTED THE SERVICES");
            }

        } else if (e.getSource() == btn[2]) {

            if (table[1].getRowCount()==0) {

                JOptionPane.showMessageDialog(null, "NO PENDING SERVICES");

            } else {

                jtf[5].setText("" +table[1].getValueAt(0,0));
                jtf[3].setText("" + table[1].getValueAt(0,1));
                jtf[4].setText("" +table[1].getValueAt(0,2));
                jta[2].setText("" + table[1].getValueAt(0,3));
                 model.removeRow(0);
            //    delete();
               // table();
             // LogTable lt = new  LogTable();
              
             
            }
        }
        else if(e.getSource()==mitem[1])
        {
             lt.setVisible(true);
        }
        else if(e.getSource()==mitem[2])
        {
            String name=JOptionPane.showInputDialog("Enter Client Name");
            filter(name);
        }
    }

    public static void main(String[] args) throws IOException {
        Home frame = new Home();
            frame.setVisible(true);
    }

  
}
