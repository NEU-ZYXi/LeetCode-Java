
/*

Convert a BST to a sorted circular doubly-linked list in-place. 
Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.
We want to transform this BST into a circular doubly linked list. 
Each node in a doubly linked list has a predecessor and successor. 
For a circular doubly linked list, the predecessor of the first element is the last element, 
and the successor of the last element is the first element.
The figure below shows the circular doubly linked list for the BST above. 
The "head" symbol means the node it points to is the smallest element of the linked list.

*/

/*

O(n),O(n)

*/

public Node treeToDoublyList(Node root) {
    if (root == null) return root;
    Node head = root, cur = root, prev = null;
    while (head.left != null) head = head.left;
    Deque<Node> deque = new LinkedList<>();
    while (!deque.isEmpty() || cur != null) {
        while (cur != null) {
            deque.offerLast(cur);
            cur = cur.left;
        }
        cur = deque.pollLast();
        if (prev != null) {
            prev.right = cur;
            cur.left = prev;
        }
        prev = cur;
        cur = cur.right;
    }
    head.left = prev;
    prev.right = head;
    return head;
}




