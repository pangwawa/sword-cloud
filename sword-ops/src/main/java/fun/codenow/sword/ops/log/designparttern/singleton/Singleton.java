package fun.codenow.sword.ops.log.designparttern.singleton;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/21 10:40
 **/
public class Singleton {
    private volatile static Singleton singleton=null;
    private Singleton() {

    }
    public synchronized static Singleton getSingleton(){
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    return new Singleton();
                }
            }
        }
        return singleton;
    }

}
