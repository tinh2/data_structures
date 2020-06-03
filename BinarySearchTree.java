import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BinarySearchTree {
  public static void main(String[] args) {
    /**
     * A tree has a root node and children nodes, Binary trees have a left child and a right child
     * A Binary Search Trees' left nodes are less than the root node and all right nodes
     */

    // pick a number between 0 and 100(inclusive) to be root Node
    Node bst = new Node(ThreadLocalRandom.current().nextInt(0, 100 + 1));

    // doing this because i wanna use mass insert
    List<Integer> listOfNumbers = new ArrayList<>();
    for (int i = 0; i <= 20; i++) {
      listOfNumbers.add(ThreadLocalRandom.current().nextInt(0, 100 + 1));
    }
    bst.massInsert(listOfNumbers);

    int favNum = 5;
    bst.printInOrder();
    if (bst.contains(favNum)) {
      System.out.println("Found your favorite number in Node: " + bst.find(favNum));
    }
    System.out.println("Root node: " + bst.toString());
  }
}

class Node {
  Node left;
  Node right;
  int data;

  public Node(int data) {
    this.data = data;
  }

  public String toString() {
    return Integer.toString(data);
  }

  public void insert(int value) {
    if (value <= data) {
      if (left == null) {
        left = new Node(value);
      } else {
        left.insert(value);
      }
    } else {
      if (right == null) {
        right = new Node(value);
      } else {
        right.insert(value);
      }
    }
  }

  public void massInsert(List<Integer> values) {
    values.forEach(value -> insert(value));
  }

  public boolean contains(int value) {
    if (value == data) {
      return true;
    } else if (value < data) {
      if (left == null) {
        return false;
      } else {
        return left.contains(value);
      }
    } else {
      if (right == null) {
        return false;
      } else {
        return right.contains(value);
      }
    }
  }

  public Node find(int value) {
    if (value == data) {
      return this;
    } else if (value < data) {
      if (left == null) {
        System.out.println("Unable to find Node with value: " + value);
        return null;
      } else {
        return left.find(value);
      }
    } else {
      if (right == null) {
        System.out.println("Unable to find Node with value: " + value);
        return null;
      } else {
        return right.find(value);
      }
    }
  }

  public void printInOrder() {
    if (left != null) {
      left.printInOrder();
    }
    System.out.println(data);
    if (right != null) {
      right.printInOrder();
    }
  }

  public void printPreOrder() {
    System.out.println(data);
    if (left != null) {
      left.printPreOrder();
    }
    if (right != null) {
      right.printPreOrder();
    }
  }

  public void printPostOrder() {
    if (left != null) {
      left.printPostOrder();
    }
    if (right != null) {
      right.printPostOrder();
    }
    System.out.println(data);
  }
}