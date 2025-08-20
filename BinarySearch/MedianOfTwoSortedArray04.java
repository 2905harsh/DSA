class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

      
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int lengthOfMergerdArray = (nums1.length+nums2.length);

        int l = 0;
        int h = nums1.length;

        while(l<=h){

            int mid1 = (l+h)/2;
            int mid2 = (lengthOfMergerdArray+1)/2-mid1; 

            int l1 = (mid1>0)?nums1[mid1-1]:Integer.MIN_VALUE;
            int l2 = (mid2>0)?nums2[mid2-1]:Integer.MIN_VALUE;
            int r1 = (mid1<nums1.length)?nums1[mid1]:Integer.MAX_VALUE;
            int r2 = (mid2<nums2.length)?nums2[mid2]:Integer.MAX_VALUE;
            

            if(l1<=r2 && l2<=r1){
                return (lengthOfMergerdArray%2==0)?(double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0 : (double)(Math.max(l1, l2));
            }

            if(l1>r2){
                h = mid1-1;
            }

            else{
                l=mid1+1;
            }

        }

        return 0.0;
    }
}

// Key Points to Remember
1.We binary search on the smaller array
2.Condition for valid partition: l1 <= r2  &&  l2 <= r1
3.Median depends on total length parity:
	•	Even: average of max(left) and min(right)
	•	Odd: max(left)
4.Handling edge cases with Integer.MIN_VALUE and Integer.MAX_VALUE
5.Time complexity: O(log(min(n, m))) where n and m are lengths of the two arrays.
6.Space complexity: O(1) since we are using constant space.