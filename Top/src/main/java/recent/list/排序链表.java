package recent.list;

import list.ListNode;

/**
 * @author Van
 * @date 2021/3/2 - 9:58
 *
 *
 * 题解：利用归并排序!!
 * https://leetcode-cn.com/problems/sort-list/solution/pai-xu-lian-biao-di-gui-die-dai-xiang-jie-by-cherr/
 */
public class 排序链表 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        //目的是让奇数个的时候slow正好在中间的位置，偶数个的时候slow正好在中间偏左的位置
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }
}
