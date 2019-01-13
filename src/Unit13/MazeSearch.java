package Unit13;

import java.awt.*;

public class MazeSearch {
    public static void main(String[] args) {
        Canvas c = new Canvas("Maze",1250,750, Color.white);
        c.setVisible(true);
        c.setInkColor(Color.black);
        Maze labyrinth = new Maze(13,8,c);

        System.out.println(labyrinth);

        int l, h;
        int[][] grid = labyrinth.getGrid();
        l = 50;//800/grid.length;
        h = 50;//1300/grid[0].length;
        int size = 50;
        if(labyrinth.traverse(0,0,c,50))
            System.out.println("The maze was successfully solved!");
        else
            System.out.println("there is no possible path.");

        System.out.println(labyrinth);

    }
}
