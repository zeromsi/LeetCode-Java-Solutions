/**
 * @see <a href="https://leetcode.com/problems/symmetric-tree/">Symmetric Tree</a>
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return subTreeMirror(root.left, root.right);
    }
    public boolean subTreeMirror(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null && r2 != null) return false;
        if (r1 != null && r2 == null) return false;
        if (r1.val != r2.val) return false;
        return subTreeMirror(r1.right, r2.left) && subTreeMirror(r1.left, r2.right);
    }
}
