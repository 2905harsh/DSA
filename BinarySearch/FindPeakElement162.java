class Solution {
    public int findPeakElement(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l <= r) {

            mid = (l + r) / 2;
            boolean leftComparision = (mid - 1 < 0) ? true : arr[mid - 1] < arr[mid];
            boolean rightComparision = (mid == arr.length - 1) ? true : arr[mid + 1] < arr[mid];

            if (leftComparision && rightComparision)
                return mid;
            else if (!rightComparision) // move right
                l = mid + 1;
            else if (!leftComparision)  // move left
                r = mid - 1;
        }
        return l;

    }
}
