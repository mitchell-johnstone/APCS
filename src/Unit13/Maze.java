package Unit13;

import java.awt.*;
import java.util.Random;

public class Maze {
    private final int TRIED = 3;
    private final int PATH = 7;
    private int l = 13;
    private int h = 8;
    int [][] grid;
    public Maze(int l, int h){
        this.l = l;
        this.h = h;
        grid = new int[h *2-1][l*2-1];
        for (int i = 0; i < h * 2 - 1; i++) {
            for (int j = 0; j < l * 2 - 1; j++) {
                grid[i][j]=2;
            }
        }
        for (int i = 1; i < h *2-1; i+=2) {
            for (int j = 0; j < l * 2-1; j++) {
                grid[i][j] = 0;
            }
        }
        for (int i = 0; i < h *2-1; i++) {
            for (int j = 1; j < l*2-1; j+=2) {
                grid[i][j] = 0;
            }
        }
        grid[0][0]=1;
        Random r = new Random();
        make(0,0,r.nextInt(2)==0?0:4);
    }
    public Maze(){
        this(13,8);
    }

    public void make(int row, int col, int dir){
//        System.out.println(row);
//        System.out.println(col);
        boolean c = false;
        if(row==0){
            if(col==0){
                if(grid[row+2][col] + grid[row][col+2]==2){
                    c = true;
                }
            } else if(col == grid[0].length-1){
                if(grid[row+2][col] + grid[row][col-2]==2){
                    c = true;
                }
            } else {
                if(grid[row+2][col] + grid[row][col-2] + grid[row][col+2]==3){
                    c = true;
                }
            }
        } else if (row == grid.length-1){
            if(col==0){
                if(grid[row-2][col] + grid[row][col+2]==2){
                    c = true;
                }
            } else if(col == grid[0].length-1){
                if(grid[row-2][col] + grid[row][col-2]==2){
                    c = true;
                }
            } else {
                if(grid[row-2][col] + grid[row][col-2] + grid[row][col+2]==3){
                    c = true;
                }
            }
        } else if (col == 0){
            if(grid[row+2][col]+ grid[row-2][col] + grid[row][col+2]==3)
                c = true;
        } else if (col == grid[0].length-1) {
            if(grid[row+2][col]+ grid[row-2][col] + grid[row][col-2]==3)
                c = true;
        }else{
            if(grid[row+2][col] + grid[row-2][col]+ grid[row][col+2]+ grid[row][col-2] == 4){
                c = true;
            }
        }
        if(!c) {
            Random r = new Random();
            int[] order = {0, 1, 2, 3};
            for (int i = 3; i > 0; i--) {
                int t = r.nextInt(i);
                int tmp = order[i];
                order[i] = order[t];
                order[t] = tmp;
            }
            for (int k = 0; k < order.length; k++) {
                int i = order[k];
                if (i == dir) {
                } else if (i == 0) {
                    if (valid2(row + 2, col) && grid[row + 2][col] == 2) {
                        grid[row + 1][col] = 1;
                        grid[row + 2][col] = 1;
                        this.make(row + 2, col, 2);
                    }
                } else if (i == 1) {
                    if (valid2(row, col + 2) && grid[row][col + 2] == 2) {
                        grid[row][col + 1] = 1;
                        grid[row][col + 2] = 1;
                        this.make(row, col + 2, 3);
                    }
                } else if (i == 2) {
                    if (valid2(row - 2, col) && grid[row - 2][col] == 2) {
                        grid[row - 1][col] = 1;
                        grid[row - 2][col] = 1;
                        this.make(row - 2, col, 0);
                    }
                } else if (i == 3) {
                    if (valid2(row, col - 2) && grid[row][col - 2] == 2) {
                        grid[row][col - 1] = 1;
                        grid[row][col - 2] = 1;
                        this.make(row, col - 2, 2);
                    }
                }
            }
        }
    }

    public boolean traverse (int row, int col, Canvas c, int size){
        boolean done = false;
        if(valid(row, col)){
            grid[row][col] = TRIED;
            c.setInkColor(Color.red);
            c.drawFilledRectangle(col*size, row*size, size,size);
            c.pause(100);
            if(row == grid.length-1 && col == grid[0].length-1)
                done = true;
            else {
                Random r = new Random();
                int[] order = {0,1,2,3};
                for (int i = 3; i >0 ; i--) {
                    int t = r.nextInt(i);
                    int tmp = order[i];
                    order[i] = order[t];
                    order[t] = tmp;
                }
                for (int k = 0; k < order.length; k++) {
                    int i = order[k];
                    if(!done){
                        if(i == 0){
                          done = traverse(row+1, col,c,size);
                        } else if(i == 1){
                            done = traverse(row, col+1,c,size);
                        } else if(i == 2){
                            done = traverse(row-1, col,c,size);
                        } else if(i == 3){
                            done = traverse(row, col-1,c,size);
                        }
                    }
                }
            }
            if(done) {
                grid[row][col] = PATH;
                c.setInkColor(Color.blue);
                c.drawFilledRectangle(col*size, row*size, size,size);
                c.pause(100);
            }
        }
        return done;
    }

    private boolean valid2 (int row, int col){
        boolean result = false;

        if(row>=0 && row<grid.length&& col >= 0 && col < grid[row].length)
            if(grid[row][col] == 2)
                result = true;
        return result;
    }

    private boolean valid (int row, int col){
        boolean result = false;

        if(row>=0 && row<grid.length&& col >= 0 && col < grid[row].length)
            if(grid[row][col] == 1)
                result = true;
        return result;
    }

    public String toString() {
        String result = "\n";
        for(int row = 0; row<grid.length; row++){
            for (int col = 0; col < grid[0].length; col++) {
                result += grid[row][col] +" ";
            }
            result += "\n";
        }
        return result;
    }

    public int[][] getGrid(){
        return grid;
    }
}
