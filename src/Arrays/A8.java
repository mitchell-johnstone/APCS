package Arrays;

import java.util.Random;

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
                letters[i][j]="_ ";
            }
        }
        Random r = new Random();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int x,y;
                do{
                    x = r.nextInt(3);
                    y = r.nextInt(3);
                } while (!openSpaces[x][y]);
                openSpaces[x][y]=false;
                if(i==0)
                    letters[x][y]="O ";
                else
                    letters[x][y]="X ";
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(letters[i][j]);
            }
            System.out.println();
        }
    }
}
