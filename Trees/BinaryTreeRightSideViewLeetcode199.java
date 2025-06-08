// THIS QUESTION IS LITTERALLY A JOKE 😂😂😂🤣 . This is Simple level Order Traversal , with add last element in each level adding to final answer only.
 
//        1        <-------
//      /   \
//     2     3     <-------
//      \     \
//       5     4   <-------
// ANSWER : [1,3,4]
// BTW 😂 level order traversal of this tree will be [[1],[2,3],[5,4]].


public class BinaryTreeRightSideViewLeetcode199 {
  class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result =  new ArrayList<>();
        if(root==null) return result ;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            for(int i = 0 ; i<levelsize;i++){
                TreeNode currentnode = queue.poll();
                if(i==levelsize-1) result.add(currentnode.val);
                if(currentnode.left!=null) queue.offer(currentnode.left) ;
                if(currentnode.right!=null) queue.offer(currentnode.right);
            }
        
        }
        return result;
    }
}
}
