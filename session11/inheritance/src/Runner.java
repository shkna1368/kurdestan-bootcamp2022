public class Runner {
    public static void main(String[] args) {
        Car car=new Car("Ferari","Xband",6,4);

        System.out.println("model:"+car.getModel());
        System.out.println("make:"+car.getMake());
        System.out.println("wheel:"+car.getWheel());

        car.describe();
    }
}
