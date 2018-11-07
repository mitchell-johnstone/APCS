package ArrayLists;

import java.util.Random;

/*
*/

public class Fish {
	private double weight;
	private int numberScales;
	private String name;
	
	public Fish(){
		weight = 1;
		numberScales = 40;
		name = "fishy";
	}
	
	public Fish(double w, String fishName){
		weight = w;
		numberScales = 40;
		name = fishName;
	}
	
	public void setScales(int scalez){
		numberScales = scalez;
	}
	
	public void eatMinnow(){
		weight +=.25;
	}
	
	public void eatPlankton(){
		Random planktonNumb = new Random();
		weight += (planktonNumb.nextInt(10)+1)*.1;
	}
	
	public void eatWorms(double wurms){
		weight += wurms*.4;
	}
	
	public void sharkBite(){
		Random m = new Random();
		weight -= (m.nextInt(10)+1)*1.0;
		weight -= weight%.001;
		numberScales -= (m.nextInt(10)+1)*1.0;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public int getScales(){
		return numberScales;
	}

	public boolean equals(Fish fishy){
		boolean t1 = this.weight == fishy.getWeight();
		boolean t2 = Math.abs(this.numberScales - fishy.getScales())<.01;
		boolean t3 = this.name == fishy.name;
		return t1 && t2 && t3;
	}
	@Override
	public String toString() {
		return "Fish{" +
				"weight=" + weight +
				", numberScales=" + numberScales +
				", name='" + name + '\'' +
				'}';
	}
}