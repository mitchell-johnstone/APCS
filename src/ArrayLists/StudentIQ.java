package ArrayLists;

import java.util.Random;

public class StudentIQ {
    private String name;
    private int IQ;
    private Random r;
    public StudentIQ() {
        this("UNKNOWN");
    }

    public StudentIQ(String name) {
        this.name = name;
        r = new Random();
        IQ = r.nextInt(161-75)+75;
    }

    public String getName() {
        return name;
    }

    public int getIQ() {
        return IQ;
    }
}
