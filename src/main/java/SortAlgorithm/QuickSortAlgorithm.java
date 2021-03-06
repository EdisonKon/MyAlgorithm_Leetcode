package SortAlgorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description: 描述 Easy
 * @author: dekai.kong
 * @date: 2019-05-13 15:39
 * @from
 * 快排练习
 * 快排使用了分区思想,取数做轴 小于放左边 大于放右边 原地排序
 */

public class QuickSortAlgorithm {
    public QuickSortAlgorithm() {

    }

    /**
     * 使用递归进行快排
     * @param arr
     * @param start
     * @param end
     */
    public void quickSortByRecursive(int[] arr, int start, int end){
        if(start >= end){
            return ;
        }
        int baseInx = partition(arr,start,end);
        quickSortByRecursive(arr,start,baseInx-1);
        quickSortByRecursive(arr,baseInx+1,end);
    }

    /**
     * 分区函数
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] arr, int start, int end) {
        //取arr当前分区的第一个做轴
        int baseVal = arr[start];
        //标记当前有多少小于等于baseVal的个数 用于下个基准值的取值范围
        int mark = start;
        for (int i = start+1; i <= end; i++) {
            if(baseVal > arr[i]){
                mark ++;
                if(mark == i){
                    continue;
                }else{
                    int temp = arr[mark];
                    arr[mark] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        //mark的值与base值交换
        arr[start] = arr[mark];
        arr[mark] = baseVal;
        return mark;
    }
//---------------------------------------------------------------------------------------------------
    /**
     * 使用栈进行快排
     * @param arr
     * @param start
     * @param end
     */
    public void quickSortByStack(int[] arr, int start, int end){
        Stack<Map<String,Integer>> stack = new Stack<>();
        Map<String,Integer> map = new HashMap<>();
        map.put("s",start);
        map.put("e",end);
        stack.push(map);
        while(!stack.isEmpty()){
            Map<String,Integer> mapTemp = stack.pop();
            int s = mapTemp.get("s");
            int e = mapTemp.get("e");
            int baseInx = partitionStack(arr,s,e);
            Map<String,Integer> mapl = new HashMap<>();
            if(s < baseInx-1){
                mapl.put("s",start);
                mapl.put("e",baseInx-1);
                stack.push(mapl);
            }
            if(baseInx+1 < e){
                mapl.put("s",baseInx+1);
                mapl.put("e",e);
                stack.push(mapl);
            }
        }
    }

    private int partitionStack(int[] arr, int s,int e) {
        int mark = s;
        int baseVal = arr[s];
        for(int i = s+1;i<=e;i++){
            if(baseVal >= arr[i]){
                mark++;
                if(mark == i){
                    continue;
                }else{
                    int temp = arr[mark];
                    arr[mark] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        arr[s] = arr[mark];
        arr[mark] = baseVal;
        return mark;
    }


    @Test
    public void test() {
        int[] arr = {0,1,2,1};
//        quickSortByRecursive(arr,0,arr.length-1);
//        quickSortByStack(arr,0,arr.length-1);
        QuickSort(arr,0,arr.length-1);
//        qs2(arr,0,arr.length-1);
        System.out.println(arr);
    }

    void QuickSort(int R[], int lo, int hi){
        int i = lo, j = hi;
        int temp;
        if(i < j){
            temp = R[i];
            while (i != j)
            {
                while(i < j && R[j] >= temp){
                    -- j;
                }
                R[i] = R[j];
                while(i < j && R[i] <= temp){
                    ++ i;
                }
                R[j] = R[i];
            }
            R[i] = temp;
            QuickSort(R, lo, i - 1);
            QuickSort(R, i + 1, hi);
        }
    }

    public void qs2(int[] arr,int lo,int hi){
        int i = lo;
        int j = hi;
        int temp = 0;
        if(i<j){
            temp = arr[i];
            while(i!=j){
                while(i<j && temp <= arr[j]){
                    --j;
                }
                arr[i] = arr[j];
                while(i<j && temp>=arr[i]){
                    ++i;
                }
                arr[j] = arr[i];
            }
            arr[i] = temp;
            qs2(arr,lo,i-1);
            qs2(arr,i+1,hi);
        }
    }


    void QuickSort2(int R[], int lo, int hi){
        int i = lo;
        int j = hi;
        int temp;
        if(i<j){
            temp = R[i];
            while(i!=j){
                while(i<j && R[i]<=temp){
                    ++i;
                }
                R[j] = R[i];
                while (i < j && R[j]>=temp) {
                    --j;
                }
                R[i] = R[j];
            }
            R[i] = temp;
            QuickSort2(R,lo,i-1);
            QuickSort2(R,i+1,hi);
        }
    }


    public void qs(int[] r,int lo,int hi){
        int i = lo;
        int j = hi;
        int temp ;
        if(i<j){
            temp = r[i];
            while(i!=j){
                while(i<j&&r[i]<=temp){
                    ++i;
                }
                r[j] = r[i];
                while(i<j && r[j]>=temp){
                    --j;
                }
                r[j] = r[i];
            }
            r[i] = temp;
            qs(r,lo,i-1);
            qs(r,i+1,hi);
        }
    }


    public void qsx(int[] r,int lo ,int hi){
        int i = lo,j=hi;
        int temp;
        if(i<j){
            temp = r[i];
            while(i!=j){
                while(i<j&&r[i]<=temp){
                    ++i;
                }
                r[j] = r[i];
                while(i<j&&r[j]>=temp){
                    --j;
                }
                r[i] = r[j];
            }
            r[i] = temp;
            qsx(r,lo,i-1);
            qsx(r,i+1,hi);
        }



    }










    public static int a = 0;
    public static Object o = new Object();

    public static void add(int i) throws InterruptedException {
        synchronized (o){
            while(a%2!=i){
                o.wait();
            }
            a+=1;
            System.out.println(Thread.currentThread().getName()+":"+a);
            o.notify();
        }
    }
    static Thread ta = new Thread(()->{
        try {
            for (int i = 0; i < 100; i++) {
                add(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });
    static Thread tb = new Thread(()->{
        try {
            for (int i = 0; i < 100; i++) {
                add(0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });


    public static void main(String[] args) {
        ta.start();
        tb.start();
    }


    public void qsk(int[] arr,int lo,int hi){
        int i = lo;
        int j = hi;
        int temp;
        if(i<j){
            temp = arr[i];
            while(i!=j){
                while(i<j && arr[i] < temp){
                    ++i;
                }
                arr[j] = arr[i];
                while(i<j && arr[j] > temp){
                    --j;
                }
                arr[i] = arr[j];
            }
            arr[i] = temp;
            qs(arr,lo,i-1);
            qs(arr,i+1,hi);
        }
    }



}

