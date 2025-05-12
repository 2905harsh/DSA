public class MoveZerosToEnd {
  public static void main(String[] args){
    int [] arr = {0,1,0,3,12};
    int a = firstZeroIndex(arr);
    int b =a+1;
   while(b<arr.length){
    if(arr[b]!=0){
      arr[a]=arr[b];
      arr[b]=0;
      a++;
      b++;
    }
    else if(arr[b]==0){
      b++;
    }
   }

   for(int i = 0;i<arr.length;i++){
    System.out.print(arr[i]+" ");
   }

  }
  static int firstZeroIndex(int arr[]){
    int i =0;
    while(i<arr.length){
      if(arr[i]==0){
        return i;
      }
    }
    return -1;
  }

}
