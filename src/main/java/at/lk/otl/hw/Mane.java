package at.lk.otl.hw;


public class Mane {


  public static void main(String[] args) {
    final Mane mane = new Mane();
    mane.calculateDistances();
  }


  private void calculateDistances() {
    final DistanceCalculator calculator = new DistanceCalculator();
    final DataHolder dataHolder = new DataHolder(calculator);
    final double[][] distances = dataHolder.getDistanceMatrix();
    printDistanceMatrix(distances);
  }

  private void printDistanceMatrix(final double[][] matrix) {
    for (int i = 0; i < 11; i++) {
      for (int j = 0; j < 11; j++) {
        System.out.println("from:\t" + i + "\tto:\t" + j + "\tdistance:\t" + matrix[i][j]);
      }
    }
  }
}
