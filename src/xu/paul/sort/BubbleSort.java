package xu.paul.sort;

/**
 * @author: Paul Xu
 * @createdAt: 2020/7/14 11:20
 * @description:
 */
public class BubbleSort {

  public static void sort(int[] array) {
    if (array == null || array.length <= 1) {
      return;
    }
    int length = array.length;
    for (int i = 0; i < length; i++) {
      boolean change = false;
      for (int j = 0; j < length - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          int tmp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = tmp;
          change = true;
        }
      }
      if (!change) {
        break;
      }
    }
  }
}
