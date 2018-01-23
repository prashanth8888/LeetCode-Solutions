/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        
        if(head == null)
            return null;
        if(head.next == null)
            return head;
            
        ListNode leftNodeHead = null;
        ListNode rightNodeHead = null;
        ListNode leftNode = null;
        ListNode rightNode = null;
        
        while(head != null){
            if(head.val < x){
                if(leftNodeHead == null){
                    leftNodeHead = head;
                    leftNode = leftNodeHead;
                }
                    
                else{
                    leftNodeHead.next = head;
                    leftNodeHead = leftNodeHead.next;
                }
            }
            
            
            else{
                if(rightNodeHead == null){
                    rightNodeHead = head;
                    rightNode = rightNodeHead;
                }
                    
                else{
                    rightNodeHead.next = head;
                    rightNodeHead = rightNodeHead.next;
                }
            }
            head = head.next;
        }
        
        if(rightNodeHead != null)
            rightNodeHead.next = null;
        
        if(leftNodeHead != null){
            leftNodeHead.next = rightNode;
            return leftNode;
        }
        else{
            return rightNode;
        }
            
    }
}
