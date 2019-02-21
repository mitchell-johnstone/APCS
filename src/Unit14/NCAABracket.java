package Unit14;

import java.util.*;
import java.io.*;

public class NCAABracket{
	public static Random r;
	public static void main(String[] args){
		Team[][] teams = new Team[4][16];
		File f = new File("TeamNames.txt");

		int seed = 0;
		int bracket = 0;
		Scanner in = new Scanner(f);
		while(in.hasNextLine()){
			seed++;
			if(seed%8==0){
				seed = 0;
				bracket++;
			}
			teams[bracket][seed] = new Team(in.next(),seed+1);
			//System.out.println(teams[bracket][seed].getName() + " " + teams[bracket][seed].getSeed);
			teams[bracket][15-seed] = new Team(in.next(),16-seed);
			//System.out.println(teams[bracket][seed].getName() + " " + teams[bracket][seed].getSeed);
		}
		printTeams(teams);
		r = new Random();
		//round 1
		//for(int b = 0; b<4; b++){
		//for(int s = 0; s<8; s++){
		teams = round(1,teams);
		
				

	}

	public static void printTeams(Team[][]teams){
		for(int i = 0; i<16; i++){
			for(int j = 0; j<4; j++){
				System.out.print(teams[j][i] + " ");
			}
			System.out.println();
		}
	}

	public static boolean whoWins(Team a, Team b){
		int upTo = a.getSeed+b.getSeed;
		int g = r.nextInt(upTo)+1;
		return g>a.getSeed();
	}

	public static Team[][] round(int num, Team[][]teams){
		int fudge = Math.pow(2,num);
		for(int i = 0; i<4; i++){
			for(int j = 0; j<16; j+=fudge){
				if(whoWins(teams[i][j],teams[i][j+fudge/2])){
					teams[i][j]=null;
				} else {
					teams[i][j+fudge/2] = null;
				}
			}
		}
		return teams;
	}
}
