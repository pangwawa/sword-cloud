package fun.codenow.sword.ops.log.question.jumpfloor;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0  可以跳一步、两步……或n步，跳上n级有多少种跳法
 * @Date2021/6/23 14:20
 **/
public class Main {
    public static int numWays(int n){
        int methodCount=0;
        if (n==0||n==1){
            return 1;
        }
       if (n>0){
           for (int i=n;i>0;i--){
               methodCount+=1;
               int remain=n-i;
               numWays(remain);
           }
       }
        return methodCount;
    }


    public static void main(String[] args) {
        System.out.println(numWays(4));
    }
}
