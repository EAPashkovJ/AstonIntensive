package SortingAlgoritms;

import Collections.CustomLinkedList;


/**
 * QuickSort implementation with generic types
 */

public class QuickSort {
    public static <T extends Comparable<? super T>> void sort(CustomLinkedList<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<? super T>> void quickSort(CustomLinkedList<T> array, int left, int right) {
        if (left >= right) {
            return;
        }

        int q = partition(array, left, right);
        quickSort(array, left, q - 1);
        quickSort(array, q + 1, right);
    }

    /**
     * Divide array into two subarray
     *
     * @param array input array
     * @param first index of element
     * @param last  index of element
     */
    private static <T extends Comparable<? super T>> int partition(
            CustomLinkedList<T> array, int first, int last) {
        T key = array.get(last);
        int smaller = first - 1;
        for (int test = first; test < last; test++) {
            if (array.get(test).compareTo(key) <= 0) {
                smaller++;
                swap(smaller, test, array);
            }
        }
        smaller++;
        swap(last, smaller, array);
        return smaller;
    }

    /**
     * Method swap() exchange elements of list
     *
     * @param j    first element to exchange
     * @param i    second element exchange
     * @param list changeable list
     */
    private static <T extends Comparable<? super T>> void swap(int j, int i, CustomLinkedList<T> list) {
        T temp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, temp);
    }

}