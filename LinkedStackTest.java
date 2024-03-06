/**
 * 
 */
package towerofhanoi;

import java.util.EmptyStackException;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- nakyahv

/**
 * @author nakyahv
 * @version 03.01
 * 
 *
 */
public class LinkedStackTest extends student.TestCase {
    private LinkedStack<String> stack;

    /**
     * set up
     */
    public void setUp() {
        stack = new LinkedStack<String>();
    }


    /**
     * tests the size
     */
    public void testsize() {
        assertEquals(stack.size(), 0);
        stack.push("boo");
        assertEquals(stack.size(), 1);
        stack.push("pookie");
        assertEquals(stack.size(), 2);

    }


    /**
     * 
     */
    public void testClear() {
        stack.push("clear");
        stack.clear();
        assertEquals(stack.size(), 0);

    }


    /**
     * tests empty
     */
    public void testEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("bill");
        assertFalse(stack.isEmpty());
    }


    /**
     * tests peek
     */
    public void testPeek() {
        stack.push("peek");
        assertEquals(stack.peek(), "peek");
        stack.clear();
        assertTrue(stack.isEmpty());
        Exception exception = null;
        try {
            stack.peek();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("peek() is throwing the wrong type of exceptions",
            exception instanceof EmptyStackException);

    }


    /**
     * tests pop
     */
    public void testPop() {
        stack.push("hola");
        stack.push("pop");
        assertEquals(stack.pop(), "pop");

        stack.clear();
        assertTrue(stack.isEmpty());
        Exception exception = null;
        try {
            stack.pop();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("pop() is throwing the wrong type of exceptions",
            exception instanceof EmptyStackException);

    }


    /**
     * tests to string
     */
    public void testToString() {
        stack.push("back");
        stack.push("front");
        String s = ("[front, back]");
        assertEquals(stack.toString(), s);
    }
}
