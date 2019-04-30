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
        i = i*2+2;
        //System.out.println(printArray(data));
      }
      //else (only one child, c1 is bigger, or c1 == c2) swap with 1
      else {
        int temp = data[i];
        data[i] = data[i*2+1];
        data[i*2+1] = temp;
        i = i*2+1;
        //System.out.println(printArray(data));
      }
    }
  }

  private static void pushUp(int[]data,int index) {
  	int i = index;
  	//push up until either at the top or when parent is bigger
  	while ((i-1)/2 >= 0 && i > 0) {
  	  if (data[(i-1)/2] < data[i]) {
  		int temp = data[i];
	    data[i] = data[(i-1)/2];
	    data[(i-1)/2] = temp;
	    i = (i-1)/2;
	    System.out.println(printArray(data));
  	  }
  	}
  }

  public static void heapify(int[] data) {}

  public static void heapsort(int[] data) {}

  public static String printArray(int[] data) {
  	String s = "[";
	for (int i = 0; i < data.length; i++) {
      s+= data[i];
      if (i < data.length-1) s+= ", ";
    }
    s+= "]\n";
    return s;
  }

  public static void main(String[] args) {
    // int[] data = new int[]{19, 100, 136, 17, 20, 25, 1, 2, 7, 3};

    // System.out.print("ORIGINAL: ");
    // System.out.println(printArray(data));

    // pushDown(data, data.length, 0);

    // System.out.print("FINAL: ");
    // System.out.println(printArray(data));
    int[] data = new int[]{100, 19, 36, 17, 3, 25, 1, 2, 200};
    System.out.print("ORIGINAL: ");
    System.out.println(printArray(data));

    pushUp(data, 8);

    System.out.print("FINAL: ");
    System.out.println(printArray(data));
  }
}
