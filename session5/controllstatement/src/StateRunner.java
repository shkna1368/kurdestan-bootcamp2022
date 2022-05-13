import java.util.Scanner;

public class StateRunner {
    public static void main(String[] args) {

        // get input
        Scanner sc=new Scanner(System.in);
        int month=sc.nextInt();
//if
        if (month==1 || month==2|| month==3){

            System.out.println("bahar");
        }

        else if (month==4|| month==5|| month==6){
            System.out.println("Tawsan");
        }
        else if (month==7|| month==8|| month==9){
            System.out.println("Paeez");
        }

        else if (month==10|| month==11|| month==12){
            System.out.println("Zestan");
        }
        else {
            System.out.println("incorrect number");
        }


     //switch

        String season=switch (month){
            case 1,2,3:
                yield "Bahar";
            case 4,5,6:
                yield "Tawsan";

            case 7,8,9:
                yield "Paeez";


            case 10,11,12:
                yield "Zestan";

            default:
                yield "incorrect number";

        };



        String se="";

        switch (month){
            case 1,2,3:
                se="bahar";
                break;
            case 4,5,6:
                se="Hawin";
                break;

              case 7,8,9:
                se="Paeez";
                break;


              case 10,11,12:
                se="Zestan";
                break;
            default:
                se="incorrect number";

        }

        System.out.println("switch before java 13:"+se);



        System.out.println("Season switch:"+season);

//if
        int number=sc.nextInt();

        if(number%2==0){
            System.out.println("zoj");
        }
        else {
            System.out.println("fard");
        }

    }
}
