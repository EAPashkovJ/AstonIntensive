package SortingAlgoritms;

import Collections.CustomLinkedList;

import java.util.Comparator;

/**
 * Simply implementation Bubble sort
 * with generics and comparator
 */

public class BubbleSort {

    public static <T extends Comparable> int bubbleSort(CustomLinkedList<T> list, Comparator<T> comparator) {
        int count = 0;
        int k = 1;
        int j = list.size();
        while (k > 0) {
            k = 0;
            for (int i = 1; i < j; i++) {
                if (comparator.compare(list.get(i - 1), list.get(i)) > 0) {
                    T tmp = list.get(i);
                    list.set(i, list.get(i - 1));
                    list.set(i - 1, tmp);
                    k = i;
                }
                count++;
            }
            j = k;
        }
        return count;
    }
}