/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverdemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import Populate.*;
/**
 *
 * 
 */
public class Sendthread extends Thread{

    public String temp[] = new String[100];
     Home h1;
      //Track  t1;
     
    int i = 1,max;  
    int p=0;
    ServerSocket s;
    Socket s2;
    DataOutputStream dos;
    DataInputStream dis;
    ObjectOutputStream out;
    int ar[]={0,0,0,0,0};
    ArrayList<Track> obj=new ArrayList<>();
    Sendthread(Home h1) throws IOException {
   
      this.h1=h1;
    }
    
    public void Connect() throws IOException
    {
       System.out.println("Waiting..."); 
       s= new ServerSocket(1024);  
       while(i<=5)
       {    
        s2 = s.accept();
        System.out.println("Client :"+i+" Connected");       
        h1.tablestate(i,"Connected");
        Track t1 =new Track(s2,this,i); 
        obj.add(t1);
        
        t1.start();
        max=i-1;
        h1.max=max;
        i++;
      
       }
    // s2.close();
   //  s.close();
     //  dos = new DataOutputStream(s2.getOutputStream());
      // dis = new DataInputStream(s2.getInputStream());
       //out=new ObjectOutputStream(s2.getOutputStream());
     //  System.out.println("connected");
      
      
    }
   
    public void Senddata(Populate t1,int temp) {  
        try{
       System.out.println("");
        ObjectOutputStream out=new ObjectOutputStream(obj.get(temp).s.getOutputStream());
       if(ar[h1.selectdesk]==0)
        {
          dos = new DataOutputStream(obj.get(temp).s.getOutputStream());
          dos.writeInt(h1.selectdesk+1);
          ar[h1.selectdesk]=1;
        }
       // obj.get(temp).dos.writeObject(t1);
       out.writeObject(t1);
        if(temp==max)
        {
           h1.track=0; 
        }
        else
        {
            h1.track++;
           
        }
            
           
        } catch (IOException ex) {
            Logger.getLogger(Sendthread.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    public void deletemsg(int objno,int row) throws IOException
    {
        System.out.println(""+obj);
        ObjectOutputStream out=new ObjectOutputStream(obj.get(objno-1).s.getOutputStream());
        Populate t1=new Populate(""+row,"","Delete","");
        out.writeObject(t1);
       
       
        
    }
    @Override
    public void run()
    {
        
              try {
//            
//            
//            while(true)
//            {
//                  System.out.println("Run method");
//                   dis = new DataInputStream(s2.getInputStream());
//                  int track=dis.readInt();
//                  System.out.println(""+track);
//                  h1.populate_run_services(track);
//                  System.out.println("hello");
//            }
          
                
        
        System.out.println("Waiting..."); 
       s= new ServerSocket(1024);  
       while(i<=5)
       {    
        s2 = s.accept();
        System.out.println("Client :"+i+" Connected");       
        h1.tablestate(i,"Connected");
        Track t1 =new Track(s2,this,i); 
        h1.state[i-1]=i;
        obj.add(t1);
        t1.start();
        max=i-1;
        h1.max=max;
        i++;
      
       }
        
        
        
        
        
        
        
        
        
        
        
        
            
//        try {
//            while(true)
//            {
//             System.out.println("Server run");
//              String str=dis.readUTF();
//              temp[5]=dis.readUTF();
//              int t=Integer.parseInt(temp[5]);
//             if(str.equalsIgnoreCase("Delete"))
//             {
//                  h1.update(t);
//                  String str2=h1.table[1].getValueAt(t, 0).toString();
//                  h1.setrunservice( h1.table[1].getValueAt(t, 0).toString(),h1.table[1].getValueAt(t, 1).toString(),"Client no"+str2+" Directly Added From Queue Table");
//                  //System.out.println("HELLO");
//             }
//             else
//             {
//               h1.setrunservice( h1.table[1].getValueAt(t, 0).toString(),h1.table[1].getValueAt(t, 1).toString(),"");
//                 h1.model.removeRow(0);
//             }
//
//            
//            }
//
//        } catch (IOException ex) {
//            Logger.getLogger(Sendthread.class.getName()).log(Level.SEVERE, null, ex);
//       }
        } catch (IOException ex) {
            Logger.getLogger(Sendthread.class.getName()).log(Level.SEVERE, null, ex);
        }
           }
    public static void main(String[] args) throws IOException {
        Home h=new Home();
               
    }

 
}
