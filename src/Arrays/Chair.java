package Arrays;

/*
*/

public class Chair {
	private double height;
	private int numberRips;
	private String name;
	
	public Chair(){
		height = 14.0;
		numberRips = 0;
		name = "oak";
	}
	
	Chair(double h, String chairName){
		height = h;
		numberRips = 0;
		name = chairName;
	}
	
	void sawLegs(){
		height -= 1.1;
	}
	
	public void addLifter(){
		height += 2.0;
	}
	
	public double getHeight(){
		return height;
	}
	
	public int getRips(){
		return numberRips;
	}
	
	public void setRips(int ripz){
		numberRips = ripz;
	}
}