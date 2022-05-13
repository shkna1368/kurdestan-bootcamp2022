public class Runner {

    public static void main(String[] args) {

      Calculator cl=new Calculator()  ;
        System.out.println("enter 1 number: ");

    int number1=  cl.getValue();
        System.out.println("enter 2 number: ");
    int number2=  cl.getValue();

        System.out.println("sum="+cl.sum(number1,number2));
        System.out.println("min="+cl.minus(number1,number2));


        double pw=cl.pow(number1,number2);


        cl.print(pw);


    }
}
