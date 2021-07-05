package fun.codenow.sword.ops.log.question.t896;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/7/2 16:57
 **/
public class Main {
    public boolean isMonotonic(int[] nums) {
        if (nums[0]>nums[nums.length-1]){
            for (int i=1;i<nums.length;i++){
                if (nums[i]>nums[i-1]){
                    return false;
                }
            }
        }
        if (nums[0]<nums[nums.length-1]){
            for (int j=1;j<nums.length;j++){
                if (nums[j]<nums[j-1]){
                    return false;
                }
            }
        }
        if (nums[0]==nums[nums.length-1]){
            for (int k=1;k<nums.length;k++){
                if (nums[k]!=nums[0]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1={1,2,2,3};
        int[] arr2={6,5,4,4};
        int[] arr3={1,3,2};
        int[] arr4={1,2,4,5};
        System.out.println(new Main().isMonotonic(arr1));
        System.out.println(new Main().isMonotonic(arr2));
        System.out.println(new Main().isMonotonic(arr3));
        System.out.println(new Main().isMonotonic(arr4));
    }
}
