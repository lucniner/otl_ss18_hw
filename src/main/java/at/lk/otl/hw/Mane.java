package at.lk.otl.hw;


import javafx.util.Pair;

import java.util.*;

public class Mane {


  public static void main(String[] args) {
    final Mane mane = new Mane();
    mane.calculateDistances();
  }


  public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
    List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
    list.sort(Map.Entry.comparingByValue());
    Collections.reverse(list);
    Map<K, V> result = new LinkedHashMap<>();
    for (Map.Entry<K, V> entry : list) {
      result.put(entry.getKey(), entry.getValue());
    }

    return result;
  }


  private void printDistanceMatrix(final double[][] matrix) {
    for (int i = 0; i < 11; i++) {
      for (int j = 0; j < 11; j++) {
        System.out.println("from:\t" + i + "\tto:\t" + j + "\tdistance:\t" + matrix[i][j]);
      }
    }
  }

  private void calculateDistances() {
    final DistanceCalculator calculator = new DistanceCalculator();
    final DataHolder dataHolder = new DataHolder(calculator);
    final double[][] distanceMatrix = dataHolder.getDistanceMatrix();
//    printDistanceMatrix(distanceMatrix);
//    System.out.println();

    final RouteCalculator routeCalculator = new RouteCalculator(distanceMatrix);
    final double[][] savingsMatrix = routeCalculator.getSavings();
//    printSavingsMatrix(savingsMatrix);
//    System.out.println();

    final Map<Pair<Integer, Integer>, Double> savings = routeCalculator.getRouteSavings();
    final Map<Pair<Integer, Integer>, Double> sortedSavings = sortByValue(savings);
//    printSavingsMap(sortedSavings);

    final int[] first = {5, 6, 7, 8};
    final Combination combination = new Combination(first);
    final List<List<Integer>> permutations = combination.getPermutations();

    final TSPTourDistanceCalculator permutationCalculator = new TSPTourDistanceCalculator(permutations, distanceMatrix);
    final Map<String, Double> costs = sortByValue(permutationCalculator.getCosts());

    costs.entrySet().forEach(System.out::println);
  }

  private void printSavingsMatrix(final double[][] matrix) {
    for (int i = 0; i < 11; i++) {
      for (int j = 0; j < 11; j++) {
        System.out.println("from:\t" + i + "\tto:\t" + j + "\tsaving:\t" + matrix[i][j]);
      }
    }
  }

  private void printSavingsMap(final Map<Pair<Integer, Integer>, Double> savings) {
    for (Map.Entry<Pair<Integer, Integer>, Double> entry : savings.entrySet()) {

      System.out.println("from:\t" + entry.getKey().getKey() + "\tto:\t" + entry.getKey().getValue() + "\tsaving:\t" + entry.getValue());

    }
  }
}
