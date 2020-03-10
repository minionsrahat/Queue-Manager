package Populate;

import Projectdemo.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Serverdemo.*;
import Clientdemo.*;
public class FrontFrame extends JFrame implements ActionListener {

    ImageIcon icon;
    JButton jb[] = new JButton[5];
    JPanel p[] = new JPanel[5];
    JLabel jl[] = new JLabel[10];
    Container c;
    Font f[]=new Font[10];
    String str="Which Queue Service System Do You Want???";

    public FrontFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        intcomponents();
       
   
    }

    public void intcomponents() {
        this.setBounds(100,100,1000,900);
         c=this.getContentPane();
         c.setLayout(null);
       f[1] = new Font("Arial", Font.BOLD, 30);
       f[2] = new Font("Arial", Font.BOLD, 16);
     icon=new ImageIcon(this.getClass().getResource("Capture.jpg"));
     jl[1]=new JLabel(icon);
     jl[1].setBounds(200,10,icon.getIconWidth(),icon.getIconWidth());
     c.add(jl[1]);
     jl[2]=new JLabel(str);
     c.add(jl[2]);
     jl[2].setBounds(110,icon.getIconHeight()+50,690,100);
     jl[2].setFont(f[1]);
     
    jb[1]=new JButton("MOBILE SERVICE SYSTEM"); 
    jb[2]=new JButton("MEDICAL SERVICE SYSTEM");
    c.add(jb[1]);
    c.add(jb[2]);
    jb[1].setBounds(270,550,300,80);
    jb[2].setBounds(270,650,300,80);
    jb[1].setFont(f[2]);
    jb[2].setFont(f[2]);
    
    
    jb[1].addActionListener(this);
    jb[2].addActionListener(this);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    }

    public static void main(String[] args) {
        FrontFrame frame=new FrontFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==jb[1])
        {
            this.dispose();
            SecondFront f=new SecondFront("1");
          
        }
          if(e.getSource()==jb[2])
        {
            this.dispose();
         
            SecondFront f=new SecondFront("2");
          
        }
    }

}
