package Serverdemo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView.TableRow;
import Populate.*;
public class Home extends JFrame implements ActionListener, MouseListener, KeyListener, ItemListener {

    public static int a = 0, q = 0, r = 1;
    public static int i = 0, j = 0, t;
    public static int flag = 0;
    public static int k = 1;
    public static int track=0;
    public static int max;
    public static int desk=1;
    int arr[]={1,1,1,1,1};
    private Container c;
    JTable table[] = new JTable[10];
    DefaultTableModel model = new DefaultTableModel();
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
    String colms[] = {"Serial No.", "Service Desk","Cuurrent State"};
    String rows[][] = new String[100][4];
    String item[] = {"Software", "Hardware","Charger","Sim","Others"};
    JMenuBar mb;
    JMenu menu;
    JMenuItem mitem[] = new JMenuItem[20];
    LogTable lt = new LogTable();
    RunningServicesTable rst;
    RunningServices rs=new RunningServices();
    Sendthread st;
    Popupclass pop;
     public int client[]={0,0,0,0,0};
     public static int state[]={0,0,0,0,0};
     public int selectdesk=0;
    //Home h1;
    // Thread t1=new Thread(st);
    // LogTable lt = new LogTable();

    public Home() throws IOException {

        initcomponents();
        panel();
        label();
        textfield();
        combobox();
        menu();
        Button();
        table();
        popupmenu();
        font();
      
        rst=new RunningServicesTable(this);
        st = new Sendthread(this);
      //  st.Connect();
         st.start();
        // Sendthread st=new Sendthread();
       
       // st.start();
    }

    public void initcomponents() {
         //this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 100, 1300, 900);
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
        this.setVisible(true);
    }

    public void panel() {
        // p[4] = new JPanel();
        // c.add(p[4]);
        //  p[4].setBounds(0, 00, 900, 700);
        // p[4].setBorder(border[3]);
        //panel(1)
        p[1] = new JPanel();
        c.add(p[1]);
        p[1].setBounds(220, 20, 450, 300);
        p[1].setBackground(new Color(204, 204, 255));
        p[1].setBorder(border[1]);

        p[2] = new JPanel();
      //  c.add(p[2]);
        p[2].setBounds(640, 20, 310, 300);
        p[2].setBackground(new Color(204, 204, 255));
        p[2].setBorder(border[2]);

        p[3] = new JPanel();
        c.add(p[3]);
        p[3].setBounds(20, 350, 930, 450);
        p[3].setBackground(Color.lightGray);
        p[3].setBorder(border[3]);
        p[3].setLayout(null);
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
        //panel 2
        jl[4] = new JLabel("Client Name");
        p[2].setLayout(null);
        p[2].add(jl[4]);
        jl[4].setBounds(100, 30, 100, 50);

        jl[5] = new JLabel("Serial No:");
        p[2].add(jl[5]);
        jl[5].setBounds(20, 120, 100, 50);

        jl[6] = new JLabel("Updated Message:");
        p[2].add(jl[6]);
        jl[6].setBounds(80, 180, 150, 50);

        //panel3
        jl[8] = new JLabel("Client Search");
      //  p[3].add(jl[8]);
        jl[8].setBounds(350, 30, 150, 35);
        jl[8].setFont(f[3]);

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
        //panel2
        jtf[2] = new JTextField();
        p[2].add(jtf[2]);

        jtf[2].setEditable(false);
        jtf[2].setBounds(50, 70, 200, 40);
        jtf[3] = new JTextField();
        p[2].add(jtf[3]);
        jtf[3].setEditable(false);
        jtf[3].setBounds(100, 125, 50, 40);
        jtf[4] = new JTextField();
        p[2].add(jtf[4]);
        jtf[4].setEditable(false);
        jtf[4].setBounds(40, 235, 220, 60);

        //panel3
        jtf[6] = new JTextField();
      //  p[3].add(jtf[6]);
        jtf[6].setBounds(700, 30, 150, 40);
        jtf[6].setFont(f[2]);
        jtf[6].addKeyListener(this);

    }

    public void combobox() {
        jcb[1] = new JComboBox(item);
        p[1].add(jcb[1]);
        jcb[1].setBounds(105, 94, 210, 40);

        jcb[2] = new JComboBox();
        jcb[2].addItem("none");
        jcb[2].addItem("Software");
        jcb[2].addItem("Hardware");
       /// p[3].add(jcb[2]);
        jcb[2].setBounds(460, 30, 210, 40);
        //jcb[2].addItemListener(this);
    }

    public void Button() {
        //panel(1);
        btn[1] = new JButton();
        p[1].add(btn[1]);
        btn[1].setText("Add Queue");
        btn[1].setBounds(110, 235, 200, 35);

        btn[1].addActionListener(this);

    }

    public void menu() {
        //   System.out.println("1111");
        mb = new JMenuBar();
        //  c.setJMenuBar(mb);
        p[4] = new JPanel();
        p[4].setBounds(10, 30, 200, 70);
        // mb.setSize(170,70);
        // mb.setLocation(0,0);
        p[4].add(mb);
        c.add(p[4]);

        menu = new JMenu("MENU");
        mitem[1] = new JMenuItem("History Log Table");
        mitem[2] = new JMenuItem("Services Desk Table");
        mitem[3] = new JMenuItem("Running Services");
        mitem[4] = new JMenuItem("Reset");
        mb.add(menu);
        //  menu.setSize(170,70);

        for (int l = 1; l <= 4; l++) {
            menu.add(mitem[l]);
        }
        mitem[1].addActionListener(this);
        mitem[2].addActionListener(this);
        mitem[3].addActionListener(this);
        mitem[4].addActionListener(this);

    }

    public void populate(String sn, String cn, String ty, String des) {
        String rows[] = {sn, cn, ty, des};
        model.addRow(rows);

    }
    public void tablestate(int deskno,String str)
    {
        table[1].setValueAt(str, deskno-1, 2);
    }
    
    public void populate_run_services(int desk)
    {
       Populate t1=new Populate(rst.table[desk].getValueAt(0,0).toString(),rst.table[desk].getValueAt(0,1).toString(),"","");
       if(desk==1)
       {
           rs.populate_desk_1(t1);
       }
       else if(desk==2)
       {
           rs.populate_desk_2(t1);
       }
       else if(desk==3)
       {
           rs.populate_desk_3(t1);
       }
       else if(desk==4)
       {
           rs.populate_desk_4(t1);
       }
       else if(desk==5)
       {
           rs.populate_desk_5(t1);
       }
       rst.model[desk].removeRow(0);
    }
  
    public void table() {

        table[1] = new JTable();
        srp[3] = new JScrollPane(table[1]);
        p[3].setLayout(null);
        p[3].add(srp[3]);
        srp[3].setBounds(50, 90, 800, 300);
        table[1].setBackground(Color.decode("#058dc7"));
        table[1].setForeground(Color.WHITE);
        f[4] = new Font("Arial", Font.BOLD, 14);
        table[1].setFont(f[4]);
        table[1].setEnabled(false);
        table[1].setRowHeight(table[1].getRowHeight() + 15);
        model = (DefaultTableModel) table[1].getModel();
        for (int l = 0; l < 3; l++) {
            model.addColumn(colms[l]);
        }
        TableColumn column = null;

        // column = table[1].getColumnModel().getColumn(0);
        for (int t = 0; t <3; t++) {
            column = table[1].getColumnModel().getColumn(t);
            if (t == 0) {
                column.setPreferredWidth(60);
            }
            if (t == 1) {
                column.setPreferredWidth(280);
            }
            if (t == 2) {
                column.setPreferredWidth(200);
            }
           

        }
        String arr[]={"","","Disconnected"};
        for (int l = 0,k=1; l <5; l++,k++) {
            arr[0]=""+k;
            arr[1]="Service Desk "+k;
            model.addRow(arr);    
        }
        cellallignment();

    }
public void selectdesk()
{
    int min=client[0];
    for (int i = 0; i <5; i++) {
        
        if(state[i]!=0)
        {
            if(client[i]<=min)
            {
               selectdesk=i;
               min=client[i];
            }
        }
        System.out.println("selec desk :"+(selectdesk+1));
//        for (int l = 0; l <5; l++) {
//            System.out.print(" "+client[l]);
//        }
        System.out.println();
    }
    
    
    
}
    public void popupmenu() {
       // pop = new Popupclass(this);
       // table[1].addMouseListener(this);
    }

    public void cellallignment() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table[1].getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table[1].getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table[1].getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

    }

    public void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        table[1].setRowSorter(tr);
        if (query != "none") {
            tr.setRowFilter(RowFilter.regexFilter(query));
        } else {
            table[1].setRowSorter(tr);
        }
    }
 public void update(int r)
    {
        //st.deletemsg(ABORT, r);
        model.removeRow(r);
       int temp=model.getRowCount();
        System.out.println(""+r);              
       // System.out.println(""+temp+" "+k);
        for (int i = r; i <temp; i++) {
           table[1].setValueAt(""+(i+1), i,0);   
        }
  
        
    }
    public void font() {
        //panel(1)
        f[1] = new Font("Arial", Font.BOLD, 16);
        f[2] = new Font("Arial", Font.BOLD, 14);

        jtf[1].setFont(f[1]);
        jtf[2].setFont(f[1]);
        jtf[3].setFont(f[1]);
        jtf[4].setFont(f[1]);
        jta[1].setFont(f[2]);
        jcb[1].setFont(f[2]);
        menu.setFont(f[1]);
        for (int l = 1; l <= 4; l++) {
            mitem[l].setFont(f[1]);
        }
        //panel2
        jl[8].setFont(f[1]);
        jtf[6].setFont(f[1]);

    }
   public void setrunservice(String sn,String cl,String up)
   {
       jtf[2].setText("");
       jtf[3].setText("");
       jtf[4].setText("");
       
       jtf[2].setText(""+cl);
       jtf[3].setText(""+sn);
       jtf[4].setText(""+up);
       
       
   }
   public void clear()
   {
       jtf[1].setText("");
       jta[1].setText("");
   }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn[1]) {

            if (jtf[1].getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "ENTER CUSTOMER NAME");

            }// else if (jtf[1].getText().toString().matches("^[A-Za-z][A-Za-z][A-Za-z0-9]*(?:_[A-Za-z0-9]+)*$") == false)
            
             else if (jtf[1].getText().toString().matches("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}")==false)
            
            
            {

                JOptionPane.showMessageDialog(null, "ENTER VALID CUSTOMER NAME");

            } else if (jta[1].getText().toString().matches("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}") == false) {

                JOptionPane.showMessageDialog(null, "ENTER VALID SHORT DISCRIPTION");

            } else {

                String s = "" + k;
                this.selectdesk();
                JOptionPane.showMessageDialog(null,"Customer Added To The Service Desk "+(selectdesk+1));
              
                //populate(""+s, jtf[1].getText().toString(), jcb[1].getSelectedItem().toString(), jta[1].getText().toString());
                Populate t1=new  Populate(""+arr[selectdesk]++, jtf[1].getText().toString(), jcb[1].getSelectedItem().toString(), jta[1].getText().toString()); 
                clear();
          
            //    rst.populate(track+1, t1);
             //   lt.populate(t1,""+(track+1));
              //  lt.filewriter(t1,""+(track+1));
              
                 rst.populate(selectdesk+1, t1);
               lt.populate(t1,""+(selectdesk+1));
              lt.filewriter(t1,""+(selectdesk+1));
         //      st.Senddata(t1,track);
               st.Senddata(t1, selectdesk);
                if(desk==max)
                {
                    desk=1;
                }
                else
                {
                    desk++;
                }
                    
                ///   jtf[1].setText("");
                //  jta[1].setText("");
                k++;

            }

        } else if (e.getSource() == mitem[1]) {
            lt.setVisible(true);
        } else if (e.getSource() == mitem[2]) {
           // String name = JOptionPane.showInputDialog("Enter Client Name");
           // filter(name);
           rst.setVisible(true);
        }
        else if(e.getSource()==mitem[3])
        {
            rs.setVisible(true);
        }
          else if(e.getSource()==mitem[4])
        {
      
            this.dispose();       
            FrontFrame f=new FrontFrame();
        }
    }

    public static void main(String[] args) throws IOException {
       // Home frame = new Home();
      //  frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            pop.show(e.getComponent(), e.getX(), e.getY());
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == jtf[6]) {
            filter(jtf[6].getText().toString());

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == jcb[2]) {
            this.filter(jcb[2].getSelectedItem().toString());

        }
    }

}
