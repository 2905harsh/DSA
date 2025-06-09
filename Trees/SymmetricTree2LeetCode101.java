// Symemetric Tree can be folded vertically . 
//         1
//      /  :   \
//     2   :    2
//    / \  :   / \
//   3   4 :  4   3
// The above tree is symmetric , i.e. if you fold it in half vertically , both sides will be same.

// In this method we will use recursion where we will if left subtree is mirror of right subtree and vice versa.
// If left subtree is mirror of right subtree then it is symmetric.
// If left subtree is not mirror of right subtree then it is not symmetric.
// This is Leetcode Problem 101 & can be submittef there directly.


public class SymmetricTree2LeetCode101 {
  class Solution {
    public boolean isSymmetric(TreeNode root) {
        return ismirror(root,root);
    }
    public boolean ismirror(TreeNode node1 , TreeNode node2){
        if(node1 == null && node2 == null ) return true;
        if(node1 == null || node2 == null ) return false; 
        return ((node1.val==node2.val) && ismirror(node1.left,node2.right) && ismirror(node1.right,node2.left));
    }
}

}
