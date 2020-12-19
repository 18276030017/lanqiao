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
			HSSFSheet sheet = workbook.createSheet("学生成绩");
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



			cell01.setCellValue("科目");
			cell03.setCellValue("语文");
			cell04.setCellValue("数学");
			cell05.setCellValue("英语");

			cell02.setCellValue("分数");
			cell06.setCellValue("98");
			cell07.setCellValue("89");
			cell08.setCellValue("90");

			FileOutputStream fout =new FileOutputStream(outputFile);
			workbook.write(fout);
			fout.flush();
			fout.close();
			System.out.println("文件生成...");
		}
		catch (Exception e){
			System.out.println("已运行 xlCreate() : "+e);
		}
	}
}