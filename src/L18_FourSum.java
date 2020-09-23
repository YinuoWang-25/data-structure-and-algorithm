// 18. 4Sum

import java.util.*;

public class L18_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        int size = nums.length;
        for (int i = 0; i < size - 3; i++) {
            for (int j = i + 1; j < size - 2; j++) {
                // deduplicate
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = size - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]));
                    } else if (sum < target) left++;
                    else right--;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
