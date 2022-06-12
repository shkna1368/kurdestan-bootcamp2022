public class ThirdException {

    public static void main(String[] args) {



      try {



          int a2[]=new int[5];

          a2[0]=30/5;
      }
      catch (ArrayIndexOutOfBoundsException e){

          System.out.println("out of the bounds");
      }
       catch (ArithmeticException e){

          System.out.println("divide by zero");
      }
      finally {
          System.out.println("always run finally");
      }






        System.out.println("end of app");

    }
}
