
/*

A linked list is given such that each node contains an additional random pointer 
which could point to any node in the list or null.
Return a deep copy of the list.

*/

/*

Solution 1: use a hashmap to copy all the list nodes and apply the next and random pointers
O(n),O(n)

*/

public RandomListNode copyRandomList(RandomListNode head) {
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode cur = head;
    while (cur != null) {
        map.put(cur, new RandomListNode(cur.label));
        cur = cur.next;
    }
    cur = head;
    while (cur != null) {
        map.get(cur).next = map.get(cur.next);
        map.get(cur).random = map.get(cur.random);
        cur = cur.next;
    }
    return map.get(head);
}


/*

Solution 2: copy all the list nodes after the original ones, and apply the next and random pointers
O(n),O(1)

*/

public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) return head;
    RandomListNode cur = head;
    while (cur != null) {
        RandomListNode copy = new RandomListNode(cur.label);
        copy.next = cur.next;
        cur.next = copy;
        cur = copy.next;
    }
    cur = head;
    while (cur != null) {
        RandomListNode copy = cur.next;
        if (cur.random != null) copy.random = cur.random.next;
        cur = copy.next;
    }
    RandomListNode dummy = new RandomListNode(0);
    RandomListNode prev = dummy;
    cur = head;
    while (cur != null) {
        prev.next = cur.next;
        prev = prev.next;
        cur.next = prev.next;
        cur = cur.next;
    }
    return dummy.next;
}




