package Strings;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult easy
 * @create 2022-05-12 20:07
 * @from https://leetcode.cn/problems/delete-columns-to-make-sorted/
 * 944. 删列造序
 * 给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
 *
 * 这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
 *
 * abc
 * bce
 * cae
 * 你需要找出并删除 不是按字典序升序排列的 列。在上面的例子（下标从 0 开始）中，列 0（'a', 'b', 'c'）和列 2（'c', 'e', 'e'）都是按升序排列的，而列 1（'b', 'c', 'a'）不是，所以要删除列 1 。
 *
 * 返回你需要删除的列数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["cba","daf","ghi"]
 * 输出：1
 * 解释：网格示意如下：
 *   cba
 *   daf
 *   ghi
 * 列 0 和列 2 按升序排列，但列 1 不是，所以只需要删除列 1 。
 * 示例 2：
 *
 * 输入：strs = ["a","b"]
 * 输出：0
 * 解释：网格示意如下：
 *   a
 *   b
 * 只有列 0 这一列，且已经按升序排列，所以不用删除任何列。
 * 示例 3：
 *
 * 输入：strs = ["zyx","wvu","tsr"]
 * 输出：3
 * 解释：网格示意如下：
 *   zyx
 *   wvu
 *   tsr
 * 所有 3 列都是非升序排列的，所以都要删除。
 *
 *
 * 提示：
 *
 * n == strs.length
 * 1 <= n <= 100
 * 1 <= strs[i].length <= 1000
 * strs[i] 由小写英文字母组成
 **/
public class DeleteColumns {
    public DeleteColumns() {

    }

    /**
     * 执行用时： 8 ms , 在所有 Java 提交中击败了 31.19% 的用户 内存消耗： 41.5 MB , 在所有 Java 提交中击败了 45.71% 的用户
     * @param strs
     * @return
     */
    public int minDeletionSize(String[] strs) {
        int rst = 0;
        int wl = strs[0].length();
        for (int i = 0; i < wl; i++) {
            char ax = 0;
            for (int j = 0; j < strs.length; j++) {
                if(ax  > strs[j].charAt(i)){
                    rst+=1;
                    break;
                }else{
                    ax = strs[j].charAt(i);
                }
            }
        }
        return rst;
    }

    /**
     * 优化一下 不需要ax 直接进行比较 7ms
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 87.14% 的用户 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 75.00% 的用户
     * @param strs
     * @return
     */
    public int minDeletionSize2(String[] strs) {
        int rst = 0;
        int wl = strs[0].length();
        for (int i = 0; i < wl; i++) {
            for (int j = 1; j < strs.length; j++) {
                if(strs[j-1].charAt(i)  > strs[j].charAt(i)){
                    rst+=1;
                    break;
                }
            }
        }
        return rst;
    }

    /**
     * 再优化, 先将str转成char[][] 效率比charAt高,但是内存占用高
     * 5 ms , 在所有 Java 提交中击败了 95.71% 的用户 内存消耗： 41.4 MB , 在所有 Java 提交中击败了 62.38% 的用户
     * @param strs
     * @return
     */
    public int minDeletionSize3(String[] strs) {
        char[][] c=new char[strs.length][];
        for(int i=0;i<strs.length;++i){
            c[i]=strs[i].toCharArray();
        }
        int rst = 0;
        int wl = strs[0].length();
        for (int i = 0; i < wl; i++) {
            for (int j = 1; j < strs.length; j++) {
                if(c[j-1][i]  > c[j][i]){
                    rst+=1;
                    break;
                }
            }
        }
        return rst;
    }



    @Test
    public void test() {
//        minDeletionSize(new String[]{"zyx","wvu","tsr"});
        minDeletionSize3(new String[]{"zyx","wvu","tsr"});
    }
}
