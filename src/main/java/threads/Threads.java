package threads;

public class Threads {
    static Object mon = new Object();
    static volatile char ch = 'A';

    public static void main(String[] args) {
        Thread threadA = new Thread(new WaitNotifyClass('A', 'B'));
        Thread threadB = new Thread(new WaitNotifyClass('B', 'C'));
        Thread threadC = new Thread(new WaitNotifyClass('C', 'A'));
        threadA.start();
        threadB.start();
        threadC.start();
    }

    static class WaitNotifyClass implements Runnable {
        private char curCh;
        private char nextCh;

        public WaitNotifyClass(char curCh, char nextCh) {
            this.nextCh = nextCh;
            this.curCh = curCh;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (mon) {
                    try {
                        while (ch != curCh) {
                            mon.wait();
                        }
                        System.out.print(curCh);
                        ch = nextCh;
                        mon.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
