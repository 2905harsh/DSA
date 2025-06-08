//            1                         1 -> null
//          /   \                     /   \
//         2     3      ------>      2 --> 3 -> null
//        / \   / \                 / \   / \
//       4   5 6   7               4-> 5->6->7-> null

// To solve this problem we will use the approach -> Assume the root node as leftmost node initially and connect its left and right child and then traverse right in the same level , if it's next is not null . Note that on moving to right in same level you should connect the previous right child to new node left child (here on moving to 3 from 2 we connect 5 to 6 ).If next node is null then we will traverse to the next level down(here in case of 1 no next node , so we move down to 2nd level having 2 and 3) and repeat the process until we reach the node that has no leftchild(here 4) no need to check beyond beacuse this is perfect binary tree.  

public class PopulatingNextRightPointersInEachNodeLeetcode116 {
  class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Node leftmost = root;
        Node currentnode ;
        while(leftmost.left!=null){
            currentnode = leftmost ;
            while(currentnode!=null){
                currentnode.left.next = currentnode.right;
                if(currentnode.next!=null){
                    currentnode.right.next=currentnode.next.left;
                }
                currentnode = currentnode.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

}
}
