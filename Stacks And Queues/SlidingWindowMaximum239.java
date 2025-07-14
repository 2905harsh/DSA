// In this we need to remove from last or first thats why we use Deque.
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int [] ans = new int[nums.length-k+1]; // Number of sliding window of size k we get in array of length l = l-k+1;
        int idx=0; 

        for(int i=0;i<nums.length;i++){
           // to maintain the length of sliding window to remain constant(k) because i keep on moving.
           if(dq.size()!=0 && i-dq.getFirst()==k) dq.pop();

           // Removing previous elements that are smaller than our current element.Because in future they will never contribute to our answer.
           while(dq.size()!=0 && nums[dq.getLast()]<=nums[i]){
                 dq.removeLast();
            }
            dq.add(i);

           // For every window we will update the answer to our ans array.
           if(i>=k-1) ans[idx++] = nums[dq.getFirst()];
        }
    return ans;
}
}

