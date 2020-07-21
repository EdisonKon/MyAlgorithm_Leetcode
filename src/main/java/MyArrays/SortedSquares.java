package MyArrays;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author dekai.kong
 * @difficult Easy
 * @create 2020-07-20 21:33
 * @from 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class SortedSquares {
    public SortedSquares() {

    }

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 66.75%
     * 的用户
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 41.6 MB
     * , 在所有 Java 提交中击败了
     * 10.00%
     * 的用户
     *
     * 双指针做法
     * @param A
     * @return
     */
    public int[] sortedSquares2(int[] A) {
        int p1 = 0;
        int p2 = A.length-1;
        int pcur = A.length-1;
        int[] rst = new int[A.length];
        while(p1<p2){
            int p1v = A[p1]*A[p1];
            int p2v = A[p2]*A[p2];
            if(p1v<=p2v){
                rst[pcur--] = p2v;
                p2--;
            }else{
                rst[pcur--] = p1v;
                p1++;
            }
        }

        if(p1 == p2){
            rst[pcur] = A[p1]*A[p1];
        }
        return rst;
    }

    @Test
    public void test() {
        sortedSquares2(new int[]{-4,-1,0,3,10});
    }
}
