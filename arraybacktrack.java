public class arraybacktrack {
    public static void newarr(int arr[],int i , int value){
        if(i==arr.length){
            printarr(arr);
            return;
        }
        arr[i]=value;
        newarr(arr, i+1, value+1);
        arr[i]=arr[i]-2;

    }
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]=new int[5];
        newarr(arr, 0, 1);
        printarr(arr);

    }
    
}
