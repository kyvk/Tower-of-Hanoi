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
 *
 */
public class DiskTest extends student.TestCase {
    private Disk disk;
    private Disk other;

    /**
     * set up
     */
    public void setUp() {
        disk = new Disk(3);
        other = new Disk(2);
    }


    /**
     * tests compare to method
     */
    public void testCompareTo() {

        Exception thrown = new IllegalArgumentException();
        try {
            other.compareTo(null);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IllegalArgumentException);

        assertEquals(disk.compareTo(other), 1);
        Disk test = new Disk(4);

        assertEquals(disk.compareTo(test), -1);
        Disk test2 = new Disk(3);
        assertEquals(disk.compareTo(test2), 0);
    }


    /**
     * testing toString method
     */
    public void testToString() {
        String test = "3";
        assertEquals(disk.toString(), test);
        assertNotSame(disk.toString(), "2");
        assertNotSame(disk.toString(), null);
    }


    /**
     * testing equals method
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {
        assertEquals(disk, disk);
        assertFalse(disk.equals(other));
        assertFalse(disk.equals(null));
        assertTrue(disk.getClass().equals(other.getClass()));
        assertFalse(disk.equals("boo"));
        assertNotSame(disk.getWidth(), other.getWidth());
        Disk test2 = new Disk(3);
        assertEquals(test2.getWidth(), disk.getWidth());
        assertNotSame(test2.getWidth(), other.getWidth());
        assertTrue(disk.getClass().equals(other.getClass()));

        assertFalse(disk.equals(other));
        assertTrue(disk.equals(test2));
    }
}
