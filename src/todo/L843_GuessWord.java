package todo;
// 843. Guess the Word

import java.util.*;

interface  Master {
    public int guess(String s);
}
public class L843_GuessWord {
    public void findSecretWord(String[] wordlist, Master master) {
        for (int times = 0, match = 0; times < 10 && match < 6; times++) {

            int[][] score = new int[6][26];
            for (String word : wordlist) {
                for (int i = 0; i < 6; i++) {
                    score[i][word.charAt(i) - 'a']++;
                }
            }

            int bestScore = 0;
            String guessWord = wordlist[0];
            for (String word : wordlist) {
                int curScore = 0;
                for (int j = 0; j < 6; j++) {
                    curScore += score[j][word.charAt(j) - 'a'];
                }
                if (curScore > bestScore) {
                    bestScore = curScore;
                    guessWord = word;
                }
            }

            int num = master.guess(guessWord);
            List<String> newList = new ArrayList<String>();

            for (String word : wordlist) {
                if (getMatch(word, guessWord) == num) {
                    newList.add(word);
                }
            }
            wordlist = newList.toArray(new String[0]);
        }
    }

    private int getMatch(String a, String b) {
        int match = 0;
        for (int i = 0 ; i < 6; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                match++;
            }
        }
        return match;
    }
}
