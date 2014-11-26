package com.xy.work;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.SheetSettings;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.junit.Test;

public class WordExcelTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
//	public void bak(){
	//		String excelPath = request.getSession().getServletContext()
	//		.getRealPath("excel")
	//		+ File.separatorChar + user.getUserid() + File.separatorChar;
	//outputGradeByScore(pro, dealIds, user, excelPath);
	//// 导出 文件
	//FileInputStream fileInputStream = null;
	//try {
	//	response.setHeader("Content-disposition", "attachment;filename=\""
	//			+ new String(pro.getProName().getBytes("GBK"), "ISO8859_1")
	//			+ ".xls\"");
	//
	//	response.setContentType("application/msexcel");
	//
	//	fileInputStream = new FileInputStream(excelPath + pro.getProName()
	//			+ ".xls");
	//	OutputStream out = response.getOutputStream();
	//	int i = 0;
	//	while ((i = fileInputStream.read()) != -1) {
	//		out.write(i);
	//	}
	//	out.flush();
	//} catch (Exception e) {
	//	e.printStackTrace();
	//	log.error("生成内控评价评分表出错：" + e.getMessage());
	//} finally {
	//	try {
	//		fileInputStream.close();
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//		log.error("生成内控评价评分表出错：" + e.getMessage());
	//	}
	//}
//	}
	
	public File createFile(String path , String fileName){
		File file = null;
		try {
			file = new File(path + File.separatorChar + fileName);
			File folder = new File(path);
			if (!folder.exists()) {
				file.mkdirs();
			}
			if (file.exists()) {
				file.delete();
				file.createNewFile();
			} else {
				file.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return file;
	}
	@Test
	public void testWord(){
		String content = "11111111111111111111111111中文";
		FileOutputStream out = null;
		try {
			File file = createFile("d:","test.doc");
			out = new FileOutputStream(file);
			out.write(content.getBytes());
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExcel(){
		File file = createFile("d:","test.xls");
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<String> colNameList = getColNameList();
		List<String[]> cellList = getCellList();
		map.put("colNameList", colNameList);
		
		FileOutputStream fos = null;
		WritableWorkbook wwb = null;
		WritableSheet ws = null;
		try {
			fos = new FileOutputStream(file);
			wwb = Workbook.createWorkbook(fos);
			
			int sheetNum = 1;
			
			ws = wwb.createSheet("sheet名字", sheetNum);
			SheetSettings st =  ws.getSettings();
			st.setVerticalFreeze(3);//冻结前3行
			createRow1(ws);
			createRow2(ws , colNameList);
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				wwb.write();
				wwb.close();
				fos.close();
				Runtime.getRuntime().gc();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private List<String[]> getCellList() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<String> getColNameList() {

		List<String> colNameList = new ArrayList<String>();
		colNameList.add("类区行");
		colNameList.add("机构名称");
		colNameList.add("总评级");
		
		colNameList.add("内部控制环境");
		colNameList.add("风险识别与评估");
		colNameList.add("内外部检查监督");
		colNameList.add("信息交流与沟通");
		colNameList.add("内部控制活动");
		
		colNameList.add("企业金融");
		colNameList.add("零售业务");
		colNameList.add("资金与同业");
		colNameList.add("会计与柜面");
		colNameList.add("财务管理");
		colNameList.add("信息科技");
		colNameList.add("安全保卫");
		return colNameList;
	}

	private void createRow1(WritableSheet ws) {

		try {
			// 标题 样式
			WritableFont font = new WritableFont(WritableFont.ARIAL, 12 ,WritableFont.BOLD);
			WritableCellFormat wc = new WritableCellFormat(font);// 样式
			ws.setRowView(0, 300);//第1行行高
			wc.setWrap(true);//折行显示
			wc.setAlignment(Alignment.CENTRE);// 水平居中
			wc.setVerticalAlignment(VerticalAlignment.CENTRE);// 垂直居中
			ws.mergeCells(0, 0, 14 , 0);//合并第一行
			ws.addCell(new Label(0, 0, "各分行内控评级表(更新至201X年X季度)" , wc));// 第1行
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createRow2(WritableSheet ws , List<String> colNameList) {

		try {
			ws.setColumnView(0, 20);// 列宽
			ws.setRowView(1, 300);//第2行行高
			ws.setRowView(2, 600);//第三行行高
			
			for (int i = 1; i < 15; i++) {
				ws.setColumnView(i, 12);// 列宽
			}
			// 标题 样式
			WritableFont font = new WritableFont(WritableFont.ARIAL, 12);
			WritableCellFormat wc = new WritableCellFormat(font);// 样式
			wc.setWrap(true);//折行显示
			wc.setAlignment(Alignment.CENTRE);// 水平居中
			wc.setVerticalAlignment(VerticalAlignment.CENTRE);// 垂直居中
			
			for(int i=0;i<8;i++){
				ws.mergeCells(i, 1, i , 2);
				ws.addCell(new Label(i, 1, colNameList.get(i) , wc));// 第2行
			}
			
			ws.mergeCells(8, 1, 14 , 1);
			ws.addCell(new Label(8, 1, "其他" , wc));// 第1行
			
			for(int i = 8;i<15; i++){
				// 标题 样式
				ws.mergeCells(i, 2, i , 2);
				ws.addCell(new Label(i, 2, colNameList.get(i) , wc));// 第2行
			}
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
