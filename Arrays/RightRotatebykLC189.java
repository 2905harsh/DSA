public class RightRotatebykLC189 {
  public static void main(String[] args) {
    int [] arr ={1,2,3,4,5,6,7};
    int k = 3;
    int n = arr.length;
    reverse(arr, 0, n-k-1);
    reverse(arr,n-k,n-1);
    reverse(arr,0,n-1);
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i] + " ");
    }


  }

  static void reverse(int arr[],int start,int end){
    while(start<end){
      int temp =arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }
  
}
