package at.lk.otl.hw;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class RouteCalculator {

  private static final double MAX_ROUTE_LENGTH = 16.0;
  private final double[][] savings = new double[11][11];
  private final double[][] distanceMatrix;
  private final Map<Pair<Integer, Integer>, Double> routeSavings = new HashMap<>();

  public RouteCalculator(double[][] distanceMatrix) {
    this.distanceMatrix = distanceMatrix;
    calculateSavings();
  }


  private void calculateSavings() {
    for (int i = 0; i < 11; i++) {
      for (int j = 0; j < 11; j++) {
        final double saving;
        if (i == j) {
          saving = 0.0;
        } else {
          saving = distanceMatrix[i][0] + distanceMatrix[0][j] - distanceMatrix[i][j];
        }
        savings[i][j] = saving;
        routeSavings.put(new Pair<>(i, j), saving);
      }
    }
  }

  public double[][] getSavings() {
    return savings;
  }

  public Map<Pair<Integer, Integer>, Double> getRouteSavings() {
    return routeSavings;
  }
}
