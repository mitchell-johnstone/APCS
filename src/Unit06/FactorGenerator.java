package Unit06;

import java.util.*;
import java.io.*;

/*
*/

public class FactorGenerator{
	int current;
	public FactorGenerator(int numberToFactor){
		current = numberToFactor;
	}
	
	public boolean hasMoreFactors(){
		for(int i = 2; i<=current; i++){
			if(current%i==0){
				return true;
			}
		}
		return false;
	}
	
	public int nextFactor(){
		for(int i = 2; i<=current; i++){
			if(current%i == 0){
				current/=i;
				return i;
			}
		}
		return 0;
	}
}