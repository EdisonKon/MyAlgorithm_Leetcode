package Booleans;

import org.junit.Test;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-24 17:22
 * @from https://leetcode.com/problems/word-search/
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 * TODO 经典DFS题，可多刷
 */

public class WordSearch {
    public WordSearch() {

    }

    /**
     * Runtime: 15 ms, faster than 32.69% of Java online submissions for Word Search.
     * @param board
     * @param word
     * @return
     * 有一个数组记录是否访问过，还有一种方法是直接在原数组上该，用个temp记录原值，如果false了把值赋值回去；
     */
    public boolean exist2(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0){
            return false;
        }
        //用于记录是否用过
        int olen = board.length;
        int ilen = board[0].length;
        int[][] copy = new int[olen][ilen];
        char[] words = word.toCharArray();
        int ix = 0;
        for (int i = 0; i < olen; i++) {
            for (int j = 0; j < ilen; j++) {
                if(board[i][j] == words[ix]){
                    if(helper2(i,j,olen,ilen,words,ix,copy,board)){
                        return true;
                    }
                    copy = new int[olen][ilen];
                    ix = 0;
                }
            }
        }

        return false;
    }

    public boolean helper2(int i, int j, int olen, int ilen, char[] words, int index, int[][] copy, char[][] board){
        if(index == words.length){
            return true;
        }
        if(i<0 || i>olen-1 || j<0 || j > ilen-1){
            return false;
        }
        if(words[index] == board[i][j] && copy[i][j] != 1){
            copy[i][j] = 1;
            if(i>=0 || i<=olen-1 || j>=0 || j<= ilen-1){
                boolean bo = helper2(i-1,j,olen,ilen,words,index+1,copy,board)||
                        helper2(i,j-1,olen,ilen,words,index+1,copy,board)||
                        helper2(i+1,j,olen,ilen,words,index+1,copy,board)||
                        helper2(i,j+1,olen,ilen,words,index+1,copy,board);
                if(!bo){
                    copy[i][j] = 0;
                }
                return bo;

            }
        }else{
            return false;
        }
        return false;
    }

    /**
     * Runtime: 11 ms, faster than 56.73% of Java online submissions for Word Search.
     * @param board
     * @param word
     * @return
     * 无新的二维数组
     */
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0){
            return false;
        }
        //用于记录是否用过
        int olen = board.length;
        int ilen = board[0].length;
        char[] words = word.toCharArray();
        int ix = 0;
        for (int i = 0; i < olen; i++) {
            for (int j = 0; j < ilen; j++) {
                if(board[i][j] == words[ix]){
                    if(helper(i,j,olen,ilen,words,ix,board)){
                        return true;
                    }
                    ix = 0;
                }
            }
        }

        return false;
    }

    public boolean helper(int i,int j,int olen,int ilen,char[] words,int index,char[][] board){
        if(index == words.length){
            return true;
        }
        if(i<0 || i>olen-1 || j<0 || j > ilen-1){
            return false;
        }
        if(words[index] == board[i][j] && board[i][j] != '#'){
            char temp = board[i][j];
            board[i][j] = '#';
            if(i>=0 || i<=olen-1 || j>=0 || j<= ilen-1){
                boolean bo = helper(i-1,j,olen,ilen,words,index+1,board)||
                        helper(i,j-1,olen,ilen,words,index+1,board)||
                        helper(i+1,j,olen,ilen,words,index+1,board)||
                        helper(i,j+1,olen,ilen,words,index+1,board);
                if(!bo){
                    board[i][j] = temp;
                }
                return bo;

            }
        }else{
            return false;
        }
        return false;
    }

    @Test
    public void test() {
//        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        char[][] board = {{'A','A'}};
        System.out.println(exist(board,"AAA"));
//        System.out.println(exist(board,"ABCCED"));
//        System.out.println(exist(board,"SEE"));
//        System.out.println(exist(board,"ABCB"));
//        System.out.println(exist(board,"ABCESEEEFS"));

    }
}

