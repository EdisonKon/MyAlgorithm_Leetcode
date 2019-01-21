package zOther;

import java.lang.reflect.Field;

/**
 * @description: 描述
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-11-05 17:26
 */


public class TestJava {
    public static void main(String[] args) {

        /**
        String a = "201810";
//        System.out.println(a.substring(4));
        System.out.println(a.substring(0,1));
        System.out.println(11 / 2);
        int ax = 10;
        String ks = "#"+StringUtils.join(Arrays.asList("bbbb".split("")),"#")+"#";
        System.out.println(ks);
        int b = ax;
        b = 3;
        System.out.println(a+"--"+b);

        Integer z = new Integer(1);
        Integer x = z;
        x = 9;
        String xx = "";
        System.out.println(x.hashCode());
        System.out.println(z.hashCode());
        System.out.println(z+"--"+x);

        String num = "123456";
        Integer index = 0;
        System.out.println(parseInt(num,index));
        Integer c1 = 0;
        System.out.println("c1:"+c1);
        System.out.println("index:"+index);

        List<Integer> lx = new ArrayList<>();
        lx.add(1);
        lx.add(2);
        lx.add(3);
        Integer[] xa = lx.toArray(new Integer[lx.size()]);
        System.out.println(lx);
        System.out.println("znm3");
        StringBuffer sv = new StringBuffer("vvv");//线程安全
        StringBuilder ac = new StringBuilder("avc");//线程不安全
        sv.reverse();
        ac.reverse();
        System.out.println(1235%100);
//        System.out.println(Integer.parseInt("888888888888"));
        char[] b123 = new char[9];
        System.out.println(b123);
        char[]   data={'a','b','c'};
        String  s=new   String(data);
        System.out.println(s);
        //字符串的list可以直接转成字符串数组
        List<String> lxs = new ArrayList<>();
        lxs.add("1");
        lxs.add("2");
        lxs.add("3");
        String[] xas = lxs.toArray(new String[lxs.size()]);
        System.out.println(xas);
        //null == 0时 报空指针
        Integer axa = null;
//        System.out.println(axa == 0);
        */

        //线程
        try {
            xmain();
//            xmain3();
//            xmain2();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static int parseInt(String num,int index){
        int result = 0;
        while(index < num.length() && num.charAt(index)<='9' && num.charAt(index)>='0'){
            result = result *10 + (num.charAt(index) - '0');
            index += 1;
        }
        Integer x1 = 0;
        Field field = null;
        try {
            field = x1.getClass().getDeclaredField("value");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);
        try {
            field.set(x1,index);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    static int c = 0;

    //jvm锁粗话问题 https://blog.csdn.net/ft305977550/article/details/78769573
    //经典 可看
    public static void xmain() throws InterruptedException {
        for (int i = 0; i < 500; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        c++;
                        //System.out.println(c); 可能引起锁粗化
                    }
                }
            };
            t.start();
//            t.join();
        }
        Thread.sleep(10000);
        System.out.println(c);
    }

    public static void xmain3() throws Exception{

        Thread a = new Thread() {
            @Override
            public void run() {
                for( int j = 0 ; j < 100000 ; j++ ) c++;
            }
        };
        a.start();
        Thread b = new Thread() {
            @Override
            public void run() {
                for( int j = 0 ; j < 100000 ; j++ ) c--;
            }
        };
        b.start();
        a.join();
        b.join();
        System.out.println(c);

    }

    public static void xmain2() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t = new ThreadX(c);
            t.start();
            System.out.println(t.getName());
            t.join();
        }
        Thread.sleep(5000);
        System.out.println(c);
    }

}
