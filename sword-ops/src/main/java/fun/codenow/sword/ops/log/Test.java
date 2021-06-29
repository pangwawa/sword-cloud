package fun.codenow.sword.ops.log;

import com.google.gson.Gson;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/4/22 14:12
 **/
public class Test {
    public static void main(String[] args) {
        String initShopInfoName="1号馆 建材馆,2号馆 材料馆,3号馆 光饰馆,4号馆 睡眠馆,5号馆 生活馆,6号馆 睡眠馆,7号馆 工作展,8号馆 软体馆,9号馆 简奢馆,10号馆 软体馆,11号馆 设计馆,12号馆 简约馆,13号馆 实木馆,14号馆 实木馆/儿童馆";
        String[] initShopArray=initShopInfoName.split(",");
        System.out.println(new Gson().toJson(initShopArray));
    }
}
