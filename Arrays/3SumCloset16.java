class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Since we do not have to return the indices we can mess up the indices.
        // Sort the array.
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize closest sum with the sum of the first three elements

        for (int i = 0; i <= nums.length - 3; i++) { // length-3 because everytime we need atleast 3 elements in our window.
            // i will be fixed and j and k will move.
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (Math.abs(target - sum) < Math.abs(target - closestSum)) { // comparing the distance with target.
                    closestSum = sum; // Update closest sum if the current sum is closer to the target
                }

                if (sum < target) {
                    j++; // Increment j to increase the sum further
                } else {
                    k--; // Decrement k to decrease the sum 
                }
            }
        }

        return closestSum;
    }
}