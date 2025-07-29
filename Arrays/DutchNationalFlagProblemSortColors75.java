class Solution {
    public void sortColors(int[] nums) {
        int i = 0 ; // [to move 0s in the starting of the array]
        int j = nums.length-1; //[to move 2s at the end of the array]
        // if we arrange 0s and 2s in the required order we need not to do anything about 1s.
        int curr = 0 ; // This is to traverse through the array.

        while(curr<=j){
            if(nums[curr]==0){
                //swap(curr,i)
                int temp = nums[curr];
                nums[curr]=nums[i];
                nums[i]=temp;
                i++;
                curr++;
            }
            else if(nums[curr]==2){
                //swap(curr,j)
                int temp = nums[curr];
                nums[curr]=nums[j];
                nums[j]=temp;
                j--;
                // we wont move curr here because a newer element came in the place of 2 from the behind .We need to look the newer element. 
            }
            else if (nums[curr]==1){
                curr++;
            }
        }
    }
}

/* Why the name “Dutch National Flag Problem”?

The problem involves sorting an array of three distinct elements — typically represented as:
	•	0 → Red
	•	1 → White
	•	2 → Blue

These map to the colors of the Dutch flag, which has three horizontal stripes in the order:

Red (top) → White (middle) → Blue (bottom)🇳🇱 
*/
