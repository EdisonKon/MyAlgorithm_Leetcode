package Lists;

import Entitys.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-13 14:49
 * @from https://leetcode.com/problems/merge-intervals/
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

public class MergeIntervals {
    public MergeIntervals() {

    }

    /**
     * Runtime: 12 ms, faster than 93.77% of Java online submissions for Merge Intervals.
     * @param intervals
     * @return
     * 一次过
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if(intervals.size()==0){
            return list;
        }
        Collections.sort(intervals,new IntervalsComp());
        list.add(new Interval(intervals.get(0).start,intervals.get(0).end));
        int i = 0;
        int j = i+1;
        while (i < list.size() && j<intervals.size()) {
            for (; j < intervals.size(); j++) {
                int sval = list.get(i).start;
                int eval = list.get(i).end;
                int insval = intervals.get(j).start;
                int ineval = intervals.get(j).end;
                if(eval>=insval){
                    list.remove(list.size()-1);
                    list.add(new Interval(sval<=insval?sval:insval,eval<=ineval?ineval:eval));
                }else{
                    list.add(new Interval(insval,ineval));
                    i++;
                    j++;
                    break;
                }
            }
        }
        return list;
    }
    class IntervalsComp implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }

    @Test
    public void test() {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(8,10));
        list.add(new Interval(1,3));
        list.add(new Interval(2,6));
        list.add(new Interval(15,18));
        merge(list);
    }
}

