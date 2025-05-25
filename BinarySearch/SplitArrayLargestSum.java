public class SplitArrayLargestSum {
  public static void main(String[] args) {
    int [] nums = {7,2,5,10,8};
    int k=2;
    int ans = splitArray(nums, k);
    System.out.println(ans); // Output: 18 // There are four ways to split nums into two subarrays.
                             //[7] [2,5,10,8] 
                             //[7,2] [5,10,8]
                             //[7,2,5] [10,8]
                             //[7,2,5,10] [8]
                            // The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

  }

  public static int splitArray(int[] nums, int k) {
    // Minimum number of (k==1) then maximum sum is the sum of all elements.
    // Maximum number of (k==nums.length) then maximum sum is the maximum element in the array.
    // Our answer will be in the range of [max(nums), sum(nums)].
    int[] ans = LargestElementAndSumOfArray(nums);
    int s = ans[0];
    int e = ans[1];
    int mid;
    while (s < e) {
      mid = (s + e) / 2;
      // Checking if we can divide array in subarray such that max-Sum among them is mid.
      int sum = 0;
      int pieces = 1;
      for (int ele : nums) {
        if (sum + ele > mid) {
          sum = ele;
          pieces++;
        } else {
          sum = sum + ele;
        }
      }
      if (pieces > k) {
        s = mid + 1;
      } else {
        e = mid;
      }
    }
    return e;
  }
  public static int[] LargestElementAndSumOfArray(int[]nums){
        int []ans = new int[2];
        int max = nums[0];
        int sum = nums[0];
        for(int i =1 ;i<nums.length;i++){
            if(nums[i]>max) max= nums[i];
            sum=sum+nums[i];
        }
        ans[0]=max;
        ans[1]=sum;
        return ans;
    }
}

// https://leetcode.com/problems/split-array-largest-sum/description/