package com.van.leetcode.twoPoint;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//判断是不是环状list
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class CircleList {
        public boolean hasCycle(ListNode head) {
            Set<ListNode>set=new HashSet<>();
            ListNode cur=new ListNode(1);
            cur.next=head;
            while (cur!=null){
                cur=cur.next;
                if (!set.add(cur)){
                    return true;
                }
            }
            return false;
        }
}
