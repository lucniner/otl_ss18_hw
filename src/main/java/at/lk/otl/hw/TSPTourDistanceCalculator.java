package at.lk.otl.hw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TSPTourDistanceCalculator {

  private final Map<String, Double> costs = new HashMap<>();
  private final List<List<Integer>> tourPermutations;
  private final double[][] distanceMatrix;


  public TSPTourDistanceCalculator(List<List<Integer>> tourPermutations, double[][] distanceMatrix) {
    this.tourPermutations = tourPermutations;
    this.distanceMatrix = distanceMatrix;
    calculateCosts();
  }


  private void calculateCosts() {
    for (final List<Integer> permutation : tourPermutations) {
      String permutationRepresentation = "";
      double sum = 0.0;
      //distance between depo and first point in permutation
      sum += distanceMatrix[0][permutation.get(0)];
      for (int i = 0; i < permutation.size() - 1; i++) {
        sum += distanceMatrix[permutation.get(i)][permutation.get(i + 1)];
      }

      for (Integer i : permutation) {
        permutationRepresentation += String.valueOf(i);
      }

      //distance between last point and depo
      sum += distanceMatrix[permutation.get(permutation.size() - 1)][0];
      costs.put(permutationRepresentation, sum);
    }
  }

  public Map<String, Double> getCosts() {
    return costs;
  }
}
