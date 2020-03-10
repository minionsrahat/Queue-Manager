package Populate;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Homepage extends JFrame implements Runnable{

    Container c;
    JProgressBar jp = new JProgressBar();
    JLabel jl[] = new JLabel[10];
    ImageIcon icon;
    Font f[]=new Font[10];
    Thread th;
    int s;
    public Homepage() {
        
        initcomponents();
         th=new Thread((Runnable)this);
         this.setuploading();
         this.setVisible(true);
    }
    @Override
    public void run() 
    {
    for (int i = 0; i <=301; i++) {
        s=s+1;
        int m=jp.getMaximum();
        int v=jp.getValue();
        if(v<m)
        {
            jp.setValue(jp.getValue()+1);
        }
        else if(i==301)
        {
            System.out.println("Completed");
           FrontFrame f=new FrontFrame();
           this.dispose();
           
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
   
}

public void setuploading()
{
   
    th.start();
}
    public void initcomponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1000, 900);
        c = this.getContentPane();
        c.setLayout(null);
        URL url = getClass().getResource("gif2.gif");
        icon = new ImageIcon(url);
        jl[1] = new JLabel(icon);
        jl[1].setBounds(50,0, icon.getIconWidth(), icon.getIconWidth());
        c.add(jl[1]);
     //   this.setUndecorated(true);
        jp = new JProgressBar(JProgressBar.VERTICAL,0, 300);
        jp.setBounds(920, 200, 30, 500);
        jp.setValue(1);
          jp.setString("Loading..");
       // jp.
        jp.setStringPainted(true);
         c.add(jp);
       c.setBackground(Color.BLACK);
      f[1] = new Font("Arial", Font.BOLD, 25);       
       jl[2]=new JLabel("PLEASE WAIT........");
     jl[2].setForeground(Color.red);
      c.add(jl[2]);
     jl[2].setBounds(350,730,200,100);
     jl[2].setFont(f[1]);
    }

    public static void main(String[] args) {
        Homepage h = new Homepage();
        //h.setVisible(true);
    }
}
