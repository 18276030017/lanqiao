public class Test3
{
	public static void main(String args[]){
		int a=(120 >>1)<<8;
		System.out.println(a);

		//120�Ķ����ƣ�00000000 00000000 00000000 00111100
		/*
		����1λ�൱�ڸ�������2
		����1λ�൱�ڸ�������2
		��Ϊʲô��ֱ���ó˳���---��Ϊλ�����ڼ�����������ٶ���죩

		��ΰ�һ������ת��4���ֽڣ�
		*/
	}
	//int ת����byte[4]����
	public static byte[] getByteArray(int i){
		byte[] b= new byte[4];
		b[0]=(byte)((i & 0xff000000) >> 24);
		b[1]=(byte)((i & 0x00ff0000) >> 16);
		b[2]=(byte)((i & 0x0000ff00) >> 8);
		b[3]=(byte)(i & 0x000000ff) ;

		return b;
	}
}