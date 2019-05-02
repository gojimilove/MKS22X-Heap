public class MyHeap {
  private static void pushDown(int[]data,int size,int index) {
    //preconditions: index is between 0 and size-1 (inclusive), size is between 0 and data.length-1 (inclusive)
    int i = index;
    //push down if it has at least one child and is smaller than one of them (if 2 even exists)
    while ((i*2+1 < size || i*2+2 < size) && ((data[i] < data[i*2+1]) || (i*2+2 < size && data[i] < data[i*2+2]))) {
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
	    //System.out.println(printArray(data));
  	  }
  	}
  }

  public static void heapify(int[] data) {
  	//push each element down into place
  	for (int i = 0; i < data.length-1; i++) {
  		//System.out.println("Push down: "+data[i]+"\n");
  		pushDown(data, data.length, i);
  		//System.out.println(printArray(data));
  	}
  }

  public static void heapsort(int[] data) {
  	System.out.print("original array: ");
  	printArray(data);
  	heapify(data);
  	System.out.print("good heap: ");
  	printArray(data);

  	//swap first and last values (moves biggest to end)
  	int size = data.length;
  	int temp = 0;
  	while (size > 1) {
  		System.out.print(data[0]+" at end: ");
	  	temp = data[0];
	  	data[0] = data[size-1];
	  	data[size-1] = temp;
	  	
	  	printArray(data);
	  	size--;
	  	System.out.println("SIZE: "+size+"\n");
	  	System.out.print(data[0]+" pushed down: ");
	  	pushDown(data, size, 0);
	  	printArray(data);
	 }
  }

  public static void printArray(int[] data) {
  	String s = "[";
	for (int i = 0; i < data.length; i++) {
      s+= data[i];
      if (i < data.length-1) s+= ", ";
    }
    s+= "]\n";
    System.out.println(s);
  }

  public static void main(String[] args) {
    // TESTING PUSHDOWN
    // int[] data = new int[]{19, 100, 136, 17, 20, 25, 1, 2, 7, 3};

    // System.out.print("ORIGINAL: ");
    // System.out.println(printArray(data));

    // pushDown(data, data.length, 0);

    // System.out.print("FINAL: ");
    // System.out.println(printArray(data));

    // TESTING PUSHUP
    // int[] data = new int[]{100, 19, 36, 17, 3, 25, 1, 2, 200};
    // System.out.print("ORIGINAL: ");
    // System.out.println(printArray(data));

    // pushUp(data, 8);

    // System.out.print("FINAL: ");
    // System.out.println(printArray(data));

    // TESTING HEAPIFY
    // int[] data = new int[]{8, 4, 17, 9, 0, 7, 12};
    // System.out.print("ORIGINAL: ");
    // printArray(data);

    // heapify(data);

    // System.out.print("FINAL: ");
    // printArray(data);

    //TESTING HEAPSORT
    int[] data = new int[]{8, 4, 17, 9, 0, 7, 12};
    heapsort(data);
  }
}
