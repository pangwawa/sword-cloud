package fun.codenow.sword.ops.log.sort;

import com.google.gson.Gson;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/25 15:45
 **/
public class Main {
    public static void main(String[] args) {
        int[] array={5,7,2,3,6,9,1};
        System.out.println(new Gson().toJson(quickSort(array,0,array.length-1)));
        System.out.println(new Gson().toJson(quickSortFromLargeToSmall(array,0,array.length)));
    }

    public static int[] quickSort(int []arr, int left, int right){
        if (left<right){
            int low=left;
            int high=right;
            int stand = arr[left];
            while (low<high){
                while (low<high && arr[high]>stand){
                    high--;
                }
                arr[low]=arr[high];
                while (low<high && arr[low]<stand){
                    low++;
                }
                arr[high]=arr[low];
            }
            arr[low] = stand;
            quickSort(arr,left,low);
            quickSort(arr,low+1,right);
        }
        return arr;
    }


    public static int[] quickSortFromLargeToSmall(int[] array, int start,int end){
        if (start<end){
            int stand = array[start];
            int low = start;
            int high = end;
            while (low<high){
                while (low<high && array[high]<stand){
                    high--;
                }
                array[low]=array[high];
                while (low<high&& array[low]>stand){
                    low++;
                }
                array[high] = array[low];
            }
            array[low]=stand;
            quickSortFromLargeToSmall(array,start,low);
            quickSortFromLargeToSmall(array,low+1,end);
        }
        return array;
    }
}
