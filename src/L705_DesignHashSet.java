// 705. Design HashSet

public class L705_DesignHashSet {

    int[] arr;

    /**
     * Initialize your data structure here.
     */
    public L705_DesignHashSet() {
        arr = new int[1000001];
    }

    public void add(int key) {
        arr[key] = 1;
    }

    public void remove(int key) {
        arr[key] = 0;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return arr[key] > 0;
    }
}
