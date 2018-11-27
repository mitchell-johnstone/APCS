package Unit09;

public class VegetableTester {
    public static void main(String[] args) {
        Vegetable v1 = new Vegetable(14.1,"potato");
        Vegetable v2 = new Vegetable(4.7,"carrot");
        System.out.println(v1);
        System.out.println(v2);

        if(v1.compareTo(v2)<0){
            double diff = v2.getWeight()-v1.getWeight();
            System.out.println(v1.getWeight() + "is < by");
            System.out.format("%.2f%n",diff);
        }else if(v1.compareTo(v2)>0){
            System.out.println(v1.getName() + " is bigger than " + v2.getName());
        } else {
            System.out.println(v1.getName() + " is same weight as " + v2.getName());
        }

        Vegetable v3 = v1.mash(v2);
        System.out.println(v3);
        if(v3.compareTo(v2)<0){
            double diff = v2.getWeight()-v3.getWeight();
            System.out.println(v3.getWeight() + "is < by");
            System.out.format("%.2f%n",diff);
        }else if(v3.compareTo(v2)>0){
            System.out.println(v3.getName() + " is bigger than " + v2.getName());
        } else {
            System.out.println(v3.getName() + " is same weight as " + v2.getName());
        }
    }
}
