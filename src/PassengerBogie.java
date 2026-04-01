public class PassengerBogie {

    private String type;
    private int    capacity;

    // Constructor throws custom exception if capacity is invalid
    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type     = type;
        this.capacity = capacity;
    }

    public String getType()  { return type; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return "PassengerBogie [Type: " + type + ", Capacity: " + capacity + " seats]";
    }
}