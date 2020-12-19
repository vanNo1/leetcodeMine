package list;

import java.util.List;

/**
 * @author Van
 * @date 2020/12/19 - 19:31
 */
public class 反转链表递归 {
    public ListNode reverseList(ListNode head) {
        return recurse(null, head);
    }

    // mean:将cur整个链表反向到pre链表，相当于我先反一个，然后再调这个函数，直到cur返完为止
    public ListNode recurse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return recurse(cur, next);
    }
}
