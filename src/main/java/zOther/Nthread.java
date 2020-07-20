package zOther;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-07-19 15:38
 * @from
 **/
public class Nthread {
    static int k = 100;
    static Lock lock = new ReentrantLock();
    static Condition[] cn = new Condition[k+1];



    static class MyThread implements Runnable{
        private int mod = 0;
        private int total = 0;
        private int k = 0;
        MyThread(int total,int mod,int k){
            this.mod = mod;
            this.total = total;
            this.k = k;
        }
        @Override
        public void run(){
            lock.lock();
            while(total%k != mod){
                try {
                    cn[mod].await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":"+mod);
            cn[mod+1].signal();
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for(int i = 0;i<cn.length;i++){
            cn[i] = lock.newCondition();
        }

        for (int i = 1; i <= k; i++) {
            new Thread(new MyThread(i,i,k)).start();
        }
    }


}

