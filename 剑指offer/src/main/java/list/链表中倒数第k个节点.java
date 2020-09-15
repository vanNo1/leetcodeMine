package list;

/**
 * 不说了，傻子题
 */
public class 链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p=head;
        int index=0;
        while (p!=null){
            p=p.next;
            index++;
        }
        p=head;
        for (int i = 0; i < index-k; i++) {
            p=p.next;
        }
        return p;
    }
}
