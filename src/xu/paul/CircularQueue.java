package xu.paul;

/**
 * @author: Paul Xu
 * @createdAt: 2020/7/13 16:41
 * @description:
 */
public class CircularQueue {

  private String[] items;
  private int n;
  private int head = 0;
  private int tail = 0;

  public CircularQueue(int totalSize) {
    items = new String[totalSize];
    n = totalSize;
  }

  public boolean enqueue(String item) {
    if ((tail + 1) % n == head) {
      return false;
    }
    items[tail] = item;
    tail = (tail + 1) % n;
    return true;
  }

  public String dequeue() {
    if (head == tail) {
      return null;
    }
    String result = items[head];
    head = (head + 1) % n;
    return result;
  }
}
