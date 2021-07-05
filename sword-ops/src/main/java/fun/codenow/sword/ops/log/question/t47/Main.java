package fun.codenow.sword.ops.log.question.t47;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/7/2 17:30
 **/
public class Main {
    public int maxValue(int[][] grid) {
        int right=0;
        int down=0;
        int m=grid.length;
        int n=grid[0].length;
        return 0;
    }
    public static int moveAndValue(int [][]grid,int down,int right,int value){
        value +=grid[down][right];
        return value;
    }
}
