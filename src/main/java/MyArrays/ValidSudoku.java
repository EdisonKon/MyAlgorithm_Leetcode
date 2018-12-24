package MyArrays;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    /**
     * Runtime: 15 ms, faster than 92.16% of Java online submissions for Valid Sudoku.
     * @param board
     * @return
     */
    public boolean isValidSudoku4(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> setrow = new HashSet<>(9);
            Set<Character> setcol = new HashSet<>(9);
            Set<Character> setsqr = new HashSet<>(9);
            for (int j = 0; j < 9; j++) {
                if('.' != board[i][j]){
                    if(!setrow.add(board[i][j])){
                        return false;
                    }
                }
                if('.' != board[j][i]){
                    if(!setcol.add(board[j][i])){
                        return false;
                    }
                }
                int x = (i / 3) * 3 + j / 3;
                int y = (i % 3) * 3 + j % 3;
                if('.' != board[x][y]){
                    if(!setsqr.add(board[x][y])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * leetcode
     * Runtime: 12 ms, faster than 99.10% of Java online submissions for Valid Sudoku.
     * Runtime: 15ms, faster than 92.16% of Java online submissions for Valid Sudoku.
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[10];
            boolean[] col = new boolean[10];
            boolean[] sqr = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row[board[i][j] - '0'])
                        return false;
                    else row[board[i][j] - '0'] = true;
                }
                if (board[j][i] != '.') {
                    if (col[board[j][i] - '0'])
                        return false;
                    else col[board[j][i] - '0'] = true;
                }
                int x = (i / 3) * 3 + j / 3;
                int y = (i % 3) * 3 + j % 3;
                if (board[x][y] != '.') {
                    if (sqr[board[x][y] - '0'])
                        return false;
                    else sqr[board[x][y] - '0'] = true;
                }
            }
        }
        return true;
    }

    /**
     * Runtime: 28 ms, faster than 23.02% of Java online submissions for Valid Sudoku.
     * @param board
     * @return
     */
    public boolean isValidSudoku3(char[][] board) {
        boolean rst = true;
        //用于每列存储是否重复
        Map<Integer,Set<Character>> mapISL = new HashMap<>();
        //用于行是否重复
        Map<Integer,Set<Character>> mapISH = new HashMap<>();
        //用于存储每3行过去的3个方块
        Set<Character> br = new HashSet<>();

        for (int i = 0; i < board.length; i+=3) {
            for (int j = 0; j < board[i].length; j+=3) {//遍历行
                br.clear();
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        char xc = board[k][l];
                        if(xc == '.')continue;
                        if(!br.add(xc)){
                            return false;
                        }
                        if(mapISL.containsKey(k)){
                            if(!mapISL.get(k).add(xc)){
                                return false;
                            }
                        }else{
                            Set<Character> sc = new HashSet<>();
                            sc.add(xc);
                            mapISL.put(k,sc);
                        }
                        if(mapISH.containsKey(l)){
                            if(!mapISH.get(l).add(xc)){
                                return false;
                            }
                        }else{
                            Set<Character> sc = new HashSet<>();
                            sc.add(xc);
                            mapISH.put(l,sc);
                        }
                    }
                }
            }
        }
        return rst;
    }
    /**
     * Runtime: 27 ms, faster than 26.12% of Java online submissions for Valid Sudoku.
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board) {
        boolean rst = true;
        //用于每列存储是否重复
        Map<Integer,Set<Character>> mapIS = new HashMap<>();
        //用于行是否重复
        Set<Character> set = new HashSet<>(9);
        //用于存储每3行过去的3个方块
        Set<Character> br123 = new HashSet<>();
        Set<Character> br456 = new HashSet<>();
        Set<Character> br789 = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            if(i==3||i==6){
                br123.clear();
                br456.clear();
                br789.clear();
            }
            set.clear();
            for (int j = 0; j < board[i].length; j++) {//遍历行
                char x = board[i][j];
                if(x == '.')continue;
                if(mapIS.containsKey(j)){
                    if(!mapIS.get(j).add(x)){
                        return false;
                    }
                }else{
                    Set<Character> sc = new HashSet<>();
                    sc.add(x);
                    mapIS.put(j,sc);
                }
                if(!set.add(x)){
                    return false;
                }
                if(j<3){
                    if(!br123.add(x)){
                        return false;
                    }
                }else if(j<6){
                    if(!br456.add(x)){
                        return false;
                    }
                }else{
                    if(!br789.add(x)){
                        return false;
                    }
                }
            }
        }
        return rst;
    }

    @Test
    public void test() {
        char[][] x = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        char[][] x1 =
                {
                        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        char[][] x2 = {{'.','.','.','.','.','.','.','.','2'},{'.','.','.','.','.','.','6','.','.'},{'.','.','1','4','.','.','8','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','3','.','.','.','.'},{'5','.','8','6','.','.','.','.','.'},{'.','9','.','.','.','.','4','.','.'},{'.','.','.','.','5','.','.','.','.'}};

                
        System.out.println(isValidSudoku(x));
        System.out.println(isValidSudoku4(x));
//        System.out.println(isValidSudoku(x1));
//        System.out.println(isValidSudoku(x2));
    }
}

