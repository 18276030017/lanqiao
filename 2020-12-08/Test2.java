public class Test2
{
	//在类中声明的变量就是成员变量，成员变量都有默认值
	int a;//整型默认值：0
	byte c;
	float b;//浮点型默认值：0.0
	char d;//默认值是空值
	boolean e;//默认值是false
	public static void main(String args[]){
		Test2 test=new Test2();
		test.m1();//调用m1方法
	}
	public void m1(){
		int a=10;
		boolean e=true;
		System.out.println("调用局部变量："+d);//Java寻找变量是就近原则（从最近的作用域找，找不到，就扩大作用域找）
	}//在方法里面声明的变量就是局部变量，如果要使用局部变量，那么必须先要给局部变量进行赋值
}