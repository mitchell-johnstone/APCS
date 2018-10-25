package Arrays;

public class A6 {
    public static void main(String[] args) {
        Fish [] fishes = new Fish[3];
        for (int i = 0; i < fishes.length; i++) {
            fishes[i]= new Fish();
        }
        fishes[0].eatMinnow();
        fishes[2].setScales(3);
        fishes[0].eatPlankton();
        fishes[2].eatWorms(100);
        fishes[2].sharkBite();
        System.out.println("fishes[0] weight" + fishes[0].getWeight());
        System.out.println("fishes[0] scales" + fishes[0].getScales());
        System.out.println("fishes[1] weight" + fishes[1].getWeight());
        System.out.println("fishes[1] scales" + fishes[1].getScales());
        System.out.println("fishes[2] weight" + fishes[2].getWeight());
        System.out.println("fishes[2] scales" + fishes[2].getScales());

    }
}
