class Solution {
    public int[] sortArrayByParity(int[] nums) {

        int j = 0 ; // to catch the even numbers

        for(int i =0 ; i < nums.length ; i++){
            if(nums[i]%2==0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        return nums;
    }
}