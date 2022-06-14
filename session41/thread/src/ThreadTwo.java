public class ThreadTwo implements Runnable{

    @Override
    public void run() {
        try {
            for (int i=5;i>0;i--){
                System.out.println("Thread two:"+i);

                Thread.sleep(300);

            }
        } catch (InterruptedException e){
            System.out.println("Thread two interrupt");
        }
        System.out.println("Existing  Thread two");


    }
}
