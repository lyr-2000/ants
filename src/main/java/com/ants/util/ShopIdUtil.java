package com.ants.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author czd
 * 生产商品订单号的类
 */
public class ShopIdUtil {
	
	public static String getShopIdByUUID() {
//		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
//		String time=format.format(new Date());
		int hashCode=UUID.randomUUID().toString().hashCode();
		if(hashCode<0) {
			hashCode=-hashCode;
			
		}
		return String.format("%011d", hashCode);//time+
	}

	public static void main(String[] args) {
		System.out.println(getShopIdByUUID());
	}

}
