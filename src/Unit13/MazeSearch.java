package Unit13;

import java.awt.*;

public class MazeSearch {
    public static void main(String[] args) {
        Maze labyrinth = new Maze();

        System.out.println(labyrinth);

        if(labyrinth.traverse(0,0))
            System.out.println("The maze was successfully solved!");
        else
            System.out.println("there is no possible path.");

        System.out.println(labyrinth);

        //now some graphics
        int l, h;
        Canvas c = new Canvas("Maze",1300,800, Color.BLACK);
        c.setVisible(true);
        int[][] grid = labyrinth.getGrid();
        l = 800/grid.length;
        h = 1300/grid[0].length;
        int size = 50;
        c.setInkColor(Color.WHITE);
//        for (int row = 0; row < grid.length; row++) {
//            c.drawLine(0,size*row, 1300,size*row);
//        }
//        for (int col = 0; col < grid[0].length; col++) {
//            c.drawLine(size*col,0,size*col, 800);
//        }
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int t = grid[row][col];
                if (t == 0) {
                    c.setInkColor(Color.white);
                } else if (t == 7) {
                    c.setInkColor(Color.blue);
                } else if (t == 3) {
                    c.setInkColor(Color.RED);
                } else if (t == 1) {
                    c.setInkColor(Color.black);
                }
                c.drawFilledRectangle(col * l, row * h, l, h);
            }
        }
    }
}
