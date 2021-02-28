package top.list;

import structure.ListNode;

/**
 * @author Van
 * @date 2021/2/13 - 15:22
 */
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recurse(l1, l2, 0);
    }

    public ListNode recurse(ListNode l1, ListNode l2, int sign) {
        if (l1 == null && l2 == null && sign == 0) {
            return null;
        }
        int value1 = l1 == null ? 0 : l1.val;
        int value2 = l2 == null ? 0 : l2.val;
        int sum = value1 + value2 + sign;
        sign = sum / 10;
        ListNode node = new ListNode(sum % 10);
        node.next = recurse(l1 == null ? l1 : l1.next, l2 == null ? l2 : l2.next, sign);
        return node;
    }
}
