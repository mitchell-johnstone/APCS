package Unit06;

import java.util.*;
import java.io.*;

/*
*/

public class PrimeGenerator{
	private int currentValue = 1;
	public PrimeGenerator(){
		currentValue = 1;
	}
	public int nextPrime(){
		currentValue++;
		boolean prime = true;
		for(int i = 2; i<currentValue && prime; i++){
			if(currentValue%i==0){
				prime = false;
			}
		}
		if(prime){
			return currentValue;
		} else {
			return this.nextPrime();
		}
	}
}