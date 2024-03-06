/**
 * 
 */
package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- nakyahv

/**
 * @author nakyahv
 * @version 03.01
 *          s
 * @param <T>
 */
public class LinkedStack<T> implements StackInterface<T> {
    private int size;
    private Node<T> topNode;

    /**
     * constructor
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }


    /**
     * @return int
     *         size
     */
    public int size() {
        return size;
    }


    /**
     * clears
     */
    @Override
    public void clear() {
        topNode = null;
        size = 0;
    }


    /**
     * @return boolean
     *         is empty
     */
    @Override
    public boolean isEmpty() {

        return size == 0;
    }


    /**
     * @returns top node data
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return topNode.data;
    }


    /**
     * @return the element removed
     */
    @Override
    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();

        }

        T pop = peek();

        topNode = topNode.next;

        // topNode = null;

        size--;
        return pop;
    }


    /**
     * adds another element
     */
    @Override
    public void push(T anEntry) {
        Node<T> newNode = new Node<T>(anEntry, topNode);
        topNode = newNode;
        size++;

    }


    /**
     * @param anEntry
     * @return a string
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        Node<T> p = topNode;
        while (p != null) {
            if (s.length() > 1) {
                s.append(", ");
            }
            s.append(p.getData());
            p = p.getNextNode();
        }
        s.append("]");
        return s.toString();

    }

    /**
     * @author nakyah
     * @version 03.15
     *
     */
    private static final class Node<T> {
        private Node<T> next;
        private T data;

        /**
         * @param entry
         * @param node
         */
        public Node(T entry, Node<T> node) {
            this(entry);
            this.setNextNode(node);
        }


        /**
         * @param node
         */
        public void setNextNode(Node<T> node) {
            this.next = node;

        }


        /**
         * @param data
         */
        public Node(T data) {
            this.data = data;
        }


        public T getData() {
            return data;
        }


        /**
         * @return
         */
        public Node<T> getNextNode() {

            return next;
        }

    }

}
