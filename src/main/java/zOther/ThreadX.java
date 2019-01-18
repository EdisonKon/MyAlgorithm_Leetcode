package zOther;

import org.junit.Test;

/**
 * @description: 描述
 * @author: dekai.kong
 * @date: 2019-01-18 10:14
 * @from
 */

public class ThreadX extends Thread{
    private int x;
    public ThreadX(int x) {
        this.x = x+1;
    }
    @Override
    public void run() {
        System.out.println("MyThread:"+x);
    }

    @Test
    public void test() {

    }
}

