import lists.ArrayList;

public class DataStructures {
  public static void main(String[] args) {
    ArrayList<Integer> intArray = new ArrayList<Integer>(5);
    intArray.put(2);
    intArray.put(12);
    intArray.put(22);
    intArray.put(32);
    intArray.put(52);

    for (int i = 0; i < intArray.length(); i++) {
      System.out.println("Array[" + i + "]: " + intArray.get(i));
    }

    try {
      intArray.put(52);
    } catch(IndexOutOfBoundsException e) {
      System.out.println("Errored out: " + e);
    }

    ArrayList<String> stringArray = new ArrayList<String>(2);
    stringArray.put("Bear");
    stringArray.put("Tho");

    System.out.println("Popping element from stringArray: " + stringArray.pop());
    System.out.println("Popping element from stringArray: " + stringArray.pop());
  }
}