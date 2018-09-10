import java.util.ArrayList;
import java.util.List;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even,
 * there is no middle value. So the median is the mean of the two middle value.
 * <p>
 * For example,
 * [2,3,4], the median is 3
 * <p>
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 */

class MedianFinder {

  private final List<Integer> elements = new ArrayList<>();

  /**
   * initialize your data structure here.
   */
  public MedianFinder() {
  }

  public void addNum(int num) {
    qinsert(0, elements.size() - 1, num);
  }

  public double findMedian() {
    if (elements.size() % 2 == 0) {
      int q = elements.size() / 2;
      int p = q > 0 ? q - 1 : q;
      return (elements.get(p) + elements.get(q)) / 2.f;
    } else {
      return elements.get((elements.size() - 1) / 2);
    }
  }

  private void qinsert(int start, int end, int num) {
    if (start > end) {
      elements.add(start, num);
      return;
    }
    int index = (start + end) / 2;
    int mid = elements.get(index);
    if (mid == num) {
      elements.add(index, num);
      return;
    }
    if (mid < num) {
      qinsert(index + 1, end, num);
    } else {
      qinsert(start, index - 1, num);
    }
  }
}