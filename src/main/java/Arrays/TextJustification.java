package Arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 描述 Hard
 * @author: dekai.kong
 * @date: 2018-12-19 15:52
 * @from https://leetcode.com/problems/text-justification/
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * Example 1:
 *
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 *              because the last line must be left-justified instead of fully-justified.
 *              Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 *
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */

public class TextJustification {
    public TextJustification() {

    }

    /**
     * Runtime: 1 ms, faster than 39.48% of Java online submissions for Text Justification.
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        List<Integer> listi = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int len;
            if(sb.length()!=0){
                len = sb.length() + 1 + words[i].length();
            }else{
                len = words[i].length();
            }
            if(len < maxWidth){
                if(sb.length()!=0){
                    sb.append(" ");
                    listi.add(sb.length()-1);
                }
                sb.append(words[i]);
                if(i == words.length-1){
                    while(sb.length()<maxWidth){
                        sb.append(" ");
                    }
                    list.add(sb.toString());
                }
            }else if(len == maxWidth){
                if(sb.length()!=0){
                    sb.append(" ");
                }
                sb.append(words[i]);
                list.add(sb.toString());
                sb = new StringBuilder();
                listi = new ArrayList<>();
            }else{
                int time = 1;
                while(sb.length()<maxWidth){
                    if(listi.size() == 0){
                        sb.append(" ");
                    }else{
                        for (int j = 0; j < listi.size(); j++) {
                            if(sb.length() == maxWidth){
                                break;
                            }
                            sb.insert(listi.get(j)+time*j," ");
                        }
                        time++;
                    }
                }
                list.add(sb.toString());
                sb = new StringBuilder();
                listi = new ArrayList<>();
                i=i-1;
            }
        }
        return list;
    }

    /**
     * leetcode 0ms
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify2(String[] words, int maxWidth) {
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<words.length;){
            char[] chs=new char[maxWidth];
            Arrays.fill(chs,' ');
            int j=i+1;
            int l=chs.length;
            l-=words[i].length();
            //探测后面装多少字符串,并计算空格
            int count=0,blank=0,remain=0;
            while(j<words.length&&l>=words[j].length()+1){
                l-=words[j].length()+1;
                // System.out.println(l+">>>"+i+"<<<"+j);
                count+=words[j].length();
                j++;
            }
            if(j-1!=i){
                blank=(maxWidth-words[i].length()-count)/(j-1-i);
                remain=(j-1-i)-(maxWidth-words[i].length()-count)%(j-1-i);//短空白的数量
            }
            for(int k=0;k<words[i].length();k++){
                chs[k]=words[i].charAt(k);
            }
            if(j!=words.length){
                for(int n=j-1,k=chs.length-1;n>i;n--){
                    for(int m=words[n].length()-1;m>=0;m--){
                        chs[k--]=words[n].charAt(m);
                    }
                    if(remain-->0) k=k-blank;
                    else{
                        k-=(blank+1);
                    }
                }
            }else{
                for(int n=i+1,k=words[i].length()+1;n<j;n++){
                    for(int m=0;m<words[n].length();m++){
                        chs[k++]=words[n].charAt(m);
                    }
                    k++;
                }
            }
            list.add(new String(chs));
            i=j;
        }
        return list;
    }

    @Test
    public void test() {
//        System.out.println("[\"Listen\",\"to    \",\"many, \",\"speak \",\"to   a\",\"few.  \"]");
        System.out.println(fullJustify(new String[]{"Listen","to","many,","speak","to","a","few."},6));
        System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16));
        System.out.println(fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},16));
        System.out.println(fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"},20));
    }
}

