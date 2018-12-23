package Lists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dekai.kong
 * @description: 难度 Medium
 * @create: 2018-12-23 19:24
 * @from: https://leetcode.com/problems/combinations/
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

    Example:

    Input: n = 4, k = 2
    Output:
    [
    [2,4],
    [3,4],
    [2,3],
    [1,2],
    [1,3],
    [1,4],
    ]
 **/

public class Combinations {
    public static final List<Integer> INLIST = new ArrayList<>();

    public Combinations() {
    }

    /**
     * Runtime: 24 ms, faster than 53.60% of Java online submissions for Combinations.
     * @param n
     * @param k
     * @return
     * 使用递归recursive 运行时间中游水平
     */
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> rst = new ArrayList<>();
        if (n < 1 || k < 1 || k > n) {
            return rst;
        }
        rst = helper(rst,n,k,1,new ArrayList<>());
        return rst;
    }
    public List<List<Integer>> helper(List<List<Integer>> rst,int n,int k,int start,List<Integer> inlist){
        if(inlist.size() == k){
            rst.add(new ArrayList<>(inlist));
        }else{
            for (int i = start; i <= n; i++) {
                inlist.add(i);
                helper(rst,n,k,i+1,inlist);
                inlist.remove(inlist.size()-1);
            }
        }
        return rst;
    }

    /**
     * leetcode 1ms
     * Runtime: 1 ms, faster than 10.00% of Java online submissions for Combinations.
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine3(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 1 || k < 1 || k > n) {
            return ans;
        }
        makeCom(n, k, ans, new ArrayList<Integer>(), 0);
        return ans;
    }
    public void makeCom(int n, int k, List<List<Integer>> ans, List<Integer> level, int pos) {
        if (k == 0) {
            ans.add(new ArrayList<>(level));
            return;
        }
        for (int i = pos; i <= n - k; i++) {
            level.add(i + 1);
            makeCom(n, k - 1, ans, level, i + 1);
            level.remove(level.size() - 1);
        }
        return;
    }

    /**
     * TODO 未完成
     * 待优化
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<>();
        int max = n+1-k;
        for (int i = 1; i <= max; i++) {
            List<Integer> inlist = new ArrayList<>();
            inlist.add(i);
            if(k == 1){
                rst.add(new ArrayList<>(inlist));
                continue;
            }
            int tims = 0;
            for (int j = i+1; j <= n + 1; j++) {
                if(j == n+1 && n>k){
                    if(inlist.size()>1){
                        tims++;
                        inlist = new ArrayList<>();
                        inlist.add(i);
                        j = i+tims;
                        if(j<=k){
                            continue;
                        }else{
                            break;
                        }
                    }
                }
                if(j == n+1) break;
                inlist.add(j);
                while(inlist.size() == k){
                    rst.add(new ArrayList<>(inlist));
                    inlist.remove(inlist.size()-1);
                    break;
                }
            }
        }

        return rst;
    }

    @Test
    public void test(){
//        combine(4,2);
//        combine(5,2);
//        combine(4,3);
//        combine(5,3);
        combine3(4,3);
    }
}
