
import Collections.CustomLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CustomLinkedListTest {
    private CustomLinkedList<Integer> testList;

    @BeforeEach
    public void createNewCustomLinkedList() {
        testList = new CustomLinkedList<>();
    }


    @Test
    public void elementShouldBeAddInCollection() {
        testList.add(1);
        int result = testList.get(0);
        Assertions.assertEquals(1, result);

    }

    @Test
    public void StringShouldBeAddInCollection() {
        CustomLinkedList<String> strList = new CustomLinkedList<>();
        strList.add("One");
        Assertions.assertEquals("One", strList.get(0));
    }

    @Test
    public void elementShouldBeRemove() {
        testList.add(1);
        testList.remove(0);
        Assertions.assertEquals(0, testList.size());
    }

    @Test
    public void GetShouldBeReturnElementByIndex() {
        testList.add(1);
        int result = testList.get(0);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void ElementShouldBeChangeByIndex() {
        testList.add(1);
        testList.set(0, 2);
        int result = testList.get(0);
        Assertions.assertEquals(2, result);
    }
//    @Test( = IllegalArgumentException.class)
//    public void GetElementShouldTrowExceptionWhenIndexOverTheList(){
//            testList.add(1);
//            testList.get(1);

        @Test
        public void GetElementShouldTrowExceptionWhenIndexOverTheList() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                Integer.parseInt("1a");
            });

            String expectedMessage = "For input string";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

