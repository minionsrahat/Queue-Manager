package MediClientdemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import MediPopulate.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mrecivethread extends Thread {

    Home1 h1;
    Socket s = null;
    DataInputStream dis;
    DataOutputStream dos;
    ObjectInputStream oin;
    ObjectOutputStream out;
    Medipopulate t1;
    int flag = 0;
    int serialcode;

    public Mrecivethread(String host) throws IOException {
        s = new Socket("localhost", 1024);
        System.out.println("connected!!");
        dis = new DataInputStream(s.getInputStream());
        dos = new DataOutputStream(s.getOutputStream());
        
        System.out.println("Started");
        super.start();

    }
 public void senddata(Medipopulate t1) throws IOException         
 {
        out=new ObjectOutputStream(s.getOutputStream());
        System.out.println(""+serialcode);
        out.writeObject(t1);
        dos.writeInt(serialcode);
 }
    
public void call()
{
    h1=new Home1(this);
    
}
    public void run() {
       
        
        while (true) {
            try {
             // dis = new DataInputStream(s.getInputStream());
               oin= new ObjectInputStream(s.getInputStream()) ;
                System.out.println("hello");
                if (flag == 0) {
                    serialcode = dis.readInt();
                    flag = 1;
                    System.out.println(""+serialcode);
                    if(serialcode==1)
                    {
                      h1.border[2].setTitle("HEART DISEASE DESK");
                   //    h1.Tborder="HEART DISEASE DESK";
                            
                    }
                      if(serialcode==2)
                    {
                        h1.border[2].setTitle("EYESIGHT DESK");
                    }
                        if(serialcode==3)
                    {
                        h1.border[2].setTitle("LIVER DESK");
                    }
                }
                 t1=(Medipopulate)oin.readObject();
                if(t1.gen.equalsIgnoreCase("Delete"))
                {
                    h1.update(Integer.parseInt(""+t1.sn));
                }
                else{
                   System.out.println(""+t1.cn);
                   h1.populate(t1.sn.toString(),t1.cn.toString(),t1.gen.toString(),t1.d.toString());
                   h1.lt.populate(t1);
                }
              
                
                
                
            } catch (Exception e) {

            }
        }
    }
    public static void main(String[] args) throws IOException {
        Mrecivethread rt=new Mrecivethread("local");
        rt.call();
    }
}
