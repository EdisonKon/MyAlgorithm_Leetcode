package zOther;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 描述
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-08-22 15:04
 */


public class TestDichotomyArrayFind {

    public static void turnFind(int[]arr,int needkey){
        int i = 0;
        for (i = 0; i < arr.length; i++) {
            if(arr[i] == needkey){
                System.out.println("find index: "+i);
                break;
            }
            if(i == arr.length-1){
                System.out.println("not found");
            }
        }
        System.out.println("find times: " + i);
    }

    public static void dichotomyFind(int[]arr,int needkey){
        int i = 0;
        int low = 0;
        int high = arr.length;
        if(arr[0]>needkey||arr[arr.length-1]<needkey){
            i++;
            System.out.println("not found");
        }
        while(true){
            i++;
            int currentIndex = (low+high)/2;
            if(needkey == arr[currentIndex]){
                System.out.println("find index: "+currentIndex);
                break;
            }
            else if(needkey > arr[currentIndex]){
                low = currentIndex+1;
            }else{
                high = currentIndex-1;
            }
        }

        System.out.println("find times: " + i);
    }

    public static void maopaoSorted(int[] arr){
        for (int i = 0; i <arr.length ; i ++){
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSorted(int[] arr){
        int minIndex = 0;
        int temp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            minIndex = i;
            for (int j = i;j<arr.length-1;j++){
                if(arr[minIndex] > arr[j+1]){
                    minIndex = j+1;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSorted(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if(arr[j+1] < arr[j]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] rst = new int[2];
        Map<Integer,Integer> hasMap = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            int has = target - nums[i];
            if(hasMap.containsKey(has)){
                rst[0] = i;
                rst[1] = hasMap.get(has);
                return rst;
            }
                hasMap.put(nums[i],i);
        }
        return null;
    }
    //TODO 虽然ac了 但是不是最好的方法,多用了空间的O(m+n),解法 https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Double rst = 0D;
        int[] rstnum;
        rstnum = Arrays.copyOf(nums1,nums1.length+nums2.length);
        System.arraycopy(nums2,0,rstnum,nums1.length,nums2.length);
        Arrays.sort(rstnum);
        int x = rstnum.length/2;
        if(rstnum.length%2 == 0){
            rst = (double)(rstnum[x-1]+rstnum[x])/2;
            return rst;
        }
        return rstnum[x];
    }

    //ZigZag Conversion
    //https://www.cnblogs.com/springfor/p/3889414.html
    public static String convert(String s, int numRows) {
        if(s==null||s.length()<=0||numRows==0){
            return "param is err";
        }
        if (numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        //先计算出转换后的每一组长度
        int blockLen = 2 * numRows - 2;
        //i : 行数 , j : 列数
        for (int i = 0; i<numRows; i++) {
            for (int j = i; j < s.length(); j += blockLen) {
                sb.append(s.charAt(j));
                if(i!=0 && i!=numRows-1){
                    int zValIdx = j + blockLen - 2*i;
                    if(zValIdx < s.length()){
                        sb.append(s.charAt(zValIdx));
                    }
                }
            }
        }
        return sb.toString();
    }
    //动态规划-备忘录版本-测试
    public static int cutMemo(int[] p)
    {
        int []r=new int[p.length+1];
        for(int i=0;i<=p.length;i++)
            r[i]=-1;
        return cut(p, p.length, r);
    }
    public static int cut(int[] p,int n,int[] r)
    {
        int q=-1;
        if(r[n]>=0)
            return r[n];
        if(n==0)
            q=0;
        else {
            for(int i=1;i<=n;i++)
                q=Math.max(q, cut(p, n-i,r)+p[i-1]);
        }
        r[n]=q;

        return q;
    }
    //x的n次方
    public static double pow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }
//----------------------------------------------------------------------------------
    public static void main(String[] args) {
        int[] p = {1,5,8,9};
//        cutMemo(p);
        System.out.println(pow(2,3));
//        System.out.println(convert("ABCDEFGHIJKLMNOPQRSTUVWXYZ",4));
//        System.out.println(convert("ABCDEFG",4));
//        int[] arr ={1,2,3,4,5,6,7,8,9,10,11};
//        int[] arr ={13,22,133,44,15,26,57,38,9,102,141};
//        int needkey = 4;
        //turnFind(arr,needkey);

//        dichotomyFind(arr,needkey);

//        maopaoSorted(arr);

//        selectSorted(arr);

//        insertSorted(arr);

//        int[] x = {2,7,11,15};
//        twoSum(x,13);

//        int[] nums1 = {1, 3};
//        int[] nums2 = {2};
//        System.out.println(findMedianSortedArrays(nums1,nums2));

    }

}
