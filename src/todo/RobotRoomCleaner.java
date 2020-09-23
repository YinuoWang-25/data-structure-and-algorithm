package todo;

public class RobotRoomCleaner {
    // 489. Robot Room Cleaner
    int[][] dir = {{1,0}, {0,1}, {-1,0}, {0, -1}};

    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        backtracking(robot, visited, 0, 0, 0);
    }

    private void backtracking(Robot robot, Set<String> visited, int x, int y, int arrow) {
        String path = x + "-" + y;
        if (visited.contains(path)) return;
        visited.add(path);
        robot.clean();

        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                //go all the way till cannot move, then back one step
                int nx = x + dir[arrow][0];
                int ny = y + dir[arrow][1];

                backtracking(robot, visited, nx, ny, arrow);
                //trace back
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
            arrow = (arrow + 1) % 4;
        }
    }
}


 interface Robot {
     // Returns true if the cell in front is open and robot moves into the cell.
          // Returns false if the cell in front is blocked and robot stays in the current cell.
          public boolean move();
              // Robot will stay in the same cell after calling turnLeft/turnRight.
              // Each turn will be 90 degrees.
              public void turnLeft();
  public void turnRight();

          // Clean the current cell.
              public void clean();
 }
