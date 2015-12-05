/**
 * @see <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">Populating Next Right Pointers in Each Node</a>
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode layerHead = root;
        while (layerHead != null) {
            TreeLinkNode nextLayerHead = null;
            TreeLinkNode layerCur = layerHead; // traverse in the current layer
            // tends to write LinkNOde, instead of LinkNode, why ????!!!!!!!!!!!!!!!!!!!!!!!!!!
            TreeLinkNode nextLayerPrev = null; // modify in the next layer
            while (layerCur != null) {
                if (layerCur.left == null && layerCur.right == null) ; // go to the next node in this layer
                else {
                    // at least one node is not null.
                    // left not null
                    if (layerCur.left != null && layerCur.right == null) {
                        if (nextLayerHead == null) {
                            nextLayerHead = layerCur.left;
                        }
                        else {
                            nextLayerPrev.next = layerCur.left;
                        }
                        nextLayerPrev = layerCur.left; // this is the common operation for the two cases, can simplify!!!
                    }
                    // right not null
                    else if (layerCur.left == null && layerCur.right != null)  {
                        if (nextLayerHead == null) {
                            nextLayerHead = layerCur.right;
                        }
                        else {
                            nextLayerPrev.next = layerCur.right;
                        }
                        nextLayerPrev = layerCur.right; // this is the common operation for the two cases, can simplify!!!
                    }
                    // both not null
                    else {// layerCur.left != null and layerCur.right != null
                        if (nextLayerHead == null) {
                            nextLayerHead = layerCur.left;
                        }
                        else {
                            nextLayerPrev.next = layerCur.left;
                        }
                        layerCur.left.next = layerCur.right; // this is the common operation for the two cases, can simplify!!!
                        nextLayerPrev = layerCur.right; // this is the common operation for the two cases, can simplify!!!
                    }
                }
                layerCur = layerCur.next;
            }
            layerHead = nextLayerHead; // may or may not be null.
        }
    }
}
