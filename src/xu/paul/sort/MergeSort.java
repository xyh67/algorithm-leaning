package xu.paul.sort;

import java.awt.Dimension;
import java.util.regex.Pattern;

/**
 * @author: Paul Xu
 * @createdAt: 2020/7/14 16:43
 * @description:
 */
public class MergeSort {

  public static void sort(int[] array) {
    if (array == null || array.length <= 1) {
      return;
    }
    int length = array.length;
    mergeSort(array, 0, length - 1);
  }

  private static void mergeSort(int[] array, int startIndex, int endIndex) {
    if (startIndex >= endIndex) {
      return;
    }
    int size = startIndex + (endIndex - startIndex) / 2;
    mergeSort(array, startIndex, size);
    mergeSort(array, size + 1, endIndex);
    merge(array, startIndex, size, endIndex);
  }

  private static void merge(int[] array, int startIndex, int size, int endIndex) {
    //初始化变量i, j, k
    int i = startIndex;
    int j = size + 1;
    int k = 0;
    //申请一个大小跟a[startIndex...endIndex]一样的临时数组
    int[] tmp = new int[endIndex - startIndex + 1];
    while (i <= size && j <= endIndex) {
      if (array[i] <= array[j]) {
        // i++等于i:=i+1
        tmp[k++] = array[i++];
      } else {
        tmp[k++] = array[j++];
      }
    }

    //判断哪个子数组中有剩余的数据
    int start = i;
    int end = size;
    if (j <= endIndex) {
      start = j;
      end = endIndex;
    }

    //将剩余的数据拷贝到临时数组tmp
    while (start <= end) {
      tmp[k++] = array[start++];
    }

    //将tmp中的数组拷贝回a[startIndex...endIndex]
    for (i = 0; i <= endIndex - startIndex; ++i) {
      array[startIndex + i] = tmp[i];
    }
  }

  /**
   * 合并(哨兵)
   */
  private static void mergeBySentry(int[] array, int startIndex, int size, int endIndex) {
    int[] leftArr = new int[size - startIndex + 2];
    int[] rightArr = new int[endIndex - size + 1];

    for (int i = 0; i <= size - startIndex; i++) {
      leftArr[i] = array[startIndex + i];
    }
    //第一个数组添加哨兵（最大值）
    leftArr[size - startIndex + 1] = Integer.MAX_VALUE;

    for (int i = 0; i < endIndex - size; i++) {
      rightArr[i] = array[size + 1 + i];
    }
    //第二个数组添加哨兵（最大值）
    rightArr[endIndex - size] = Integer.MAX_VALUE;

    int i = 0;
    int j = 0;
    int k = startIndex;
    while (k <= endIndex) {
      //当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
      if (leftArr[i] <= rightArr[j]) {
        array[k++] = leftArr[i++];
      } else {
        array[k++] = rightArr[j++];
      }
    }
  }
}
