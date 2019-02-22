package Unit14;

public class Team {
	private String name;
	private int seed;
	private int bracket;

	public Team(String n, int s, int b){
		name = n;
		seed = s;
		bracket = b;
	}
	public String getName(){
		return name;
	}
	public int getSeed(){
		return seed;
	}
	public int getBracket(){
		return bracket;
	}

	@Override
	public String toString() {
		return "Team{" +
				"name='" + name + '\'' +
				", seed=" + seed +
				'}';
	}
}
