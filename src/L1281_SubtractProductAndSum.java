// 1281. Subtract the Product and Sum of Digits of an Integer

public class L1281_SubtractProductAndSum {
    public int subtractProductAndSum(int n) {
        int sum = 0, pro = 1;
        while (n > 0) {
            sum += n % 10;
            pro *= n % 10;
            n /= 10;
        }
        return pro - sum;
    }
}
