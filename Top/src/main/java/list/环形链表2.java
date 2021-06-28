package list;

/**
 * @author Van
 * @date 2021/3/12 - 16:23
 * <p>
 * 快慢指针
 */
public class 环形链表2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
            // 这里一定要当心！！fast!=null&&fast.next!=null
        } while (fast != null && fast.next != null && fast != slow);
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
