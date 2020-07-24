package BackTrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-07-22 19:15
 * @from 回溯问题标准
 * 数字全排列问题
 *
 **/
public class AllArrange {
    public AllArrange() {

    }

    //1 2 3
    public List<List<Integer>> arrange(int[] q){
        List<List<Integer>> arrange = new ArrayList();
        LinkedList<Integer> list = new LinkedList<>();
        helper(q,list,arrange);
        return arrange;
    }
    public void helper(int[] q,LinkedList<Integer> list,List<List<Integer>> arrange){
        if(list.size() == q.length){
            arrange.add(new LinkedList<>(list));
        }
        for(int i = 0;i<q.length;i++){
            if(list.contains(q[i])){
                continue;
            }
            list.add(q[i]);
            helper(q,list,arrange);
            list.removeLast();
        }
    }


    @Test
    public void test() {
        arrange(new int[]{1,2,3});
    }
}
