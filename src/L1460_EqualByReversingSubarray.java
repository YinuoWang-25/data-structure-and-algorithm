// 1460. Make Two Arrays Equal by Reversing Sub-arrays

public class L1460_EqualByReversingSubarray {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] f = new int[1001];
        for (int i = 0; i < arr.length; i++) {
            f[target[i]]++;
            f[arr[i]]--;
        }

        for (int i = 0; i < 1001; i++)
            if (f[i] != 0) return false;
        return true;
    }
}
