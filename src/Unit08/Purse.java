package Unit08;

import java.util.ArrayList;

public class Purse {
    private ArrayList<Coin> coins = new ArrayList <>();

    public Purse() {
    }

    public void add(Coin c){
        coins.add(c);
        System.out.println("Loaded " +c.getName());
    }

    public double getTotal(){
        double total = 0;
        for (int i = 0; i < coins.size(); i++) {
            total+=coins.get(i).getValue();
        }
        return total;
    }

    public double getAverage(){
        return this.getTotal()/(coins.size());
    }
}
