package todo;

public class NextClosestTime {
    // 681. Next Closest Time
    public String nextClosestTime(String originalTime) {
        if (originalTime == null || originalTime.length() != 5) {
            return null;
        }
        List<Character> chs = new ArrayList<>();
        for (char c : originalTime.toCharArray()) {
            if (c != ':') {
                chs.add(c);
            }
        }
        Collections.sort(chs);

        for (int i = originalTime.length() - 1; i >= 0; i--) {
            if (originalTime.charAt(i) != ':' && hasLargerDigit(chs, originalTime.charAt(i))) {
                String nextTime = buildNextTime(originalTime, i, chs);
                char[] nextTimeChs = nextTime.toCharArray();
                for (int start = i + 1; start < originalTime.length(); start++) {
                    if (nextTimeChs[start] != ':')
                        nextTimeChs[start] = chs.get(0);
                }
                nextTime = new String(nextTimeChs);
                if (isValidTime(nextTime)) {
                    return nextTime;
                }
            }
        }
        char min = chs.get(0);
        return "" + min + min + ":" + min + min;
    }

    private boolean hasLargerDigit(List<Character> chs, char c) {
        return chs.get(chs.size() - 1) != c;
    }

    private String buildNextTime(String originalTime, int index, List<Character> chs) {
        char c = originalTime.charAt(index);
        int idx = -1;
        for (int i = chs.size() - 1; i >= 1; i--) {
            if (chs.get(i - 1) == c) {
                idx = i;
                break;
            }
        }
        char nextChar = chs.get(idx);
        return originalTime.substring(0, index) + nextChar + originalTime.substring(index + 1);

    }

    private boolean isValidTime(String time) {
        String hour = time.substring(0, 2);
        Integer hourInInt = Integer.parseInt(hour);
        if (hourInInt < 0 || hourInInt > 23) {
            return false;
        }
        String min = time.substring(3);
        Integer minInInt = Integer.parseInt(min);
        return minInInt >= 0 && minInInt <= 59;
    }
}
