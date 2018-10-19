package Chair;

import java.util.*;
import javax.swing.JOptionPane;
/*
*/

public class ChairTester{
	public static void main(String[] args){
		Chair stool = new Chair();
		System.out.println(stool.getHeight());
		stool.sawLegs();
		System.out.println(stool.getHeight());
		
		Chair lowRider = new Chair(5, "LowRider");
		System.out.println("lowRider " + lowRider.getHeight());
		lowRider.sawLegs();
		System.out.println("lowRider " + lowRider.getHeight());
		
		Chair highGuy = new Chair(20, "highGuy");
		System.out.println("highGuy " + highGuy.getHeight());
		highGuy.sawLegs();
		System.out.println("highGuy " + highGuy.getHeight());
		
		Chair lawnChair = new Chair();
		System.out.println("lawnChair height " + lawnChair.getHeight());
		System.out.println("lawnChair rips " + lawnChair.getRips());
		lawnChair.sawLegs();
		lawnChair.setRips(3);
		System.out.println("lawnChair height " + lawnChair.getHeight());
		System.out.println("lawnChair rips " + lawnChair.getRips());
		lawnChair.addLifter();
		System.out.println("lawnChair height " + lawnChair.getHeight());
		
		String height = JOptionPane.showInputDialog("Height of new chair?");
		int h = Integer.parseInt(height);
		String  n = JOptionPane.showInputDialog("Name of new chair?");
		Random r = new Random();
		Chair tmp = new Chair(h, n);
		System.out.println(n + " height " + tmp.getHeight());
		System.out.println(n + " rips " +tmp.getRips());
		tmp.sawLegs();
		tmp.setRips(r.nextInt(10)+1);
		System.out.println(n+ " height " +tmp.getHeight());
		System.out.println(n+ " rips " + tmp.getRips());
		tmp.addLifter();
		System.out.println(n+" height " +tmp.getHeight());
	}
}