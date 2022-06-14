public class ThreadDemo {

    public static void main(String[] args) {
        ThreadOne tr1=new ThreadOne();

        ThreadTwo t2=new ThreadTwo();
        Thread tr2=new Thread(t2,"Thread Two");

        tr1.start();
        tr2.start();

        try {
            for (int i=5;i>0;i--){
                System.out.println("Thread main:"+i);

                Thread.sleep(1000);

            }
        } catch (InterruptedException e){
            System.out.println("Thread one interrupt");
        }

        System.out.println("Main thread exist");



    }
}
