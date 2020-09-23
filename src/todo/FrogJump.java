package todo;

public class FrogJump {
    // 403. Frog Jump
    public boolean canCross(int[] stones) {
        if (stones.length <= 1) {
            return true;
        }
        if (!(stones[0] == 0 && stones[1] == 1)) {
            return false;
        }

        HashMap<Integer, HashSet<Integer>> dp =
                new HashMap<Integer, HashSet<Integer>>(stones.length);
        for (int value : stones) {
            dp.put(value, new HashSet<Integer>());
        }
        dp.get(0).add(0);

        for (int i = 0; i < stones.length - 1; ++i) {
            int stone = stones[i];
            for (int step : dp.get(stone)) {
                // step - 1
                if (step > 1 && dp.containsKey(stone + step - 1))
                    dp.get(stone + step - 1).add(step - 1);
                // step
                if (dp.containsKey(stone + step))
                    dp.get(stone + step).add(step);
                // step + 1
                if (dp.containsKey(stone + step + 1))
                    dp.get(stone + step + 1).add(step + 1);
            }
        }

        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}
