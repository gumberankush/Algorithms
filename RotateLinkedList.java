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
class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null || k == 0){
            return head;
        }
        
        ListNode current = head;
        int len = 1;
        
        while(current.next != null){
            current = current.next;
            len++;
        }
        
        current.next = head;
        
        k = k % len;
        k = len - k;
        
        while(k > 0){
            current = current.next;
            k--;
        }
        
        head = current.next;
        current.next = null;
        
        return head;
    }
}
