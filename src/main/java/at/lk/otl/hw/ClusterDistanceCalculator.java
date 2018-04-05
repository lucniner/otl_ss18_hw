package at.lk.otl.hw;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.List;

public class ClusterDistanceCalculator {

  private final double[][] distanceMatrix;

  private final Multimap<Integer, Double> clusterDistanceCosts = ArrayListMultimap.create();
  private final List<Integer> seeds;

  public ClusterDistanceCalculator(double[][] distanceMatrix, List<Integer> seeds) {
    this.distanceMatrix = distanceMatrix;
    this.seeds = seeds;
    calculateClusterDistances();
  }

  private void calculateClusterDistances() {
    for (Integer seed : seeds) {
      for (int i = 1; i < 11; i++) {
        double roundOne = distanceMatrix[0][i] + distanceMatrix[i][seed] + distanceMatrix[seed][0];
        double roundTwo = distanceMatrix[0][seed] + distanceMatrix[seed][i] + distanceMatrix[i][0];
        double costs = Math.min(roundOne, roundTwo) - (distanceMatrix[0][seed] + distanceMatrix[seed][0]);
        clusterDistanceCosts.put(i, costs);

      }
    }
  }

  public Multimap<Integer, Double> getClusterDistanceCosts() {
    return clusterDistanceCosts;
  }
}
