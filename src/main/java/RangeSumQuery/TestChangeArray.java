package RangeSumQuery;

import org.junit.Test;

/**
 * @description: 描述
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-11-01 10:13
 */

/**
 * https://www.youtube.com/watch?v=S0Bf9jpgHmQ
 * 构建一棵树型数组 tree ,2倍数组长度,后半的存数组原值,然后前半每个存储tree[2*i] + tree[2*i+1] 的和
 * 例如:
 *          对应的新index↓                              |        新index↓
 *  0       1       2            3       4       5       |   6   7   8   9   10  11    构建的tree及tree的index
 *  0    sum(0-5)   sum(2-5)     0+1     2+3     4+5     |   0   1   2   3   4   5     其值的index0-5表示 0-5的和
 *          对应的旧index↑                              |        旧index ↑
 *
 *  比如取上述tree[5] 即 tree[10]+tree[11] ,tree[4] 即 tree[8]+tree[9]
 *  tree[2] 即 tree[4]+tree[5] =  tree[2]+tree[3]+tree[4]+tree[5]                 即 sum(2,5)
 *  tree[1] 即 tree[2]+tree[3] =  tree[2]+tree[3]+tree[4]+tree[5]+tree[0]+tree[1] 即 sum(0,5)
 *
 * */
public class TestChangeArray {
    private int[] tree;
    private int size;

    public TestChangeArray(){
    }

    public void initArray(int[] nums) {
        if(nums.length > 0){
            size = nums.length;
            tree = new int[size * 2];
            buildTree(nums);
        }
    }

    public void update(int i,int val){
        i += size;
        tree[i] = val;
        while(i>0){
            int left = i;
            int right = i;
            if(i%2 == 0){
                right = i+1;
            }else{
                left = i-1;
            }
            tree[i/2] = tree[left] + tree[right];
            i/=2;
        }
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        i+=size;
        j+=size;
        while(i<=j){
            if(i%2 !=0){
                sum+=tree[i];
                i++;
            }
            if(j%2 !=1){
                sum+=tree[j];
                j--;
            }
            i/=2;
            j/=2;
        }
        return sum;
    }

    public void buildTree(int[] nums){
        for(int i = size,j = 0; j<nums.length;i++,j++){
            tree[i] = nums[j];
        }
        for(int i =size -1;i>0; i--){
            tree[i] = tree[2*i]+tree[2*i+1];
        }
    }
    @Test
    public void test (){
        int[] x = {-1,2,3};
        initArray(x);
        update(0,1);
        sumRange(0, 0);
    }
}
