
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Collections.CustomLinkedList;


public class CustomLinkedListTest {
    private CustomLinkedList<Integer> testList;

    @Before
    public void createNewCustomLinkedList() {
        testList = new CustomLinkedList<>();
    }


    @Test
    public void elementShouldBeAddInCollection() {
        testList.add(1);
        int result = testList.get(0);
        Assert.assertEquals(1, result);

    }

    @Test
    public void StringShouldBeAddInCollection() {
        CustomLinkedList<String> strList = new CustomLinkedList<>();
        strList.add("One");
        Assert.assertEquals("One", strList.get(0));
    }

    @Test
    public void elementShouldBeRemove() {
        testList.add(1);
        testList.remove(0);
        Assert.assertEquals(0, testList.size());
    }

    @Test
    public void GetShouldBeReturnElementByIndex() {
        testList.add(1);
        int result = testList.get(0);
        Assert.assertEquals(1, result);
    }

    @Test
    public void ElementShouldBeChangeByIndex() {
        testList.add(1);
        testList.set(0, 2);
        int result = testList.get(0);
        Assert.assertEquals(2, result);
    }

}
