package Unit09;

public class Vegetable implements Comparable {
    private double weight;
    private String name;

    public Vegetable(double weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Vegetable{" +
                "weight=" + weight +
                "ounces, name='" + name + '\'' +
                '}';
    }

    public Vegetable mash(Vegetable veggie2){
        return new Vegetable(weight+veggie2.getWeight(),
                name.substring(0,1)+veggie2.getName().substring(1));
    }

    public int compareTo(Object obj){
        double otherNum = ((Vegetable) obj).getWeight();
        if(weight<otherNum)
            return -1;
        else if(weight>otherNum)
            return 1;
        else
            return 0;
    }
}
