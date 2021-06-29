package fun.codenow.sword.ops.log.question.one;

/**
 * @Author Jack Wu
 * @Description 请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * @Version V1.0
 * @Date2021/4/15 18:18
 **/
public class Main {
    public int[] twoSum(int[] nums, int target) {
        int [] result=new int[2];
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if ((nums[i]+nums[j])==target){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }
}
