package Lists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2019-01-05 15:50
 * @from https://leetcode.com/problems/restore-ip-addresses/
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Example:
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 一是只要遇到字符串的子序列或配准问题首先考虑动态规划DP，二是只要遇到需要求出所有可能情况首先考虑用递归。
 * 用一个k记录当前的 数字 个数,用一个n记录当前 . 的个数
 * TODO 递归,可以多刷 从a.a.a.a -->a.a.a.aa--> a.a.a.aaa --> a.a.aa.a--> a.a.aa.aa-->a.a.aa.aaa->.....等等递归
 */

public class RestoreIPAddresses {
    public RestoreIPAddresses() {

    }

    /**
     * Runtime: 4 ms, faster than 39.58% of Java online submissions for Restore IP Addresses.
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, "", res);
        return res;
    }

    public void helper(String s, int n, String out, List<String> res) {
        if (n == 4) {
            if (s.isEmpty()) res.add(out);
            return;
        }
        for (int k = 1; k < 4; ++k) {
            if (s.length() < k) break;
            int val = Integer.parseInt(s.substring(0, k));
            if (val > 255 || k != String.valueOf(val).length()) continue;
            helper(s.substring(k), n + 1, out + s.substring(0, k) + (n == 3 ? "" : "."), res);
        }
    }

    @Test
    public void test() {
        System.out.println(restoreIpAddresses("25525511135"));
    }
}

