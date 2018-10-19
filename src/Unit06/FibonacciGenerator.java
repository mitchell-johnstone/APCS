package Unit06;

import java.util.*;
import java.io.*;

/*
*/

public class FibonacciGenerator{
	int i1;
	int i2;
	public FibonacciGenerator(){
		i1 = 0;
		i2 = 1;
	}
	
	public int nextNumber(){
		int tmp = i2;
		i2+=i1;
		i1 = tmp;
		return i1;
	}
}