package SlidingWindow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-07-19 19:37
 * @from
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 **/
public class MaxList {
    public MaxList() {

    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList();
        if(size == 0){
            return list;
        }
        int low;
        int high = size;
        for(low = 0;low<=num.length-size;low++){
            int max = 0;
            for(int cur = low;cur<high;cur++){
                max = Math.max(max,num[cur]);
            }
            list.add(max);
            high++;
        }
        return list;
    }
    @Test
    public void test() {
        maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);
    }
}
