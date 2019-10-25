package zOther;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2019-10-24 19:42
 * @from:校友群
 * 从100到200共101个数字中按照顺序取10个数,每个数字可以重复取,使十个数的总和为1024,求共多少种取法
 * 例如 100 100 100 100 100 100 104 106 106 108 可为一种
 * 100 101 与101 100 是2种选择
 **/

public class Test1024_2 {
    static int[] cons = new int[25];
    static int ss = 1024;
    static List<Integer> cus = new ArrayList<>(10);
    static int tx = 0;
    public static int chargeTypes(int[] vals, int total,int xaa){
        if(cus.size()==10 && total==0){
            System.out.println(cus.toString());
            cus.remove(cus.size()-1);
            tx++;
            return xaa+1;
        }
        if(total>=vals[0]&&cus.size()<10){
            if(cus.size() == 9){
                cus.add(vals[total - 100]);
                xaa += chargeTypes(vals,total-cus.get(cus.size()-1),xaa);
            }else{
                for (int i = 0; i < vals.length; i++) {
                    cus.add(vals[i]);
                    xaa += chargeTypes(vals,total-cus.get(cus.size()-1),xaa);
                }
            }
        }
        cus.remove(cus.size()-1);
        xaa = 0;
        return xaa;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 25; i++) {
            cons[i] = 100+i;
        }

        int x = chargeTypes(cons,ss,0);
        System.out.println(x);
    }
}
