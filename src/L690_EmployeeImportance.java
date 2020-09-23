// 690. Employee Importance

import java.util.*;

public class L690_EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        // build the graph
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while (!q.isEmpty()) {
            int cur = q.poll();
            res += map.get(cur).importance;
            for (int sub : map.get(cur).subordinates) {
                q.add(sub);
            }
        }
        return res;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
