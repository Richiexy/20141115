package com.xy.test;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

import sun.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;

/**
 * 获取系统信息的业务逻辑实现类. 
 * @author sunyard
 *
 */
public class MonitorServiceImpl implements IMonitorService {

	//可以设置长些，防止读到运行此次系统检查时的cpu占用率，就不准了
	private static final int CPUTIME = 5000;
	
	private static final int PERCENT = 100;
	
	private static final int FAULTLENGTH = 10;
	
	@Override
	public MonitorInfoBean getMonitorInfoBean() throws Exception {
		
		int kb = 1024;
		
		// 可使用内存
		long totalMemory = Runtime.getRuntime().totalMemory();
		// 剩余内存
		long freeMemory = Runtime.getRuntime().freeMemory();
		// 最大可使用内存
		long maxMemory = Runtime.getRuntime().maxMemory();
		
		OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		// 操作系统
		String osName = System.getProperty("os.name");
		// 总的物理内存
		long totalMemorySize = osmxb.getTotalPhysicalMemorySize()/kb;
		// 剩余的物理内存
		long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize()/kb;
		// 已使用的物理内存
		long usedMemory = (osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize())/kb;
		// 获得线程总数
		ThreadGroup parentThread;
		for(parentThread = Thread.currentThread().getThreadGroup() ; parentThread.getParent() !=null; parentThread = parentThread.getParent()){
			int totalThread = parentThread.activeCount();
		}
		//cpu使用率
		double cpuRatio = 0;
		if(osName.toLowerCase().startsWith("windows")){
			cpuRatio = this.getCpuRatioForWindows();
		}
		return null;
	}

	private double getCpuRatioForWindows() {
		
		try {
			String procCmd = System.getenv("windir")
					+ "\\system32\\wbem\\wmic.exe process get Caption,CommandLine,"
					+ "KernelModeTime,ReadOperationCount,ThreadCount,UserModeTime,WriteOperationCount";
			//取进程信息
			long[] c0 = readCpu(Runtime.getRuntime().exec(procCmd));
			Thread.sleep(CPUTIME);
			long[] c1 = readCpu(Runtime.getRuntime().exec(procCmd));
			if (c0 != null && c1 != null) {
				long idletime = c1[0] - c0[0];
				long busytime = c1[1] - c0[1];
				return Double.valueOf(
						PERCENT * (busytime) / (busytime + idletime))
						.doubleValue();
			} else {
				return 0.0;
			}
			
		} catch (Exception e) {
			return 0.0;
		}
	}

	private long[] readCpu(final Process proc) {
		long[] retn = new long[2];           
		try {   
            proc.getOutputStream().close();   
            InputStreamReader ir = new InputStreamReader(proc.getInputStream());   
            LineNumberReader input = new LineNumberReader(ir);               String line = input.readLine();   
            if (line == null || line.length() < FAULTLENGTH) {                   return null;               }   
            int capidx = line.indexOf("Caption");               int cmdidx = line.indexOf("CommandLine");   
            int rocidx = line.indexOf("ReadOperationCount");               int umtidx = line.indexOf("UserModeTime");               int kmtidx = line.indexOf("KernelModeTime");               int wocidx = line.indexOf("WriteOperationCount");               long idletime = 0;               long kneltime = 0;               long usertime = 0;   
            while ((line = input.readLine()) != null) {  
            	if (line.length() < wocidx) {                
            		continue;            
            	}   
                // 字段出现顺序：Caption,CommandLine,KernelModeTime,ReadOperationCount,   
                // ThreadCount,UserModeTime,WriteOperation   
                String caption = this.substring(line, capidx, cmdidx - 1).trim();   
                String cmd = this.substring(line, cmdidx, kmtidx - 1).trim();   
                if (cmd.indexOf("wmic.exe") >= 0) {
                	continue;                  
                }   
                // log.info("line="+line);   
                if (caption.equals("System Idle Process") || caption.equals("System")) {     
                	idletime += Long.valueOf( this.substring(line, kmtidx, rocidx - 1).trim()).longValue();                       
                	idletime += Long.valueOf(this.substring(line, umtidx, wocidx - 1).trim()).longValue(); 
                     continue;
                }      
                kneltime += Long.valueOf(this.substring(line, kmtidx, rocidx - 1).trim()).longValue();  
                usertime += Long.valueOf( this.substring(line, umtidx, wocidx - 1).trim()).longValue();  
               }   
            retn[0] = idletime;   
            retn[1] = kneltime + usertime;               return retn;   
        } catch (Exception ex) {               ex.printStackTrace();           } finally {               try {   
                proc.getInputStream().close();               } catch (Exception e) {                   e.printStackTrace();               }           }   
        return null;  
	}
	
	public static String substring(String src, int start_idx, int end_idx){   
        byte[] b = src.getBytes();         
        String tgt = "";   
        for(int i=start_idx; i<=end_idx; i++){        
        	tgt +=(char)b[i];          
        }   
        return tgt;       
    }  

}
