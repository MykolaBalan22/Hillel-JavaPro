package task2;

import org.junit.Assert;
import org.junit.Test;

public class ReverserTest {
    @Test
    public void reverseListTest(){
        ListNode inputList = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
        ListNode expected = new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(1,null))));
        ListNode actual = Reverser.reverseList(inputList);
        Assert.assertEquals(expected, actual);
    }
}
