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
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        
        ListNode firstHalf = findMiddleNode(temp);
        ListNode secondHalf = reverse(firstHalf.next);
        
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        
        while(p2 != null){
            if(p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode l1){
        ListNode current = l1;
        ListNode prev = null, temp = null;
        
        while(current != null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
    
    public ListNode findMiddleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
