/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class AddTwoLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        
        int carry = 0;
        while(l1 != null && l2 != null){
            int value = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            res.next = new ListNode(value);
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            int l1Val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10; 
            res.next = new ListNode(l1Val);
            res = res.next;
            l1 = l1.next;
        }
        
        while(l2 != null){
            int l2Val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10; 
            res.next = new ListNode(l2Val);
            res = res.next;
            l2 = l2.next;
        }
        
        if(carry != 0){
            res.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
