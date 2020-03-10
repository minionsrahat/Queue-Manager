
package Mserverdemo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import MediPopulate.*;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.Serializable;

public class Mtrack extends Thread{

    
   Socket s;
    ObjectOutputStream dos;
    ObjectInputStream din;
    Msendthread st;
    int i;
    int track;
    public Mtrack(Socket s, Msendthread st, int i) {
        this.s = s;
        this.st = st;
        this.i = i;
    }

    public void run()
    {
     while (true) {

            try {
                System.out.println("Run method");
                DataInputStream dis = new DataInputStream(s.getInputStream());
                din=new ObjectInputStream(s.getInputStream());
                Medipopulate t1=(Medipopulate)din.readObject();
                 track=dis.readInt();
                System.out.println("track from run:"+track);
                System.out.println(""+t1.sn);
                if(t1.gen.equalsIgnoreCase("Running"))
                {
                    st.h1.jlabel[track+3].setText("Running");
                    st.h1.jlabel[(track)+3].setForeground(Color.blue);
                }
                if(t1.d.equalsIgnoreCase("Remove"))
                {
                    
                    
                 st.h1.populate_run_services(track);
                }
               if(t1.cn.equalsIgnoreCase("Updated Msg"))
               {
                   System.out.println(""+t1.d);
                   st.h1.rs.jtf[track*3].setText(""+t1.d);
                  
                   
               }      
            
               //System.out.println(""+st.obj.get(0).hashCode());
            } catch (IOException ex) {
                  
                   System.out.println("Server Desk :"+i+" Disconnected");
                   st.h1.jlabel[i+3].setText("Disconnected");
                   st.h1.jlabel[i+3].setForeground(Color.RED);
                   break;
                
            } catch (ClassNotFoundException ex) {
                System.out.println("Exception");
            }

        }
        
    }
}
