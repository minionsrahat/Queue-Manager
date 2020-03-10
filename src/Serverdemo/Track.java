package Serverdemo;

import Populate.Populate;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Track extends Thread {

    Socket s;
    ObjectOutputStream dos;
    ObjectInputStream din;
    Sendthread st;
    int i;
    public Track(Socket s, Sendthread st,int i) throws IOException {
        this.s = s;
        this.st = st;
        // dos=new ObjectOutputStream(s.getOutputStream());
        //  dis=new ObjectInputStream(s.getInputStream());
        this.i=i;
    }

    public void run() {
        while (true) {

            try {
                System.out.println("Run method");
                DataInputStream dis = new DataInputStream(s.getInputStream());
                din=new ObjectInputStream(s.getInputStream());
                Populate t1=(Populate)din.readObject();
                int track=dis.readInt();
               // System.out.println("track:"+track);
               System.out.println("total row :"+t1.sn);
                st.h1.client[i-1]=Integer.parseInt(t1.sn);
                //st.h1.selectdesk();
             //   System.out.println("track  ::"+st.h1.client[i-1]);
                if(t1.t.equalsIgnoreCase("Running"))
                {
                    st.h1.tablestate(track,""+t1.t);
                }
                if(t1.cn.equalsIgnoreCase("Remove"))
                {
                  st.h1.populate_run_services(track);
                }
               if(t1.cn.equalsIgnoreCase("Updated Msg"))
               {
                   System.out.println(""+t1.d);
                   st.h1.rs.jtf[(track)*3].setText(""+t1.d);
               }      
            
               //System.out.println(""+st.obj.get(0).hashCode());
            } catch (IOException ex) {
                 st.h1.state[i-1]=0;
                System.out.println("Server Desk :"+i+" Disconnected");
                st.h1.table[1].setValueAt("Disconnected", i-1, 2);
                break;
                
            } catch (ClassNotFoundException ex) {
                System.out.println("Exception");
            }

        }
    }
}
