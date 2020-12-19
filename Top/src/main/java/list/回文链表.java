package list;

import com.sun.org.apache.bcel.internal.generic.FADD;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 思路：把链表后面那一部分给反转，然后再去判断两部分的链表是否相等
 * 坑：会有死循环
 */
public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        // 测试用例有病：会出一个head==null的，而且head==null返回true
        if (head == null) {
            return true;
        }
        // 这里利用快慢指针来找到中间元素，如果是基数个，那么slow对应的是中间那个，如果是偶数个，那么slow对应的是第length/2+1个，也就是说假如有4个元素，那么slow指向的是第3个元素
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 坑1：如果只有两个元素，那么ListNode next搞出来会越界. 只要length>2都行
        // 所以，如果这里只有两个元素的话，我直接判断这两个元素的值是否相等即可
        if (slow.next == null) {
            return head.val == slow.val;
        }
        // 直接用反转链表这一套，把这三个ListNode定位好
        ListNode pre = slow;
        ListNode cur = slow.next;
        ListNode next = slow.next.next;
        // 这里是一个大坑：在定位好ListNode之后一定要把slow.next设置为null
        // 举一个例子 1->2->1  按道理来说我要让他变为： 1->2<-1  但实际上变为了 1->2<->1 这就是一个死循环，从左往右：1->2->1->2->1......
        // 所以可以看出，slow的next是要被阻断的
        slow.next = null;
        // 这里直接套反转链表
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        // 其实如果总长度是奇数个的话，cur的长度和head长度相等，如果是偶数个的话。head会比cur多一个节点
        // 例子：1->2->2->1    1 -> 2 -> 2 <- 1
        //                              ↓
        //                              null
        // head：1->2->2->null  cur：1->2->null

        // 所以只要中途有一个链表是到尾了，那么就停止循环即可
        while (cur != null && head != null) {
            if (cur.val == head.val) {
                cur = cur.next;
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
