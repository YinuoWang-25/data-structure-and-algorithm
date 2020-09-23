// 855. Exam Room
/**
 * Main a list to store all occupied seats L
 * <p>
 * When assigning seat
 * we do two pass check:
 * 1. find the max distance
 * a. initiate dist as first seats
 * b. for loop every two seats, get the dist and update max distance
 * 2. for loop L and find two seats which could make the max distance
 * 3. assign the seat
 * <p>
 * when freeing up seat
 * For loop L, find the seats and remove it from L
 */

import java.util.ArrayList;
import java.util.List;

public class L855_ExamRoom {

    List<Integer> seats;
    int size;

    public L855_ExamRoom(int N) {
        size = N;
        seats = new ArrayList<>();
    }

    public int seat() {

        if (seats.size() == 0) {
            seats.add(0);
            return 0;
        }

        int dist = Math.max(seats.get(0), size - seats.get(seats.size() - 1) - 1);

        for (int i = 1; i < seats.size(); i++) {
            dist = Math.max(dist, (seats.get(i) - seats.get(i - 1)) / 2);
        }
        if (dist == seats.get(0)) {
            seats.add(0, 0);
            return 0;
        }
        for (int i = 1; i < seats.size(); ++i) {
            if ((seats.get(i) - seats.get(i - 1)) / 2 == dist) {
                seats.add(i, (seats.get(i) + seats.get(i - 1)) / 2);
                return seats.get(i);
            }
        }
        seats.add(size - 1);
        return size - 1;
    }

    public void leave(int p) {
        for (int i = 0; i < seats.size(); ++i) if (seats.get(i) == p) seats.remove(i);
    }
}
