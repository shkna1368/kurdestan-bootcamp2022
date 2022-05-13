public class StringModifierRunner {


    public static void main(String[] args) {

        String str="Hello , Im from kurdestan.Im kurdish";

        int strLength=str.length();
        System.out.println("Length="+strLength);

        String lowStr=str.toLowerCase();
        String upStr=str.toUpperCase();

        System.out.println("uppercase="+str.toUpperCase());
        System.out.println("uppercase="+str.toLowerCase());

        boolean equal1=lowStr.equals(upStr);
        System.out.println(equal1);
        boolean equal2=lowStr.equalsIgnoreCase(upStr);
        System.out.println(equal2);

      char[] crs=  str.toCharArray();

      String rps=str.replace("l","e");
        System.out.println(rps);

      char c=  str.charAt(3);
        System.out.println(c);
      int index=  str.indexOf("kurdestan");
        System.out.println(index);

        


    }
}
