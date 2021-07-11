package todo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FavoriteCompanies {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int size = favoriteCompanies.size();
        int[][] dp = new int[size][size];

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int j = 0;
            while (j < size) {
                if (j != i) {
                    if (favoriteCompanies.get(i).size() <= favoriteCompanies.get(j).size() && isSubset(favoriteCompanies.get(i), favoriteCompanies.get(j))) {
                        break;
                    }
                }
                j++;
            }
            if (j == size) {
                res.add(i);
            }
        }
        return res;

    }

    // check whether a is a subset of b
    private boolean isSubset(List<String> a, List<String> b) {
        if (a.size() > b.size()) return false;
        Set<String> set1 = new HashSet<>(a);
        Set<String> set2 = new HashSet<>(b);
        for (String s : set1) {
            if (!set2.contains(s)) return false;
        }
        return true;
    }
}
