package fun.codenow.sword.ops.log.question.t1299;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/29 14:29
 **/
public class Main {
    public int[] replaceElements(int[] arr) {
        for (int i=0;i<arr.length-1;i++){
            int max=arr[i+1];
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]>max){
                    max=arr[j];
                }
            }
            arr[i]=max;
        }
        arr[arr.length-1]=-1;
        return arr;
    }
}
