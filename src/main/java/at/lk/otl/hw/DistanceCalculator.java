package at.lk.otl.hw;

import javafx.util.Pair;

public class DistanceCalculator {


  public double calculateDistanceBetweenPoints(final Pair<Integer, Integer> from, final Pair<Integer, Integer> to) {
    final double xDistance = Math.pow(from.getKey() - to.getKey(), 2);
    final double yDistance = Math.pow(from.getValue() - to.getValue(), 2);
    final double totalDistance = xDistance + yDistance;
    return Math.sqrt(totalDistance);
  }
}
