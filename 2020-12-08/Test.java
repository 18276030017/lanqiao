public class Test
{
	public static void main(String args[]){
		//java中的小数默认的是double
		float price=88.8F;

		//赋值符号：赋值符号左右两侧的类型必须一致
		//数据类型转换（进行了自动转换：由低到高）
		int a='c';

		double height=1.88F;		//强制类型转换
		float price2=(float)88.8;
		System.out.println(price);
		System.out.println("hello world!");

		char c1='\u6797';
		System.out.println(c1);
	}
}