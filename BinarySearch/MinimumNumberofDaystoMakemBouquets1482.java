class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length)
            return -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <bloomDay.length; i++) {
            min = Math.min(min,bloomDay[i]);
            max = Math.max(max,bloomDay[i]);
        }
        int l = min;
        int h = max;
        int ans = -1;
        int mid = 0;
        while (l <= h) {
            mid = (l + h) / 2;
            if (isPossible(bloomDay, mid, m, k)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;

    }

    public boolean isPossible(int[] bloomDay, int Day, int m, int k) {
        int flowerCollected = 0;
        int bouquets = 0;
        for (int day : bloomDay) {
            if (day <= Day) {
                // collect flower
                flowerCollected++;
                if (flowerCollected == k) {
                    // we can make a bouquets now
                    bouquets++;
                    flowerCollected = 0;
                }
            } else {
                // throw away all previously collected flower
                flowerCollected = 0;
            }
        }
        return (bouquets >= m);
    }
}
