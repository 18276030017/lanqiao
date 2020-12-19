import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;

public class CreateXL
{
	public static String outputFile = "F:\\test.xls";
	public static void main(String argv[]){
		try{
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("ѧ���ɼ�");
			HSSFRow row = sheet.createRow((short)0);

			HSSFRow row1 = sheet.createRow((short)1);
			HSSFRow row2 = sheet.createRow((short)2);
			HSSFRow row3 = sheet.createRow((short)3);

			HSSFRow row4 = sheet.createRow((short)1);
			HSSFRow row5 = sheet.createRow((short)2);
			HSSFRow row6 = sheet.createRow((short)3);

			HSSFCell cell01 = row.createCell((short)0);
			HSSFCell cell02 = row.createCell((short)1);

			HSSFCell cell03 = row1.createCell((short)0);
			HSSFCell cell04 = row2.createCell((short)0);
			HSSFCell cell05 = row3.createCell((short)0);

			HSSFCell cell06 = row4.createCell((short)1);
			HSSFCell cell07 = row5.createCell((short)1);
			HSSFCell cell08 = row6.createCell((short)1);



			cell01.setCellValue("��Ŀ");
			cell03.setCellValue("����");
			cell04.setCellValue("��ѧ");
			cell05.setCellValue("Ӣ��");

			cell02.setCellValue("����");
			cell06.setCellValue("98");
			cell07.setCellValue("89");
			cell08.setCellValue("90");

			FileOutputStream fout =new FileOutputStream(outputFile);
			workbook.write(fout);
			fout.flush();
			fout.close();
			System.out.println("�ļ�����...");
		}
		catch (Exception e){
			System.out.println("������ xlCreate() : "+e);
		}
	}
}