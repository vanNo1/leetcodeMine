package recent.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Van
 * @date 2021/2/27 - 10:34
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * <p>
 * 最关键的一点就是map  map《oldNode，newNode》，去遍历oldNode然后给newNode设置random和next关系
 *
 */
public class 复制带随机指针的链表 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        // 第一趟把newNode搞出来
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        //这里再让cur等于head，来进行下面的遍历
        cur = head;
        // 第二趟设置关系
        while (cur != null) {
            Node curNode = map.get(cur);
            // 一定要小心，random==null的情况，一定要特殊处理，map中的key和value都不能为null的
            Node randomNode = cur.random == null ? null : map.get(cur.random);
            // 和random一样，next==null的情况，也要特殊处理
            Node nextNode = cur.next == null ? null : map.get(cur.next);
            curNode.next = nextNode;
            curNode.random = randomNode;
            cur = cur.next;
        }
        return map.get(head);
    }
}
