package zOther;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 描述
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-11-05 17:26
 */


public class TestJava {
    public static void main(String[] args) {
//        String a = "201810";
//        System.out.println(a.substring(4));
//        System.out.println(a.substring(0,4));

        int a = 10;
        int b = a;
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
        lx.add(1);
        lx.add(1);
        System.out.println(lx);
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

}
