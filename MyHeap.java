public class MyHeap {
  private static void pushDown(int[]data,int size,int index) {
    //preconditions: index is between 0 and size-1 (inclusive), size is between 0 and data.length-1 (inclusive)
    int i = index;
    //make sure it has at least one child
    while (i*2+1 < size || i*2+2 < size) {
      //if there's more than one child and c2 is bigger than c1 swap with 2
      if (i*2+2 < size && data[i*2+2] > data[i*2+1]) {
        int temp = data[i];
        data[i] = data[i*2+2];
        data[i*2+2] = temp;
        i = i*2+1;
      }
      //else (only one child, c1 is bigger, or c1 == c2) swap with 1
      else {
        int temp = data[i];
        data[i] = data[i*2+1];
        data[i*2+1] = temp;
        i = i*2;
      }
    }
  }

  private static void pushUp(int[]data,int index) {}

  public static void heapify(int[] data) {}

  public static void heapsort(int[] data) {}

  public static void main(String[] args) {
    int[] data = new int[]{8, 4, 17, 9, 0, 7, 12};

    System.out.print("[");
    for (int i = 0; i < data.length; i++) {
      System.out.print(data[i]);
      if (i < data.length-1) System.out.print(", ");
    }
    System.out.print("}\n\n");

    pushDown(data, 7, 0);

    System.out.print("[");
    for (int i = 0; i < data.length; i++) {
      System.out.print(data[i]);
      if (i < data.length-1) System.out.print(", ");
    }
    System.out.print("]\n\n");
  }
}
