package lucky;

public class LuckyTicket {
    static int x = 0;
    static int count = 0;

    static class LuckyThread extends Thread {
        @Override
        public void run() {
            while (true){
                int tmp;

                synchronized (LuckyTicket.class) {
                    if (x < 999999)
                        tmp = x++;
                    else
                        break;
                }

                if ((tmp % 10) + (tmp / 10) % 10 + (tmp / 100) % 10 == (tmp / 1000)
                        % 10 + (tmp / 10000) % 10 + (tmp / 100000) % 10) {
                    synchronized (LuckyTicket.class){
                        count++;
                    }

                    System.out.println(tmp);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new LuckyThread();
        Thread t2 = new LuckyThread();
        Thread t3 = new LuckyThread();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Total: " + count);
    }
}
