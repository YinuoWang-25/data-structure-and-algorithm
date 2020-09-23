// 398. Random Pick Index

import java.util.Random;

public class L398_RandomPickIndex {
    int[] nums;
    Random rand;

    public L398_RandomPickIndex(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }

    public int pick(int target) {
        int time = 1;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int choose = rand.nextInt(time);
                if (choose == 0) {
                    res = i;
                }
                time++;
            }
        }
        return res;
    }
}
