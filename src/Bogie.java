public class Bogie {

    // Fields
    String name;
    int capacity;

    // Constructor
    public Bogie(String name, int capacity) {
        this.name     = name;
        this.capacity = capacity;
    }

    // Getters
    public String getName()    { return name; }
    public int getCapacity()   { return capacity; }

    // Display
    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + " seats)";
    }
}