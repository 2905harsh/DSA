//     1
//    / \
//   2   5
//  / \   \
//  3  4   6

// Flatten to 
// 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
//          \
//           6

// LeetCode Problem 114: Flatten Binary Tree to Linked List
// Can be submited in Leetcode directly using the class name Solution.

// Time Complexity: O(n) where n is the number of nodes in the tree.
// Space Complexity: O(1) since we are not using any extra space except for a few variables.

public class FlattenBinaryTreeLeetCode114 {
  class Solution {
    public void flatten(TreeNode root) {
        TreeNode currentNode = root; 
        while(currentNode!=null){
            if(currentNode.left!=null){
                TreeNode temp = currentNode.left ; 
                while(temp.right!=null){
                    temp = temp.right;
                }
                temp.right = currentNode.right;
                currentNode.right = currentNode.left;
                currentNode.left = null;
            }
            currentNode = currentNode.right;
        }
    }
}
}
