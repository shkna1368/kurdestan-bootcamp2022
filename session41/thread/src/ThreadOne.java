public class ThreadOne extends Thread{
    public ThreadOne() {
        super("ThreadOne");
        System.out.println("Thread one:"+this);
    }

    @Override
    public void run() {
      try {
          for (int i=5;i>0;i--){
              System.out.println("Thread One:"+i);
              Thread.sleep(500);

          }
      } catch (InterruptedException e){
          System.out.println("Thread one interrupt");
      }
        System.out.println("Existing  Thread One");

    }
}
