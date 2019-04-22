
/*

Given a singly linked list, return a random node's value from the linked list. 
Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? 
Could you solve this efficiently without using extra space?

Example:
// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();

*/

/*

Solution: 蓄水池抽样(Reservoir Sampling), P(n)=1*1/2*2/3*3/4*...*(n-1)/n=1/n
O(n),O(1)

*/

class Solution {

    private ListNode head;
    private Random rand;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = head;
        int ans = -1, cnt = 0;
        while (cur != null) {
            if (rand.nextInt(++cnt) == 0) ans = cur.val;
            cur = cur.next;
        }
        return ans;
    }
}




