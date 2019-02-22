package Unit14;

import java.util.*;
import java.io.*;

public class NCAABracket{
	public static Random r;
	public static void main(String[] args){
		Team[][] teams = new Team[4][16];
		File f = new File("C:\\Users\\Admin\\Documents\\Coding\\APCS\\src\\Unit14\\TeamNames.txt");

		int seed = 0;
		int bracket = 0;
		Scanner in = new Scanner(System.in);
		try {
			in = new Scanner(f);
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		for(int i = 0; i<32; i++){
			if(seed>7){
				seed = 0;
				bracket++;
			}
			seed++;

//			System.out.println(seed + " "+ bracket);
			teams[bracket][(seed-1)*2] = new Team(in.nextLine(),seed);
//			System.out.println(teams[bracket][seed-1].getName() + " " + teams[bracket][seed-1].getSeed());
			teams[bracket][seed*2-1] = new Team(in.nextLine(),17-seed);
//			System.out.println(teams[bracket][16-seed].getName() + " " + teams[bracket][16-seed].getSeed());
//			if(teams[bracket][15-seed].getName().equalsIgnoreCase("South Dakota St.")) System.out.println("YES \n");
//			System.out.println();
		}
		System.out.println("Simple 64");
		r = new Random();
		printTeams(teams);

		//round 1
		System.out.println("Thrifty 32");
		teams = round(1,teams);
		printTeams(teams);

		//round 2
		System.out.println("Sweet 16");
		teams = round(2,teams);
		printTeams(teams);

		//round 3
		System.out.println("Crazy 8");
		teams = round(3,teams);
		printTeams(teams);

		//round 4
		System.out.println("Final 4");
		teams = round(4,teams);
		printTeams(teams);

		//round 5
		System.out.println("Competition");
		teams = finals(5,teams);
		printTeams(teams);

		//round 6
		System.out.println("WINNER!");
		teams = finals(6,teams);
		printTeams(teams);
	}

	public static void printTeams(Team[][]teams){
		for(int i = 0; i<16; i++){
			boolean empty = teams[0][i]==null;
			for(int j = 0; j<4; j++){
				if(!empty){
					empty=false;
					String s;
					if(teams[j][i]==null) s = "";
					else  s = teams[j][i].toString();
					int howMuchLeft = 42-s.length();
					for (int k = 0; k < howMuchLeft; k++) {
						s+=" ";
					}
					System.out.print(s + " ");
				}
			}
			if(!empty)System.out.println();
		}
		System.out.println("\n---------------------------------------------------------------------------------------" +
				"----------------------------------------------------------------------------------\n");
	}

	public static Team[][] finals(int r, Team[][]teams){
		r -=4;
		for (int i = 0; i < 4; i+=r*2) {
			if(whoWins(teams[i][0],teams[i+r][0])){
				teams[i][0]=teams[i+r][0];
//					teams[i][j]=null;
			}
			teams[i+r][0] = null;
		}
		return teams;
	}

	public static boolean whoWins(Team a, Team b){
		int upTo = a.getSeed()+b.getSeed();
		int g = r.nextInt(upTo)+1;
//		System.out.println(upTo + " " + g);
		Team smallest = a.getSeed()<b.getSeed()?a:b;
		return g<=smallest.getSeed();
	}

	public static Team[][] round(int num, Team[][]teams){
		int fudge = (int)Math.pow(2,num);
		for(int i = 0; i<4; i++){
			for(int j = 0; j<16; j+=fudge){
				if(whoWins(teams[i][j],teams[i][j+fudge/2])){
					teams[i][j]=teams[i][j+fudge/2];
//					teams[i][j]=null;
				}
				teams[i][j+fudge/2] = null;
			}
		}
		return teams;
	}
}
