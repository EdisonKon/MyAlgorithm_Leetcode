package Lists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-13 10:53
 * @from
 */

public class SpiralMatrix {
    public SpiralMatrix() {

    }

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
     * @param matrix
     * @return
     * 就是暴力破解,上右下左-->上右下左的循环
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix == null||matrix.length == 0||matrix[0].length == 0||matrix[0] == null){
            return list;
        }
        int rows = 0;
        int rowe = matrix.length-1;
        int cols = 0;
        int cole = matrix[0].length -1;
        while(rows<=rowe && cols<= cole){
            for (int i = cols; i <= cole; i++) {
                list.add(matrix[rows][i]);
            }
            rows++;
            for (int i = rows; i <= rowe; i++) {
                list.add(matrix[i][cole]);
            }
            cole--;
            if(rows<=rowe){
                for (int i = cole; i >= cols; i--) {
                    list.add(matrix[rowe][i]);
                }
            }
            rowe --;
            if(cols<=cole){
                for (int i = rowe; i >=rows ; i--) {
                    list.add(matrix[i][cols]);
                }
            }
            cols++;
        }
        System.out.println(list);
        return list;
    }

    @Test
    public void test() {
        spiralOrder(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });
    }
}

