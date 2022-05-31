package lt.vu.usecases;

import lt.vu.services.RoadCalculator;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class CalculateRoadTime implements Serializable {
    @Inject
    RoadCalculator roadCalculator;

    private CompletableFuture<Integer> calculationTask = null;

//    @LoggedInvocation
//    public String generateNewJerseyNumber() {
//        Map<String, String> requestParameters =
//                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//
//        jerseyNumberGenerationTask = CompletableFuture.supplyAsync(() -> jerseyNumberGenerator.generateJerseyNumber());
//
//        return  "/playerDetails.xhtml?faces-redirect=true&playerId=" + requestParameters.get("playerId");
//    }

    public String calculateRoadTime() {
        calculationTask = CompletableFuture.supplyAsync(() -> roadCalculator.calculateRoadToNearestClinic());
        return  "/index.xhtml?faces-redirect=true";
    }

    public boolean isCalculating() {
        return calculationTask != null && !calculationTask.isDone();
    }

    public String getCalculationStatus() throws ExecutionException, InterruptedException {
        if (calculationTask == null) {
            return null;
        } else if (isCalculating()) {
            return "Calculating..";
        }
        return "Suggested time by car to our neariest clinic: " + calculationTask.get();
    }
}
