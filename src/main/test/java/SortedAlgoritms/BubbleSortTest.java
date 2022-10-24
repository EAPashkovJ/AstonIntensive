package SortedAlgoritms;

import Collections.CustomLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
public class BubbleSortTest {


    private CustomLinkedList<String> testList;
    private CustomLinkedList<String> expectList;
    @BeforeEach
    public void createNewCustomLinkedList() {
        testList = new CustomLinkedList<>();
        expectList = new CustomLinkedList<>();
    }
    @Test
    public void BubbleSortShouldReturnSortedCollectionByComparator() {
        // fill the tested List
        testList.add("E");
        testList.add("D");
        testList.add("C");
        testList.add("B");
        testList.add("A");
        // fill the expected List
        expectList.add("A");
        expectList.add("B");
        expectList.add("C");
        expectList.add("D");
        expectList.add("E");

        testList.bSort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Assertions.assertArrayEquals(expectList.toArray(), testList.toArray());
    }
}
