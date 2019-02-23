package thread;

/**
 * @Auther: albert
 * @Date: 2019-02-23 12:58
 * @Description:
 */
public class ThreadTest implements Runnable{




    @Override
    public void run() {
        System.out.println("新建一个线程");

        while (true) {
            System.out.println("run....");
        }
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " run...");
                }

            }
        });
        thread.start();
        thread.resume();



        Thread thread1 = new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " run...");;
            }

        });
        thread1.start();



    }
}

