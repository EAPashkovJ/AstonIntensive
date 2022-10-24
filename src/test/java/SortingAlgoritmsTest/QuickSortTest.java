package SortingAlgoritmsTest;

import Collections.CustomLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class QuickSortTest {
    private CustomLinkedList<Integer> testList;
    private CustomLinkedList<Integer> expectList;

    @BeforeEach
    public void createNewCustomLinkedList() {
        testList = new CustomLinkedList<>();
        expectList = new CustomLinkedList<>();
    }

    @Test
    public void QuickSortShouldReturnSortedCollection() {
        // fill the tested List
        testList.add(5);
        testList.add(4);
        testList.add(3);
        testList.add(2);
        testList.add(1);
        // fill the expected List
        expectList.add(1);
        expectList.add(2);
        expectList.add(3);
        expectList.add(4);
        expectList.add(5);
        // sort tested List
        testList.qsort();

        Assertions.assertArrayEquals(expectList.toArray(), expectList.toArray());
    }
}
