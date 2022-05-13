import java.util.Scanner;

public class Calculator {

    public int sum(int x,int y){
       int reult=x+y;

       return reult;

    }


    public int minus(int x,int y){
       return x-y;

    }

    public void print(int num){
        System.out.println(num);
    }

    public void print(double num){
        System.out.println(num);
    }

    public double pow(int x,int y){
        return Math.pow(x, y);

    }

    public int getValue(){
        Scanner scanner=new Scanner(System.in);

        return scanner.nextInt();

    }





}
