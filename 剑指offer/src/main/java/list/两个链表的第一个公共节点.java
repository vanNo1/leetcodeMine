package list;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 如下面的两个链表：
 * ------------
 *              ---
 *                  (-)-----------
 *              ---
 * -------------
 *
 *
 * 我们使用两个指针 node1，node2 分别指向两个链表 headA，headB 的头结点，然后同时分别逐结点遍历，当 node1 到达链表 headA 的末尾时，重新定位到链表 headB 的头结点；当 node2 到达链表 headB 的末尾时，重新定位到链表 headA 的头结点。
 *
 * 这样，当它们相遇时，所指向的结点就是第一个公共结点。
 *
 * 作者：z1m
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/shuang-zhi-zhen-fa-lang-man-xiang-yu-by-ml-zimingm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 * 但这题我是用hashMap做的
 */
public class 两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode>set=new HashSet<>();
        while (headA!=null){
            set.add(headA);
            headA=headA.next;
        }
        while (headB!=null){
            if (!set.add(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }
}
