public class WildcardDemo {

    public static void main(String[] args) {
        Integer[] inums={1,2,3,4,5};
        Stats<Integer> iob=new Stats<>(inums);
        double v=iob.average();
        System.out.println("iob average="+v);

        Double[] dums={1.1,2.2,3.3,4.4,5.5};
        Stats<Double> dob=new Stats<Double>(dums);
        double x=dob.average();
        System.out.println("dob average="+x);


        Float[] fnums={1.0f,2.0f,3.0f,4.0f,5.0f};
        Stats<Float> fob=new Stats<Float>(fnums);
        double y=fob.average();
        System.out.println("fnums average="+y);

       if (iob.isSameAverage(dob))
        System.out.println("same");
        else
           System.out.println("differ");

        System.out.println("Averages of iob and dob");

if (iob.isSameAverage(fob))
    System.out.println("same");
else
    System.out.println("differ");


    }
}
