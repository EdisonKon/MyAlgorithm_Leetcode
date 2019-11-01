package zUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author dekai.kong
 * @difficult
 * @create 2019-11-01 15:31
 * @from
 **/
public class ForMatrixArrays {
    public ForMatrixArrays(){

    }
    String str = "[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]";

    public static JSONArray generateMatrix(String str){
        JSONArray array = (JSONArray) JSONArray.parse(str);
        return array;
    }
    public static void forMatrixArrays(int[][] matrix) {
        String pan = "\t";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pan = "\t";
                if(j == matrix[0].length-1){
                    pan = "\n";
                }
                System.out.print(matrix[i][j]+pan);
            }
        }
    }


    @Test
    public void test() {

    }
}
