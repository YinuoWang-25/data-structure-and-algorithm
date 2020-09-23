package todo;

public class ContainsDuplicateIII {
    private int getID(int i, int w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }
        Map<Integer, Integer> d = new HashMap<>();
        int w = t + 1;
        for (int i = 0; i < nums.length; ++i) {
            int m = getID(nums[i], w);
            if (d.containsKey(m)) {
                return true;
            }
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w) {
                return true;
            }
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w) {

                return true;
            }
            d.put(m, nums[i]);
            if (i >= k) {
                d.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }
}
