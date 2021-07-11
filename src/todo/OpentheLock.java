package todo;

public class OpentheLock {
    // 752. Open the Lock
    public int openLock(String[] deadends, String target) {
        Set<String> ds = new HashSet<>();
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        for (String s : deadends) {
            ds.add(s);
        }
        if (ds.contains("0000")) {
            return -1;
        }
        Queue<String> q = new LinkedList<>();
        int step = 0;
        q.offer("0000");
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return step;
                } else {
                    List<String> nexts = new ArrayList<>();
                    getNexts(nexts, cur, new StringBuilder(), ds, visited, 0, false);
                    for (String next : nexts) {
                        q.offer(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private void getNexts(List<String> ans, String origin, StringBuilder sb, Set<String> ds, Set<String> visited, int index, boolean changed) {
        if (sb.length() == 4) {
            String cur = new String(sb);
            if (!visited.contains(cur) && !ds.contains(cur) && changed) {
                ans.add(cur);
                visited.add(cur);
            }
            return;
        }
        char tmp = origin.charAt(index);
        char prev = tmp == '0' ? '9' : (char) ((tmp - '0' - 1) + '0');
        char next = tmp == '9' ? '0' : (char) ((tmp - '0' + 1) + '0');
        if (changed) {
            sb.append(tmp);
            getNexts(ans, origin, sb, ds, visited, index + 1, changed);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(prev);
            getNexts(ans, origin, sb, ds, visited, index + 1, true);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(next);
            getNexts(ans, origin, sb, ds, visited, index + 1, true);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(tmp);
            getNexts(ans, origin, sb, ds, visited, index + 1, false);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
