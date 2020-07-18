package zOther;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-07-17 19:41
 * @from
 **/
public class MyReadWriteLock {
    public MyReadWriteLock() {

    }

    public volatile int read;

    public volatile int write;

    public synchronized void readLock() throws Exception{
        while(write>0){
            this.wait();
        }
        read++;
    }

    public synchronized void unLockRead(){
        read--;
        notifyAll();
    }

    public synchronized void writeLock() throws Exception{
        while(read>0||write>0){
            this.wait();
        }
        write++;
    }

    public synchronized void unLockWrite(){
        write--;
        notifyAll();
    }


    @Test
    public void test() {

    }
}
