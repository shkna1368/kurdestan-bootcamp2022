package keyvalue;

import model.Address;

import java.util.HashMap;
import java.util.Hashtable;

public class KeyValueDemo {
    public static void main(String[] args) {
        HashMap<Integer, Address> ml=new HashMap<>();
        Address ad1=new Address("j.w.west","11 oak ave","urbana","IL",1005);

        ml.put(1005,ad1);
        ml.put(1002,new Address("Ralph baker","1142 Maple lane","Mahomet","IL",1002));
        ml.put(1001,new Address("Tom Carltont","876 Elm st","Champign","IL",1001));

        System.out.println("getValue:"+ml.get(1005));

        System.out.println("-----------");
        for (Integer i:ml.keySet()){

            System.out.println(ml.get(i));
        }

        System.out.println("-----------------");
        Hashtable<String,Double> balance=new Hashtable<>();

     balance.put("Awin",3255.25)  ;
     balance.put("Zhina",3.26)  ;
     balance.put("Frmisk",99.26)  ;
     balance.put("Zhikan",199.26)  ;

     for (String str:balance.keySet()){
         System.out.println(balance.get(str));
     }



    }
}
