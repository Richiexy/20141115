package com.xy.exception;

/**
 * 数据分析异常
 * 
 * @author peng.h 2011-04-13
 */
public class AuditRuntimeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5121723716435881378L;

	public AuditRuntimeException() {
		super();
	}
	
	public AuditRuntimeException(String message) {
		super(message);
	}
	
	public AuditRuntimeException(String message,Throwable throwable) {
		super(message,throwable);
	}
	
	public AuditRuntimeException(Throwable throwable) {
		super(throwable);
	}
}
