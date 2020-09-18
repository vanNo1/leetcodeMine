package list;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 记住是让mid不等于null，而且对rear向下走的时候要判断是否它已经是null了
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        //它会传入一个空的head
        if (head==null){
            return head;
        }
        ListNode pre=null;
        ListNode mid=head;
        ListNode rear=head.next;
        while (mid!=null){
            mid.next=pre;
            pre=mid;
            mid=rear;
            if (rear!=null){
                rear=rear.next;
            }
        }
        return pre;

    }
}
