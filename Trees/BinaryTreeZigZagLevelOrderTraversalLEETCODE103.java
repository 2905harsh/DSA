// This the leetcode problem 103 and can be submitted there directly.
//           3
//         /   \
//        4     5
//       / \   / \ 
//      6   9 11  12
//            / \
//           8  16 
// ANSWER: // [[3],[5,4],[6,9,11,12],[16,8]]
// WE NEED TO ALTERNATIVLEY CHANGE THE ORDER AS WE GO DOWN THE LEVELS.
// AT THE ROOT NODE FLAG IS FALSE , SO WE PRINT LEFT TO RIGHT.
// THEREAFTER WHEN WE GO DOWN THE LEVELS, WE CHANGE THE FLAG TO TRUE AND PRINT RIGHT TO LEFT.
// To implement this , we can use a deque (double-ended queue) to allow us to add and remove nodes from both ends.
// When the flag is false , we remove from the front and add children to the back in order left child first then right child.
// When the flag is true , we remove from the back and add children to the front in order right child first then left child.
// You can learn java deque from gfg for more details.


public class BinaryTreeZigZagLevelOrderTraversalLEETCODE103 {
  class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if(root==null) return result;
        deque.offerFirst(root);
        boolean flag = false ; 
        while(!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> temp = new ArrayList<>();
            for(int i =0 ;i<levelSize ; i++){
               if(!flag){
                    TreeNode currentNode = deque.pollFirst();
                    if(currentNode.left!=null) deque.addLast(currentNode.left);
                    if(currentNode.right!=null) deque.addLast(currentNode.right);
                   temp.add(currentNode.val);
                }
               else if(flag){
                    TreeNode currentNode = deque.pollLast();
                    if(currentNode.right!=null) deque.addFirst(currentNode.right);
                    if(currentNode.left!=null)  deque.addFirst(currentNode.left);
                    temp.add(currentNode.val);
                }
            }
            flag = !flag;
            result.add(temp);
        }
        return result;
    }
}
}
