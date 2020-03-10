
package Populate;

//import Serverdemo.*;
import java.io.Serializable;


public class Populate implements Serializable{
   public String sn;
   public String cn;
   public String d;
   public String t;

    public Populate(String sn, String cn, String t,String d) {
        this.sn = sn;
        this.cn = cn;
        this.d = d;
        this.t = t;
    }
}
