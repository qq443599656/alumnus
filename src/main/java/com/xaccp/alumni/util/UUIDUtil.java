package com.xaccp.alumni.util;

import java.util.UUID;

/**
 * 功能：激活码工具
 * 
 * @author GX
 * @version 1.0
 */
public class UUIDUtil {
	public static String uuid;

	/**
	 * 生成激活码
	 * 
	 * @return 激活码uuid
	 */
	public static String getUUID() {
		uuid = UUID.randomUUID().toString().replaceAll("-", ""); // 密钥
		return uuid;
	}
}
