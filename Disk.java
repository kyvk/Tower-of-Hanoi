/**
 * 
 */
package towerofhanoi;

import java.awt.Color;
import cs2.Shape;
import student.TestableRandom;
// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- nakyahv

/**
 * @author nakyahv
 * @version 3.1
 *
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * @param width
     *            constructor
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom generator = new TestableRandom();
        int random = generator.nextInt(256);
        Color background = new Color(random, random, random);
        super.setBackgroundColor(background);

    }


    /**
     * @param otherDisk
     *            disk disk is being compared to
     * @return which disk is bigger via int
     *         negative if this>other
     */
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        else if (otherDisk.getWidth() > this.getWidth()) {
            return -1;
        }
        else if (this.getWidth() > otherDisk.getWidth()) {
            return 1;
        }
        else {
            return 0;
        }

    }


    /**
     * @return the width of the disk in a string
     */
    public String toString() {
        String width = "" + this.getWidth();
        return width;

    }


    /**
     * @param obj
     *            object its being compared to
     * @return true if equal
     */
    public boolean equals(Object obj) {
        // Implement this method

// same instance
        if (obj == this) {
            return true;
        }

        // null
        if (obj == null) {
            return false;
        }

        // same class
        if (this.getClass() == obj.getClass()) { // checks class
            Disk other = (Disk)obj;

            return (getWidth() == other.getWidth());

        }
        return false;

    }

}
