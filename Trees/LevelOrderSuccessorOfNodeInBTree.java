// LEVEL ORDER SUCCESSOR OF A NODE IN BINARY TREE(Give me value that is right next to it).
//            3
//         /     \ 
//        4       8
//       / \     / \
//      12  14  7  11
//          / \    /
//         36  9   2
//                  \
//                   44
// For the above tree, if we are given key = 14, then the output should be 7.
// If we are given key = 11, then the output should be 36.

public TreeNode findSuccesor(TreeNode root , int key){
  if(root == null) return null;
  Queue<TreeNode> queue = new LinkedList<>();
  queue.offer(root);
  while(!queue.isEmpty()){
    TreeNode currentNode = queue.poll();
    if(currentNode.left!=null) queue.offer(currentNode.left);
    if(currentNode.right!=null) queue.offer(currentNode.right);
    if(currentNode.val == key) break ;
  }

  return queue.peek();
}