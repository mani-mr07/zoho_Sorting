import java.net.SocketOption;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int arr[]={123,543,234,876,12,98};
        int n= arr.length;
        radixsort(arr,n);
        System.out.println(Arrays.toString(arr));
    }
    public static void radixsort(int[]arr,int n){
        int max=maximum(arr,n);
        for(int pos=1;(max/pos)>0;pos=pos*10){
            countsort(arr,n,pos);
        }
    }

    private static void countsort(int[] arr, int n, int pos) {
          int[]count=new int[10];
          int[]copyarray=new int[n];
          for(int i=0;i<n;i++){
              count[(arr[i]/pos) %10]++;
          }
        for (int i = 1; i <10 ; i++) {
            count[i]=count[i]+count[i-1];
        }
        for (int i = n-1; i >= 0; i--) {
            int digit = (arr[i] / pos) % 10;
            copyarray[count[digit] - 1] = arr[i];
            count[digit]--;

        }

        for (int i = 0; i < n; i++) {
            arr[i]=copyarray[i];

        }
    }

    public static int maximum(int[]arr,int n){
        int max=arr[0];
        for (int i = 1; i <n ; i++) {
            if(arr[i]>max) {
                max = arr[i];
            }
        }
        return  max;
    }
}