
/*

Write a program to find the node at which the intersection of two singly linked lists begins.
 
Example 1:
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8

Example 2:
Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2

Example 3:
Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null

*/

/*

Solution 1: get the length of two linked lists, and make them the same, then find the intersection
O(n),O(1)

*/

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = getLength(headA), lenB = getLength(headB);
    while (lenA > lenB) {
        headA = headA.next;
        lenA--;
    }
    while (lenA < lenB) {
        headB = headB.next;
        lenB--;
    }
    while (headA != headB) {
        headA = headA.next;
        headB = headB.next;
    }
    return headA;
}

private int getLength(ListNode head) {
    int ans = 0;
    for (ListNode cur = head; cur != null; cur = cur.next) ans++;
    return ans;
}


/*

Solution 2: let two pointers go through list A and list B, which means when pA goes through list A, it goes to list B
            when two pointers meet, the current node is intersection
            
            ____________
                  a     \_________  pA go (a+c)+b, pB go (b+c)+a, so they meet at the intersection node the first time
            ____________/    c
                  b
                  
O(2n),O(1)            

*/

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode pA = headA, pB = headB;
    while (pA != pB) {
        pA = pA == null ? headB : pA.next;
        pB = pB == null ? headA : pB.next;
    }
    return pA;
}




