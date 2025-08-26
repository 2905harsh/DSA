class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int min_distance = 0;
        int max_distance = nums[nums.length-1]-nums[0];

        int l = min_distance;
        int r = max_distance;

        while(l<=r){
            int mid = (l+r)/2;
            int count = countPairWithDifferenceLessThanEqualToTemp(nums,mid);
            if(count>=k){
                r = mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }

    public int countPairWithDifferenceLessThanEqualToTemp(int[] nums , int temp){
        int count = 0;
        int start = 0;
        int end  = 0 ;
        while(start<nums.length){
               while(end<nums.length && nums[end]-nums[start]<=temp ){
                end++;
                }
                count+=end-start-1;
                start++;
        }
        return count;
    }
}

