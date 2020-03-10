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
    public static int track = 0;
    public static int max;
    public static int desk = 1;
    int arr[] = {1, 1, 1, 1, 1};
    private Container c;
    JTable[] List_Table = new JTable[10];
    DefaultTableModel Table_Model = new DefaultTableModel();
    JPanel[] Panel = new JPanel[10];
    JLabel[] Label = new JLabel[16];
    JTextField[] Text_Field = new JTextField[30];
    JTextArea[] Text_Area = new JTextArea[30];
    JButton[] Button = new JButton[20];
   // JScrollPane JScroll_Pane;
    TitledBorder[] Title_Border = new TitledBorder[10];
    JFrame frame;
    JComboBox[] JCombo_Box = new JComboBox[10];
    JScrollPane[] JScroll_Pane = new JScrollPane[10];
    Font[] font = new Font[30];
    String[] Colums = {"Serial No.", "Service Desk", "Cuurrent State"};
    String rows[][] = new String[100][4];
    String item[] = {"Software", "Hardware", "Charger", "Sim", "Others"};
    JMenuBar Menu_Bar;
    JMenu menu;
    JMenuItem[] Manu_Item = new JMenuItem[20];
    LogTable Log_Table = new LogTable();
    RunningServicesTable Running_Service_Table;
    RunningServices rs = new RunningServices();
    Sendthread Send_Data;
    Popupclass pop;
    public int client[] = {0, 0, 0, 0, 0};
    public static int state[] = {0, 0, 0, 0, 0};
    public int selectdesk = 0;
    //Home h1;
    // Thread t1=new Thread(Send_Data);
    // LogTable Log_Table = new LogTable();

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

        Running_Service_Table = new RunningServicesTable(this);
        Send_Data = new Sendthread(this);
        //  Send_Data.Connect();
        Send_Data.start();
        // Sendthread Send_Data=new Sendthread();

        // Send_Data.start();
    }

    public void Create_Server_Service_Border() {
        font[3] = new Font("Arial", Font.BOLD, 25);
        Title_Border[1] = new TitledBorder("Server SERVICE");
        Title_Border[1].setTitleJustification(TitledBorder.LEFT);
        Title_Border[1].setTitlePosition(TitledBorder.TOP);
        Title_Border[1].setTitleColor(Color.RED);
        Title_Border[1].setTitleFont(font[3]);
    }

    public void Running_Server_Service_Border() {
        font[3] = new Font("Arial", Font.BOLD, 25);
        Title_Border[2] = new TitledBorder("RUNNING SERVICE");
        Title_Border[2].setTitleJustification(TitledBorder.LEFT);
        Title_Border[2].setTitlePosition(TitledBorder.TOP);
        Title_Border[2].setTitleFont(font[3]);
    }
     public void ListOF_Service_Border()
     {
        font[3] = new Font("Arial", Font.BOLD, 25);
        Title_Border[2].setTitleColor(Color.RED);
        Title_Border[3] = new TitledBorder("LIST OF SERVICES");
        Title_Border[3].setTitleJustification(TitledBorder.LEFT);
        Title_Border[3].setTitlePosition(TitledBorder.TOP);
        Title_Border[3].setTitleColor(Color.RED);
        Title_Border[3].setTitleFont(font[3]);
     }
    public void initcomponents() {
        //this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 100, 1300, 900);
        c = this.getContentPane();
        c.setLayout(null);
        this.Create_Server_Service_Border();
        this.Running_Server_Service_Border();
        this.ListOF_Service_Border();
        this.setVisible(true);
    }

    public void panel() {
      
        Panel[1] = new JPanel();
        c.add(Panel[1]);
        Panel[1].setBounds(220, 20, 450, 300);
        Panel[1].setBackground(new Color(204, 204, 255));
        Panel[1].setBorder(Title_Border[1]);

        Panel[2] = new JPanel();
        //  c.add(Panel[2]);
        Panel[2].setBounds(640, 20, 310, 300);
        Panel[2].setBackground(new Color(204, 204, 255));
        Panel[2].setBorder(Title_Border[2]);

        Panel[3] = new JPanel();
        c.add(Panel[3]);
        Panel[3].setBounds(20, 350, 930, 450);
        Panel[3].setBackground(Color.lightGray);
        Panel[3].setBorder(Title_Border[3]);
        Panel[3].setLayout(null);
    }

    public void label() {
        // panel(1)
        Label[1] = new JLabel("Name");
        Panel[1].setLayout(null);
        Panel[1].add(Label[1]);
        Label[1].setBounds(20, 30, 100, 50);
        Label[2] = new JLabel("Type");
        Panel[1].add(Label[2]);
        Label[2].setBounds(20, 90, 100, 50);
        Label[3] = new JLabel("Description");
        Panel[1].add(Label[3]);
        Label[3].setBounds(20, 150, 100, 50);
        //panel 2
        Label[4] = new JLabel("Client Name");
        Panel[2].setLayout(null);
        Panel[2].add(Label[4]);
        Label[4].setBounds(100, 30, 100, 50);

        Label[5] = new JLabel("Serial No:");
        Panel[2].add(Label[5]);
        Label[5].setBounds(20, 120, 100, 50);

        Label[6] = new JLabel("Updated Message:");
        Panel[2].add(Label[6]);
        Label[6].setBounds(80, 180, 150, 50);

        //panel3
        Label[8] = new JLabel("Client Search");
        //  Panel[3].add(Label[8]);
        Label[8].setBounds(350, 30, 150, 35);
        Label[8].setFont(font[3]);

    }

    public void textfield() {
        //panel(1)
        Text_Field[1] = new JTextField();
        Text_Area[1] = new JTextArea();
        Text_Area[1].setLineWrap(true);
        Text_Area[1].setWrapStyleWord(true);
        Panel[1].add(Text_Field[1]);
        Text_Field[1].setBounds(105, 37, 210, 40);
        JScroll_Pane[1] = new JScrollPane(Text_Area[1]);
        Panel[1].add(JScroll_Pane[1]);
        JScroll_Pane[1].setBounds(105, 157, 210, 60);
        //panel2
        Text_Field[2] = new JTextField();
        Panel[2].add(Text_Field[2]);

        Text_Field[2].setEditable(false);
        Text_Field[2].setBounds(50, 70, 200, 40);
        Text_Field[3] = new JTextField();
        Panel[2].add(Text_Field[3]);
        Text_Field[3].setEditable(false);
        Text_Field[3].setBounds(100, 125, 50, 40);
        Text_Field[4] = new JTextField();
        Panel[2].add(Text_Field[4]);
        Text_Field[4].setEditable(false);
        Text_Field[4].setBounds(40, 235, 220, 60);

        //panel3
        Text_Field[6] = new JTextField();
        //  Panel[3].add(Text_Field[6]);
        Text_Field[6].setBounds(700, 30, 150, 40);
        Text_Field[6].setFont(font[2]);
        Text_Field[6].addKeyListener(this);

    }

    public void combobox() {
        JCombo_Box[1] = new JComboBox(item);
        Panel[1].add(JCombo_Box[1]);
        JCombo_Box[1].setBounds(105, 94, 210, 40);

        JCombo_Box[2] = new JComboBox();
        JCombo_Box[2].addItem("none");
        JCombo_Box[2].addItem("Software");
        JCombo_Box[2].addItem("Hardware");
        /// Panel[3].add(JCombo_Box[2]);
        JCombo_Box[2].setBounds(460, 30, 210, 40);
        //jcb[2].addItemListener(this);
    }

    public void Button() {
        //panel(1);
        Button[1] = new JButton();
        Panel[1].add(Button[1]);
        Button[1].setText("Add Queue");
        Button[1].setBounds(110, 235, 200, 35);

        Button[1].addActionListener(this);

    }

    public void menu() {
        //   System.out.println("1111");
        Menu_Bar = new JMenuBar();
        //  c.setJMenuBar(Menu_Bar);
        Panel[4] = new JPanel();
        Panel[4].setBounds(10, 30, 200, 70);
        // Menu_Bar.setSize(170,70);
        // Menu_Bar.setLocation(0,0);
        Panel[4].add(Menu_Bar);
        c.add(Panel[4]);

        menu = new JMenu("MENU");
        Manu_Item[1] = new JMenuItem("History Log Table");
        Manu_Item[2] = new JMenuItem("Services Desk Table");
        Manu_Item[3] = new JMenuItem("Running Services");
        Manu_Item[4] = new JMenuItem("Reset");
        Menu_Bar.add(menu);
        //  menu.setSize(170,70);

        for (int l = 1; l <= 4; l++) {
            menu.add(Manu_Item[l]);
        }
        Manu_Item[1].addActionListener(this);
        Manu_Item[2].addActionListener(this);
        Manu_Item[3].addActionListener(this);
        Manu_Item[4].addActionListener(this);

    }

    public void populate(String sn, String cn, String ty, String des) {
        String rows[] = {sn, cn, ty, des};
        Table_Model.addRow(rows);

    }

    public void tablestate(int deskno, String str) {
        List_Table[1].setValueAt(str, deskno - 1, 2);
    }

    public void populate_run_services(int desk) {
        Populate t1 = new Populate(Running_Service_Table.table[desk].getValueAt(0, 0).toString(), Running_Service_Table.table[desk].getValueAt(0, 1).toString(), "", "");
        if (desk == 1) {
            rs.populate_desk_1(t1);
        } else if (desk == 2) {
            rs.populate_desk_2(t1);
        } else if (desk == 3) {
            rs.populate_desk_3(t1);
        } else if (desk == 4) {
            rs.populate_desk_4(t1);
        } else if (desk == 5) {
            rs.populate_desk_5(t1);
        }
        Running_Service_Table.model[desk].removeRow(0);
    }

    public void table() {

        List_Table[1] = new JTable();
        JScroll_Pane[3] = new JScrollPane(List_Table[1]);
        Panel[3].setLayout(null);
        Panel[3].add(JScroll_Pane[3]);
        JScroll_Pane[3].setBounds(50, 90, 800, 300);
        List_Table[1].setBackground(Color.decode("#058dc7"));
        List_Table[1].setForeground(Color.WHITE);
        font[4] = new Font("Arial", Font.BOLD, 14);
        List_Table[1].setFont(font[4]);
        List_Table[1].setEnabled(false);
        List_Table[1].setRowHeight(List_Table[1].getRowHeight() + 15);
        Table_Model = (DefaultTableModel) List_Table[1].getModel();
        for (int l = 0; l < 3; l++) {
            Table_Model.addColumn(Colums[l]);
        }
        TableColumn column = null;

        // column = List_Table[1].getColumnModel().getColumn(0);
        for (int t = 0; t < 3; t++) {
            column = List_Table[1].getColumnModel().getColumn(t);
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
        String arr[] = {"", "", "Disconnected"};
        for (int l = 0, k = 1; l < 5; l++, k++) {
            arr[0] = "" + k;
            arr[1] = "Service Desk " + k;
            Table_Model.addRow(arr);
        }
        cellallignment();

    }

    public void selectdesk() {
        int min = client[0];
        for (int i = 0; i < 5; i++) {

            if (state[i] != 0) {
                if (client[i] <= min) {
                    selectdesk = i;
                    min = client[i];
                }
            }
            System.out.println("selec desk :" + (selectdesk + 1));
//        for (int l = 0; l <5; l++) {
//            System.out.print(" "+client[l]);
//        }
            System.out.println();
        }

    }

    public void popupmenu() {
        // pop = new Popupclass(this);
        // List_Table[1].addMouseListener(this);
    }

    public void cellallignment() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        List_Table[1].getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        List_Table[1].getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
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
        //st.deletemsg(ABORT, r);
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
        font[1] = new Font("Arial", Font.BOLD, 16);
        font[2] = new Font("Arial", Font.BOLD, 14);

        Text_Field[1].setFont(font[1]);
        Text_Field[2].setFont(font[1]);
        Text_Field[3].setFont(font[1]);
        Text_Field[4].setFont(font[1]);
        Text_Area[1].setFont(font[2]);
        JCombo_Box[1].setFont(font[2]);
        menu.setFont(font[1]);
        for (int l = 1; l <= 4; l++) {
            Manu_Item[l].setFont(font[1]);
        }
        //panel2
        Label[8].setFont(font[1]);
        Text_Field[6].setFont(font[1]);

    }

    public void setrunservice(String sn, String cl, String up) {
        Text_Field[2].setText("");
        Text_Field[3].setText("");
        Text_Field[4].setText("");

        Text_Field[2].setText("" + cl);
        Text_Field[3].setText("" + sn);
        Text_Field[4].setText("" + up);

    }

    public void clear() {
        Text_Field[1].setText("");
        Text_Area[1].setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Button[1]) {

            if (Text_Field[1].getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "ENTER CUSTOMER NAME");

            }// else if (Text_Field[1].getText().toString().matches("^[A-Za-z][A-Za-z][A-Za-z0-9]*(?:_[A-Za-z0-9]+)*$") == false)
            else if (Text_Field[1].getText().toString().matches("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}") == false) {

                JOptionPane.showMessageDialog(null, "ENTER VALID CUSTOMER NAME");

            } else if (Text_Area[1].getText().toString().matches("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}") == false) {

                JOptionPane.showMessageDialog(null, "ENTER VALID SHORT DISCRIPTION");

            } else {

                String s = "" + k;
                this.selectdesk();
                JOptionPane.showMessageDialog(null, "Customer Added To The Service Desk " + (selectdesk + 1));

                //populate(""+s, Text_Field[1].getText().toString(), JCombo_Box[1].getSelectedItem().toString(), Text_Area[1].getText().toString());
                Populate t1 = new Populate("" + arr[selectdesk]++, Text_Field[1].getText().toString(), JCombo_Box[1].getSelectedItem().toString(), Text_Area[1].getText().toString());
                clear();

                //    Running_Service_Table.populate(track+1, t1);
                //   Log_Table.populate(t1,""+(track+1));
                //  Log_Table.filewriter(t1,""+(track+1));
                Running_Service_Table.populate(selectdesk + 1, t1);
                Log_Table.populate(t1, "" + (selectdesk + 1));
                Log_Table.filewriter(t1, "" + (selectdesk + 1));
                //      Send_Data.Senddata(t1,track);
                Send_Data.Senddata(t1, selectdesk);
                if (desk == max) {
                    desk = 1;
                } else {
                    desk++;
                }

                ///   Text_Field[1].setText("");
                //  Text_Area[1].setText("");
                k++;

            }

        } else if (e.getSource() == Manu_Item[1]) {
            Log_Table.setVisible(true);
        } else if (e.getSource() == Manu_Item[2]) {
            // String name = JOptionPane.showInputDialog("Enter Client Name");
            // filter(name);
            Running_Service_Table.setVisible(true);
        } else if (e.getSource() == Manu_Item[3]) {
            rs.setVisible(true);
        } else if (e.getSource() == Manu_Item[4]) {

            this.dispose();
            FrontFrame f = new FrontFrame();
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
        if (e.getSource() == Text_Field[6]) {
            filter(Text_Field[6].getText().toString());

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == JCombo_Box[2]) {
            this.filter(JCombo_Box[2].getSelectedItem().toString());

        }
    }

}
