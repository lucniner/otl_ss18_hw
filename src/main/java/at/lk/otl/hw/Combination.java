package at.lk.otl.hw;


import java.util.LinkedList;
import java.util.List;

/**
 * adapted from
 * https://www.sanfoundry.com/java-program-generate-all-possible-combinations-given-list-numbers/
 */
public class Combination {

  private final List<List<Integer>> permutations = new LinkedList<>();

  public Combination(int[] permutationSequence) {
    permute(permutationSequence, 0);
  }

  private void permute(int[] a, int k) {
    if (k == a.length) {
      final List<Integer> elements = new LinkedList<>();
      for (int i = 0; i < a.length; i++) {
        elements.add(a[i]);
      }
      permutations.add(elements);
    } else {
      for (int i = k; i < a.length; i++) {
        int temp = a[k];
        a[k] = a[i];
        a[i] = temp;
        permute(a, k + 1);
        temp = a[k];
        a[k] = a[i];
        a[i] = temp;
      }
    }
  }


  public List<List<Integer>> getPermutations() {
    return permutations;
  }
}