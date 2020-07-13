package MyArrays;

import org.junit.Test;

import java.util.*;

/**
 * @author dekai.kong
 * @difficult Easy
 * @create 2020-07-13 11:40
 * @from 350. Intersection of Two Arrays II
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 **/
public class IntersectionTwoArraysII {
    public IntersectionTwoArraysII() {

    }


    /**
     * 5ms 31.23
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> rst = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if(map.get(nums1[i])!=null){
                map.put(nums1[i],map.get(nums1[i])+1);
            }else{
                map.put(nums1[i],1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            Integer x = map.get(nums2[i]);
            if(x!=null && x>0){
                rst.add(nums2[i]);
                map.put(nums2[i],x-1);
            }
        }
        int[] d = new int[rst.size()];
        for(int i = 0;i<rst.size();i++){
            d[i] = rst.get(i);
        }
        return d;
    }

    @Test
    public void test() {
        intersect(new int[]{1,2,2,1},new int[]{2,2});
    }
}
