package GUI;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import DTO.XuatHDDTO;

public class XuatHd {
	//created PDF document instance   
	
	
	
	
	public void cc(String mahd,String tenkh,String ngay,ArrayList<XuatHDDTO> tthd) throws IOException
	{
		Document doc=new Document();	
		String path="..\\HoaDonBanHang"+mahd+".pdf";
		
		try 
		{  
		//generate a PDF at the specified location  
		PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(path));  
		
		System.out.println("PDF created.");  
		//opens the PDF  	
		doc.open();  
		
		
		//adds paragraph to the PDF file  
			//font
		BaseFont bf = BaseFont.createFont("c:\\windows\\fonts\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font f_1 = new Font(bf, 30, Font.NORMAL);
		Font f_2 = new Font(bf, 15, Font.NORMAL);
		Font f_3 = new Font(bf, 23, Font.NORMAL);
		Paragraph title = new Paragraph("HÓA ĐƠN BÁN LẺ \n",f_1);
		title.setAlignment(Element.ALIGN_CENTER);
		doc.add(title);
		
		Paragraph diachi = new Paragraph("Địa chỉ cửa hàng : Số 69 Thủ Đô Bình Chánh",f_2);
		Paragraph hotline = new Paragraph("Hotline : 0123285982",f_2);
		Paragraph sophieu = new Paragraph("Số Phiếu :"+mahd,f_2);
		Paragraph date = new Paragraph("Thời Gian : "+ngay,f_2);
		Paragraph tenkh_sdt = new Paragraph("Họ tên khách hàng :"+tenkh,f_2);
		
		Paragraph cthd = new Paragraph("CHI TIẾT HÓA ĐƠN",f_3);
		cthd.setSpacingBefore(20);
		cthd.setSpacingAfter(20);
		
		
		
		sophieu.setAlignment(Element.ALIGN_RIGHT);
		diachi.setSpacingBefore(20);
		
		doc.add(diachi);
		doc.add(hotline);
		doc.add(sophieu);	
		doc.add(date);
		doc.add(tenkh_sdt);
		
		



		
		
		// columnWidths = {column1, column2, column3...}

		
		float[] columnWidths = new float[]{2f, 6f, 3f, 4f,4f};
		
		PdfPTable t = new PdfPTable(columnWidths);
		
		
		//t.setWidths(columnWidths);


		
		t.setSpacingBefore(25);
		//t.setSpacingAfter(25);
		Paragraph stt = new Paragraph("Số TT ",f_2);
		Paragraph tensp = new Paragraph("      Tên Sản Phẩm",f_2);
		Paragraph sl = new Paragraph("Số Lượng",f_2);
		Paragraph gia = new Paragraph("    Đơn Giá",f_2);
		Paragraph thanhtien = new Paragraph("  Thành Tiền",f_2);
		PdfPCell c1 = new PdfPCell(stt);
		
		t.addCell(c1);
		PdfPCell c2 = new PdfPCell(tensp);
		t.addCell(c2);
		PdfPCell c3 = new PdfPCell(sl);
		t.addCell(c3);
		PdfPCell c5 = new PdfPCell(gia);
		t.addCell(c5);
		PdfPCell c4 = new PdfPCell(thanhtien);
		t.addCell(c4);
		
		doc.add(t);
		int tongsl=0;
		int tongdongia=0;
		int tongthanhtien=0;
		for(int i=0;i<tthd.size();i++)
		{
			PdfPTable ti=new PdfPTable(columnWidths);
			ti.addCell(tthd.get(i).getStt()+"");
				
			ti.addCell(tthd.get(i).getTensp());
			
			ti.addCell(tthd.get(i).getSl()+"");
			tongsl=tongsl+tthd.get(i).getSl();
			ti.addCell(tthd.get(i).getDongia()+"");
			tongdongia=tongdongia+tthd.get(i).getDongia();
			ti.addCell(tthd.get(i).getThanhtien()+"");
			tongthanhtien=tongthanhtien+tthd.get(i).getThanhtien();
			doc.add(ti);
		}
		PdfPTable t_2=new PdfPTable(columnWidths);
		t_2.addCell("");
		Paragraph tongcong = new Paragraph("TỔNG CỘNG : ",f_2);
		t_2.addCell(tongcong);
		t_2.addCell(tongsl+"");
		t_2.addCell(tongdongia+"");
		t_2.addCell(tongthanhtien+"");
		doc.add(t_2);
		
		
		
		
		
		Paragraph view = new Paragraph("----------------------------CẢM ƠN QUÝ KHÁCH ĐÃ ỦNG HỘ----------------------------",f_2);
		view.setSpacingBefore(30);
		doc.add(view);
		
		
			//close the PDF file 
		
		doc.close();  
		//closes the writer  
		writer.close();  
		}   
		catch (DocumentException e)  
		{  
		e.printStackTrace();  
		}   
		catch (FileNotFoundException e1)  
		{  
		e1.printStackTrace();  
		}  
	}
	
	public static void main(String args[]) throws IOException  
	{  
		XuatHd dd=new XuatHd();
		//	dd.cc();
	 
	}  
}
