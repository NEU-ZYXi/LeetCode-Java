
/*

Given a node from a cyclic linked list which is sorted in ascending order, 
write a function to insert a value into the list such that it remains a cyclic sorted list.
The given node can be a reference to any single node in the list, 
and may not be necessarily the smallest value in the cyclic list.
If there are multiple suitable places for insertion, you may choose any place to insert the new value.
After the insertion, the cyclic list should remain sorted.
If the list is empty (i.e., given node is null), 
you should create a new single cyclic list and return the reference to that single node.
Otherwise, you should return the original given node.

*/

/*

Solution: 1. add in the middle, cur.val<=insertVal<=cur.next.val
          2. add in the head or tail since the insertVal is the smallest or the largest
          3. all the values are the same, add in the last position
O(n),O(1)          

*/

public Node insert(Node head, int insertVal) {
    if (head == null) {
        Node node = new Node(insertVal);
        node.next = node;
        return node;
    }
    Node cur = head;
    while (true) {
        if (cur.val < cur.next.val) {
            if (cur.val <= insertVal && insertVal <= cur.next.val) {
                cur.next = new Node(insertVal, cur.next);
                break;
            }
        } else if (cur.val > cur.next.val) {
            if (cur.val <= insertVal || insertVal <= cur.next.val) {
                cur.next = new Node(insertVal, cur.next);
                break;
            }
        } else {
            if (cur.next == head) {
                cur.next = new Node(insertVal, cur.next);
                break;
            }
        }
        cur = cur.next;
    }
    return head;
}





