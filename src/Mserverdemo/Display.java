/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mserverdemo;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame{
    private Container c;
    JPanel jp[] = new JPanel[12];
    JButton jb[] = new JButton[10];
    Font f;
    JLabel jl[] = new JLabel[12];
    JTextField jtf[] = new JTextField[12];
    
    
    
    Display()
    {
        component();
        panel();
        button();
        label();
        textfield();
    }
    
    public void component()
    {
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 50, 1000, 900);
        //c = new Container();
        c = this.getContentPane();
        c.setLayout(null);
        f = new Font("ARIAL", Font.BOLD, 35);
        
        
        
    }
    public void panel()
    {
        jp[1] = new JPanel();
        c.add(jp[1]);
        jp[1].setBounds(10, 20, 1000, 120);
        jp[1].setBackground(Color.yellow);
        jp[1].setLayout(null);
    }
    
    public void button()
    {
        jb[1] = new JButton();
        c.add(jb[1]);
        jb[1].setBounds(15, 30, 100, 50);
        jb[1].setText("hi");
        jb[1].setFont(f);
        
    }
    
    public void label()
    {
        jl[1] = new JLabel();
        jp[1].add(jl[1]);
        jl[1].setBounds(130,30,150,100);
        jl[1].setText("HI everybody");
    }
    
    public void textfield()
    {
        jtf[1] = new JTextField();
        c.add(jtf[1]);
        jtf[1].setBounds(10, 130, 1000, 100);
        jtf[1].setBackground(Color.BLACK);
        jtf[1].setForeground(Color.RED);
        jtf[1].setFont(f);
        jtf[1].setHorizontalAlignment(JTextField.RIGHT);
    }
    
    
    public static void main(String[] args) {
        new Display();
    }
}
