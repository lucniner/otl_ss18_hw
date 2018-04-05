package at.lk.otl.hw;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class DataHolder {

  private final Map<Integer, Pair<Integer, Integer>> points = new HashMap<>();
  private final double[][] distanceMatrix = new double[11][11];
  private final DistanceCalculator distanceCalculator;

  public DataHolder(DistanceCalculator distanceCalculator) {
    this.distanceCalculator = distanceCalculator;

    initializePoints();
    calculateDistanceBetweenPoints();
  }


  private void initializePoints() {
    points.put(0, new Pair<>(0, 0));
    points.put(1, new Pair<>(4, 1));
    points.put(2, new Pair<>(1, 2));
    points.put(3, new Pair<>(0, 5));
    points.put(4, new Pair<>(-3, 3));
    points.put(5, new Pair<>(-2, 1));
    points.put(6, new Pair<>(-5, 1));
    points.put(7, new Pair<>(-5, -1));
    points.put(8, new Pair<>(-1, -3));
    points.put(9, new Pair<>(3, -2));
    points.put(10, new Pair<>(6, -1));
  }

  private void calculateDistanceBetweenPoints() {
    for (int i = 0; i < 11; i++) {
      for (int j = 0; j < 11; j++) {
        final Pair<Integer, Integer> from = points.get(i);
        final Pair<Integer, Integer> to = points.get(j);
        distanceMatrix[i][j] = distanceCalculator.calculateDistanceBetweenPoints(from, to);
      }
    }
  }

  public Map<Integer, Pair<Integer, Integer>> getPoints() {
    return points;
  }

  public double[][] getDistanceMatrix() {
    return distanceMatrix;
  }
}
