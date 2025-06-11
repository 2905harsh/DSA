//     3
//    / \
//   9  20
//      /  \
//     15   7
// The maximum depth of the binary tree is 3.

// The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.

// This is Leetcode Problem 104 & can be submitted there directly.


public class MaximumDepthOfBinaryTreeLeetCode104 {
class Solution {
    public int maxDepth(TreeNode root) {
        return godeep(root,0);
    }
    public int godeep(TreeNode node , int NoOfNodes){
        if(node == null){
            return 0 ;
        }
        int l = godeep(node.left , NoOfNodes+1);
        int r = godeep(node.right , NoOfNodes+1);

        return Math.max(l,r) +1;  

    }
}
}
