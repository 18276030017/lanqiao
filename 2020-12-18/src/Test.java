public class Test {
    public static void main(String[] args){
        /*创建了一个客户对象*/
        Kehu kehu=new Kehu();

        //给对象的属性赋值（相当于在注册京东商城时填的信息）
        kehu.KehuID="11007456";
        kehu.KehuName="张三";
        kehu.address="桂林电子科技大学";
        kehu.phone="18632427756";

        /*kehu.setKehuID("11007456");*/

        DingDan dingdan=new DingDan();
        dingdan.DingDanID="11111";//商城自动生成
        dingdan.amounts =888F;

        //客户和订单进行关联
        kehu.dingdan=dingdan;

        //需求：客户要查询他下订单的金额
        System.out.println("订单金额："+ kehu.dingdan.amounts);
    }
}
