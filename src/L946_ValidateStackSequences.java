// 946. Validate Stack Sequences

public class L946_ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int slow = 0, pop = 0;
        for (int i = 0; i < pushed.length; i++) {
            pushed[slow++] = pushed[i];
            while (slow > 0 && pushed[slow - 1] == popped[pop]) {
                pop++;
                slow--;
            }
        }
        return slow == 0 && pop == popped.length;
    }
}
