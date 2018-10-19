package Unit02;

import java.util.*;
import java.awt.Rectangle;
/*
*/

public class E1_2 {
	public static void main(String[] args){
		Rectangle rec = new Rectangle(30, 40, 70, 10);
		System.out.println("The width is " + rec.getWidth());
		System.out.println("The height is " + rec.getHeight());
		System.out.println("The area of the rectangle is " + rec.getWidth()*rec.getHeight());
		System.out.println("The perimeter of the rectangle is " + ((2*rec.getWidth())+(2*rec.getHeight())));
	}
}