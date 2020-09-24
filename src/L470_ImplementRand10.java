// 470. Implement Rand10() Using Rand7()
/*
Idea: We at least need to call rand7 twice. So we can make them in grid, and index all
numbers as ((a - 1) * 7 + b - 1) % 10 - 1.

 */

public class L470_ImplementRand10 extends SolBase {
    public int rand10() {
        int result = 40;
        while (result >= 40) {
            result = 7 * (rand7() - 1) + (rand7() - 1);
        }
        return result % 10 + 1;
    }
}

class SolBase {
    public int rand7() {
        return 1;
    }
}
