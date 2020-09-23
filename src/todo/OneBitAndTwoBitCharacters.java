package todo;

public class OneBitAndTwoBitCharacters {
    // 717. 1-bit and 2-bit Characters
    public boolean isOneBitCharacter(int[] bits) {
        int prev = -1;
        int index = 0;
        while (index < bits.length) {
            prev = index;
            if (bits[index] == 0) {
                index++;
            } else {
                index += 2;
            }
        }
        return prev == bits.length - 1;
    }
}
