package Arrays;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-06 16:25
 * @from https://leetcode.com/problems/valid-sudoku/
 *
 */

public class ValidSudoku {
    public ValidSudoku() {

    }

    public boolean isValidSudoku(char[][] board) {
        boolean rst = true;
        Set<Character> set = new HashSet<>(9);
        //用于存储每3行过去的3个方块
        char[] br123 = new char[9];
        char[] br456 = new char[9];
        char[] br789 = new char[9];
        char[] bc = new char[9];

        for (int i = 0; i < board.length; i++) {
            if((i+1)%3 == 0){

            }
            for (int j = 0; j < board[i].length; j++) {//遍历行
                char x = board[i][j];
                if('.' !=x){
                    if(set.contains(x)){
                        return false;
                    }else{
                        set.add(x);
                    }
                }
                if((j+1)%3 == 0){

                }
            }
        }
        return rst;
    }

    @Test
    public void test() {
    }
}

