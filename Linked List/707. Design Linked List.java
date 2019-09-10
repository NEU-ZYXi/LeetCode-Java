
/*

Design your implementation of the linked list. 
You can choose to use the singly linked list or the doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, 
and next is a pointer/reference to the next node. 
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list.
Assume all nodes in the linked list are 0-indexed.

Implement these functions in your linked list class:

get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
addAtHead(val) : Add a node of value val before the first element of the linked list. 
  After the insertion, the new node will be the first node of the linked list.
addAtTail(val) : Append a node of value val to the last element of the linked list.
addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list.
  If index equals to the length of linked list, the node will be appended to the end of linked list. 
  If index is greater than the length, the node will not be inserted. 
  If index is negative, the node will be inserted at the head of the list.
deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.

Example:
MyLinkedList linkedList = new MyLinkedList();
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
linkedList.get(1);            // returns 2
linkedList.deleteAtIndex(1);  // now the linked list is 1->3
linkedList.get(1);            // returns 3

*/

/*

O(n),O(n)

*/

class MyLinkedList {
    class Node {
        private int val;
        private Node next;
        
        public Node(int val) {
            this.val = val;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = new Node(0);
        this.tail = new Node(0);
        this.head.next = this.tail;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node prev = findPrev(index);
        return prev.next.val;
    }
    
    /** Add a node of value val before the first element of the linked list. 
    After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list.
    If index equals to the length of linked list, the node will be appended to the end of linked list. 
    If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        Node prev = findPrev(index);
        Node tmp = prev.next;
        prev.next = new Node(val);
        prev.next.next = tmp;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node prev = findPrev(index);
        prev.next = prev.next.next;
        size--;
    }
    
    private Node findPrev(int index) {
        Node cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }
}





