package StackyQues;

public class Customer {
    private int startTime;
    private String name;

    public Customer(int startTime, String name) {
        this.startTime = startTime;
        this.name = name;
    }

    public int getStartTime() {
        return startTime;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}
