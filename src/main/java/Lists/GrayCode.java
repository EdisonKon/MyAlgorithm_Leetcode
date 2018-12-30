package Lists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dekai.kong
 * @difficult Medium
 * @create 2018-12-30 18:18
 * @from https://leetcode.com/problems/gray-code/submissions/
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 *
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * Example 2:
 *
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 *              A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 *              Therefore, for n = 0 the gray code sequence is [0].
 *
 * 格雷码 没明白 https://zhuanlan.zhihu.com/p/29254973
 * https://zh.wikipedia.org/wiki/%E6%A0%BC%E9%9B%B7%E7%A0%81
 **/
public class GrayCode {
    public GrayCode() {

    }

    /**
     * Runtime: 1 ms, faster than 67.80% of Java online submissions for Gray Code.
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Math.pow(2,n); i++) {
            list.add((i>>1)^i);
        }
        return list;
    }

    @Test
    public void test() {
        System.out.println(grayCode(2));
    }
}
