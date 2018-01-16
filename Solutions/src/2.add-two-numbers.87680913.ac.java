/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode result;
    ListNode head;
    int sum = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        result = new ListNode(0);
        head = result;
        if(l1 == null && l2 == null) {
            return null;
        }
        
        while(l1 != null && l2 != null){
            sum = l1.val + l2.val + carry;
            carry = 0;
            while(sum > 9){
                carry = sum / 10;
                sum = sum - 10;
            }
            result.val = sum;
            l1 = l1.next;
            l2 = l2.next;
            if(l1 == null || l2 == null) break;
            result.next = new ListNode(0);
            result = result.next;
        }
        
        if(l1 != null){
        result.next = new ListNode(0);
        result = result.next;
        }
        while(l1 != null){
            sum = l1.val + carry;
            carry = 0;
            if(sum > 9){
               carry = sum / 10;
                sum = sum - 10;
            }
            result.val = sum;
            l1 = l1.next;
            if(l1 == null) break;
            result.next = new ListNode(0);
            result = result.next;
        }
        
        
        if(l2 != null){
        result.next = new ListNode(0);
        result = result.next;
        }
        while(l2 != null){
            sum = l2.val + carry;
            carry = 0;
            if(sum > 9){
               carry = sum / 10;
                sum = sum - 10;
            }
            result.val = sum;
            l2 = l2.next;
            if(l2 == null) break;
            result.next = new ListNode(0);
            result = result.next;
        }
        
        if(carry >= 1){
            result.next = new ListNode(0);
            result = result.next;
            result.val = carry;
        }
        return head;
    }
}
