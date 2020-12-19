public class MethodTest
{
	public static void main(String args[]){
		MethodTest mt= new MethodTest();
		//方法的调用
		boolean loginResult = mt.login("张三","123456");

		if(loginResult==true){
			System.out.println("跳转到主页");
		}
		else{
			System.out.println("用户名或者密码错误");
		}
	}


	/*封装登陆方法*/
	//public int login(String usernsme,String password){
	/*返回值1：登陆成功   
	  返回值0：登陆失败
	*/

	//方法的定义
	public boolean login(String username,String password){
		//如果用户名和密码都正确，返回1；否则返回0
		if(username.equals("张三")&& password.equals("123456")){
		return true;
		}
		else {
		return false;
		}
	}
}