package Strings;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult easy
 * @create 2018-12-03 21:10
 * @from
 **/
public class ImplementstrStr {
    public ImplementstrStr() {

    }

    /**
     * Runtime: 3 ms, faster than 99.79% of Java online submissions for Implement strStr().
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int index = -1;
        if("".equals(needle)){
            return 0;
        }else{
            int len = needle.length();
            int tot = haystack.length();
            char fir = needle.charAt(0);
            for (int i = 0; i < tot; i++) {
                if(haystack.charAt(i) == fir){
                    if(i+len>tot){
                        return -1;
                    }else{
                        if(needle.equals(haystack.substring(i,i+len))){
                            return i;
                        }
                    }
                }
            }
        }
        return index;
    }

    @Test
    public void test() {
        System.out.println(strStr("aaaaa","bba"));
    }
}
