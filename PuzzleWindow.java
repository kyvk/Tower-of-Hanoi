/**
 * 
 */
package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- nakyahv

/**
 * @author nakyahv
 * @version 03.15
 *
 */
@SuppressWarnings("deprecation")
public class PuzzleWindow implements Observer {
    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;
    public static final int WIDTH_FACTOR = 9;
    public static final int DISK_GAP = 0;
    public static final int DISK_HEIGHT = 10;

    /**
     * sleep
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * @param position
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole = right;

        if (position == Position.LEFT) {
            currentPole = left;
        }
        if (position == Position.MIDDLE) {
            currentPole = middle;
        }
        if (position == Position.RIGHT) {
            currentPole = right;
        }
        int x = currentPole.getX() + currentPole.getWidth() / 2 - currentDisk
            .getWidth() / 2;

        int y = currentPole.getY() + currentPole.getHeight() - game.getTower(
            position).size() * (DISK_GAP + DISK_HEIGHT);

        currentDisk.moveTo(x, y);

    }


    /**
     * @param game
     */
    @SuppressWarnings("deprecation")
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window();
        window.setTitle("Tower of Hanoi");

        int x = window.getGraphPanelWidth();
        int y = window.getGraphPanelHeight() / 2;

        left = new Shape(x / 6, y, 3, 90, Color.BLUE);
        middle = new Shape(x / 3, y, 3, 90, Color.PINK);
        right = new Shape(x / 2, y, 3, 90, Color.GREEN);

        for (int i = game.disks(); i >= 1; i--) {
            Disk disk = new Disk(i * WIDTH_FACTOR);
            window.addShape(disk);
            game.getTower(Position.LEFT).push(disk);
            moveDisk(Position.LEFT);
        }
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        Button solve = new Button("Solve");
        solve.onClick(this, "clickedSolve");
        window.addButton(solve, WindowSide.NORTH);
    }


    /**
     * @param button
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * updates
     */
    @Override
    public void update(
        @SuppressWarnings("deprecation") Observable o,
        Object arg) {
        if (arg.getClass().equals(Position.class)) {
            Position pos = (Position)arg;
            moveDisk(pos);
            sleep();
        }

    }

}
