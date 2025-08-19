/*
At each step, the frog has a choice : either go to the next stone or skip one.
If it always goes to the next stone, the return trip fails (no stones left) because it can jump to any stone at most once.
If it skips more than one stone, it creates unnecessarily large jumps since we need to minimise the maximum length of a jump among all jumps in the path.
Therefore, the greedy optimal choice is to skip exactly one stone each time.
This ensures both trips are valid and keeps the maximum jump minimized.
So the answer is simply the largest gap between stones that are two apart.

This solution is greedy, because the locally optimal choice (skipping exactly one stone each time) leads to the global optimum.

 */

 class Solution {
    public int maxJump(int[] stones) {
        // base case
        if(stones.length==2) return stones[1]-stones[0];
        int ans = 0;
        for(int i =2 ;i<stones.length;i++){
            ans=Math.max(ans,stones[i]-stones[i-2]);
        }
        return ans;
        
    }
}