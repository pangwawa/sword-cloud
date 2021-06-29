package fun.codenow.sword.ops.log.question.five;

/**
 * @Author Jack Wu
 * @Description 寻找两个正序数组的中位数
 *   给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * @Version V1.0
 * @Date2021/5/19 18:11
 **/
public class Main {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length=nums1.length+nums2.length;
        int[] tempArray=new int[length];
        int flag1=0;
        int flag2=0;
        for (int i=0;i<length;i++){
            if (flag1>=nums1.length){
                tempArray[i]=nums2[flag2];
                flag2++;
                continue;
            }
            if (flag2>=nums2.length){
                tempArray[i]=nums1[flag1];
                flag1++;
                continue;
            }
            if (nums1[flag1]<nums2[flag2]){
                tempArray[i]=nums1[flag1];
                flag1++;//越界
            }else {
                tempArray[i]=nums2[flag2];
                flag2++;//越界
            }
        }
        if (length%2==0){
            return (tempArray[length/2]+tempArray[length/2+1])/2.0;
        }else{
            return tempArray[length/2+1];
        }
    }
}
