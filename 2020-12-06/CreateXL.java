import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;


public class CreateXL {
    /** Excel �ļ�Ҫ��ŵ�λ�ã��ٶ���E����*/
    public static String outputFile = "E:\\test.xls";
    public static void main(String argv[]) {
        try {
            // �����µ�Excel ������
            HSSFWorkbook workbook = new HSSFWorkbook();
            // ��Excel�������н�һ����������Ϊȱʡֵ
            // ��Ҫ�½�һ��Ϊ"Ч��ָ��"�Ĺ����������Ϊ��
            HSSFSheet sheet = workbook.createSheet("ѧ���ɼ�");
            // ������0��λ�ô����У���˵��У�
            HSSFRow row = sheet.createRow((short)0);
            //������0��λ�ô�����Ԫ�����϶ˣ�

			HSSFRow row1 = sheet.createRow((short)1);//������ǵ�һ�еڶ���
			HSSFRow row2 = sheet.createRow((short)2);//������ǵ�һ�е�����
			HSSFRow row3 = sheet.createRow((short)3);//������ǵ�һ�е�����

			HSSFRow row4 = sheet.createRow((short)1);//������ǵڶ��еڶ���
			HSSFRow row5 = sheet.createRow((short)2);//������ǵڶ��е�����
			HSSFRow row6 = sheet.createRow((short)3);//������ǵڶ��е�����

            HSSFCell cell01 = row.createCell((short)0);//��һ��0�����һ�У��ڶ���0������ǵ�һ��
			HSSFCell cell04 = row1.createCell((short)0);
			HSSFCell cell05 = row2.createCell((short)0);
			HSSFCell cell06 = row3.createCell((short)0);

			HSSFCell cell02 = row.createCell((short)1);//��һ��0�����һ�У�1����ڶ���
			HSSFCell cell07 = row4.createCell((short)1);
			HSSFCell cell08 = row5.createCell((short)1);
			HSSFCell cell09 = row6.createCell((short)1);
            
            // �ڵ�Ԫ��������һЩ����
            cell01.setCellValue("��Ŀ");
			cell04.setCellValue("����");
			cell05.setCellValue("��ѧ");
			cell06.setCellValue("Ӣ��");

			cell02.setCellValue("����");
			cell07.setCellValue("96");
			cell08.setCellValue("89");
			cell09.setCellValue("95");
            // �½�һ����ļ���
            FileOutputStream fOut = new FileOutputStream(outputFile);
            // ����Ӧ��Excel ����������
            workbook.write(fOut);
            fOut.flush();
            // �����������ر��ļ�
            fOut.close();
            System.out.println("�ļ�����...");
        } catch (Exception e) {
            System.out.println("������ xlCreate() : " + e);
        }
    }
}