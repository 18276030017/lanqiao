public class MethodTest
{
	public static void main(String args[]){
		MethodTest mt= new MethodTest();
		//�����ĵ���
		boolean loginResult = mt.login("����","123456");

		if(loginResult==true){
			System.out.println("��ת����ҳ");
		}
		else{
			System.out.println("�û��������������");
		}
	}


	/*��װ��½����*/
	//public int login(String usernsme,String password){
	/*����ֵ1����½�ɹ�   
	  ����ֵ0����½ʧ��
	*/

	//�����Ķ���
	public boolean login(String username,String password){
		//����û��������붼��ȷ������1�����򷵻�0
		if(username.equals("����")&& password.equals("123456")){
		return true;
		}
		else {
		return false;
		}
	}
}