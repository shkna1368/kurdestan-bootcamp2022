package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MailList {

    public static void main(String[] args) {
        List<Address> addressList=new ArrayList<>();
        Address ad1=new Address("j.w.west","11 oak ave","urbana","IL",1005);

        addressList.add(ad1);
        addressList.add(new Address("Ralph baker","1142 Maple lane","Mahomet","IL",1002));
        addressList.add(new Address("Tom Carltont","876 Elm st","Champign","IL",1001));


        for(Address address:addressList){
            System.out.println(address);
        }

        System.out.println("---------Sort-----------");
        Collections.sort(addressList,(o1,o2)->o1.getCode()-o2.getCode());
        System.out.println("sorted value");


        for(Address address:addressList){
            System.out.println(address);
        }

        System.out.println("sort2");
        System.out.println();
        Collections.sort(addressList,(o1,o2)->o2.getCode()-o1.getCode());
        for(Address address:addressList){
            System.out.println(address);
        }


    }
}
