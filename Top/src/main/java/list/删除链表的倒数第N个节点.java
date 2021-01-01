package list;

import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 思路：既然是遍历一遍，而且给了倒数第几个，那么删除的元素和最后一个元素的距离就是确定的
 * 所以总体思路是先让cur指针走，走了定长的长度之后再指定delete指针，后面让他们一起走，直到cur指针走到末端
 * 那么delete指针指到的位置就是要删除的元素的位置
 *
 *
 * 这里直接拿 1->2->3->4->5 举例子，直接考虑极端情况：要删除倒数第5个，也就是第一个节点。
 * 那么这里设置一个dummyHead，因为删除某一个节点，肯定是要操控到这个节点的前驱节点
 * 直接先让cur指针走5次，那么cur正好走到5的位置，接着设置preDelete指针指向dummyHead
 * 让preDelete和cur一起走,当cur走到最尾端（null 的前一个）的时候，那么要删除的那个节点就是preDelete的后驱节点
 * 那么删除掉这个节点，然后返回dummyHead.next 即可
 *
 * 如果不设置dummyHead，那假设要删除的节点就是第一个节点的话，会很麻烦，还要单独去考虑这种情况，设置了以后就能够做到统一了
 */
public class 删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        // 让cur走n次
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        // 走完n从开始设置preDelete节点
        ListNode preDelete = dummyHead;
        // 让preDelete和cur一起走，直到cur走到尾端（null的前一个）
        while (cur.next != null) {
            cur = cur.next;
            preDelete = preDelete.next;
        }
        // 那么此时要删除的节点就是preDelete节点的后面一个节点，把它删除即可
        preDelete.next = preDelete.next.next;
        // 然后返回dummyHead
        return dummyHead.next;
    }
}
