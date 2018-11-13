package Unit08;

public class Coin {
    private double value;
    private String name;
    public static int NumberOfCoins;

    public Coin(double value, String name) {
        this.value = value;
        this.name = name;
        NumberOfCoins++;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
