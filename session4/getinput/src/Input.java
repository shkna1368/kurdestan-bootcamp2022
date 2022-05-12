import java.util.Scanner;

public class Input {
    public static void main(String[] args) {


        Scanner scanner=new Scanner(System.in);
        int x=    scanner.nextInt();
        int y=scanner.nextInt();

        int sum=x+y;

        System.out.println("You enter:"+x);
        System.out.println("You enter:"+y);

        System.out.println("sum:"+sum);


        System.out.println("------------");

        int max=Math.max(x,y);

        System.out.println("max is"+max);

        int min=Math.min(x,y);
        System.out.println("min is:"+min);

       double pw= Math.pow(x,y);
        System.out.println("pow="+pw);


    }
}
