// 55. Jump Game
/*
reach is the farest point we can reach
 */

public class L55_JumpGame {
    public boolean canJump(int[] nums) {
        int index = 0, reach = 0;
        for (; index < nums.length && index <= reach; index++) {
            reach = Math.max(reach, index + nums[index]);
            if (reach >= nums.length - 1) return true;
        }
        return false;
    }
}
