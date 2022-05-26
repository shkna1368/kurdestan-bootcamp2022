public class GenDemo {
    public static void main(String[] args) {
        Gen<Integer> iOb=new Gen<Integer>(88);
        iOb.showType();
        System.out.println("value="+iOb.getOb());

        System.out.println("-------------------");

        Gen<String> strOb=new Gen<>("Generic test");
        strOb.showType();
        System.out.println("value:"+strOb.getOb());

    }
}
