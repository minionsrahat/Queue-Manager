
package Mserverdemo;

import java.awt.*;
import javax.swing.*;


public class Doctor_Interface extends JFrame{

    private Container c;
    Font f[] = new Font[12];
    JPanel jp[] = new JPanel[12];
    JButton jb[] = new JButton[12];
    JLabel jl[] = new JLabel[12];
    
    
    
    Doctor_Interface(){
        components();
        label();
        panel();
        button();
        
    }
    
    public void components(){
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 100, 800, 400);
        
        c = this.getContentPane();
        c.setLayout(null);
        
        f[1] = new Font("Arial", Font.BOLD, 25);

    }
    
    public void panel(){
        jp[1] = new JPanel();
        c.add(jp[1]);
        jp[1].setLayout(null);
        jp[1].setBounds(0, 0, 800, 400);
        jp[1].setBackground(new Color(32, 37, 89));
        
    }
    
    public void button(){
        jb[1] = new JButton();
        jp[1].add(jb[1]);
        jb[1].setBounds(60, 200, 100, 50);
        jb[1].setText("NEXT");
        
        jb[2] = new JButton();
        jp[1].add(jb[2]);
        jb[2].setBounds(200, 200, 100, 50);
        jb[2].setText("Recall");
        
        jb[3] = new JButton();
        jp[1].add(jb[3]);
        jb[3].setBounds(340, 200, 200, 50);
        jb[3].setText("Send to Pathology");
        
    }
    public void label(){
        jl[1] = new JLabel();
        c.add(jl[1]);
        jl[1].setBounds(55, 70, 250, 50);
        jl[1].setText("Token number 12");
        jl[1].setForeground(Color.black);
        jl[1].setBackground(Color.red);
        jl[1].setOpaque(rootPaneCheckingEnabled);
        jl[1].setFont(new Font("Arial", Font.BOLD, 25));
        
    }
    
    public static void main(String[] args) {
        Doctor_Interface f = new Doctor_Interface();
        f.setTitle("Doctor's Interface");
    }

 
}
