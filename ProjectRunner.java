/**
 * 
 */
package towerofhanoi;

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
public class ProjectRunner {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int disks = 6;

        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver solve = new HanoiSolver(disks);
        PuzzleWindow game = new PuzzleWindow(solve);
    }
}
