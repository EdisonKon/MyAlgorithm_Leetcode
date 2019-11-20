package PalindromePairs;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult hard
 * @create 2019-11-05 16:52
 * @from https://leetcode-cn.com/problems/shortest-palindrome/solution/c-li-yong-kmpsuan-fa-xiang-xi-tui-dao-zhuan-hua-gu/
 *
 * /*思路  如对于串 abcd 想要将其变为回文串
 *       那么先把它逆序 然后放在前面 自然是回文了
 *                                    abcd
 *                                dcba
 *                                dcbaabcd ->是回文
 *       但是我们发现根本没必要放这么多在前面 因为abcd的前缀和dcab的后缀有重合(如a) 所以为了只添加最少
 *       的字符,我们在前方只需要添加不重复的即可
 *                                     abcd
 *                                  dcba
 *                                  dcbabcd ->依然是回文
 *      //为了添加的最少 我们就需要找到dcba的后缀和abcd的前缀重合的部分，且让重合部分最大即可
 *      //故而联想到kmp算法，它的next数组就是用来求一个串的前缀和后缀相同的长度的最大值
 *      //所以拼接起字符串 abcddcba 但是我们所求的前缀是不能超过中点的，因此用一个特殊字符隔开
 *      //           即为 abcd#dcba 这样在匹配前后缀时，相同长度就一定不会超过#号了
 *      //           这样问题就转化为了 求abcd#dcba的next数组 易知该串的前后缀相同时的最大长度为1
 *                 此时的最长相同前后缀即为a   和  a
 *                                      所以把后半部分除去重叠的部分拼接到前半部分即可
 *                             答案就是  dcbabcd
 *                                      大功告成!
 *
 *      */

public class ShortestPalindrome {
    public ShortestPalindrome() {

    }

    /**
     执行用时 :5 ms , 在所有 java 提交中击败了 93.15% 的用户
     内存消耗 : 36.6 MB , 在所有 java 提交中击败了 82.35% 的用户
     */
    public String shortestPalindrome(String s) {
        String rev = new StringBuffer(s).reverse().toString();
        String str = s+"#"+rev;
        int sl = s.length();
        int strl = str.length();
        int[] next = new int[strl];
        next[0] = 0;

        for (int i = 1; i < next.length; i++) {
            int f = next[i-1];
            while(f>0 && str.charAt(i) != str.charAt(f)){
                f = next[f-1];
            }
            if(str.charAt(i) == str.charAt(f)){
                f+=1;
            }
            next[i] = f;
        }
        return rev.substring(0,sl -next[strl-1])+s;
    }

    @Test
    public void test() {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));
    }
}
