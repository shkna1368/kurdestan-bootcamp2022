public  class Vehicle {

    private String model;
    private String make;
    private int age;

    public Vehicle(String model, String make, int age) {
        System.out.println("Vehicle constructor is call");
        this.model = model;
        this.make = make;
        this.age = age;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void describe(){
        System.out.println(age+"-"+make+"-"+model);
    }

     public final void describe2(){
        System.out.println(age+"-"+make+"-"+model);
    }
}
