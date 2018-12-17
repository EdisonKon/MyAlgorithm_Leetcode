package Lists;

import Entitys.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 描述 Hard
 * @author: dekai.kong
 * @date: 2018-12-17 15:27
 * @from https://leetcode.com/problems/insert-interval/
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */

public class InsertInterval {
    public InsertInterval() {

    }

    /**
     * Runtime: 8 ms, faster than 69.25% of Java online submissions for Insert Interval.
     * @param intervals
     * @param newInterval
     * @return
     */
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        List<Interval> rst = new ArrayList<>();
        if(intervals.size()==0){
            rst.add(newInterval);
            return rst;
        }
        int ix = 0;
        for (; ix < intervals.size(); ix++) {
            if(newInterval.start <= intervals.get(ix).start){
                break;
            }
        }
        intervals.add(ix,newInterval);
        rst.add(new Interval(intervals.get(0).start,intervals.get(0).end));
        int i = 0;
        int j = i+1;
        while (i < rst.size() && j<intervals.size()) {
            for (; j < intervals.size(); j++) {
                int sval = rst.get(i).start;
                int eval = rst.get(i).end;
                int insval = intervals.get(j).start;
                int ineval = intervals.get(j).end;
                if(eval>=insval){
                    rst.remove(rst.size()-1);
                    rst.add(new Interval(sval<=insval?sval:insval,eval<=ineval?ineval:eval));
                }else{
                    rst.add(new Interval(insval,ineval));
                    i++;
                    j++;
                    break;
                }
            }
        }
        return rst;
    }

    /**
     * Runtime: 6 ms, faster than 99.82% of Java online submissions for Insert Interval.
     * @param intervals
     * @param newInterval
     * @return
     * 无排序,直接进行对比
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> rst = new ArrayList<>();
        if(intervals.size()==0){
            rst.add(newInterval);
            return rst;
        }
        int sval = newInterval.start;
        int eval = newInterval.end;
        for (int j = 0; j < intervals.size(); j++) {
            int insval = intervals.get(j).start;
            int ineval = intervals.get(j).end;
            if(sval > ineval){
                rst.add(new Interval(insval,ineval));
            }else if(sval == ineval || sval>insval){
                sval = insval;
            }
            if (eval<insval){
                rst.add(new Interval(sval,eval));
                sval = insval;
                eval = ineval;
            }else if(eval<ineval || eval == insval){
                eval = ineval;
            }

        }
        rst.add(new Interval(sval,eval));
        return rst;
    }

    @Test
    public void test() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));
        Interval newInterval = new Interval(4,8);
//        List<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(1,5));
//        Interval newInterval = new Interval(2,3);
        insert(intervals,newInterval);
    }
}

