package MyArrays;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult medium
 * @create 2020-07-30 19:36
 * @from 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MaxProfit {
    public MaxProfit() {

    }

    /**
     * O(n) 记录最小 遍历后边的大数-最小即可
     * 因为只问一次买卖 所以不考虑多次更改low
     * @param prices
     * @return
     * 执行用时：
     * 1 ms
     * 98.87%
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int low = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1] && prices[i] < low) {
                low = prices[i];
            } else {
                max = Math.max(max, prices[i] - low);
            }
        }
        return max;
    }

    @Test
    public void test() {

    }
}
