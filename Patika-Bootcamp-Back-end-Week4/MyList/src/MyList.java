import java.util.Arrays;

// Class properties:
// - The default size of the array in the class is 10, and the array should double in size as needed.
// - Two types of constructors for the class:
//     - MyList(): If the empty constructor is used, the initial size of the array should be 10.
//     - MyList(int capacity): The initial value of the array should be taken from the capacity parameter.
// - size(): Returns the number of elements in the array.
// - getCapacity(): Returns the capacity value of the array.
// - add(T data): Used to add an element to the array in the class.
//     If there is not enough space in the array, the array size should be doubled.

public class MyList<T> {
    // Default capacity for the array
    private static final int DEFAULT_CAPACITY = 10;

    // Growth factor for dynamically resizing the array
    private static final double GROWTH_FACTOR = 2.0;

    // Capacity of the array
    private int capacity;

    // Array to store elements
    private T[] list;

    // Number of elements in the array
    private int size;

    // Default constructor with default capacity
    public MyList() {
        this(DEFAULT_CAPACITY);
    }

    // Constructor with a specified capacity
    public MyList(int capacity) {
        this.capacity = capacity;
        this.list = (T[]) new Object[capacity];
        this.size = 0;
    }

    // Returns the number of elements in the array
    public int size() {
        return size;
    }

    // Returns the capacity of the array
    public int getCapacity() {
        return capacity;
    }

    // Adds an element to the array
    public void add(T data) {
        // Check if the array is full, and resize if necessary
        if (size == capacity) {
            int newCapacity = (int) (capacity * GROWTH_FACTOR);
            list = Arrays.copyOf(list, newCapacity);
            capacity = newCapacity;
        }
        list[size++] = data; // Add the element and increment the size
    }

    // Removes the element at the specified index
    public void remove(int index) {
        if (index >= 0 && index < size) {
            // Using System.arraycopy to efficiently shift elements
            System.arraycopy(list, index + 1, list, index, size - index - 1);
            list[--size] = null; // Set the last element to null and decrement the size
        }
    }

    // Returns the element at the specified index
    public T get(int index) {
        if (index >= 0 && index < size) {
            return list[index];
        }
        return null; // Return null if the index is out of bounds
    }

    // Sets the element at the specified index with the given data
    public T set(int index, T data) {
        if (index >= 0 && index < size) {
            T oldValue = list[index];
            list[index] = data;
            return oldValue; // Return the old value at the specified index
        }
        return null; // Return null if the index is out of bounds
    }

    // Returns a string representation of the list
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }

    // Returns the index of the first occurrence of the specified element
    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (data == null && list[i] == null || data != null && data.equals(list[i])) {
                return i;
            }
        }
        return -1; // Return -1 if the element is not found
    }

    // Checks if the array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the index of the last occurrence of the specified element
    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (data == null && list[i] == null || data != null && data.equals(list[i])) {
                return i;
            }
        }
        return -1; // Return -1 if the element is not found
    }

    // Returns a clone of the list as an Object array
    public Object[] toArray() {
        return Arrays.copyOf(list, size);
    }

    // Returns a sublist of the list from start to finish indices
    public MyList<T> subList(int start, int finish) {
        MyList<T> sublist = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish && i < size; i++) {
            sublist.add(list[i]);
        }
        return sublist;
    }

    // Checks if the list contains the specified element
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    // Clears the list, making it empty and resizing it to the default size
    public void clear() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }
}