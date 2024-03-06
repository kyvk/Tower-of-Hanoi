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

public class HanoiSolverTest extends student.TestCase {
    private HanoiSolver test;
    private Disk disk1;
    private Disk disk2;
    private Disk disk3;

    /**
     * set up
     */
    public void setUp() {
        test = new HanoiSolver(3);
        disk1 = new Disk(1);
        disk2 = new Disk(2);
        disk3 = new Disk(3);

    }


    /**
     * returns number of disks
     */
    public void testDisks() {
        assertEquals(test.disks(), 3);
        assertNotSame(test.disks(), 2);
    }


    /**
     * tests tower pos
     */
    public void testGetTower() {
        assertEquals(test.getTower(Position.MIDDLE).position(),
            Position.MIDDLE);
        assertEquals(test.getTower(Position.DEFAULT).position(),
            Position.MIDDLE);
        assertEquals(test.getTower(Position.LEFT).position(), Position.LEFT);
        assertEquals(test.getTower(Position.RIGHT).position(), Position.RIGHT);
    }


    /**
     * test to string
     */
    public void testToString() {
        test.getTower(Position.LEFT).push(disk1);
        test.getTower(Position.MIDDLE).push(disk2);
        test.getTower(Position.RIGHT).push(disk3);
        assertTrue(test.toString().equals("[1][2][3]"));
    }


    /**
     * tests solve
     */
    public void testSolve() {
        test.getTower(Position.LEFT).push(disk3);
        test.getTower(Position.LEFT).push(disk2);
        test.getTower(Position.LEFT).push(disk1);
        test.solve();
        String s = "[][][1, 2, 3]";
        assertEquals(test.toString(), s);
        // assertTrue(test.toString().equals("[]2][1, 2, 3]"));
        // assertTrue((test.getTower(Position.RIGHT).size()==3));
    }
}
