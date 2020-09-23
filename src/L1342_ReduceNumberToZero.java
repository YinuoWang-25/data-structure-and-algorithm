// 1342. Number of Steps to Reduce a Number to Zero

public class L1342_ReduceNumberToZero {
    public int numberOfSteps(int num) {
        int res = 0;
        while (num > 0) {
            if (num % 2 == 0) num /= 2;
            else num--;
            res++;
        }
        return res;
    }
}
