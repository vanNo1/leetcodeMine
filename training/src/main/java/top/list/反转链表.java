package top.list;

import structure.ListNode;

/**
 * @author Van
 * @date 2021/2/13 - 11:05
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        return recurse(null, head);
    }

    public ListNode recurse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return recurse(cur, next);
    }
}
