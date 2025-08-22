class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = getMax(weights); //The minimum possible ship capacity cannot be 0. It must be at least the maximum single weight in weights, otherwise you can’t even ship the heaviest package.
        int high = sumOfElement(weights);
        int mid = 0;
        while(low<=high){
            mid= (low+high)/2;
            if(isThisCapacityPossible(weights,days,mid)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }

    public boolean isThisCapacityPossible(int []weights , int days,int capacity){
        int currSum=0;
        int tempDays=1;
        for(int weight : weights){
            if(currSum+weight>capacity){
               tempDays++;
               currSum=0;
            }
            currSum +=weight;
        }
        return (tempDays<=days);
    }

    public int sumOfElement(int [] weights){
        int sum =0;
        for(int weight:weights){
            sum+=weight;
        }
        return sum;
    }

    public int getMax(int [] arr){
        int max = arr[0];
        for(int ele : arr){
            if(ele>max) max = ele;
        }
        return max;
    }
}

