// 422. Valid Word Square

import java.util.List;

public class L422_ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (words.get(j).length() > i && words.get(j).charAt(i) != words.get(i).charAt(j)) return false;
            }
        }
        return true;
    }
}
