class ArrayBytte {
  public static void main(String[] args) {
    int[] array = {1,2,3,4,5,6,7,8,9,10};
    int lengdePaarray = array.length;
    int minsteTall = 0;
    int storsteTall = 0 ;

    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
    int largest = array[0];
    int smallest = array[0];

    for (int i =1 ; i < lengdePaarray;i++) {
      if(array[i] > largest) {
        largest = array[i];
        storsteTall = i;
      }
      if(array[i] < smallest) {
        smallest = array[i];
        minsteTall = i;
      }
    }
    System.out.println("minste: "+ smallest + ", storste: " + largest);

    int temp = array[minsteTall];
    array[minsteTall] = array[storsteTall];
    array[storsteTall] = temp;

    System.out.println("Array etter bytting av minste og storste:");
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }
}
