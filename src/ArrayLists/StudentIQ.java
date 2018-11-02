package ArrayLists;

import java.util.Random;

public class StudentIQ {
    private String name;
    private int IQ;
    public StudentIQ() {
        this("UNKNOWN");
    }

    StudentIQ(String name) {
        this.name = name;
        Random r = new Random();
        IQ = r.nextInt(161-75)+75;
    }

    public String getName() {
        return name;
    }

    int getIQ() {
        return IQ;
    }
}
