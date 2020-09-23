// 251. Flatten 2D Vector

public class L251_Flatten2DVector {
    int[][] v;
    int i;
    int j;

    public L251_Flatten2DVector(int[][] v) {
        this.v = v;
    }

    public int next() {
        if (hasNext()) {
            return v[i][j++];
        }
        return -1;
    }

    public boolean hasNext() {
        while (i < v.length && j == v[i].length) {
            i++;
            j = 0;
        }
        return i < v.length;
    }
}
