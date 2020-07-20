package SortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-07-20 20:48
 * @from
 **/
public class MergeSort {
    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int L, int R) {
        if(L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        sort(arr, L, mid);
        sort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while(p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while(p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while(p2 <= R) {
            temp[i++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for(i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }

    /**
     * 看这个 归并排序
     * @param arr
     * @return
     */
    public int[] myMergeSort(int[] arr){
        if(arr.length<=1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);
        left = myMergeSort(left);
        right = myMergeSort(right);
        return myMerge(left,right);

    }
    public int[] myMerge(int[] left,int[] right){
        int[] result = new int[left.length+right.length];
        int lp = 0;
        int rp = 0;
        int i = 0;
        while(lp<left.length && rp<right.length){
            if(left[lp]<=right[rp]){
                result[i] = left[lp];
                lp++;
            }else{
                result[i] = right[rp];
                rp++;
            }
            i++;
        }
        if(lp<left.length){
            for(int j = lp;j<left.length;j++,i++){
                result[i]=left[j];
            }
        }
        if(rp<right.length){
            for(int j = rp;j<right.length;j++,i++){
                result[i]=right[j];
            }
        }
        return result;
    }



    @Test
    public void test() {
//        mergeSort(new int[]{2,5,4,6,1,7,9,8});
        int[] val = myMergeSort(new int[]{2,5,4,6,1,7,9,8});
        System.out.println(val);
    }
}
