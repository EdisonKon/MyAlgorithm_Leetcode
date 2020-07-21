package MyArrays;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author dekai.kong
 * @difficult Easy
 * @create 2020-07-20 21:33
 * @from 977. 有序数组，判断平方不相等的数的个数
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组中平方不一样的个数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[-10, -10, -5, 0, 1, 5, 8, 10]
 * 输出：5
 * 来源：字节跳动 面试题
 *
 * 思路,双指针
 **/
public class SortedSquaresII {
    public SortedSquaresII() {

    }

    public int sortedSquaresII(int[] A) {
        int count = 0;
        if(A.length==0){
            return count;
        }
        int p1 = 0;
        int p2 = A.length-1;
        count = 1;
        while(p1<p2){
            if (A[p1]*A[p1] == A[p2]*A[p2]){
                p1++;
            }else{
                p2--;
                count++;
            }
        }
        return count;
    }


    @Test
    public void test() {
        sortedSquaresII(new int[]{-10, -10, -5, 0, 1, 5, 8, 10});
    }
}
