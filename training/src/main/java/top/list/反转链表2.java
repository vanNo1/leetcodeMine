package top.list;

import structure.ListNode;

/**
 * @author Van
 * @date 2021/2/13 - 14:57
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 这里用递归来算
 * 这个为例子：输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 我要得到1，记为preStart，5记为afterEnd
 */
public class 反转链表2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode preStart = dummyHead;
        ListNode afterEnd = dummyHead;
        // 先找到点的位置
        for (int i = 0; i < n + 1; i++) {
            afterEnd = afterEnd.next;
            if (i < m - 1) {
                preStart = preStart.next;
            }
        }
        // 记录好start位置
        ListNode start = preStart.next;
        // 接下来处理两端
        ListNode changedStart = recurse(start, start.next, afterEnd);
        preStart.next = changedStart;
        start.next=afterEnd;
        return dummyHead.next;
    }

    public ListNode recurse(ListNode pre, ListNode cur, ListNode end) {
        if (cur == end) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return recurse(cur, next, end);
    }
}
