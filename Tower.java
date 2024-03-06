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
public class Tower extends LinkedStack<Disk> {
    private Position position;

    /**
     * @param position
     *            consrtuctor
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }


    /**
     * @return Position position
     *         the position of the tower
     */
    public Position position() {

        return position;

    }


    /**
     * @param disk
     *            adds a new disk
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {

            super.push(disk);
        }
        else if (peek().compareTo(disk) > 0) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }

    }

}
