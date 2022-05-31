package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public interface RoadCalculator  {
    public Integer calculateRoadToNearestClinic();
}