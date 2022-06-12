public class CustomExceptionRunner {

    static void validated(int age) throws InvalidAgeException {

        if(age<18){
         throw new InvalidAgeException("your age is below 18")   ;

        }

    }

    public static void main(String[] args) {

        try {
            validated(17);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());

        }
    }
}
