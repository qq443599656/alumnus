package com.xaccp.alumni.util;
/**
 * 功能：获取30分钟后时间
 * @author GX
 *@version 1.0
 */

import java.sql.Timestamp;

public class DateUtil {
	/**
	 * 获取30分钟后时间
	 * 
	 * @return
	 */
	public static Timestamp getOutTime() {
		Timestamp outDate = new Timestamp(System.currentTimeMillis() + 1 * 60 * 1000);// 30分钟后过期
		return outDate;
	}
}
