
package MediPopulate;

import java.io.Serializable;

public class Medipopulate implements Serializable{
  public String sn;
   public String cn;
  public String gen;
  public String d;

    public Medipopulate(String sn, String cn, String gen, String d) {
        this.sn = sn;
        this.cn = cn;
        this.gen = gen;
        this.d = d;
    }
    
    
   
}
