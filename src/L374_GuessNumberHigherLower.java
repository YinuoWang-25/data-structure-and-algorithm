// 374. Guess Number Higher or Lower

public class L374_GuessNumberHigherLower extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int tmp = guess(mid);
            if (tmp == 0) {
                return mid;
            } else if (tmp < 0) {
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

class GuessGame {
    int guess(int num) {
        return 1;
    }
}
