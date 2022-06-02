public class LambdaAsArgumentDemo {

    static String stringOpr(StringFunction stringFunction,String str){
       return stringFunction.func(str) ;

    }

    public static void main(String[] args) {
        String inStr="Lambdas add power to Java";
        String outStr;
        outStr=stringOpr((str)->str.toUpperCase(),inStr);
        System.out.println("upercase="+outStr);
        outStr=stringOpr((str)->{
            String result="";
            for(int i=0;i<str.length();i++){
                if(str.charAt(i) !=' ')
                    result+=str.charAt(i);
            }
            return  result;


        },inStr);
        System.out.println("remove space="+outStr);



      StringFunction  reverse=(str)->{
            String result="";
            for(int i=str.length()-1;i>=0;i--){
                    result+=str.charAt(i);
            }
            return  result;
      };
        System.out.println("revers="+stringOpr(reverse,inStr));



    }
}
