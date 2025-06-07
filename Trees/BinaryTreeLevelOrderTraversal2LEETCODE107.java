// THIS IS LITERALLY 🤣🤣 THE SAME QUESTION AS LEVEL ORDER TRAVERSAL OF BINARY TREE LEETCODE 102 😂 . 
// JUST A SMALL CHANGE INSTEAD OF INSERTING EVERY SUBSTANCIAL ANSWER IN THE END OF ARRAYLIST , JUST ADD EVERY SUBSTANCIAL ANSWER IN THE BEGINNING OF ARRAYLIST MEANS AT THE 0 INDEX EVERTIME.
//                     3
//                   /   \
//                  9    20
//                      /  \
//                     15   7 
// ANSWER OF NORMAL LEVEL ORDER TRAVERSAL OF BINARY TREE LEETCODE 102 IS : [[3],[9,20],[15,7]]
// ANSWER OF BINARY TREE LEVEL ORDER TRAVERSAL 2 LEETCODE 107 IS : [[15,7],[9,20],[3]]

public class BinaryTreeLevelOrderTraversal2LEETCODE107{
  class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result ; 

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            List<Integer> currentlevel = new ArrayList<>();
            for(int i =0;i<levelsize;i++){
                TreeNode currentNode = queue.poll();
                if(currentNode.left!=null) queue.offer(currentNode.left); 
                if(currentNode.right!=null) queue.offer(currentNode.right); 
                currentlevel.add(currentNode.val);
                
            }
            result.add(0,currentlevel);

        }
        return result;
        
    }
}
}
