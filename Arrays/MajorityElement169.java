// Number of elements greater than [n/k] will always equal to == (k-1).
// For eg greater than [n/2] we can get only 1 element in n length array.
// For eg greater than [n/3] we can get only 2 element in n length array.

// This can be assumed how election vote counting happens.
// Lets assume the winning candidate(our answer) to be first element.
// Initially his vote balance will be 1 .
// Each time he comes again in array his vote balance will be increased to 1.
// If any other candidate comes then he will cancel 1 vote from our existing candidate.
// If Number of votes our existing candidate have becomes 0 then the current person will become our new Candidate.

// But this does not guarantee that we can found correct element all times .For example in this case no one have occurence more than [n/2] times [1,1,2,2,1,2].
// So we need to manually check if the candidate returned as answer have [n/2] frequency or not.
// But in this question since it have already given that such element is present that have occurence greater than [n/2].
// So even if we don't write check function code works fine.

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int vote = 1;
        for(int i =1 ;i<nums.length;i++){
            int newCandidate = nums[i];
            if(vote==0){
                candidate = newCandidate;
                vote++;
            }
            else if(newCandidate==candidate) vote++;
            else if(newCandidate!=candidate) vote--;
        }
        return (check(nums,candidate))?candidate:-1;
    }
    public boolean check(int[]nums,int candidate){
        int count = 0 ;
        for(int i =0 ;i<nums.length;i++){
            if(nums[i]==candidate) count++;
        }
        return (count>nums.length/2)?true:false;
    }
}
