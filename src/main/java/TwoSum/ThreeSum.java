package TwoSum;

import org.junit.Test;

import java.util.*;

/**
 * @description: 描述
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-11-06 17:13
 */

/**
 * LeetCode
 * https://leetcode.com/problems/3sum/
 *Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public ThreeSum(){

    }
    //把大于0的都放入map,小于0的相加在>0map查找看看有没有,消重使用set
    public List<List<Integer>> threeSumx(int[] nums) {
        Long a = System.currentTimeMillis();
        List<List<Integer>> resultList = new ArrayList<>();
        if(nums.length<3){
            return resultList;
        }
        Map<Integer,Integer> mapKt = new HashMap<>();

        Arrays.sort(nums);
        int[] numsLeft = new int[nums.length];
        int[] numsRigh = new int[nums.length];
        Set<String> keySet = new HashSet<>();
        int l=0;
        int r=0;
        for (int i = 0;i<nums.length;i++){
            if(nums[i] == 0 && mapKt.getOrDefault(nums[i],0) == 3 || nums[i]!= 0 && mapKt.getOrDefault(nums[i],0) == 2){
                continue;
            }
            if(nums[i]<= 0){
                numsLeft[l] = nums[i];
                l++;
            }else{
                numsRigh[r] = nums[i];
                r++;
            }
            mapKt.put(nums[i],mapKt.getOrDefault(nums[i],0)+1);
        }

        numsLeft = Arrays.copyOfRange(numsLeft, 0, l);
        numsRigh = Arrays.copyOfRange(numsRigh, 0, r);
        if(numsLeft.length == 0){
            return resultList;
        }
        if(numsLeft.length>=3){
            if(numsLeft[numsLeft.length-1] == 0 && numsLeft[numsLeft.length-2] == 0 && numsLeft[numsLeft.length-3] == 0){
                resultList.add(Arrays.asList(0, 0,0));
                if(numsLeft.length == 3){
                    return resultList;
                }
            }
        }

        for(int i = 0;i<numsLeft.length-1;i++){
            for(int j = 1;j<numsLeft.length;j++){
                if(i != j && numsLeft[i]<=numsLeft[j]){
                    if(mapKt.containsKey(0-(numsLeft[i] + numsLeft[j])) && 0-(numsLeft[i] + numsLeft[j])!=0){
                        int[] temarr = {numsLeft[i],numsLeft[j],0-(numsLeft[i] + numsLeft[j])};
                        if(!keySet.contains(Arrays.toString(temarr))){
                            resultList.add(Arrays.asList(numsLeft[i], numsLeft[j],0-(numsLeft[i] + numsLeft[j])));
                            keySet.add(Arrays.toString(temarr));
                        }
                    }
                }
            }
        }
        for(int i = 0;i<numsRigh.length-1;i++){
            for(int j = 1;j<numsRigh.length;j++){
                if(i != j && numsRigh[i]<=numsRigh[j]){
                    if(mapKt.containsKey(0-(numsRigh[i] + numsRigh[j]))){
                        int[] temarr = {numsRigh[i],numsRigh[j],0-(numsRigh[i] + numsRigh[j])};
                        if(!keySet.contains(Arrays.toString(temarr))){
                            resultList.add(Arrays.asList(numsRigh[i], numsRigh[j],0-(numsRigh[i] + numsRigh[j])));
                            keySet.add(Arrays.toString(temarr));
                        }
                    }
                }
            }
        }
        System.out.println("1:"+(System.currentTimeMillis() - a));
        return resultList;
    }
//最快的方法,来自leetcode
    public List<List<Integer>> threeSumX2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length < 3){
            return res;
        }else{
            Arrays.sort(nums);
            for(int i=0;i<nums.length-2;i++){
                if(nums[i]>0){
                    break;
                }
                if(i>0&&nums[i] == nums[i-1]){
                    continue;
                }
                int a1 = i + 1;
                int a2 = nums.length-1;
                int sum = 0;
                int com = 0;
                sum = 0 - nums[i];
                while(a1<a2){
                    com = nums[a1] + nums[a2];
                    if(com == sum){
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[a1],nums[a2])));
                        while(a1<a2 && nums[a1] == nums[a1+1]){
                            a1++;
                        }
                        while(a1<a2 && nums[a2] == nums[a2-1]){
                            a2--;
                        }
                        a1++;
                        a2--;
                    }else if(com < sum){
                        a1++;
                    }else{
                        a2--;
                    }
                }
            }
            return res;
        }
    }
    //重复率越高越快
    public List<List<Integer>> threeSumX3(int[] nums) {
        Long a = System.currentTimeMillis();
        List<List<Integer>> resultList = new ArrayList<>();
        if(nums.length<3){
            return resultList;
        }
        Map<Integer,Integer> mapKt = new HashMap<>();
        List<Integer> listKey = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0;i<nums.length;i++){
            if(nums[i] == 0 && mapKt.getOrDefault(nums[i],0) == 3 || nums[i]!= 0 && mapKt.getOrDefault(nums[i],0) == 2){
                continue;
            }
            if(mapKt.getOrDefault(nums[i],0) == 0){
                listKey.add(nums[i]);
            }
            mapKt.put(nums[i],mapKt.getOrDefault(nums[i],0)+1);
        }
        for (int i = 0; i < listKey.size(); i++) {
            for(int j = 0; j < listKey.size(); j++){
                if(listKey.get(i) <= listKey.get(j)){
                    if(mapKt.get(listKey.get(i)) == 1 && listKey.get(i) == listKey.get(j)){
                        continue;
                    }
                    if(mapKt.containsKey(0-(listKey.get(i)+listKey.get(j))) ){
                        if ((0-(listKey.get(i)+listKey.get(j))) > listKey.get(j)){
                            resultList.add(Arrays.asList(listKey.get(i), listKey.get(j), 0-(listKey.get(i)+listKey.get(j))));
                        }
                        else if((0-(listKey.get(i)+listKey.get(j))) == listKey.get(j) && mapKt.get(listKey.get(j)) >= 2){
                            if(listKey.get(j) == 0){
                                if(mapKt.get(listKey.get(j)) == 3){
                                    resultList.add(Arrays.asList(listKey.get(i), listKey.get(j), 0-(listKey.get(i)+listKey.get(j))));
                                }
                            }else{
                                resultList.add(Arrays.asList(listKey.get(i), listKey.get(j), 0-(listKey.get(i)+listKey.get(j))));
                            }
                        }
                    }
                }
            }
        }
        System.out.println("2:"+(System.currentTimeMillis() - a));
        return resultList;
    }

    @Test
    public void testThreeSum(){
//        int[] a = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
//        int[] a = {0,1,1};
//        int[] a = {-1,0,1};
//        int[] a = {-1,0,1,2,-1,-4};
//        int[] a = {1,1,-2};
        int[] a = {-1,0,1,0};
//        int[] a = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        List<List<Integer>> resultList2 = threeSumx(a);
        List<List<Integer>> resultList = threeSumX2(a);
        List<List<Integer>> resultList3 = threeSumX3(a);
        System.out.println(resultList);
        System.out.println(resultList2);
        System.out.println(resultList3);
    }

    /**
     * 测试一下回溯能不能解
     */
    Set<String> bool;
    List<List<Integer>> resx = new ArrayList<List<Integer>>();
    public List<List<Integer>> threeSumBackTrace(int[] nums,int n,int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int cur = 0;
        bool = new HashSet<>();
        helper(nums,n,k,list,cur);
        return resx;
    }

    public void helper(int[] nums,int n,int k,LinkedList<Integer> list,int cur){
        if(list.size()==n&&cur == k){
            String s = "";
            List nl = new LinkedList<>(list);
            Collections.sort(nl);
            for (int i = 0; i < nl.size(); i++) {
                s+=nl.get(i);
            }
            if(!bool.contains(s)){
                bool.add(s);
                resx.add(nl);
            }
            return;
        }
        if(list.size()>=n){
            return;
        }

        for(int i = 0;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }

            list.add(nums[i]);
            cur+=nums[i];
            helper(nums,n,k,list,cur);
            cur-=nums[i];
            list.removeLast();
        }
    }

    @Test
    public void testThreeSumx(){
        threeSumBackTrace(new int[]{1,2,3,4,5,6,7,8,9},3,10);
    }
}
