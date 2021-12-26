/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class CopyLinkedList {
    public Node copyRandomList(Node head) {
        // O(N) and SC - O(N)
//         if(head == null)
//             return null;
        
//         Map<Node, Node> map = new HashMap<>();
        
//         Node node = head;
        
//         while(node != null){
//             map.put(node, new Node(node.val));
//             node = node.next;
//         }
        
//         Node temp = head;
        
//         while(temp != null){
//             map.get(temp).next = map.get(temp.next);
//             map.get(temp).random = map.get(temp.random);
//             temp = temp.next;
//         }
        
//         return map.get(head);
        
        // O(1)
        Node iter = head;
        Node front = head;
        
        while(iter != null){
            front = iter.next;
            
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;
            
            iter = front;
            
        }
        
        iter = head;
        // assign random pointers
        while(iter != null){
            if(iter.random != null){
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }
        
        iter = head;
        // change references
        Node dummy = new Node(-1);
        Node copy = dummy;
        
        while(iter != null){
            front = iter.next.next;
            copy.next = iter.next;
            copy = copy.next;
            iter.next = front;
            
            iter = front;
        }
        return dummy.next;
    }
}
