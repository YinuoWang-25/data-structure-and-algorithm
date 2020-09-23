// 1396. Design Underground System

import java.util.HashMap;
import java.util.Map;

public class L1396_DesignUndergroundSystem {
    Map<Integer, CheckIn> users;
    Map<String, Duration> trips;

    public L1396_DesignUndergroundSystem() {
        users = new HashMap<>();
        trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        this.users.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn user = this.users.get(id);
        String trip = user.stationName + "_" + stationName;
        if (!this.trips.containsKey(trip)) {
            this.trips.put(trip, new Duration(0, 0));
        }
        Duration duration = this.trips.get(trip);
        int totalTime = duration.totalDuration + t - user.time;
        int nums = duration.tripTimes + 1;
        this.trips.put(trip, new Duration(totalTime, nums));
    }

    public double getAverageTime(String startStation, String endStation) {
        Duration duration = this.trips.get(startStation + "_" + endStation);
        return (double) duration.totalDuration / duration.tripTimes;

    }

    class CheckIn {
        String stationName;
        int time;

        public CheckIn(String s, int t) {
            this.stationName = s;
            this.time = t;
        }
    }

    class Duration {
        int totalDuration;
        int tripTimes;

        public Duration(int s, int t) {
            this.totalDuration = s;
            this.tripTimes = t;
        }
    }
}
