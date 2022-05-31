package lt.vu.services;

import java.util.Random;

public class DefaultRoadCalculator implements RoadCalculator {
    public Integer calculateRoadToNearestClinic() {
        try {
            Thread.sleep(300); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        Integer time = new Random().nextInt(100);
        return time;
    }
}
