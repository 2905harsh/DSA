// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
// So we will not write any new code for this problem, rather we will use the concept of height of a node, so we will make a global variable diameter and update it at every node. Now the question is we have to derive a relation between the diameter and height of that node.
// So, for every node the diameter through that node will be equal to the sum of the height of the leftsub tree and rightsub of tree . 
// In this we are calculating the diameter though each node and updating the global variable diameter with the maximum diameter found so far.
// The height of a node is the maximum height of its left and right subtrees plus one for the current node.

// This is Leetcode Problem 543 & can be submitted there directly.

public class DiameterOfBinaryTreeLeetCode543 {
  class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    int height(TreeNode node){
        if(node == null){
            return 0 ;
        }
        int leftheight = height(node.left);
        int rightheight = height(node.right);

        int dia = leftheight + rightheight ; 
        diameter = Math.max(dia,diameter);

        return Math.max(leftheight,rightheight)+1 ; 
    }
}
}
