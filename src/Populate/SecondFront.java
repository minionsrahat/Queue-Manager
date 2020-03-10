package Populate;

import Projectdemo.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Serverdemo.*;
import Clientdemo.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import MediClientdemo.*;
import Mserverdemo.*;

public class SecondFront extends JFrame implements ActionListener {

    JButton jb[] = new JButton[5];
    JLabel jl[] = new JLabel[10];
    Container c;
    Font f[] = new Font[10];
    String str = "Working As A???";
    String str3 = "";

    public SecondFront(String str3) {
        initcomponents();
        this.str3 = str3;
    }

    public void initcomponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 600, 600);
        c = this.getContentPane();
        c.setLayout(null);
        f[1] = new Font("Arial", Font.BOLD, 22);
        f[2] = new Font("Arial", Font.BOLD, 16);

        jl[1] = new JLabel(str);
        jl[1].setBounds(200, 100, 300, 200);
        c.add(jl[1]);
        jl[1].setFont(f[1]);

        jb[1] = new JButton("MASTER DESK");
        jb[2] = new JButton("SERVICE PROVIDER DESK");
        c.add(jb[1]);
        c.add(jb[2]);
        jb[1].setBounds(160, 240, 300, 80);
        jb[2].setBounds(160, 340, 300, 80);
        jb[1].setFont(f[2]);
        jb[2].setFont(f[2]);
        jb[1].addActionListener(this);
        jb[2].addActionListener(this);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        //  SecondFront frame=new SecondFront();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jb[1]) {

            if (str3.equalsIgnoreCase("1")) {

                try {

                    Home h1 = new Home();
                    // h1.setVisible(true);
                    this.dispose();
                } catch (IOException ex) {
                    System.out.println("eXCEPTION");
                }

            } else {

                Admin_Panel f = new Admin_Panel();
                this.dispose();

            }

        }

        if (e.getSource() == jb[2]) {

            if (str3.equalsIgnoreCase("1")) {
                try {
                    System.out.println("hello");
                    String str = JOptionPane.showInputDialog("Input Server Host IP");
                    Recivethread rt = new Recivethread(str);
                    rt.Call(rt);
                    System.out.println("visible");
                    this.dispose();

                } catch (IOException ex) {
                    System.out.println("Exception");
                }
            } else {

                try {
                    String str = JOptionPane.showInputDialog("Input Server Host IP");
                    Mrecivethread rt;

                    rt = new Mrecivethread(str);
                    rt.call();
                    this.dispose();
                } catch (IOException ex) {
                    Logger.getLogger(SecondFront.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }
}
