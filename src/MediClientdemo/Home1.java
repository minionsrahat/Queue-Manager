package MediClientdemo;

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
import MediPopulate.*;
import Populate.*;
public class Home1 extends JFrame implements ActionListener, MouseListener, KeyListener, ItemListener {

    public static int flag = 0;
    public static int k = 1;
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
    String colms[] = {"Serial No.", "Customer Name", "Gender", "Description"};
    // String rows[][] = new String[100][4];
    String item[] = {"Male","Female"};
    JMenuBar mb;
    JMenu menu;
    String Tborder="RUNNING SERVICES";
    JMenuItem mitem[] = new JMenuItem[20];
    LogTable lt = new LogTable();
    Mrecivethread rt;
    //  Popupclass pop;

    Home1(Mrecivethread rt) {

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
        f[3] = new Font("Arial", Font.BOLD, 25);

        border[1] = new TitledBorder("Client SERVICE");
        border[1].setTitleJustification(TitledBorder.LEFT);
        border[1].setTitlePosition(TitledBorder.TOP);
        border[1].setTitleColor(Color.RED);
        border[1].setTitleFont(f[3]);

        border[2] = new TitledBorder(Tborder);
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

        p[1] = new JPanel();
        c.add(p[1]);
        p[1].setBounds(800, 100, 350, 200);
        // p[1].setBackground(new Color(204, 255, 153));

        //panel(2)
        p[2] = new JPanel();
        c.add(p[2]);
        p[2].setBounds(250, 20, 450, 300);
        p[2].setBackground(new Color(204, 255, 153));
        p[2].setBorder(border[2]);
        //panel(3)
        p[3] = new JPanel();
        c.add(p[3]);
        p[3].setBounds(20, 350, 930, 450);
        p[3].setBackground(new Color(57, 44, 99));
        p[3].setBorder(border[3]);
        p[3].setLayout(null);
        //panel[4] 

    }

    public void label() {

        //panel 1
        p[1].setLayout(null);
        jl[1] = new JLabel("Send Message To Server");
        p[1].add(jl[1]);
        jl[1].setBounds(22, 30, 400, 200);

        //panel(2)
        p[2].setLayout(null);
        jl[4] = new JLabel("Name");
        p[2].add(jl[4]);
        jl[4].setBounds(20, 30, 100, 50);
        jl[5] = new JLabel("Gender");
        p[2].add(jl[5]);
        jl[5].setBounds(20, 90, 100, 50);
        jl[6] = new JLabel("Description");
        p[2].add(jl[6]);
        jl[6].setBounds(20, 150, 100, 50);
        jl[7] = new JLabel("Serial");
        p[2].add(jl[7]);
        jl[7].setBounds(20, 210, 100, 50);
        //panel3
        jl[8] = new JLabel("Client Search");
        p[3].add(jl[8]);
        jl[8].setBounds(350, 30, 150, 35);
        jl[8].setForeground(Color.WHITE);
        jl[8].setFont(f[3]);

    }

    public void textfield() {
        //panel 1

        jta[1] = new JTextArea();
        srp[1] = new JScrollPane(jta[1]);
        jta[1].setWrapStyleWord(true);
        jta[1].setLineWrap(true);
        srp[1].setBounds(20, 50, 200, 60);
        p[1].add(srp[1]);

        //panel(2)
        jtf[3] = new JTextField();
        jtf[3].setEditable(false);
        jta[2] = new JTextArea();
        jta[2].setLineWrap(true);
        jta[2].setEditable(false);
        jta[2].setWrapStyleWord(true);
        p[2].add(jtf[3]);
        jtf[3].setBounds(105, 37, 210, 40);
        srp[2] = new JScrollPane(jta[2]);
        p[2].add(srp[2]);
        srp[2].setBounds(105, 157, 210, 40);
        jtf[4] = new JTextField();
        jtf[4].setEditable(false);
        p[2].add(jtf[4]);
        jtf[4].setBounds(105, 94, 210, 40);
        jtf[5] = new JTextField();
        jtf[5].setEditable(false);
        p[2].add(jtf[5]);
        jtf[5].setBounds(105, 220, 100, 30);

        //panel3
        jtf[6] = new JTextField();
        p[3].add(jtf[6]);
        jtf[6].setBounds(700, 30, 150, 40);
        jtf[6].setFont(f[2]);
        jtf[6].addKeyListener(this);

    }

    public void combobox() {
        jcb[2] = new JComboBox();
        jcb[2].addItem("none");
        jcb[2].addItem("Female");
        jcb[2].addItem("Male");
        p[3].add(jcb[2]);
        jcb[2].setBounds(460, 30, 210, 40);
        jcb[2].addItemListener(this);
    }

    public void Button() {
        //panel 1
        btn[1] = new JButton("SEND");
        p[1].add(btn[1]);
        btn[1].setBounds(240, 50, 80, 60);

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

        // btn[1].addActionListener(this);
        btn[1].addActionListener(this);
        btn[2].addActionListener(this);
        btn[3].addActionListener(this);

    }

    public void menu() {
        // System.out.println("1111");
        mb = new JMenuBar();
        //  c.setJMenuBar(mb);
        p[4] = new JPanel();
        p[4].setBounds(100, 30, 100, 70);
        p[4].add(mb);
        c.add(p[4]);

        menu = new JMenu("MENU");
        mitem[1] = new JMenuItem("History Log Table");
        mitem[2] = new JMenuItem("Reset");
        mitem[3] = new JMenuItem("Delete Queue Member");
        mitem[4] = new JMenuItem("Reset");
        mb.add(menu);

        for (int l = 1; l <= 2; l++) {
            menu.add(mitem[l]);
        }
        mitem[1].addActionListener(this);
        mitem[2].addActionListener(this);

    }

    public void populate(String sn, String cn, String gen, String des) {
        String rows[] = {sn, cn, gen, des};
        model.addRow(rows);

    }

    public void table() {

        table[1] = new JTable();
        srp[3] = new JScrollPane(table[1]);

        p[3].add(srp[3]);
        srp[3].setBounds(50, 90, 800, 300);
        table[1].setBackground(Color.decode("#058dc7"));
        table[1].setForeground(Color.WHITE);
        f[4] = new Font("Arial", Font.BOLD, 14);
        table[1].setFont(f[4]);
        table[1].setEnabled(false);
        table[1].setRowHeight(table[1].getRowHeight() + 15);
        model = (DefaultTableModel) table[1].getModel();
        for (int l = 0; l < 4; l++) {
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

    public void popupmenu() {
        //  pop = new Popupclass(table[1], this);
        // table[1].addMouseListener(this);

    }

    public void setrunningservice(String sn, String n, String type, String des) {
        jtf[5].setText("" + sn);
        jtf[3].setText("" + n);
        jtf[4].setText("" + type);
        jta[2].setText("" + des);

    }

    public void cellallignment() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table[1].getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
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

    public void update(int r) {

        model.removeRow(r);
        int temp = model.getRowCount();
        System.out.println("" + r);
        // System.out.println(""+temp+" "+k);
        for (int i = r; i < temp; i++) {
            table[1].setValueAt("" + (i + 1), i, 0);

        }

    }

    public void font() {
        //panel(1)
        f[1] = new Font("Arial", Font.BOLD, 16);
        f[2] = new Font("Arial", Font.BOLD, 14);
        f[3] = new Font("Arial", Font.BOLD, 20);
        jta[1].setFont(f[1]);
        jl[1].setFont(f[3]);
        //panel(2)
        jtf[3].setFont(f[1]);
        jta[2].setFont(f[2]);
        jtf[4].setFont(f[1]);
        jtf[5].setFont(f[1]);
        menu.setFont(f[1]);
        for (int l = 1; l <= 4; l++) {
            mitem[l].setFont(f[1]);
        }
        //panel2
        jl[8].setFont(f[1]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn[1]) {

            try {
                String str = jta[1].getText().toString();
                Medipopulate t1 = new Medipopulate("", "Updated Msg", "", "" + str);
                rt.senddata(t1);
                jta[1].setText("");
            } catch (IOException ex) {
                Logger.getLogger(Home1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == btn[3]) {

            if (flag == 0) {

                try {
                    this.setrunningservice(table[1].getValueAt(0, 0).toString(), table[1].getValueAt(0, 1).toString(), table[1].getValueAt(0, 2).toString(), table[1].getValueAt(0, 2).toString());
                    model.removeRow(0);
                    Medipopulate t1 = new Medipopulate("", "", "Running", "Remove");
                    rt.senddata(t1);
                } catch (IOException ex) {
                    Logger.getLogger(Home1.class.getName()).log(Level.SEVERE, null, ex);
                }
                flag = 1;

            } else {
                JOptionPane.showMessageDialog(null, "YOU ALREADY START THE SERVICE");
            }

        } else if (e.getSource() == btn[2]) {

            if (flag != 1) {
                JOptionPane.showMessageDialog(null, "Please First Start The Service");
            } else{
                   
                if(table[1].getRowCount()==0)
                {
                     JOptionPane.showMessageDialog(null, "NO PENDING SERVICES");
                }
                else
                {
                       
                try {
                    this.setrunningservice(table[1].getValueAt(0, 0).toString(), table[1].getValueAt(0, 1).toString(), table[1].getValueAt(0, 2).toString(), table[1].getValueAt(0, 2).toString());
                    model.removeRow(0);
                    Medipopulate t1 = new Medipopulate("", "", "Running", "Remove");
                    rt.senddata(t1);
                } catch (IOException ex) {
                    Logger.getLogger(Home1.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
             
            }

        } else if (e.getSource() == mitem[1]) {
            lt.setVisible(true);

        } else if (e.getSource() == mitem[2]) {
         this.dispose();
         FrontFrame f=new FrontFrame();
        }
    }

    public static void main(String[] args) {
        //Home1 frame = new Home1();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            // pop.show(e.getComponent(), e.getX(), e.getY());
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
