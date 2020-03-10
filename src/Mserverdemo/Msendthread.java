
package Mserverdemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import MediPopulate.*;
import java.awt.Color;
public class Msendthread extends Thread{
    int i = 1,max;  
    int p=0;
    ServerSocket ss;
    Socket s2;
    DataOutputStream dos;
    DataInputStream dis;
    ObjectOutputStream out;
    int ar[]={0,0,0,0,0};
    ArrayList<Mtrack> obj=new ArrayList<>();
    Admin_Panel h1;
  
     Msendthread(Admin_Panel h1)
     {
         this.h1=h1;
         
     }
    public void send(Medipopulate t1,int track) throws IOException
    {
        ObjectOutputStream out=new ObjectOutputStream(obj.get(track).s.getOutputStream());
        System.out.println("Track "+track);
        System.out.println(""+t1.gen);
        if(ar[track]==0)
        {
            dos=new DataOutputStream(obj.get(track).s.getOutputStream());
            dos.writeInt(track+1);
            ar[track]=1;
        }
    
        out.writeObject(t1);
        System.out.println("Send :"+track);
    }
    public void run()
    {
              
        System.out.println("Waiting..."); 
        try {  
            ss= new ServerSocket(1024);
       while(i<=3)
       {    
        s2 = ss.accept();
        System.out.println("Client :"+i+" Connected");   
        h1.jlabel[i+3].setText("Connected");
        h1.jlabel[i+3].setForeground(Color.GREEN);
      //  h1.tablestate(i,"Connected");
        Mtrack t1 =new Mtrack(s2,this,i); 
        obj.add(t1);
        t1.start();
        max=i-1;
     //   h1.max=max;
        i++;
      
       }
            
            
            
            
        } catch (IOException ex) {
            
            
            
        }
   
    }
}
