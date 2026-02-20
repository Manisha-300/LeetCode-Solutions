/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode curr= head;
      ListNode tail=head;
     while(tail!=null && tail.next!=null){
        curr=curr.next;
        tail=tail.next.next;
        if(curr==tail){
            return true;
        }
     }
     
      return false;

        
    }
}