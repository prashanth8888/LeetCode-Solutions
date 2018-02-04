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
    public ListNode detectCycle(ListNode head) {
        
        if(head == null)
            return null;
            
            
        //List resultNode = null;
        ListNode fast = head;
        ListNode slow = head;
        do{
           
            slow = slow.next;
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            else{
                fast = fast.next.next;
            }
            
        }while(slow.val != fast.val);
        
        slow = head;
        while(slow.val != fast.val){
            
            slow = slow.next;
            fast = fast.next;
        }
        
        return fast;
        
    }
}
