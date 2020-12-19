package list;

import java.lang.management.LockInfo;

/**
 * @author Van
 * @date 2020/12/19 - 19:21
 * 普通方式：
 * 三个指针
 */
public class 反转链表1 {
    public ListNode reverseList(ListNode head) {
        // 这个测试用例会出现head==null情况
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        // 这个是重点，一开始我让cur！=next，但最后一次处理完cur.next=pre的时候，跳跃的时候：next=next.next这里会报错
        // 这里要让最后一次处理完，但不要跳跃，总结了一下选择了让next！=null，也就是最后一次还没有处理，就让他退出循环
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        // 由于我最后一次没有处理，所以现在去处理一下
        cur.next = pre;
        return cur;
    }
}
