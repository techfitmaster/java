package thread;

/**
 * @Auther: albert
 * @Date: 2019-02-23 14:02
 * @Description: 卖票案例, 测试多个线程操作共享数据的情况
 */
public class Ticket implements Runnable {
    int tickets = 400;
    int ticketSale = 0;

    @Override
    public void run() {
        synchronized (new Object()) {
            while (true) {
                if (tickets <= 0) {
                    break;
                }
                tickets--;
                ticketSale++;
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + "还剩票：" + tickets);
            }
            System.out.println("卖出的票数：" + ticketSale);
        }

    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket, "1号");
        Thread thread2 = new Thread(ticket, "2号");
        Thread thread3 = new Thread(ticket, "3号");
        Thread thread4 = new Thread(ticket, "4号");
        Thread thread5 = new Thread(ticket, "5号");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}

class Ticket1 implements Runnable {
    private int tickets = 400;

    public synchronized void saleTicket() {
        if (tickets <= 0) {
            System.out.println("全部售完");
            return;
        }
        System.out.println(Thread.currentThread().getName() + "还剩票：" + tickets--);
    }

    @Override
    public void run() {
        while (true) {
            if (tickets <= 0) {
                break;
            }
            saleTicket();
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public static void main(String[] args) {
        Ticket1 ticket1 = new Ticket1();
        Thread thread1 = new Thread(ticket1, "1号");
        Thread thread2 = new Thread(ticket1, "2号");
        Thread thread3 = new Thread(ticket1, "3号");
        Thread thread4 = new Thread(ticket1, "4号");
        Thread thread5 = new Thread(ticket1, "5号");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread5.setPriority(Thread.MAX_PRIORITY);
    }
}


class ThreadTest2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println("run...");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest2());
        thread.start();

    }
}
