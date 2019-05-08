package SortAlgorithm;

import org.junit.Test;

/**
 * @description: 描述 Easy
 * @author: dekai.kong
 * @date: 2019-05-06 15:54
 * @from
 * 插入排序算法
 */

public class InsertSortAlgorithm {
    public InsertSortAlgorithm() {

    }

    // 插入排序，a 表示数组，n 表示数组大小
    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;
        // 2 1 2 4 5 6
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }
    @Test
    public void test() {
        insertionSort(new int[]{2 ,1 ,2 ,4 ,5 ,6},6);
    }
}

