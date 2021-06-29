package fun.codenow.sword.ops.log.question.three;

/**
 * @Author Jack Wu
 * @Description 找出其中不含有重复字符的 最长子串 的长度。
 * @Version V1.0
 * @Date2021/4/25 18:20
 **/
public class Main {
    public int lengthOfLongestSubstring(String s) {
        int len=1;
        char[] charArray=s.toCharArray();
        for (int i=0;i<charArray.length;i++){
            for (int j=i+1;j<charArray.length;j++){
                int templeg=0;
                if (charArray[j]==charArray[j-1]){
                    templeg = j-i;
                    if (templeg>len){
                        len=templeg;
                    }
                    break;
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new Main().lengthOfLongestSubstring("glaofanga1fa2g1ag"));
    }
}
