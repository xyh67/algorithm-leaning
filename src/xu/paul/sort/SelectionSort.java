package xu.paul.sort;

import java.util.ArrayList;

/**
 * @author: Paul Xu
 * @createdAt: 2020/7/14 14:51
 * @description:
 */
public class SelectionSort {

  public static void sort(int[] array) {
    if (array == null || array.length <= 1) {
      return;
    }
    int length = array.length;
    for (int i = 0; i < length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      int tmp = array[i];
      array[i] = array[minIndex];
      array[minIndex] = tmp;
    }
  }
}
