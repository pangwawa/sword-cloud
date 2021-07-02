package fun.codenow.sword.common.model;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2020/8/21 15:29
 **/
public class PageVO {
    private Long size;
    private Long current;

    public long getSize() {
        if (size==null){
            size=10L;
        }
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getCurrent() {
        if (current==null){
            current=1L;
        }
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }
}
