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
class ReverseNodesKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Ref: https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/183356/Java-O(n)-solution-with-super-detailed-explanation-and-illustration
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pointer = dummy;
        
        while(pointer != null)
        {
            ListNode node = pointer;
            
            for(int i = 0; i < k && node != null; i++){
                node = node.next;
            }
            if(node == null)
                break;
            
            ListNode curr = pointer.next, prev = null;
        
            for(int i = 0; i < k; i++){
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            
            ListNode tail = pointer.next;
            tail.next = curr;
            pointer.next = prev;
            pointer = tail;
        }
        
        return dummy.next;
    }
}
