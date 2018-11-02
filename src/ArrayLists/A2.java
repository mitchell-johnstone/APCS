package ArrayLists;

import java.util.ArrayList;
import java.util.Random;

public class A2 {
    public static void main(String[] args) {
        ArrayList<Fish> fish = new ArrayList <>();
        for (int i = 0; i < 3; i++) {
            fish.add( new Fish());
        }
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int tmp = r.nextInt(5);
            int whichFish = r.nextInt(3);
            switch (tmp){
                case 0:
                    fish.get(whichFish).eatMinnow();
                    break;
                case 1:
                    fish.get(whichFish).eatPlankton();
                    break;
                case 2:
                    fish.get(whichFish).eatWorms(r.nextInt(100));
                    break;
                case 3:
                    fish.get(whichFish).sharkBite();
                    break;
                case 4:
                    fish.get(whichFish).setScales(fish.get(whichFish).getScales()+r.nextInt(10));
            }
        }
        int i = 1;
        for(Fish f : fish){
            System.out.println("Fish "+ i);
            System.out.println("\tScales: " + f.getScales());
            System.out.println("\tWeight: " + f.getWeight());
            System.out.println();
            i++;
        }
    }
}
