class Solution {
    public int removeElement(int[] nums, int val) {
        // start arranging all the element which are not equal to val from the starting of array.
        int index = 0;
        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i]!=val){
              nums[index] = nums[i];
              index++;
            } 
        }
        return index;
    }
}
