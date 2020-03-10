package Clientdemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import Populate.*;
public class Recivethread extends Thread {

    Home1 h1;
    Socket s = null;
    DataInputStream dis;
    DataOutputStream dos;
    ObjectInputStream out;
    ObjectOutputStream oin;
    Populate t1;
    int flag=0;
    int serialcode=0;
   public Recivethread(String host) throws IOException {
        s = new Socket(host, 1024);
        System.out.println("connected!!");
      
        dis = new DataInputStream(s.getInputStream());
        dos = new DataOutputStream(s.getOutputStream());
        System.out.println("Started"); 
        super.start();
       
    }

    public void Call(Recivethread rt) throws IOException {
        h1 = new Home1(rt);
        Populate t1=new Populate(""+h1.model.getRowCount(),"","","");
       // this.send(t1);
    }

    public void Connect() throws IOException {
        //  System.out.println("");

    }

    public void send(Populate t1) throws IOException {
        //  index--;
        //dos.writeUTF(str);
       // dos.writeUTF("" + index);
       // System.out.println("" + index);
        oin=new ObjectOutputStream(s.getOutputStream());
        System.out.println(""+t1.cn);
        System.out.println(""+serialcode);
        oin.writeObject(t1);
        dos.writeInt(serialcode);
        // dos.write(0);
    }

    @Override
    public void run() {
        int i = 1;
        String temp[] = new String[100];
        while (true) {

            try {
     
               out=new ObjectInputStream(s.getInputStream());
//                // DataOutputStream dos = new DataOutputStream(s.getOutputStream());
//                //  Thread.sleep(10000);
//                temp[0] = dis.readUTF();
//                temp[1] = dis.readUTF();
//                temp[2] = dis.readUTF();
//                temp[3] = dis.readUTF();
//                System.out.println("" + temp[0]);
//                if (temp[1].equals("0") || temp[2].equals("Remove")) {
//                    int p = Integer.parseInt(temp[3]);
//                    h1.update(p);
//
//                } else {
//                    h1.populate(temp[0], temp[1], temp[2], temp[3]);
//                    h1.lt.populate(temp[0], temp[1], temp[2], temp[3]);
//                    h1.lt.filewriter(temp[0], temp[1], temp[2], temp[3]);
//                }
                if(flag==0)
                {
                    serialcode=dis.readInt();
                     h1.border[2].setTitle("RUNNING SERVICE DESK "+serialcode);
                   // h1.panel();
                    flag=1;
                }
                t1=(Populate)out.readObject();
                if(t1.t.equalsIgnoreCase("Delete"))
                {
                    h1.update(Integer.parseInt(""+t1.sn));
                }
                else{
                    h1.populate(t1.sn.toString(),t1.cn.toString(),t1.t.toString(),t1.d.toString());
                    h1.lt.populate(t1);
                    Populate t2=new Populate(""+h1.model.getRowCount(),"","","");
                    
                    System.out.println("total row :"+h1.model.getRowCount());
                    this.send(t2);
                }
              
              //  h1.lt.populate(temp[0], temp[1], temp[2], temp[3]);
              //     h1.lt.filewriter(temp[0], temp[1], temp[2], temp[3]);



            } catch (Exception ex) {
                System.out.println("DisConnected From Server");
                break;
            }

        }
    }

    public static void main(String[] args) throws IOException {

        Recivethread rt = new Recivethread("localhost");
        System.out.println("hello");
        rt.Call(rt);
        System.out.println("visible");
        //rt.Connect();

    }
}
