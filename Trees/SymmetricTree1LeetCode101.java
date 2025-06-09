// Symemetric Tree can be folded vertically . 
//         1
//      /  :   \
//     2   :    2
//    / \  :   / \
//   3   4 :  4   3
// The above tree is symmetric , i.e. if you fold it in half vertically , both sides will be same.

// In this method we will use queue where we will compare one node left child with other node right child and so on .

// This is Leetcode Problem 101 & can be submittef there directly.

public class SymmetricTree1LeetCode101 {
  class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        if((root.left == null && root.right!=null) || (root.right==null && root.left!=null)) return false ; 
        Queue<TreeNode> queue  = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){

            TreeNode temp1 = queue.poll();
            TreeNode temp2 = queue.poll();

            // These 4 conditions check if both node we are comparing(one's left and other's right) are null or not.
            // Aisa nahi hona chahiye ki ek node null ho aur dursi null na ho.

            if(temp1.left==null && temp2.right!=null) return false;
            if(temp1.left!=null && temp2.right==null) return false;
            if(temp1.right==null && temp2.left!=null) return false;
            if(temp1.right!=null && temp2.left==null) return false;

            if (temp1.val != temp2.val) return false;

            if(temp1.left!=null) queue.offer(temp1.left);
            if(temp2.right!=null)queue.offer(temp2.right);
            if(temp1.right!=null)queue.offer(temp1.right);
            if(temp2.left!=null) queue.offer(temp2.left);
        }
        return true;
    }
}
}
