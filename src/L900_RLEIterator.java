// 900. RLE Iterator

public class L900_RLEIterator {
    int[] nums;
    int index;

    public L900_RLEIterator(int[] A) {
        nums = A;
        index = 0;
    }

    public int next(int n) {
        while (index < nums.length) {
            if (n > nums[index]) {
                n -= nums[index];
                index += 2;
            } else {
                nums[index] -= n;
                return nums[index + 1];
            }
        }
        return -1;
    }
}
