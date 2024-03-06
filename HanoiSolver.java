/**
 * 
 */
package towerofhanoi;

import java.util.Observable;

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
public class HanoiSolver extends Observable {
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    /**
     * @param numDisks
     *            constructor
     */
    public HanoiSolver(int numDisks) {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);

    }


    /**
     * @return number of disks
     */
    public int disks() {
        return numDisks;
    }


    /**
     * @param pos
     *            position of the tower
     * @return tower position
     */
    public Tower getTower(Position pos) {
        Tower getTower = new Tower(Position.DEFAULT);
        if (pos == Position.DEFAULT || pos == Position.MIDDLE) {
            getTower = middle;
        }
        if (pos == Position.LEFT) {
            getTower = left;
        }
        if (pos == Position.RIGHT) {
            getTower = right;
        }
        return getTower;
    }


    /**
     * @return s
     *         return left , middle, and right, as strings w disk width
     */
    public String toString() {
        String s = "";
        s = s + left.toString();
        s = s + middle.toString();
        s = s + right.toString();

        return s;
    }


    /**
     * @param source
     * @param destination
     * 
     *            moves the disks
     */
    private void move(Tower source, Tower destination) {
        Disk pop = source.pop();
        destination.push(pop);
        setChanged();
        notifyObservers(destination.position());

    }


    /**
     * @param currentDisks
     * @param startPole
     * @param tempPole
     * @param endPole
     * 
     *            private solve tower method
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * solves the tower
     */
    public void solve() {
        solveTowers(numDisks, left, middle, right);
    }

}
