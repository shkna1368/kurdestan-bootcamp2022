package map;

import model.NamePhone;
import model.NamePhoneEmail;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        List<NamePhoneEmail> namePhoneEmailList=new ArrayList<>();
        namePhoneEmailList.add(new NamePhoneEmail("Rebwar","659","reb@gmail.com"));
        namePhoneEmailList.add(new NamePhoneEmail("Zhikan","69252","zhik@gmail.com"));
        namePhoneEmailList.add(new NamePhoneEmail("Awin","5466","awin@gmail.com"));

        namePhoneEmailList.stream().forEach(namePhoneEmail -> System.out.println(namePhoneEmail.getName()+
                " "+namePhoneEmail.getPhone()+" "+
                " "+namePhoneEmail.getEmail()+" "

                ));
        System.out.println("-----------");
        Stream<NamePhone> namePhoneStream=namePhoneEmailList.stream().map(
                (a) ->new NamePhone(a.getName(),a.getPhone())

        );
namePhoneStream.forEach(namePhone -> System.out.println(namePhone.getName()+"-"+namePhone.getPhone()));

    }
}
