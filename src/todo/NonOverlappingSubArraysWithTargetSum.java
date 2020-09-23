package todo;

import java.util.HashMap;
import java.util.Map;

public class NonOverlappingSubArraysWithTargetSum {
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0, lsize = Integer.MAX_VALUE, result = Integer.MAX_VALUE;
        map.put(0,-1);
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            map.put(sum,i);
        }
        sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            if (map.get(sum - target) != null){
                lsize = Math.min(lsize, i - map.get(sum - target));
            }
            if (map.get(sum + target) != null && lsize < Integer.MAX_VALUE){
                result = Math.min(result, map.get(sum + target) - i + lsize);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
