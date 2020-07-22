package BackTrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dekai.kong
 * @difficult Hard
 * @create 2020-07-22 14:47
 * @from
 **/
public class SolveNQueens {
    /**
     *
     作者：ckhero
     链接：https://leetcode-cn.com/problems/eight-queens-lcci/solution/jie-jin-shuang-bai-by-ckhero/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> ans = new ArrayList<>();
            char[][] nums = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(nums[i], '.');
            }
            backtrack(nums,0, ans);
            return ans;
        }

        private void backtrack(char[][] nums, int currRow, List<List<String>> ans) {
            int len = nums.length;
            if (len == currRow) {
                List<String> path2 = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    path2.add(String.valueOf(nums[i]));
                }
                ans.add(path2);
                return;
            }

            for (int col = 0; col < len; col++) {
                //判断这个位置是否合适
                boolean isok = true;
                for (int row = 0; row < currRow; row++) {
                    //竖的有Q
                    if (nums[row][col] == 'Q') {
                        isok = false;
                        break;
                    }
                    //判断对角线
                    if (col + (currRow - row) < len && nums[row][col + (currRow - row)] == 'Q') {
                        isok = false;
                        break;
                    }
                    if (col - (currRow - row) >= 0 && nums[row][col - (currRow - row)] == 'Q') {
                        isok = false;
                        break;
                    }
                }
                if (!isok) {
                    continue;
                }
                //满足条件
                nums[currRow][col] = 'Q';
                backtrack(nums, currRow + 1, ans);
                nums[currRow][col] = '.';
            }
    }


    @Test

    public void test() {
        solveNQueens(8);
    }
}
