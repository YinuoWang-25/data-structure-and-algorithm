// 852. Peak Index in a Mountain Array

public class L852_PeakIndexMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int index = 0;
        while (index + 1 < arr.length && arr[index + 1] > arr[index]) index++;
        return index;
    }
}
