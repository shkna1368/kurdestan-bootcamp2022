import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> noVal=Optional.empty();
        Optional<String> hasValue=Optional.of("ABCDEFGH");

        if (noVal.isPresent())
            System.out.println("Dont display");


         if (hasValue.isPresent()){
            System.out.println(" display"+ hasValue.get());

         }

         String defValue=noVal.orElse("Default value");
        System.out.println(defValue);



    }

}
