package set;

import model.Address;

import java.util.HashSet;
import java.util.Set;

public class SetMaiList {

    public static void main(String[] args) {
        Set<Address> ml=new HashSet<>();
        Address ad1=new Address("j.w.west","11 oak ave","urbana","IL",1005);

        ml.add(ad1);

        boolean isAdded=ml.add(ad1);

        System.out.println("is added:"+isAdded);

        ml.add(new Address("Ralph baker","1142 Maple lane","Mahomet","IL",1002));
        ml.add(new Address("Tom Carltont","876 Elm st","Champign","IL",1001));


        for(Address address:ml){
            System.out.println(address);
        }




    }
}
