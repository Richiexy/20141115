package com.xy.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.codehaus.jackson.type.TypeReference;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.sunyard.extjs.ExtColumnFormat;
import com.sunyard.extjs.store.JsonData;
import com.sunyard.util.JacksonUtil;

/**
 * 对文件进行操作
 * @author 彭敏
 */
@SuppressWarnings("deprecation")
public class FileUtil {
	
	private static Logger log = LoggerFactory.getLogger(FileUtil.class);
	
	public static String createExcelMode(String filePath,String[] datas){
		String fileNames[]=null;
		if("/".equals(File.separator)){
			fileNames = filePath.split("/");
		} else {
			fileNames = filePath.split("\\\\");
		}
		String fileName=fileNames[fileNames.length-1].substring(0, fileNames[fileNames.length-1].indexOf("."));
		FileOutputStream fos = null;
		WritableWorkbook wwb=null;
		WritableSheet ws=null;
		try {
			fos = new FileOutputStream(filePath);
			wwb = Workbook.createWorkbook(fos);
			ws =wwb.createSheet(fileName, 1);
			int i=0;
			for (String data : datas) {
				ws.addCell(new Label(i, 0, data));
				i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "生成审报表excel模板失败!";
		}finally{
			try {
				fos.flush();
				wwb.write();
				wwb.close();
				fos.close();
				Runtime.getRuntime().gc();
			} catch (Exception e) {
				e.printStackTrace();
				return "生成审报表excel模板失败!";
			}

		}
		return "";
	}
	
	/**
	 * 解析DOC
	 * @param inputFIle
	 * @param outputFile
	 */
    public static void extractDoc(String inputFIle, String outputFile) {
        boolean flag = false;
        // 打开Word应用程序
        ActiveXComponent app = new ActiveXComponent("Word.Application");
        try {
           // 设置word不可见
           app.setProperty("Visible", new Variant(false));
           // 打开word文件
           Dispatch doc1 = app.getProperty("Documents").toDispatch();
           Dispatch doc2 = Dispatch.invoke(doc1, "Open", Dispatch.Method,
					new Object[] { inputFIle, new Variant(false), new Variant(true) }, new int[1]).toDispatch();
           // 作为txt格式保存到临时文件
           Dispatch.invoke(doc2, "SaveAs", Dispatch.Method, new Object[] {
                 outputFile, new Variant(7) }, new int[1]);
           // 关闭word
           Variant f = new Variant(false);
           Dispatch.call(doc2, "Close", f);
           flag = true;
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
           app.invoke("Quit", new Variant[] {});
        }
        if (flag == true) {
        	log.warn("解析DOC文档成功！");
        } else {
        	log.warn("解析DOC文档失败！");
        }
     }
    
    /**
	 * 新建文档夹
	 * @param folderPath 文件路径
	 */
	public  static void newFolder(String folderPath) {
		try {
			String filePath = folderPath;
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.mkdir();
			}
		} catch (Exception e) {
			log.error("新建文件夹操作失败！"+e);
		}
	}
	
	/**
	 * 删除文件夹及其里的所有文件
	 * @param dir
	 */
	public static void deleteFolder(File dir) {
		if (dir == null || !dir.exists() || !dir.isDirectory())
			return;
		for (File file : dir.listFiles()) {
			if (file.isFile())
				file.delete(); // 删除所有文件
			else if (file.isDirectory())
				deleteFolder(file); // 递规的方式删除文件夹
		}
		dir.delete();// 删除目录本身
	}
	
	
	public void addPassWord(String filePath,String password,String fileName){
//		View view = new View();
//		FileInputStream fileInputStream=null;
//		FileOutputStream paramOutputStream=null;
//		try {
//			fileInputStream = new FileInputStream(filePath+fileName+".xls");
//			view.read(fileInputStream);
//			File file = new File(filePath+fileName+".xls");
//			paramOutputStream = new FileOutputStream(file);
//			view.write(paramOutputStream,password);
//		} catch (Exception e) {
//			log.error(e.getMessage());
//			log.error("excel加密出现错误！");
//		} finally{
//			try {
//				fileInputStream.close();
//				paramOutputStream.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//		}
	}
	/**
	 * 得到文件名称
	 * @param filePath
	 * @return
	 */
	public static String getFileName(String filePath) {
//	    File file = new File(filePath);
//	    String filename=file.getName();
//	    String filename2=filename.replace(" ", "");
		System.out.println("filePath="+filePath);
		String[] filePathArr = filePath.split("\\\\");
		String filename2 = filePathArr[filePathArr.length-1];
		System.out.println("filename2="+filename2);
	    return filename2;
	}

	 /**   
     * EXCEL转HTML   
     * @param xlsfile EXCEL文件全路径   
     * @param htmlfile 转换后HTML存放路径   
     */    
    public  static boolean excelToHtml(String xlsFile, String htmlFile) {     
        ActiveXComponent app = new ActiveXComponent("Excel.Application");
        boolean result = false;
        try{   
	         app.setProperty("Visible", new Variant(false));     
	         Dispatch excels = app.getProperty("Workbooks").toDispatch();    
	         Dispatch excel = Dispatch.invoke(excels,"Open",Dispatch.Method,     
	                new Object[] { xlsFile, new Variant(false),new Variant(true) }, new int[1]).toDispatch();     
	         Dispatch.invoke(excel, "SaveAs", Dispatch.Method, new Object[] {  htmlFile, new Variant(44) }, new int[1]);     
	         app.setProperty("DisplayAlerts", new Variant(false));
	         Dispatch.call(excel, "Close", new Variant(false));
	         excel = null;
	         excels = null;
	         ComThread.Release();
	         app = null;
	         result = true;
        } catch (Exception e){
        	log.error("EXCEL转HTML出错。" +e.getMessage());
        	result = false;
        } finally {   
	         if(app!=null){
	        	 app.invoke("Quit", new Variant[] {});
	         }
        } 
        return result;
    } 	
	
	
	/**
	 * WORD转HTML
	 * @param docfile  WORD文件全路径
	 * @param htmlfile 转换后HTML存放路径
	 */
	public static void wordToHtml(String docfile, String htmlfile) {
		ActiveXComponent app = new ActiveXComponent("Word.Application"); // 启动word    
		try {
			app.setProperty("Visible", new Variant(false));
			Dispatch docs = app.getProperty("Documents").toDispatch();
			Dispatch doc = Dispatch.invoke(docs, "Open", Dispatch.Method,
					new Object[] { docfile, new Variant(false), new Variant(false) }, new int[1]).toDispatch();
			Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] { htmlfile, new Variant(8) }, new int[1]);
			Variant f = new Variant(false);
			Dispatch.call(doc, "Close", f);
		} catch (Exception e) {
			log.error("WORD转HTML出错。"+e.getMessage());
		} finally {
			app.invoke("Quit", new Variant[] {});
		}
	}
	
	public static String ReadTxt(String filePath) throws UnsupportedEncodingException{
		StringBuffer reString=new StringBuffer();
	  try {
//		   FileReader read = new FileReader(filePath);
		   BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
		   String row;
		   while((row = br.readLine())!=null){
			   reString.append(row);
		   }
		  } catch (FileNotFoundException e) {
			  e.printStackTrace();
		  } catch (IOException e){
			  e.printStackTrace();
		  }
	  return reString.toString();
//		  return new String(reString.toString().getBytes("GBK"),"UTF-8");
	}
	
	
	
	/**
	 * 创建一个文件
	 * @param filePath 文件路径
	 */
	public static void createNewFile(String filePath){
		String fileName="";
		if("/".equals(File.separator)){
			fileName= filePath.substring(filePath.lastIndexOf("/")+1);//文件名称
		} else {
			fileName= filePath.substring(filePath.lastIndexOf("\\")+1);//文件名称
		}
		
		String fielDirs = "";
		if("/".equals(File.separator)){
			fielDirs=filePath.substring(0,filePath.lastIndexOf("/"));//文件路径
		} else {
			fielDirs=filePath.substring(0,filePath.lastIndexOf("\\"));//文件路径
		}
		
		try {
			
			File file = new File(filePath);
			File folder = new File(fielDirs);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			if (file.exists()) {
				file.delete();
				file.createNewFile();
			} else {
				file.createNewFile();
			}				
		} catch (Exception e) {
			log.error("创建文件："+fileName+"失败。");
		}
	}
	
	/**
	 * 
	 * @param filePath 文件路径
	 * @param exportFields
	 * @param jsonData
	 * @param response
	 */
	public static void createExcel(String filePath,String exportFields,
			JsonData jsonData,HttpServletResponse response){
		String fileName="";
		if("/".equals(File.separator)){
			fileName= filePath.substring(filePath.lastIndexOf("/")+1);//文件名称
		} else {
			fileName= filePath.substring(filePath.lastIndexOf("\\")+1);//文件名称
		}
		String name[]=fileName.split("\\.");
		createExcel(filePath,exportFields,jsonData);
	    OutputStream os = null;
		try {
			response.setHeader("Content-disposition","attachment; filename="+new String(name[0].getBytes("GBK"),"ISO8859-1")+".xls");
			response.setContentType("application/msexcel"); 
			os = response.getOutputStream();

			FileInputStream fileInputStream = new FileInputStream(filePath);
			int i = 0;
			while ((i = fileInputStream.read()) != -1) {
				os.write(i);
			}
			os.flush();
			fileInputStream.close();
			os.close();
		} catch (Exception e) {
			log.error("下载文件失败。",e);
		}finally{
			if(null!=os){
				try {
					os.close();
				} catch (IOException e) {
					log.error("关闭输出流出错。",e);
				}
			}
		}
	}

	/**
	 * 导出excel文件
	 * @param fileName  文件路径
	 * @param exportFields 文件字段
	 */
	@SuppressWarnings("deprecation")
	public static  void createExcel(String fileName,String exportFields,JsonData jsonData){
		
		FileUtil.createNewFile(fileName);
		File file = new File(fileName);
		
		List<LinkedHashMap<String, String>> fields = JacksonUtil.deserializeJsonToObject(
				exportFields,
				new TypeReference<List<LinkedHashMap<String, String>>>() {
				});
		int i=0;//行
		int j=0;//列
		
		FileOutputStream fos = null;
		WritableWorkbook wwb = null;
		WritableSheet ws = null;
		
		try {
			
			fos = new FileOutputStream(file);
			wwb = Workbook.createWorkbook(fos);
			ws = wwb.createSheet("数据", 0);
			for(Map<String, String> field : fields){
				WritableFont wf = new WritableFont(WritableFont.TIMES,12,WritableFont.BOLD,false);
				WritableCellFormat wcf = new WritableCellFormat(wf);
				Label label= new Label(j++,0,field.get("header"),wcf);
				ws.addCell(label);
			}
			
			i=1;
			DecimalFormat format = new DecimalFormat("#,###.#########");
			for(Map<String,Object> row : jsonData.getResults()){
				j=0;
				for(Map<String, String> field : fields){
					String name = field.get("name");
					Object v = row.get(name)==null ? "" : row.get(name);
					if(v instanceof Number){
						v = format.format(v);
					}
					String value = v.toString();
					ExtColumnFormat<?> formators = jsonData.getFormators().get(name);
					if(null!=formators){
						value = formators.format(jsonData.getResults(),row,jsonData.getResults().indexOf(row), value).toString();
					}
					Label label = new Label(j++,i,value.replaceAll("<A/>", ""));
					ws.addCell(label);
				}
				i++;
				fos.flush();
			}
		} catch (Exception e) {
			log.error("生成Excel文件出错"+e.getMessage());
			
		} finally{
			try {
				wwb.write();
				wwb.close();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}	
	
	
	
	
	/**
	 * 用POI得到DOC文件内容
	 * @param filePath 文件路径
	 * @return
	 * @throws IOException
	 */
	public static String getDocContent(String filePath) throws IOException {
		   File file = new File(filePath); 
		   FileInputStream fis=null;
		   try {
			    fis = new FileInputStream(file); 
			    try{
			    	HWPFDocument document=new HWPFDocument(fis);
				    WordExtractor wordExtractor = new WordExtractor(document);
				    return wordExtractor.getText();
			    }catch(Exception ex){
			    	XWPFDocument document=new XWPFDocument(new FileInputStream(file));
				    XWPFWordExtractor wordExtractor = new XWPFWordExtractor(document);
				    return wordExtractor.getText();
			    }
		   } catch (IOException e) {
			   log.error("读取"+filePath+"文件出错。");
			   log.error(e.getMessage());
		   } finally{
			   if(null !=fis){
				   fis.close();
			   }
		   }
		return ""; 
	}
	/**
	 * 读取PDF文件内容
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public static String getPdfContent(String filePath) throws Exception {
		InputStream input = null;
		File pdfFile = new File(filePath);
		PDDocument document = null;
		String content = "";
		try{
			input = new FileInputStream( pdfFile );
			//加载 pdf 文档
			document = PDDocument.load( input );
			//获取内容信息
			if(document.isEncrypted()== true){
				throw new Exception("读取的【"+filePath+"】文件是加密文件不能读取!");
			}
			PDFTextStripper pts = new PDFTextStripper();
			 content = pts.getText( document );
		   } catch (Exception e) {
			   log.error("读取"+filePath+"文件出错。");
			   log.error(e.getMessage());
		   } finally{
			   if( null != input )
					input.close();
				if( null != document )
					document.close();
		   }
		return content; 
	}
	 /**
     * 读取Excel所有数据内容
     * @param InputStream
     * @return Map 包含单元格数据内容的Map对象
     */
    @SuppressWarnings("deprecation")
	public static String getExcelContent(String filePath ) {
        Map<Integer, String> content = new HashMap<Integer, String>();
        InputStream is = null;
        String str = "";
        
        org.apache.poi.ss.usermodel.Workbook wb = null;
        Sheet sheet =null;
        Row row;

        try {
        	is =new FileInputStream(filePath);
        	try {
        		wb = new XSSFWorkbook(filePath);
			} catch (Exception ex) {
                wb = new HSSFWorkbook(is);
			}
            
            sheet = wb.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            row = sheet.getRow(0);
            int colNum = row.getPhysicalNumberOfCells();
            for (int i = 0; i <= rowNum; i++) {
                row = sheet.getRow(i);
                int j = 0;
                while (j < colNum+1) {
                    str += getCellFormatValue(row.getCell((short) j)).trim() + "";
                    j++;
                }
                content.put(i, str);
                str = "";
            }            
            
        } catch (Exception e) {
        	log.error("解析EXCEL文件出错"+e.getMessage());
            e.printStackTrace();
        } finally{
        		try {
        			if(null!=is){
        				is.close();
        			}
				} catch (IOException e) {
					e.printStackTrace();
				}
        }
        
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i <= content.size(); i++) {
        	buf.append(content.get(i));
        }
        return buf.toString();
    }

    
    /**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @return
     */
    private static String getCellFormatValue(Cell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
            // 如果当前Cell的Type为NUMERIC
            case HSSFCell.CELL_TYPE_NUMERIC:
            case HSSFCell.CELL_TYPE_FORMULA: {
                // 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellvalue = sdf.format(date);
                    
                }
                else {
                    // 取得当前Cell的数值
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            // 如果当前Cell的Type为STRIN
            case HSSFCell.CELL_TYPE_STRING:
                // 取得当前的Cell字符串
                cellvalue = cell.getRichStringCellValue().getString();
                break;
            // 默认的Cell值
            default:
                cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }	
	
}
