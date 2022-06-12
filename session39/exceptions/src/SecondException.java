public class SecondException {

    public static void main(String[] args) {

      try {
          int a=20;
          int x=0;

          int result=a/x;
      }
      catch (ArithmeticException e){

          System.out.println("divide by zero is imposible");
      }


      try {
          int a2[]=new int[5];

          a2[10]=50;
      }
      catch (ArrayIndexOutOfBoundsException e){
          System.out.println("out of bound ");
      }




        System.out.println("end of app");

    }
}
