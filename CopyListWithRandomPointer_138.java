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

class Solution {
    public Node copyRandomList(Node head) {
        /**
        One approach is easy, to just store old and new nodes in map and link them later 
        However, solving in O(1)
         */

         if (head == null) {
            return null;
         }

         Node curr = head;

         while (curr != null) {
            // create a copy of curr node and put it in between curr and its next one
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        curr = head;
        while (curr != null) {
            // update random pointers of new nodes, which are currently null
            if (curr.random != null) {
                // curr.next is new node, so random of that should now be curr.random's new copy
                curr.next.random = curr.random.next;
            }
            curr = curr.next != null ? curr.next.next : null;
        }

        // now just break this interweaved list into two lists, original and new

        // oldHead is same as head, newHead should be next of it
        Node newHead = head.next;
        curr = head;
        Node currNew = curr.next;;

        while (curr != null) {
            curr.next = curr.next.next;
            currNew.next = currNew.next != null ? currNew.next.next : null;
            curr = curr.next;
            currNew = currNew.next;
        }
        return newHead;
    }
}
