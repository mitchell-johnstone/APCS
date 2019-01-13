package Unit13;

import java.awt.*;

public class TowerTester {
    public static void main(String[] args) {
        Canvas c = new Canvas("HanoiTower", 800,800, Color.BLACK);
        c.setVisible(true);
        HanoiTower tower = new HanoiTower(9, c);
        tower.solve();
    }
}
