
package Mserverdemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import MediPopulate.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin_info extends JFrame implements ActionListener{
    
    Container c = new Container();
    JPanel jp[] = new JPanel[10];
    JLabel jl[] = new JLabel[10];
    JTextField jtf[] = new JTextField[30];
    JTextArea jta[] = new JTextArea[30];
    JButton btn[] = new JButton[20];
    JComboBox jcb[]=new JComboBox[3];
    JFrame frame;
    Font f[] = new Font[30];
    String combo[]={"Male","Female"};
    Admin_Panel h1;
    String disease;
    int track;
    int serial;
    Medipopulate t1;
    Admin_info(Admin_Panel h1,String disese,int track,int serial){
       this.h1=h1;
       components();
       panel();
       label();
       textfield();
       Jcombobox();
       button();
       font();
     
     
       this.disease=disese;
       this.track=track;
       this.serial=serial;
       this.setVisible(true);
       
    }
     public void components(){
      
        this.setBounds(630, 250, 650,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        //f[1] = new Font("Arial", Font.BOLD, 25);
        
    }
     
    public void panel(){
        jp[1] = new JPanel();
        c.add(jp[1]);
        jp[1].setBounds(60, 10, 500, 300);
        jp[1].setBackground(new Color(48, 52, 91));
        
    }
    public void label(){
        jl[1] = new JLabel("Name");
        jp[1].setLayout(null);
        jl[1].setForeground(Color.WHITE);
        jp[1].add(jl[1]);
        jl[1].setBounds(20, 30, 100, 50);
        
        jl[2] = new JLabel("Gender");
        jl[2].setForeground(Color.WHITE);
        jp[1].add(jl[2]);
        jl[2].setBounds(20, 90, 100, 50);
        
        jl[3] = new JLabel("Description");
        jl[3].setForeground(Color.WHITE);
        jp[1].add(jl[3]);
        jl[3].setBounds(20, 150, 100, 50);

    }
    public void textfield(){
        jtf[1] = new JTextField();
      //  jta[1] = new JTextArea();
        
        jp[1].add(jtf[1]);
        jtf[1].setBounds(200, 37, 210, 40);

        jtf[2] = new JTextField();
        jta[2] = new JTextArea();

        //jp[1].add(jtf[2]);
        jtf[2].setBounds(200, 100, 210, 40);
        
        jta[1] = new JTextArea();
        jp[1].add(jta[1]);
        jta[1].setBounds(200, 160, 210, 40);

    }
    public void Jcombobox()
    {
        jcb[1]=new JComboBox(combo);
        jcb[1].setBounds(200, 100, 210, 40);
        jp[1].add(jcb[1]);
        
    }
    public void button(){
        btn[1] = new JButton();
        jp[1].add(btn[1]);
        btn[1].setText("Add");
        btn[1].setBounds(200, 210, 90, 60);
        btn[1].addActionListener(this);
    }
    public void font()
    {
        f[1] = new Font("Arial", Font.BOLD, 16);
        jtf[1].setFont(f[1]);
        jta[1].setFont(f[1]);
    }
    public static void main(String[] args) {
       // new Admin_info();
        
    }
    public Medipopulate get()
    {
        return t1;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn[1])
        {
      try {
          if(jtf[1].getText().toString().matches("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}") == false) 
          {
              JOptionPane.showMessageDialog(null, "ENTER VALID CLIENT NAME");
          }
          
         
            else if (jta[1].getText().toString().matches("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}") == false) {

                JOptionPane.showMessageDialog(null, "ENTER VALID SHORT DISCRIPTION");

            }
          else
            {
                
                 t1=new  Medipopulate(""+serial,""+jtf[1].getText().toString(),""+jcb[1].getSelectedItem().toString(),""+jta[1].getText().toString());
                 h1.rs.populate(track+1, t1);
                 h1.lt.populate(t1, disease);
                 h1.lt.filewriter(t1, disease);
                 System.out.println(""+t1.sn+"  "+t1.cn);
                 h1.st.send(t1, track);
                
            }
          
               
            } catch (IOException ex) {
                Logger.getLogger(Admin_info.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }
        
        
    }
}
