package lt.vu.services;

import javax.enterprise.inject.Alternative;
import java.util.Random;

@Alternative
public class RoadCalculatorBicycle implements RoadCalculator {

    public Integer calculateRoadToNearestClinic() {
        try {
            Thread.sleep(300); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        Integer time = new Random().nextInt(100);
        return time*2;
    }
}
