package saone;

public class Dog  extends Animal{


    private String color;

    public Dog() {
    }

    public void display(){

        System.out.println(" the animal is dog");
    }

    private void makeSound(){

        System.out.println(" Dog Sound");
    }

      protected String print(String msg){

        System.out.println(msg);

        return  msg;
    }




}
