package com.vtiger.practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
	public static  void main(String[]args){
		Date date=new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy_dd_MM_yyyy_HH_mm_sss");
		String date1 = f.format(date);
		System.out.println(date1);
		
	}
}
