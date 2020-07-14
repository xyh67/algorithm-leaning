package xu.paul.sort;

import java.lang.invoke.VarHandle;

/**
 * @author: Paul Xu
 * @createdAt: 2020/7/14 13:24
 * @description:
 */
public class InsertionSort {

  public static void sort(int[] array) {
    if (array == null || array.length <= 1) {
      return;
    }
    for (int i = 1; i < array.length; i++) {
      int value = array[i];
      int j = i - 1;
      for (; j >= 0; j--) {
        if (array[j] > value) {
          array[j + 1] = array[j];
        } else {
          break;
        }
      }
      array[j + 1] = value;
    }
  }

}
