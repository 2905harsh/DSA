//      4
//     / \
//    2   7
//   / \ / \
//  1  3 6  9
// The tree is inverted to:
//     4
//    / \
//   7   2
//  / \ / \
// 9  6 3  1

// We have solved this using a basic recursion . the idea is to swap the left and right children of each node in the tree. We will recursively call the function for the left and right children of the current node, and then swap them.
// This is Leetcode Problem 226 & can be submitted there directly.

public class InvertBinaryTreeLeetCode226 {
  class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left =  invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;

        
    }
}
}
