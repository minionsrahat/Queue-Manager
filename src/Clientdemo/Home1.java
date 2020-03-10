package Clientdemo;

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
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Home1 extends JFrame implements ActionListener, MouseListener, KeyListener, ItemListener {

    public static int a = 0, q = 0, r = 1;
    public static int i = 0, j = 0, t;
    public static int flag = 0;
    public static int k = 1;
    private Container c;
    JTable[] List_Table = new JTable[10];
    DefaultTableModel Table_Model = new DefaultTableModel();
    JPanel[] Panel = new JPanel[10];
    JLabel[] Label = new JLabel[16];
    JTextField[] Text_Field = new JTextField[30];
    JTextArea[] Text_Area = new JTextArea[30];
    JButton[] Button = new JButton[20];
    JScrollPane pane;
    TitledBorder[] Title_Border = new TitledBorder[10];
    JFrame frame;
    JComboBox[] Combo_BOX= new JComboBox[10];
    JScrollPane[] Scroll_Pane = new JScrollPane[10];
    Font[] font = new Font[30];
    String colms[] = {"Serial No.", "Customer Name", "Type", "Description"};
    String rows[][] = new String[100][4];
    String item[] = {"Software", "Hardware","Charger","Sim","Others"};
    JMenuBar MenuBar;
    JMenu menu;
    JMenuItem mitem[] = new JMenuItem[20];
    LogTable lt = new LogTable();
    Recivethread rt;
    Popupclass pop;

    Home1(Recivethread rt) {

        this.rt = rt;
        initcomponents();
        panel();
        label();
        combobox();
        textfield();
        menu();
        Button();
        table();
        popupmenu();
        font();

    }

    public void initcomponents() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 100, 1300, 900);
        c = this.getContentPane();
        c.setLayout(null);
        font[3] = new Font("Arial", font.BOLD, 25);

        Title_Border[1] = new TitledBorder("Client SERVICE");
        Title_Border[1].setTitleJustification(TitledBorder.LEFT);
        Title_Border[1].setTitlePosition(TitledBorder.TOP);
        Title_Border[1].setTitleColor(Color.RED);
        Title_Border[1].setTitleFont(font[3]);

        Title_Border[2] = new TitledBorder("RUNNING SERVICE DESK");
        Title_Border[2].setTitleJustification(TitledBorder.LEFT);
        Title_Border[2].setTitlePosition(TitledBorder.TOP);
        Title_Border[2].setTitleFont(font[3]);
        Title_Border[2].setTitleColor(Color.RED);
        Title_Border[3] = new TitledBorder("LIST OF SERVICES");
        Title_Border[3].setTitleJustification(TitledBorder.LEFT);
        Title_Border[3].setTitlePosition(TitledBorder.TOP);
        Title_Border[3].setTitleColor(Color.RED);
        Title_Border[3].setTitleFont(font[3]);
    }

    public void panel() {

        
        Panel[1] = new JPanel();
        c.add(Panel[1]);
        Panel[1].setBounds(800, 100, 350, 200);
       // Panel[1].setBackground(new Color(204, 255, 153));
        
        
        //panel(2)
        Panel[2] = new JPanel();
        c.add(Panel[2]);
        Panel[2].setBounds(250, 20, 450, 300);
        Panel[2].setBackground(new Color(204, 255, 153));
        Panel[2].setBorder(Title_Border[2]);
        //panel(3)
        Panel[3] = new JPanel();
        c.add(Panel[3]);
        Panel[3].setBounds(20, 350, 930, 450);
        Panel[3].setBackground(Color.lightGray);
        Panel[3].setBorder(Title_Border[3]);
        Panel[3].setLayout(null);
        //panel[4] 

    }

    public void label() {
        
        //panel 1
        Panel[1].setLayout(null);
        Label[1] = new JLabel("Send Message To Server");
        Panel[1].add(Label[1]);
        Label[1].setBounds(22,30,400,200);
        

        //panel(2)
        Panel[2].setLayout(null);
        Label[4] = new JLabel("Name");
        Panel[2].add(Label[4]);
        Label[4].setBounds(20, 30, 100, 50);
        Label[5] = new JLabel("Type");
        Panel[2].add(Label[5]);
        Label[5].setBounds(20, 90, 100, 50);
        Label[6] = new JLabel("Description");
        Panel[2].add(Label[6]);
        Label[6].setBounds(20, 150, 100, 50);
        Label[7] = new JLabel("Serial");
        Panel[2].add(Label[7]);
        Label[7].setBounds(20, 210, 100, 50);
        //panel3
        Label[8] = new JLabel("Client Search");
        Panel[3].add(Label[8]);
        Label[8].setBounds(350, 30, 150, 35);
        Label[8].setFont(font[3]);

    }

    public void textfield() {
        //panel 1
        
        Text_Area[1]=new JTextArea();
        Scroll_Pane[1]=new JScrollPane(Text_Area[1]);
        Text_Area[1].setWrapStyleWord(true);
        Text_Area[1].setLineWrap(true);
        Scroll_Pane[1].setBounds(20,50,200,60);
        Panel[1].add(Scroll_Pane[1]);

        //panel(2)
        Text_Field[3] = new JTextField();
        Text_Field[3].setEditable(false);
        Text_Area[2] = new JTextArea();
        Text_Area[2].setLineWrap(true);
        Text_Area[2].setEditable(false);
        Text_Area[2].setWrapStyleWord(true);
        Panel[2].add(Text_Field[3]);
        Text_Field[3].setBounds(105, 37, 210, 40);
        Scroll_Pane[2] = new JScrollPane(Text_Area[2]);
        Panel[2].add(Scroll_Pane[2]);
        Scroll_Pane[2].setBounds(105, 157, 210, 40);
        Text_Field[4] = new JTextField();
        Text_Field[4].setEditable(false);
        Panel[2].add(Text_Field[4]);
        Text_Field[4].setBounds(105, 94, 210, 40);
        Text_Field[5] = new JTextField();
        Text_Field[5].setEditable(false);
        Panel[2].add(Text_Field[5]);
        Text_Field[5].setBounds(105, 220, 100, 30);

        //panel3
        Text_Field[6] = new JTextField();
        Panel[3].add(Text_Field[6]);
        Text_Field[6].setBounds(700, 30, 150, 40);
        Text_Field[6].setFont(font[2]);
        Text_Field[6].addKeyListener(this);

    }

    public void combobox() {
        Combo_BOX[2] = new JComboBox();
        Combo_BOX[2].addItem("none");
        Combo_BOX[2].addItem("Software");
        Combo_BOX[2].addItem("Hardware");
        Panel[3].add(Combo_BOX[2]);
        Combo_BOX[2].setBounds(460, 30, 210, 40);
        Combo_BOX[2].addItemListener(this);
    }

    public void Button() {
    //panel 1
      Button[1]=new JButton("SEND");
      Panel[1].add(Button[1]);
      Button[1].setBounds(240,50,80,60);
   
        //panel(2);
        Button[2] = new JButton();
        Panel[2].add(Button[2]);
        Button[2].setText("Complete");
        Button[2].setBounds(215, 220, 100, 30);
        Button[3] = new JButton();
        Panel[2].add(Button[3]);
        Button[3].setText("Start");
        Button[3].setBounds(125, 260, 150, 30);
        //Actionlistener

        // Button[1].addActionListener(this);
        Button[1].addActionListener(this);
        Button[2].addActionListener(this);
        Button[3].addActionListener(this);

    }

    public void menu() {
        // System.out.println("1111");
        MenuBar = new JMenuBar();
        //  c.setJMenuBar(MenuBar);
        Panel[4] = new JPanel();
        Panel[4].setBounds(100, 30, 100, 70);
        Panel[4].add(MenuBar);
        c.add(Panel[4]);

        menu = new JMenu("MENU");
        mitem[1] = new JMenuItem("History Log Table");
        mitem[2] = new JMenuItem("Reset");
        mitem[3] = new JMenuItem("Delete Queue Member");
        mitem[4] = new JMenuItem("Reset");
        MenuBar.add(menu);

        for (int l = 1; l <= 2; l++) {
            menu.add(mitem[l]);
        }
        mitem[1].addActionListener(this);
        mitem[2].addActionListener(this);

    }

    public void populate(String sn, String cn, String ty, String des) {
        String rows[] = {sn, cn, ty, des};
        Table_Model.addRow(rows);

    }

    public void table() {

        List_Table[1] = new JTable();
        Scroll_Pane[3] = new JScrollPane(List_Table[1]);

        Panel[3].add(Scroll_Pane[3]);
        Scroll_Pane[3].setBounds(50, 90, 800, 300);
        List_Table[1].setBackground(Color.decode("#058dc7"));
        List_Table[1].setForeground(Color.WHITE);
        font[4] = new Font("Arial", font.BOLD, 14);
        List_Table[1].setFont(font[4]);
        List_Table[1].setEnabled(false);
        List_Table[1].setRowHeight(List_Table[1].getRowHeight() + 15);
        Table_Model = (DefaultTableModel) List_Table[1].getModel();
        for (int l = 0; l < 4; l++) {
            Table_Model.addColumn(colms[l]);
        }
        TableColumn column = null;

        // column = List_Table[1].getColumnModel().getColumn(0);
        for (int t = 0; t < 4; t++) {
            column = List_Table[1].getColumnModel().getColumn(t);
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

    public void popupmenu() {
      //  pop = new Popupclass(List_Table[1], this);
       // List_Table[1].addMouseListener(this);

    }

    public void setrunningservice(String sn, String n, String type, String des) {
        Text_Field[5].setText("" + sn);
        Text_Field[3].setText("" + n);
        Text_Field[4].setText("" + type);
        Text_Area[2].setText("" + des);

    }

    public void cellallignment() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        List_Table[1].getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        List_Table[1].getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

    }

    public void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(Table_Model);
        List_Table[1].setRowSorter(tr);
        if (query != "none") {
            tr.setRowFilter(RowFilter.regexFilter(query));
        } else {
            List_Table[1].setRowSorter(tr);
        }
    }

    public void update(int r) {

        Table_Model.removeRow(r);
        int temp = Table_Model.getRowCount();
        System.out.println("" + r);
        // System.out.println(""+temp+" "+k);
        for (int i = r; i < temp; i++) {
            List_Table[1].setValueAt("" + (i + 1), i, 0);

        }

    }

    public void font() {
        //panel(1)
        font[1] = new Font("Arial", font.BOLD, 16);
        font[2] = new Font("Arial", font.BOLD, 14);
        font[3] = new Font("Arial", font.BOLD, 20);
        Text_Area[1].setFont(font[1]);
        Label[1].setFont(font[3]);
        //panel(2)
        Text_Field[3].setFont(font[1]);
        Text_Area[2].setFont(font[2]);
        Text_Field[4].setFont(font[1]);
        Text_Field[5].setFont(font[1]);
        menu.setFont(font[1]);
        for (int l = 1; l <= 4; l++) {
            mitem[l].setFont(font[1]);
        }
        //panel2
        Label[8].setFont(font[1]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()==Button[1])
        {
           
            try {
            String str=Text_Area[1].getText().toString();
            Text_Area[1].setText("");
            Populate t1=new Populate(""+Table_Model.getRowCount(),"Updated Msg","Running",""+str);          
            rt.send(t1);
            } catch (IOException ex) {
                System.out.println("Exception Home Class");
            }
        }

        if (e.getSource() == Button[3]) {
            if (List_Table[1].getRowCount() == 0) {

                JOptionPane.showMessageDialog(null, "NO PENDING SERVICES");
            } else if (flag == 0) {
                // Text_Field[5].setText("" +List_Table[1].getValueAt(0,0));
                //jtf[3].setText("" + List_Table[1].getValueAt(0,1));
                // Text_Field[4].setText("" +List_Table[1].getValueAt(0,2));
                // Text_Area[2].setText("" + List_Table[1].getValueAt(0,3));
                setrunningservice(List_Table[1].getValueAt(0, 0).toString(), List_Table[1].getValueAt(0, 1).toString(), List_Table[1].getValueAt(0, 2).toString(), List_Table[1].getValueAt(0, 3).toString());
                Table_Model.removeRow(0);
                try {
                  Populate t1=new Populate(""+Table_Model.getRowCount(),"Remove","Running","");
                    rt.send(t1);
                } catch (IOException ex) {
                    Logger.getLogger(Home1.class.getName()).log(Level.SEVERE, null, ex);
                }
                flag = 1;
            } else {
                JOptionPane.showMessageDialog(null, "YOU ALREADY STARTED THE SERVICES");
            }

        } else if (e.getSource() == Button[2]) {

            if (List_Table[1].getRowCount() == 0) {

                JOptionPane.showMessageDialog(null, "NO PENDING SERVICES");

            } else {

                // Text_Field[5].setText("" +List_Table[1].getValueAt(0,0));
                // Text_Field[3].setText("" + List_Table[1].getValueAt(0,1));
                // Text_Field[4].setText("" +List_Table[1].getValueAt(0,2));
                // Text_Area[2].setText("" + List_Table[1].getValueAt(0,3));
                setrunningservice(List_Table[1].getValueAt(0, 0).toString(), List_Table[1].getValueAt(0, 1).toString(), List_Table[1].getValueAt(0, 2).toString(), List_Table[1].getValueAt(0, 3).toString());
                try {
                   Populate t1=new Populate(""+Table_Model.getRowCount(),"Remove","Running","");
                    rt.send(t1);
                } catch (IOException ex) {
                    Logger.getLogger(Home1.class.getName()).log(Level.SEVERE, null, ex);
                }
                Table_Model.removeRow(0);

            }
        } else if (e.getSource() == mitem[1]) {
            lt.setVisible(true);
        } else if (e.getSource() == mitem[2]) {
          
            this.dispose();
            FrontFrame f=new FrontFrame();
        }
    }

    public static void main(String[] args) {
        //Home frame = new Home1();

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
        if (e.getSource() == Text_Field[6]) {
            filter(Text_Field[6].getText().toString());

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == Combo_BOX[2]) {
            this.filter(Combo_BOX[2].getSelectedItem().toString());

        }
    }

}
