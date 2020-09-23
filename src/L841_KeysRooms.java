// 841. Keys and Rooms

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L841_KeysRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visitedRooms = new HashSet<>();
        dfs(rooms, 0, visitedRooms);
        return rooms.size() == visitedRooms.size();
    }

    private void dfs(List<List<Integer>> rooms, int curRoom, Set<Integer> visitedRooms) {
        if (visitedRooms.contains(curRoom)) return;
        visitedRooms.add(curRoom);
        for (int next : rooms.get(curRoom)) {
            dfs(rooms, next, visitedRooms);
        }
    }

}
