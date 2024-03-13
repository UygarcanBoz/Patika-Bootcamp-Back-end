public class Main {
    public static void main(String[] args) {
        // Example usage of the MyList class
        MyList<Integer> myList = new MyList<>();

        // Check the status of the list
        System.out.println("List Status: " + (myList.isEmpty() ? "Empty" : "Full"));

        // Add elements to the list
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);
        myList.add(20);
        myList.add(50);
        myList.add(60);
        myList.add(70);
        myList.add(80);
        myList.add(90);
        myList.add(100);

        // Check the status of the list
        System.out.println("List Status: " + (myList.isEmpty() ? "Empty" : "Full"));

        // Find the index of a specific element
        System.out.println("Index of 20: " + myList.indexOf(20));

        // Check if a specific value is present in the list
        System.out.println("Contains 50: " + myList.contains(50));
        System.out.println("Contains 120: " + myList.contains(120));

        // Display the list elements
        System.out.println("List: " + myList.toString());

        // Remove an element at a specific index
        myList.remove(3);

        // Display the list elements after removal
        System.out.println("List after removal: " + myList.toString());

        // Update an element at a specific index
        myList.set(1, 99);

        // Display the list elements after modification
        System.out.println("List after modification: " + myList.toString());

        // Clear all elements from the list
        myList.clear();

        // Check the status of the list after clear
        System.out.println("List Status after clear: " + (myList.isEmpty() ? "Empty" : "Full"));
    }
}