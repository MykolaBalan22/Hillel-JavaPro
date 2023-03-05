package task2;

public class Reverser {
    public static ListNode reverseList(ListNode head) {
        ListNode nextNode = head;
        ListNode newNode = null;
        while (nextNode != null) {
            newNode = new ListNode(nextNode.val, newNode);
            nextNode = nextNode.next;
        }
        return newNode;
    }
}
