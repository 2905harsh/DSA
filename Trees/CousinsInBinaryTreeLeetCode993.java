//       1      
//      /   \
//     2     3    
//      \     \
//       4     5
// 4 5 are cousins because they are at the same level and have different parents.
// For two node to be cousins , they must be at the same level and they must not be siblings (i.e. they should not have the same parent).

// This solution can be submitted directly to LeetCode problem 993.

public class CousinsInBinaryTreeLeetCode993 {
  class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = find(root,x); // finding node by their value.
        TreeNode yy = find(root,y);
        return((level(root,xx,0)==level(root,yy,0))&&(!isSibling(root,xx,yy)));
    }

    public TreeNode find(TreeNode node , int x){
        if(node==null) return null;
        if(node.val==x) return node ; 
        TreeNode n = find(node.left,x);
        if(n!=null) return n ; // if n is not null means we have found node in left sub tree and return n .
        // Otherwise find node in right sub tree.
        return find(node.right,x);
    }

    public int level(TreeNode node , TreeNode x , int level){
        if(node == null ) return 0;

        if(node==x) return level ; // if you found the node retuns current level.

        int l = level(node.left,x,level+1); // finding in the left sub tree.
        if(l!=0) return l ; // if founded in left subtree return the current level . 
        return level(node.right,x,level+1); // if not founded in left subtree , then found in right subtree .
    }

    public boolean isSibling(TreeNode node, TreeNode x , TreeNode y){
        if(node==null) return false ; 
        return(
            (node.left == x && node.right == y ) ||
            (node.left == y && node.right == x) ||
            isSibling(node.left,x,y) ||  // finding in the left subtree
            isSibling(node.right,x,y)  // finding in the right subtree
        );
     }
}
}
