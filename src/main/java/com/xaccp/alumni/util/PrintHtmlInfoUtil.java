package com.xaccp.alumni.util;

import java.io.PrintWriter;

/**
 * 功能：打印html页面工具
 * 
 * @author GX
 * @version 1.0
 */
public class PrintHtmlInfoUtil {

	/**
	 * 打印信息
	 * 
	 * @param write
	 */
	public static void printInfo(PrintWriter out, String mes) {
		out.print("<html><head><title>信息</title><h1>" + mes + "</h1></head>");
		out.flush();
	}
}
