package list;

import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 思路：反转该反转的部分（但是要记录这个区间的前与后一个节点，不然连接不了这个区间）
 * 其次，定位这个区间以及反转的次数也是要考虑的一点
 *
 * 用dummyHead的原因：因为要统一逻辑，dummyHead与最后的null都不可能会动，逻辑就是处理dummyHead与null中间区间部分的链表
 * 如果不用dummyHead，那么head节点很可能就会要求被动（有可能要对head节点进行反转操作）
 */
public class 反转链表2 {
   // 拿这个举例子： 1->2->3->4->5->NULL, m = 2, n = 4
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 测试用例有一个节点的情况，n与m都是1，这样的话后面的节点赋值会越界，所以这种情况直接return
        if (m==n)return dummyHead.next;
        ListNode pre = dummyHead;
        // 以上的例子中从2-4 开始反转，但是我要记录1的位置，所以先让pre走到1的位置
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        // prev指针就是这个区间的前一个节点
        ListNode prev = pre;
        // 定位好了prev指针再让pre指针指到正确的位置
        pre = pre.next;
        // 接着定位cur与next
        ListNode cur = pre.next;
        ListNode next = cur.next;
        // 这里要注意，我之前写的反转链表中：并没有用一个循环把链表全部反转完，我还留了一个，原因是如果全部用这个逻辑反转的话，那么最后一次反转的过程中next节点会越界
        // 因此这里也是留了一个，我并没有全部反转完
        for (int i = 0; i < n-m - 1; i++) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        // 到这里我再反转最后一次，此时区间内的所有节点被反转好了，但1.next->2   2.next->3
        cur.next = pre;
        // 这里是记录这个区间的后一个节点位置
        ListNode last = next;
        // 这里是把2.next指向5
        prev.next.next=last;
        // 把1.next指向4
        prev.next=cur;
        // 返回
        return dummyHead.next;
    }
}
