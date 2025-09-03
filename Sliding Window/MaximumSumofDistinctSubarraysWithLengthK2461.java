class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        if (nums.length < k)
            return 0;
        long finalAns = 0;
        long temp = 0;
        int l = 0;
        int r = k - 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = l; i <= r; i++) {
            temp += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if (map.size()==k) {
                finalAns = Math.max(finalAns, temp);
            }

        while (r + 1 < nums.length) {
            temp -= nums[l];
            map.put(nums[l], map.get(nums[l]) - 1);
            if (map.get(nums[l]) == 0) map.remove(nums[l]);
            l++;
            r++;
            temp += nums[r];
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            if (map.size()==k) {
                finalAns = Math.max(finalAns, temp);
            }

        }
        return finalAns;
    }

}