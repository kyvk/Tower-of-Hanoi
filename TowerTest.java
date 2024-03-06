/**
 * 
 */
package towerofhanoi;

/// Virginia Tech Honor Code Pledge:
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
public class TowerTest extends student.TestCase {
    private Tower test;

    /**
     *
     */
    public void setUp() {
        test = new Tower(Position.MIDDLE);
    }


    /**
     * 
     */
    public void testPosition() {
        assertEquals(test.position(), Position.MIDDLE);
    }


    /**
     * 
     */
    public void testPush() {
        Disk disk = new Disk(1);
        Disk disk2 = new Disk(3);
        Disk disk3 = new Disk(0);
        Disk disk4 = new Disk(4);
        // tests illegal argument
        Exception thrown1 = null;
        try {
            test.push(null);
        }
        catch (Exception exception) {
            thrown1 = exception;
        }
        assertTrue(thrown1 instanceof IllegalArgumentException);
        // tests illegal state
        test.clear();

        test.push(disk2);
        Exception thrown = null;
        try {
            test.push(disk4);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof IllegalStateException);
        // comparison
        assertEquals(disk.compareTo(disk3), 1); // disk>disk3 returns 1

        test.clear(); // clears stack
        test.push(disk2); // tests empty stack if statement
        assertEquals(test.size(), 1);

        assertEquals(test.peek().compareTo(disk), 1);
        test.push(disk);

    }

}
