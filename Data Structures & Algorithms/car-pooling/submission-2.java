

class Pair implements Comparable<Pair> {
    int c; // count / passengers
    int p; // pickup / start location
    int d; // drop-off / end location

    Pair(int c, int p, int d) {
        this.c = c;
        this.p = p;
        this.d = d;
    }

    @Override
    public int compareTo(Pair other) {
        if (this.p != other.p) {
            return Integer.compare(this.p, other.p);
        }
        if (this.d != other.d) {
            return Integer.compare(this.d, other.d);
        }
        return Integer.compare(this.c, other.c);
    }
}

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Queue 1: Upcoming trips sorted by pickup location (p) using Pair's compareTo
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int[] trip : trips) {
            pq.add(new Pair(trip[0], trip[1], trip[2]));
        }

        // Queue 2: Active trips in the car sorted by drop-off location (d)
        PriorityQueue<Pair> activeTrips = new PriorityQueue<>((a, b) -> Integer.compare(a.d, b.d));

        int currentPassengers = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            // 1. Drop off passengers whose destination d <= current pickup location p
            while (!activeTrips.isEmpty() && activeTrips.peek().d <= curr.p) {
                currentPassengers -= activeTrips.poll().c; // Properly remove finished trips
            }

            // 2. Add new passengers
            currentPassengers += curr.c;

            // 3. Check capacity limit
            if (currentPassengers > capacity) {
                return false;
            }

            // 4. Track current trip in active queue
            activeTrips.add(curr);
        }

        return true;
    }
}