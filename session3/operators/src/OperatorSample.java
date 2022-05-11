public class OperatorSample {

    public static void main(String[] args) {
       int x=50;
       int y=10;

      int sum= x+y;
      int mul=x*y;
      int min=x-y;
      int div=x/y;

        System.out.println("sum="+sum);
        System.out.println("m="+mul);
        System.out.println("div="+div);
        System.out.println("min="+min);
        System.out.println("--------Assignment value--------");

        System.out.println( x+=20);
        System.out.println( x-=5);
        System.out.println(" -------------Compare operator------------");

        boolean result= y==25;
        System.out.println("reult is:"+result);

        boolean result2= y==10;
        System.out.println("reult is:"+result2);

        System.out.println(x>200);
        System.out.println(x>=200);

        System.out.println("------Logical operator-----");

        boolean s1=(x>10 && y>20);
        System.out.println("and="+s1);

        System.out.println(x>10 || y>20);
        boolean s2=!(x>10 && y>20);
        System.out.println("!="+s2);

        String s5="Hi";
        String s6="Kurdestan";
        System.out.println(s5+s6);
        System.out.println(s5+x);
        System.out.println(s5+x+y);









    }


}
