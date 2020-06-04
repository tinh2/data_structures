package lists;

public class ArrayList<E> {
  private int size = 0;
  private Object elements[];

  public ArrayList(int capacity) {
    elements = new Object[capacity];
  }

  public int length() {
    return size;
  }

  public void put(E element) throws IndexOutOfBoundsException {
    if (size == elements.length) {
      throw new IndexOutOfBoundsException("Out of bounds");
    }

    elements[size++] = element;
  }

  @SuppressWarnings("unchecked")
  public E get(int index) throws IndexOutOfBoundsException {
    if (index > size) {
      throw new IndexOutOfBoundsException("Out of bounds");
    }

    return (E) elements[index];
  }

  @SuppressWarnings("unchecked")
  public E pop() {
    size = size - 1;
    return (E) elements[size];
  }
}
