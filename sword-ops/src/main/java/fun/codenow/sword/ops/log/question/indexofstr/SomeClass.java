package fun.codenow.sword.ops.log.question.indexofstr;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/25 16:14
 **/
public class SomeClass {
    public static int indexOf(String source,String target){
        char[] sourceChars=source.toCharArray();
        char[] targetChars=target.toCharArray();
        int index=-1;
        for (int i=0;i<sourceChars.length;i++){
            Boolean isExit=true;
            if (sourceChars[i]==targetChars[0]&&sourceChars.length-i>=targetChars.length){
                for (int j=0;j<targetChars.length;j++){
                    if (targetChars[j]!=sourceChars[i+j]){
                        isExit=false;
                    }
                }
            }else {
                isExit=false;
            }
            if (isExit){
                index=i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(indexOf("abcabdef","abd"));
    }
}
