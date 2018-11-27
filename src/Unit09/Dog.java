package Unit09;

public class Dog implements Speaker{
    private int weight;
    private String name;

    public Dog(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void speak(){
        System.out.println(" Ruff Ruff ");
    }

    public String toString(){
        return name + " weighs " + weight;
    }
}
