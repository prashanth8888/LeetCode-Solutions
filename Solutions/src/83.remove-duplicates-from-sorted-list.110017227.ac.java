/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null) return null;
        
        ListNode currentNode = new ListNode(-1);
        currentNode.val = head.val;
        ListNode listHead = currentNode;
        
        while(head != null){
            head = head.next;
            if(head != null){
                if(head.val == currentNode.val){
                while(head != null && head.val == currentNode.val){
                    head = head.next;
                }
                if(head != null){
                    currentNode.next = new ListNode(head.val);
                    currentNode = currentNode.next;
                }
            }
            else{
                currentNode.next =  new ListNode(head.val);
                currentNode = currentNode.next;
            } 
            }
        }
        return listHead;
    }
}
