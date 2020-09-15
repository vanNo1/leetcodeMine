package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 弱智
 */
public class 从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode cur=head;
        while (cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }
        Collections.reverse(list);
        int[]result=new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=list.get(i);
        }
        return result;
    }
}
