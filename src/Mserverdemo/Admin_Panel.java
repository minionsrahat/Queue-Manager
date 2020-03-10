package Mserverdemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import MediPopulate.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Populate.*;
public class Admin_Panel extends JFrame implements ActionListener {

    private Container c;
    JPanel jp[] = new JPanel[10];
    JLabel jlabel[] = new JLabel[16];
    JButton jl[] = new JButton[16];
    JTextField jtf[] = new JTextField[30];
    JTextArea jta[] = new JTextArea[30];
    JButton bt[] = new JButton[20];
    JFrame frame;
    Font ft[] = new Font[30];
    int arr[] = {1, 1, 1, 1, 1};
    Medipopulate t1;
    Admin_Panel ad;
    Msendthread st;
    Admin_info f;
    Runservices rs = new Runservices();
    JMenuBar mb;
    JMenu menu;
    JMenuItem mitem[] = new JMenuItem[20];
    LogTable lt=new LogTable();
  public  Admin_Panel() {
        components();
        panel();
        button();
        jlabel();
        menu();
        font();
        this.ad = this;
        st = new Msendthread(this);
        st.start();
    }

    public void components() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 100, 1100, 800);
        c = this.getContentPane();
        c.setLayout(null);
        ft[3] = new Font("Arial", Font.BOLD, 35);

    }

    public void panel() {
        jp[1] = new JPanel();
        c.add(jp[1]);
        jp[1].setBounds(20, 20, 400, 300);
        //   jp[1].setBackground(new Color(57, 44, 99));
        jp[1].setLayout(null);

        jp[2] = new JPanel();
        //  c.add(jp[2]);
        jp[2].setBounds(450, 20, 400, 300);
        //jp[2].setBackground(new Color(57, 44, 99));
        jp[2].setLayout(null);

        jp[3] = new JPanel();
        c.add(jp[3]);
        jp[3].setBounds(450, 20, 400, 300);
        // jp[3].setBackground(new Color(57, 44, 99));
        jp[3].setLayout(null);

        jp[4] = new JPanel();
        c.add(jp[4]);
        jp[4].setBounds(20, 350, 400, 300);
        // jp[4].setBackground(new Color(57, 44, 99));
        jp[4].setLayout(null);

        jp[5] = new JPanel();
        c.add(jp[5]);
        jp[5].setBounds(500, 350, 400, 300);
        //    jp[5].setBackground(new Color(57, 44, 99));
        jp[5].setLayout(null);

//        jp[6] = new JPanel();
//        c.add(jp[6]);
//        jp[6].setBounds(900, 50, 100, 70);
//       // jp[6].setBackground(new Color(57, 44, 99));
//        jp[6].setLayout(null);
    }

    public void button() {
        Font f1 = new Font("Arial", Font.BOLD, 30);

        jl[1] = new JButton("Heart Disease");
        jl[1].setBounds(0, 0, 400, 300);
        jp[1].add(jl[1]);
        jl[1].setFont(f1);
        jl[1].setForeground(new Color(237, 180, 226));
        jl[1].setBackground(new Color(57, 44, 99));
        jl[1].addActionListener(this);

//        jl[2] = new JButton("Diabetes");
//        jl[2].setBounds(0, 0, 400, 300);
//        jp[2].add(jl[2]);
//        jl[2].setFont(f1);
//        jl[2].setForeground(new Color(237, 180, 226));
        jl[3] = new JButton("Eyesight");
        jl[3].setBounds(0, 0, 400, 300);
        jp[3].add(jl[3]);
        jl[3].setFont(f1);
        jl[3].setForeground(new Color(237, 180, 226));
        jl[3].setBackground(new Color(57, 44, 99));
        jl[3].addActionListener(this);

        jl[4] = new JButton("Liver");
        jl[4].setBounds(0, 0, 400, 300);
        jp[4].add(jl[4]);
        jl[4].setFont(f1);
        jl[4].setForeground(new Color(237, 180, 226));
        jl[4].setBackground(new Color(57, 44, 99));
        jl[4].addActionListener(this);

//        jl[5] = new JButton("Lungs");
//        jl[5].setBounds(0, 0, 400, 300);
//        jp[5].add(jl[5]);
//        jl[5].setFont(f1);
//        jl[5].setForeground(new Color(237, 180, 226));
//
//        jl[6] = new JButton("Urology");
//        jl[5].setBounds(0, 0, 400, 300);
//        jp[6].add(jl[6]);
//        jl[6].setFont(f1);
//        jl[6].setForeground(new Color(237, 180, 226));
    }

    public void menu() {
        ft[5] = new Font("Arial", Font.BOLD, 16);
        System.out.println("1111");
        mb = new JMenuBar();
        jp[6] = new JPanel();
        c.add(jp[6]);
        // c.add(mb);
        jp[6].setBounds(900, 30, 100, 70);
        //  jp[6].setBackground(new Color(57, 44, 99));
      //  jp[6].setLayout(null);
        // c.add(jp[6]);
        jp[6].add(mb);
        menu = new JMenu("MENU");
        mb.add(menu);
        mitem[1] = new JMenuItem("History Log Table");
        mitem[2] = new JMenuItem("Running Services");
        // mitem[3] = new JMenuItem("Delete Queue Member");
        mitem[3] = new JMenuItem("Reset");
        menu.setFont(ft[5]);

        for (int l = 1; l <= 3; l++) {
            mitem[l].setFont(ft[5]);
            menu.add(mitem[l]);
        }
        mitem[1].addActionListener(this);
        mitem[2].addActionListener(this);
        mitem[3].addActionListener(this);

    }

    public void jlabel() {
        jlabel[1] = new JLabel("Heart Disease Desk :");
        jp[5].add(jlabel[1]);
        jlabel[1].setBounds(30, 30, 200, 90);
        jlabel[2] = new JLabel("     EyeSight Desk    :");
        jp[5].add(jlabel[2]);
        jlabel[2].setBounds(30, 90, 200, 90);
        jlabel[3] = new JLabel("          Liver       :");
        jp[5].add(jlabel[3]);
        jlabel[3].setBounds(70, 145, 200, 90);

        jlabel[4] = new JLabel("Disconnected");
        jp[5].add(jlabel[4]);
        jlabel[4].setBounds(235, 30, 200, 90);
        jlabel[4].setForeground(Color.red);

        jlabel[5] = new JLabel("Disconnected");
        jp[5].add(jlabel[5]);
        jlabel[5].setBounds(235, 90, 200, 90);
        jlabel[5].setForeground(Color.red);

        jlabel[6] = new JLabel("Disconnected");
        jp[5].add(jlabel[6]);
        jlabel[6].setBounds(235, 145, 200, 90);
        jlabel[6].setForeground(Color.red);
    }

    public void font() {
        ft[2] = new Font("Arial", Font.BOLD, 20);
        jlabel[1].setFont(ft[2]);
        jlabel[2].setFont(ft[2]);
        jlabel[3].setFont(ft[2]);
        jlabel[4].setFont(ft[2]);
        jlabel[5].setFont(ft[2]);
        jlabel[6].setFont(ft[2]);
    }

    public void populate_run_services(int desk) {
        Medipopulate t1 = new Medipopulate(rs.table[desk].getValueAt(0, 0).toString(), rs.table[desk].getValueAt(0, 1).toString(), "", "");
        if (desk == 1) {
            rs.populate_desk_1(t1);
        } else if (desk == 2) {
            rs.populate_desk_2(t1);
        } else if (desk == 3) {
            rs.populate_desk_3(t1);
        }
        rs.model[desk].removeRow(0);
    }

    public void setpopulate(Medipopulate t1) {
        System.out.println("admin panel");
        this.t1 = t1;

        System.out.println("" + this.t1.gen);
    }

    public static void main(String args[]) {
        Admin_Panel f = new Admin_Panel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jl[1])//heart Disease
        {

            try {
                System.out.println("hello");
                Admin_info f = new Admin_info(ad, "" + jl[1].getText(), 0, arr[0]++);

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        if (e.getSource() == jl[3])//eyesight
        {
            try {
                f = new Admin_info(this, "" + jl[3].getText().toString(), 1, arr[1]++);

            } catch (Exception ex) {
                System.out.println("" + ex);
            }

        }

        if (e.getSource() == jl[4])//liver
        {
            try {
                Admin_info f = new Admin_info(this, "" + jl[4].getText().toString(), 2, arr[2]++);

            } catch (Exception ex) {
                System.out.println("Exception");
            }
        }
        
        if(e.getSource()==mitem[1])
        {
            lt.setVisible(true);
        }
        if(e.getSource()==mitem[2])
        {
            rs.setVisible(true);
        }
           if(e.getSource()==mitem[3])
        {
           this.dispose();
           FrontFrame f=new FrontFrame();
        }

    }

}
