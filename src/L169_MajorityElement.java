// 169. Majority Element

public class L169_MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int ans = nums[0], num = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ans) num++;
            else {
                num--;
                if (num == 0) {
                    ans = nums[i];
                    num = 1;
                }
            }
        }
        return ans;
    }
}
