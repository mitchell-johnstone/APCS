package ArrayLists;

import java.util.ArrayList;
import java.util.Arrays;
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
        fish.add(new Fish(20, "Pudge"));
        fish.set(1, new Fish(20, "Pudge"));
        for(Fish f : fish){
            System.out.println("Fish "+ i);
            System.out.println("\tScales: " + f.getScales());
            System.out.println("\tWeight: " + f.getWeight());
            System.out.println();
            i++;
        }
        for (int j = 0; j < fish.size(); j++) {
            for (int k = j+1; k < fish.size(); k++) {
                if(fish.get(j).equals(fish.get(k))) System.out.println("same fishes found at " + j + " and " + k);
            }
        }
    }
}
