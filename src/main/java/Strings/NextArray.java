package Strings;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author dekai.kong
 * @difficult medium
 * @create 2020-07-26 10:46
 * @from  求当前字符串的下一个全排列数
 * 比如21543 下一个就是23145
 *
 * 方法:
 * 从后往前找到 i ->右边比自己大 : 例子中是 1
 * 从 i 往后找比自己大的集合里最小的数 : 例子中是 543 中的3
 * 将i和3交换   : 例子中是 23541
 * 然后从i+1 到 length 进行从小到大排序(或者 直接从i+1到结尾进行翻转),得到的就是下一个全排列 : 例子中是 23145
 *
 **/
public class NextArray {
    public NextArray() {

    }

    public String nextArray(String s){
        if (s.length()<=1){
            return s;
        }
        int cur = 0;
        int min = Integer.MAX_VALUE;
        int ind = 0;
        char[] chars = s.toCharArray();
        for (int i = s.length()-2; i >= 0; i--) {
            if(chars[i]<chars[i+1]){
                cur = i;
                for (int j = i+1; j < s.length(); j++) {
                    if(chars[j]>chars[i]){
                        if(chars[j]<min){
                            min = chars[j];
                            ind = j;
                        }
                    }
                }
            }
        }
        char temp = chars[cur];
        chars[cur] = (char) min;
        chars[ind] = temp;
//      排序解法
//        String ans = "";
//        Arrays.sort(chars,cur+1,chars.length);
//        for (char c:chars) {
//            ans+=c;
//        }
//        return ans;

        //翻转
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length-1; i >=0; i--) {
            if(i == cur){
                sb.reverse();
            }
            sb.append(chars[i]);
        }
        sb.reverse();

        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(nextArray("21543"));
    }
}
