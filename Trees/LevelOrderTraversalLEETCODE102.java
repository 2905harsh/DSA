import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class LevelOrderTraversalLEETCODE102 {

  class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            result.add(currentlevel);

        }
        return result;
        
    }
}
}
