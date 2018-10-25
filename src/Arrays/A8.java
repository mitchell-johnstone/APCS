package Arrays;

public class A8 {
    public static void main(String[] args) {
        boolean[][]openSpaces = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                openSpaces[i][j]=true;
            }
        }
        String[][]letters = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                letters[i][j]="_";
            }
        }

    }
}
