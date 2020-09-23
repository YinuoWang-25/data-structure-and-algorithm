// 249. Group Shifted Strings

/*
    intuition: get the basic string of every string
        1. get the gap which is diff between first char and a
        2. char - diff, if < a + 26

 */


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class L249_GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new TreeMap<>();
        for (String str : strings) {
            int gap = str.charAt(0) - 'a';
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < str.length(); ++j) {
                char c = (char) (str.charAt(j) - gap);
                if (c < 'a') c += 26;
                tmp.append(c);
            }
            String key = tmp.toString();
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}
