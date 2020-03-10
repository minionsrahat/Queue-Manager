
package Projectdemo;

import java.awt.Container;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SecondFront  extends JFrame {
         
  
     JButton jb[] = new JButton[5];
    JLabel jl[] = new JLabel[10];
    Container c;
    Font f[]=new Font[10];
    String str="Working As A???";
    public SecondFront() {
        initcomponents();
        
    }
    
    public void initcomponents()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setBounds(100,100,600,600);
       c=this.getContentPane();
       c.setLayout(null);
       f[1] = new Font("Arial", Font.BOLD, 22);
       f[2] = new Font("Arial", Font.BOLD, 16);
 
     jl[1]=new JLabel(str);
     jl[1].setBounds(200,100,300,200);
     c.add(jl[1]);
     jl[1].setFont(f[1]);
     
    jb[1]=new JButton("MASTER DESK"); 
    jb[2]=new JButton("SERVICE PROVIDER DESK");
    c.add(jb[1]);
    c.add(jb[2]);
    jb[1].setBounds(160,240,300,80);
    jb[2].setBounds(160,340,300,80);
    jb[1].setFont(f[2]);
    jb[2].setFont(f[2]);
    this.setVisible(true);
    }
    
    
    public static void main(String[] args) {
       SecondFront frame=new SecondFront();
    }
}
