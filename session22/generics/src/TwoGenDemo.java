public class TwoGenDemo {
    public static void main(String[] args) {
        TwoGen<Integer,String> tgObj=new TwoGen<>(88,"Generic");
        tgObj.showType();
        System.out.println("value integer:"+tgObj.getOb1());
        System.out.println("value String:"+tgObj.getOb2());

        System.out.println("-----------");
    }
}
