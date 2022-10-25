package Collections;


import SortingAlgoritms.BubbleSort;
import SortingAlgoritms.QuickSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.Comparator;

/**
 * Implementation singly linked list with standard methods:
 * size()
 * add()
 * get()
 * isEmpty()
 * set()
 * remove()
 * sort()
 * qSort()
 * toString()
 */
public class CustomLinkedList<T extends Comparable> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomLinkedList.class);
    private static final Marker EXCEPTIONS_MARKER = MarkerFactory.getMarker("EXCEPTIONS");
    private Node<T> head; // first element of list
    private int size; // size of list elements


    /**
     * @return amount of elements in list
     */
    public int size() {
        return size;
    }

    /**
     * Add new element in List
     *
     * @param value element added to List
     * @throws IllegalArgumentException return if trying to add NULL in collection
     */

    public void add(T value) {
        try {
            if (value == null) {
                LOGGER.error(EXCEPTIONS_MARKER, "Cannot add null to List");
                throw new IllegalArgumentException("Trying null add to List ");
            }

            if (head == null) {
                this.head = new Node<>(value);
            } else {
                Node<T> tmp = head;
                while (tmp.getNext() != null) {
                    tmp = tmp.getNext();
                }
                tmp.setNext(new Node<>(value));
            }
            size++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * return element of input index
     *
     * @param index index of element
     * @throws IllegalArgumentException throw exception if index over list size
     */
    public T get(int index) {
        int currentIndex = 0;
        Node<T> tmp = head;

        while (tmp != null) {
            if (currentIndex == index) {
                return tmp.getValue();
            } else {
                tmp = tmp.getNext();
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * Check for absence elements in collection
     *
     * @return TRUE if collection is Empty
     * and FALSE if not
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Replace an element in the collection with a new
     *
     * @param index   index of element to be replaced
     * @param element new element for input
     * @throws return exception when input index out of bound
     */
    public T set(int index, T element) {

        try {
            if (index > this.size) {
                LOGGER.error(EXCEPTIONS_MARKER, "Index out of bound");
                throw new IndexOutOfBoundsException("Cannot reached index");
            }
            int i = -1;
            if (isEmpty()) {
                add(element);
                return null;
            }
            if (index < 0 || index > size()) {
                return null;
            }
            Node<T> p = head;
            T o;
            while (p != null) {
                i++;
                if (i == index) {
                    o = p.value;
                    p.value = element;
                    return o;
                }
                p = p.next;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * remove element of input index
     *
     * @param index index of element required to remove
     * @throws return exception when removed index out of bound
     */
    public void remove(int index) {

        try {
            if (index > this.size) {
                LOGGER.error(EXCEPTIONS_MARKER, "Index out of bound");
                throw new IndexOutOfBoundsException("Index has not been removed. Cannot reached to index");
            }
            // remove 0 element in list
            if (index == 0) {
                head = head.getNext();
                size--;
                return;
            }
            int currentIndex = 0;
            Node<T> tmp = head;

            while (tmp != null) {
                if (currentIndex == index - 1) {
                    tmp.setNext(tmp.getNext().getNext());
                    size--;
                    return;
                } else {
                    tmp = tmp.getNext();
                    currentIndex++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Override standard method Object.Class
     * to interpreted linkedList in console
     *
     * @return list of elements
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> current = head;
        while (current.getNext() != null) {
            result.append(current.value);
            result.append(", ");
            current = current.getNext();
        }
        result.append(current.value);
        return " [" + result + "] ";
    }


    /**
     * Implementation of Bubble Sort
     * Only with Comparator use
     * In default apply Natural ordering
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void bSort(Comparator<T> comparator) {
        CustomLinkedList list = this;
        BubbleSort.bubbleSort(list, comparator);
    }

    /**
     * Implementation of Quick sort.
     * For compare Objects use implementation  Comparable <T>
     * in class of Object
     */

    @SuppressWarnings({"unchecked"})
    public void qsort() {
        CustomLinkedList<T> customLinkedList = this;
        QuickSort.sort(customLinkedList);
    }

    /**
     * Transforms input list to Array
     *
     * @return new array
     */
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (CustomLinkedList.Node<T> x = head; x != null; x = x.next)
            result[i++] = x.value;
        return result;
    }

    /**
     * inner class Node
     *
     * @param <E> input generic parameter
     */
    private static class Node<E> {

        private E value; // value added in List
        private Node<E> next; // next node of List

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
