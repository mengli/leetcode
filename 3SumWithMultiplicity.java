/**
 * Given an integer array A, and an integer target, return the number of tuples i, j, k  such that i < j < k and A[i] + A[j] + A[k] == target.
 *
 * As the answer can be very large, return it modulo 10^9 + 7.
 */
class Solution {
  public int threeSumMulti(int[] A, int target) {
    Map<Integer, Integer> count = new HashMap<>();
    for (int a : A) {
      if (count.containsKey(a)) {
        count.put(a, count.get(a) + 1);
      } else {
        count.put(a, 1);
      }
    }
    Object[] elements = count.keySet().toArray();
    Integer[] integers = Arrays.copyOf(elements, elements.length, Integer[].class);
    long ret = 0;
    Arrays.sort(integers);
    for (int i = 0; i < integers.length; i++) {
      for (int j = i; j < integers.length; j++) {
        int rest = target - integers[i] - integers[j];
        if (count.containsKey(rest) && rest >= integers[j]) {
          if (integers[i] == integers[j] && integers[j] == rest) {
            ret += calculate(count.get(rest), 3);
          } else if (integers[i] == rest && integers[i] != integers[j]) {
            ret += (calculate(count.get(integers[i]), 2) * count.get(integers[j]));
          } else if (integers[j] == rest && integers[i] != integers[j]) {
            ret += (calculate(count.get(integers[j]), 2) * count.get(integers[i]));
          } else if (integers[i] == integers[j] && integers[i] != rest) {
            ret += (calculate(count.get(integers[j]), 2) * count.get(rest));
          } else {
            ret += (count.get(integers[i]) * count.get(integers[j]) * count.get(rest));
          }
        }
      }
    }
    return (int) (ret % (1e9 + 7));
  }

  private long calculate(long x, long n) {
    if (n == 2) {
      return x * (x - 1) / 2;
    }
    return x * (x - 1) * (x - 2) / 6;
  }
}
