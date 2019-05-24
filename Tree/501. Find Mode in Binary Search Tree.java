
/*

Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

*/

/*

O(n),O(n)

*/

private int cnt = 0;
private int max = Integer.MIN_VALUE;
private TreeNode prev;

public int[] findMode(TreeNode root) {
    List<Integer> tmp = new ArrayList<>();
    this.prev = root;
    inorder(root, tmp);
    int[] ans = new int[tmp.size()];
    for (int i = 0; i < ans.length; ++i) {
        ans[i] = tmp.get(i);
    }
    return ans;
}

private void inorder(TreeNode root, List<Integer> tmp) {
    if (root == null) {
        return;
    }
    inorder(root.left, tmp);
    cnt = prev.val == root.val ? cnt + 1 : 1;
    if (cnt == max) {
        tmp.add(root.val);
    } else if (cnt > max) {
        max = cnt;
        tmp.clear();
        tmp.add(root.val);
    }
    prev = root;
    inorder(root.right, tmp);
}




