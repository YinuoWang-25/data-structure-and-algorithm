// 500. Keyboard Row

import java.util.stream.Stream;

public class L500_KeyboardRow {
    public String[] findWords(String[] words) {
        return Stream.of(words)
                .filter(w -> w.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
                .toArray(String[]::new);
    }
}
