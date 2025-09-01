class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        int windowSize = 2*k + 1;
        if (windowSize > n) return ans;

        long sum = 0;
        for (int j = 0; j < windowSize; j++) {
            sum += nums[j];
        }

        // First valid center
        ans[k] = (int)(sum / windowSize);

        // Slide window over valid centers
        for (int i = k+1; i <= n-k-1; i++) {
            sum -= nums[i - k - 1];  // element leaving
            sum += nums[i + k];      // element entering
            ans[i] = (int)(sum / windowSize);
        }

        return ans;
    }
}

