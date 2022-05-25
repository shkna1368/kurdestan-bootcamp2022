public class Runner {

    public static void main(String[] args) {

        Shape shape=new Square();

        //java old way

        if (shape instanceof Square){
           Square square= (Square) shape;
           square.draw();

        }
        else if (shape instanceof Rectangle){

            Rectangle rectangle= (Rectangle) shape;
            rectangle.draw();
        }
        System.out.println("------------------");
        //java new way

        if (shape instanceof Square square){
            square.draw();
        }

        else if (shape instanceof Rectangle rectangle){
            rectangle.draw();
        }




    }
}
