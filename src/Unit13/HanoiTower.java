package Unit13;

import java.awt.*;

public class HanoiTower {
    public int [][] grid;
    private int numOfDisks;
    private Canvas c;
    private final int pole1x = 200-10;
    private final int pole2x = 400-10;
    private final int pole3x = 600-10;
    private final int poleWidth = 20;
    private final int poleHeight = 600;
    private final int diskHeight = 50;
    public HanoiTower(int numberOfDisks, Canvas canvas){
        numOfDisks=numberOfDisks;
        grid = new int[numberOfDisks+1][3];
        c = canvas;
        for (int i = 0; i < numberOfDisks; i++) {
            grid[i+1][0] = i + 1;
        }
        draw();
    }

    public void draw(){
        c.pause(1000);
        c.erase();
        c.setInkColor(Color.white);
        c.drawFilledRectangle(pole1x,100,poleWidth,poleHeight);
        c.drawFilledRectangle(pole2x,100,poleWidth,poleHeight);
        c.drawFilledRectangle(pole3x,100,poleWidth,poleHeight);
        int i = grid.length-1;
        int width = 150/(i-1);
        Color[] colors = {Color.red, Color.orange, Color.yellow, Color.green, Color.cyan, Color.blue, Color.magenta};
        for (int j = 0; j < grid.length; j++) {
            for (int k = 0; k < grid[0].length; k++) {
                if(grid[j][k]!=0) {
                    c.setInkColor(colors[(grid[j][k]%7)]);
                    c.drawFilledRectangle(200 * (k+1) - (grid[j][k])*width / 2,  700 - grid.length * diskHeight+j*diskHeight, (grid[j][k])*width, diskHeight);
                }
            }
        }
    }

    public void solve(){
        this.solve(numOfDisks,0,1,2);
    }

    public void solve(int numberofDisks, int beginning, int middle, int end){

        if(numberofDisks==1){
            move(beginning,end);
        } else {
            solve(numberofDisks-1, beginning,end,middle);
            solve(1,beginning,middle,end);
            solve(numberofDisks-1, middle,beginning,end);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    public void move(int a, int b){
        int i;
        for (i = grid.length-1; i >=0; i--) {
            if(grid[i][a] == 0) break;
        }
        int j;
        for (j = grid.length-1; j >=0; j--) {
            if(grid[j][b] == 0) break;
        }
        i=i<(grid.length-1)?i+1:i;

        int tmp = grid[i][a];
        grid[i][a] = grid[j][b];
        grid[j][b] = tmp;
        draw();
    }
}
