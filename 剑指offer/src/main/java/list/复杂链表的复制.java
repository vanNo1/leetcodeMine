package list;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 总的来说，复制这个List就是把List在Map中创建一遍，然后再把这些node串起来
 */
public class 复杂链表的复制 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
        public Node copyRandomList(Node head) {
            Map<Node,Node>map=new HashMap<>();
            for (Node cur=head;cur!=null;cur=cur.next){
                map.put(cur,new Node(cur.val));
            }
            for (Node cur=head;cur!=null;cur=cur.next){
                map.get(cur).next=map.get(cur.next);
                map.get(cur).random=map.get(cur.random);
            }
            return map.get(head);

        }
}
